package com.yy.service;

import com.cinema.pojo.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {

    // 根据电影id 查询 该电影的评价
     List<Comment> findAllById(int id);

    // 根据电影id 添加 该电影的评价
     Boolean addComment(Comment comment);

    // 根据评论id 删除评论
     Boolean delComment(Integer id);
}
