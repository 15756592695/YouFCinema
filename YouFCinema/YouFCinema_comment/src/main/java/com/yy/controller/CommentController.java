package com.yy.controller;

import com.cinema.pojo.Comment;
import com.yy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CommentController {

    @Resource
    private CommentService commentService;

    @GetMapping("/findAll/{id}")
    public List<Comment> findAllById(@PathVariable(name = "id") int id){
        return commentService.findAllById(id);
    }


}
