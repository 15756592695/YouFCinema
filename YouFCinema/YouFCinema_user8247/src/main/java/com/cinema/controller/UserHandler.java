package com.cinema.controller;

import com.cinema.interfaces.OrderController;
import com.cinema.pojo.Movie;
import com.cinema.pojo.Order;
import com.cinema.pojo.User;
import com.cinema.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {
    private static String UPLOADED_FOLDER = "E://idea//endpro4//" +
            "YouFCinema//YouFCinema//YouFCinema_user8247//src//main//resources//static//headimg//";

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "注册",notes = "注册账号")
    public void register(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/login")
    @ApiOperation(value = "登录",notes = "登录账号")
    public String login(@RequestBody User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getU_tel(),user.getU_password());
        try{
            subject.login(token);
            return "登陆成功";
        }catch (Exception e){
            return "登录异常";
        }
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除",notes = "删除账号")
    public void delete(){
        userService.deleteUser();
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改",notes = "修改账号信息")
    public void update(@RequestBody User user){
        userService.modifyUser(user);
    }

    @PostMapping("/uploadHead")
    @ApiOperation(value = "上传头像",notes = "上传一个你自己的头像")
    public void uploadHead(MultipartFile file){
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
