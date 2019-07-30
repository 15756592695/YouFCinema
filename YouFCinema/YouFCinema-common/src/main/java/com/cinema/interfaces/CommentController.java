package com.cinema.interfaces;

import com.cinema.pojo.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="comment-provider-8888")
public interface CommentController {

    @GetMapping("/comment/{id}")
    public List<Comment> findAllById(@PathVariable(name = "id") int id);
}
