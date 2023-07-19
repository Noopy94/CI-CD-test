package com.ssafy.ssafit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.dao.CommentDao;
import com.ssafy.ssafit.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService{

	private CommentDao commentDao;
	
	@Autowired
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public List<Comment> getCommentList(String videoid) {
		return commentDao.selectAll(videoid);
	}

	@Override
	public Comment getComment(int commentId) {
		return commentDao.selectOne(commentId);
	}

	@Transactional
	@Override
	public int writeComment(Comment comment) {
		return commentDao.insertComment(comment);
	}

	@Transactional
	@Override
	public void removeComment(int commentId) {
		commentDao.deleteComment(commentId);
	}

	@Transactional
	@Override
	public void modifyComment(Comment comment) {
		commentDao.updateComment(comment);
	}

	

}
