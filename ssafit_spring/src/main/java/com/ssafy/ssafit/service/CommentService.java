package com.ssafy.ssafit.service;

import java.util.List;

import com.ssafy.ssafit.dto.Comment;

public interface CommentService {

	// 비디오에 맞는 코멘트 전체 조회
	public List<Comment> getCommentList(String videoid);
	// 코멘트 상세조회
	public Comment getComment(int commentId);
	// 코멘트 작성
	public int writeComment(Comment comment);
	// 코멘트 삭제
	public void removeComment(int commentId);
	// 코멘트 수정
	public void modifyComment(Comment comment);
}
