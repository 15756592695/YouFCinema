package com.yy.service;

import com.cinema.pojo.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {

     List<Comment> findAllById(int id);
}
