package com.yy.dao;

import com.cinema.pojo.Comment;
import com.yy.dyno.DynaSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommentDao {

    @Select("SELECT * FROM `comment` WHERE filmid=#{id} AND flag = 0")
    List<Comment> findAllById(int id);

    @Insert("INSERT INTO comment(c_message,uid,filmid,c_score) VALUES (#{c_message},#{uid},#{filmid},#{c_score})")
    Boolean addComment(Comment comment);

    @Update("UPDATE `comment` SET flag = 1 WHERE c_id=#{id}")
    Boolean delComment(Integer id);

    // 查询所有评论
    @SelectProvider(type= DynaSqlProvider.class,method="selectWhitParamSql")
    List<Comment> findAll(int id);
}
