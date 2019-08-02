package com.cinema.controller;

import com.cinema.pojo.User;
import com.cinema.service.UserService;
import com.cinema.utils.AccountFormat;
import com.cinema.utils.RedisUtil;
import com.cinema.utils.Upload;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Resource
    private UserService userService;
    @Resource
    private RedisUtil redisUtil;

    @PostMapping("/register")
    @ApiOperation(value = "注册", notes = "注册账号")
    public String register(@RequestBody User user) {

        //注册验证
        String verify = new AccountFormat().verify(user.getU_tel(), user.getU_password());
        if (!verify.equals("账号密码合法")) {
            return verify;
        }
        return userService.addUser(user);
    }

    @GetMapping("/login")
    @ApiOperation(value = "登录", notes = "登录账号")
    public String login(User user, HttpSession session, HttpServletRequest request) {

        String ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        System.out.println("登陆的网络ip地址为：" + ip);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getU_tel(), user.getU_password());
        try {
            subject.login(token);
            //数据库获取userId
            System.out.println("tel:"+user.getU_tel());
            Integer uid = userService.findIdByTel(user.getU_tel());
            System.out.println("uid:"+uid);
            redisUtil.set(ip,uid);
            System.out.println(redisUtil.get(ip));
            return "登陆成功";
        } catch (Exception e) {
            return "登录异常";
        }
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除", notes = "删除账号")
    public void delete() {
        userService.deleteUser();
    }


    @PutMapping("/update")
    @ApiOperation(value = "修改,任何数据的修改都可以在这里处理", notes = "修改账号信息，动态sql实现")
    public void update(@RequestBody User user) {
        userService.modifyUser(user);
    }


    @PostMapping("/uploadHead")
    @ApiOperation(value = "上传头像", notes = "上传一个你自己的头像")
    public void uploadHead(MultipartFile file) {
        Path path = new Upload().UploadHeadImg(file);
        String path2 = path.toString();
        userService.addHeadImg(path2.substring(84));
    }

    @GetMapping("/myselfInfo")
    @ApiOperation(value = "个人信息", notes = "某个用户的个人信息")
    public User myselfInfo() {
        return userService.myInfo();
    }


    @PutMapping("/modifyNickname")
    @ApiOperation(value = "修改昵称", notes = "用户个人修改昵称")
    public void modifyNickname(String nickname) {
        userService.modifyNickname(nickname);
    }


    //查询所有用户，给管理员操作
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有用户", notes = "管理员可以做这个操作，查询所有用户")
    public List<User> findAll() {
        return userService.findAllUser();
    }

    //批量删除，给管理员操作的
    @DeleteMapping("/deleteMore")
    @ApiOperation(value = "删除多个用户", notes = "给管理员操作，可以一次性删除多个用户")
    public void deleteMore(@RequestBody List<Integer> delete_ids) {
        userService.deleteMore(delete_ids);
    }

    //批量拉黑/取消拉黑也是他，给管理员操作的
    @PutMapping("/getBlacks")
    @ApiOperation(value = "拉黑（或取消拉黑）多个用户", notes = "给管理员操作，可以一次性拉黑（或取消拉黑）多个用户，flag设置为1")
    public void getBlacks(@RequestBody List<Integer> u_ids) {
        userService.getBlacks(u_ids);
    }

    //根据电话号码去找到用户(模糊查询)
    @GetMapping("/findUsersByTel/{likeTel}")
    @ApiOperation(value = "根据电话号码或者用户角色模糊查询用户", notes = "给管理员操作，可以模糊查询用户")
    public List<User> findUsersByTel(@PathVariable("likeTel") String likeTel) {
        return userService.findUsersByTel(likeTel);
    }
}
