package com.cinema.controller;

import cn.dsna.util.images.ValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
public class CodeImgHandler {
    @GetMapping("/loginCode")
    public void getLoginCode(HttpServletRequest req, HttpServletResponse resp){
        ValidateCode code = new ValidateCode(120,40,4,20);
        req.getSession().setAttribute("loginCode", code.getCode());
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            boolean flag = ImageIO.write(code.getBuffImg(), "JPEG",out);
            byte[] b=out.toByteArray();
            resp.getOutputStream().write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @GetMapping("/")
    public String index(){
        return "test.html";
    }

}
