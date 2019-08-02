package com.yy.controller;

import com.cinema.pojo.Comment;
import com.yy.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class CommentController {

    @Resource
    private CommentService commentService;

    // 根据电影id 查询 该电影的评价
    @GetMapping("/comment/{id}")
    public List<Comment> findAllById(@PathVariable(name = "id") int id){
//        System.out.println(id);
        return commentService.findAllById(id);
    }
    // 添加评论
    @PostMapping("/comment")
    public Boolean addComment(Comment comment){
        return commentService.addComment(comment);
    }

    @PutMapping("/comment")
    public Boolean delComment(Integer c_id){
        return commentService.delComment(c_id);
    }

    @GetMapping("/commentAll")
    public List<Comment> findAll(){
        return commentService.findAll();
    }
}
