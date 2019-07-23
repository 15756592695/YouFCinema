package com.yy.service.Imp;

import com.cinema.pojo.Comment;
import com.yy.dao.CommentDao;
import com.yy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("CommentService")
public class CommentServiceImp implements CommentService {

    @Resource
    private CommentDao commentDao;

    @Override
    public List<Comment> findAllById(int id) {
        return commentDao.findAllById(id);
    }

    @Override
    public Boolean addComment(Comment comment) {
        return commentDao.addComment(comment);
    }

    @Override
    public Boolean delComment(Integer id) {
        return commentDao.delComment(id);
    }
}
