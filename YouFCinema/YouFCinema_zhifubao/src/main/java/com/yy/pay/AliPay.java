package com.yy.pay;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradePayResponse;
import com.yy.config.AlipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AliPay {
    /*
     *  out_trade_no;// 订单编号 （商家提供唯一的编号）
     *  subject; //订单名称
     *  total_amount; // 金额
     *  body;    // 商品名称
     *  product_code; // 商品码
     */
    @ResponseBody
    @GetMapping("/pay")
    public String pay(String out_trade_no ,String subject,String total_amount) throws AlipayApiException {
//        封装 rsa签名方式
        /*
         * 参数1:请求网关
         * 参数2：收款人id
         * 参数3：支付宝密钥
         * 参数4：返回格式
         * 参数5：字符编码格式
         * 参数6：支付宝公钥
         * 参数7：加密方式
         * */
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
        model.setSubject(subject); // 订单名称
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
//        System.out.println(form);
      
        return client.pageExecute(alipayRequest).getBody();
    }

}
