package com.cinema.service.impl;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.dao.ErweiDao;
import com.cinema.service.ErweiService;
import com.cinema.util.QRCodeUtil;

@Service
public class ErweiServiceImpl implements ErweiService {
	@Autowired
	private ErweiDao erweiDao;

	@Override
	public String createPic() {
		

		// 存放在二维码中的内容(订单号作为取票码)
		String text ="123456";
		// 嵌入二维码的图片路径(用户头像)
		String imgPath = "G:/007.jpg";
		// 生成的二维码的路径及名称
		String picname=UUID.randomUUID()+".jpg";
		String destPath = "G:/"+picname;
		// 生成二维码
		try {
			QRCodeUtil.encode(text, imgPath, destPath, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 解析二维码
		String str=null;
		try {
			str = QRCodeUtil.decode(destPath);
			// 打印出解析出的内容
			System.out.println(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destPath;
	}

}
