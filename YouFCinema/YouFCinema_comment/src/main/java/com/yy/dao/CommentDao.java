package com.yy.dao;

import com.cinema.pojo.Comment;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentDao {

    @Select("SELECT * FROM `comment` WHERE c_id=#{id}")
    List<Comment> findAllById(int id);


}
