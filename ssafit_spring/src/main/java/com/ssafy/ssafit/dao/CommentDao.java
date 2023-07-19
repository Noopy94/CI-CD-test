package com.ssafy.ssafit.dao;

import java.util.List;
import com.ssafy.ssafit.dto.Comment;

public interface CommentDao {
	
	public List<Comment> selectAll(String videoid);
	public Comment selectOne(int commentid);
	public int insertComment(Comment comment);
	public void deleteComment(int commentid);
	public void updateComment(Comment comment);

}
