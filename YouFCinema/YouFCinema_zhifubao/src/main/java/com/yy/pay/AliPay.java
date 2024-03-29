package com.yy.pay;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradePayResponse;
import com.cinema.dto.SeatToOrderDto;
import com.cinema.interfaces.Order02Controller;
import com.yy.config.AlipayConfig;
import com.yy.util.RedisUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
@CrossOrigin
public class AliPay {

    @Autowired
    private Order02Controller order02Controller;
    
    @Autowired
	private RedisUtil redisUtil;

    /*
     *  out_trade_no;// 订单编号 （商家提供唯一的编号）
     *  subject; //订单名称
     *  total_amount; // 金额
     *  body;    // 商品名称
     *  product_code; // 商品码
     */
    @ResponseBody
    @GetMapping("/pay")
    public String pay( @RequestParam("out_trade_no")String out_trade_no ,@RequestParam("subject")String subject,@RequestParam("total_amount")String total_amount) throws AlipayApiException, UnsupportedEncodingException {
//        封装 rsa签名方式
        /*
         * 参数1:请求网关z
         * 参数2：收款人id
         * 参数3：支付宝密钥
         * 参数4：返回格式
         * 参数5：字符编码格式
         * 参数6：支付宝公钥
         * 参数7：加密方式
         * */
    	System.out.println("调用pay");
        AlipayClient client =  new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
                AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET,
                AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);

//        2. 创建Request请求
        // 支付请求
        // 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        // AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();

//        3.封装传入参数
        // SDK已经封装掉了公共参数，这里只需要传入业务参数。
        // 以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradePayModel model = new AlipayTradePayModel();
        // 描述信息 添加附加数据
//        model.setProductCode(product_code); // 设置销售产品码
        model.setOutTradeNo(out_trade_no); // 设置订单号
        model.setSubject(URLEncoder.encode(subject,"utf-8")); // 订单名称
        model.setTotalAmount(total_amount); // 支付总金额total_amount
//        model.setBody(body); // 设置商品描述
        model.setTimeoutExpress("30m"); // 超时关闭该订单时间
        // model.setSellerId("416032133@qq.com"); // 商家id
        alipayRequest.setBizModel(model);// 参数传到request中
        // 异步回调地址
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //同步地址
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        // 生成表单
        System.out.println("ddd");
        return client.pageExecute(alipayRequest).getBody();
    }

    @RequestMapping("/save")
    @ResponseBody
    public void saveResult(HttpServletRequest req, String out_trade_no, String trade_no, String trade_status) throws AlipayApiException, UnsupportedEncodingException {
        //获取支付宝POST过来反馈信息
    	System.out.println("666");
//    	System.out.println("trade_no:"+trade_no);
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = req.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");

            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGNTYPE); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——

		/* 实际验证过程建议商户务必添加以下校验：
		1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
		2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
		3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
		4、验证app_id是否为该商户本身。
		*/
        
        System.out.println(signVerified);
        if(!signVerified) {//验证成功
            if (trade_status.equals("TRADE_SUCCESS")){
            	System.out.println("trade_no:"+trade_no);
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序
            	//更新order的flag
            	System.out.println("out_trade_no:"+out_trade_no);
                order02Controller.updateOrderByOnum(out_trade_no,trade_no);
                Integer uid=1;
                SeatToOrderDto orderDTO=(SeatToOrderDto) redisUtil.get("orderDTO"+out_trade_no);
                //更新seatrecord表
                order02Controller.upSeats(orderDTO);
                //注意：
                //付款完成后，支付宝系统发送该交易状态通知
            }
        }
    }

    @RequestMapping("/refund")
    @ResponseBody
    public void refund(@RequestParam("response") HttpServletResponse response,@RequestParam("ordernumber") String ordernumber,@RequestParam("payNumber") String payNumber,@RequestParam("total_money") String total_money) {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);

        //设置请求参数
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();

//		//商户订单号，商户网站订单系统中唯一订单号
        String out_trade_no = ordernumber;
//		//支付宝交易号
        String trade_no = payNumber;
//		//请二选一设置
//		//需要退款的金额，该金额不能大于订单金额，必填
        String total_amount =  total_money;
//		//退款的原因说明
        String refund_reason = "";
//		//标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
        String out_request_no = "";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"trade_no\":\""+ trade_no +"\","
                + "\"refund_amount\":\""+ total_amount +"\","
                + "\"refund_reason\":\""+ refund_reason +"\","
                + "\"out_request_no\":\""+ out_request_no +"\"}");

        //请求
        String result;
        try {
            result = alipayClient.execute(alipayRequest).getBody();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out;
            try {
                out = response.getWriter();
                response.sendRedirect("https://www.baidu.com");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }






}
