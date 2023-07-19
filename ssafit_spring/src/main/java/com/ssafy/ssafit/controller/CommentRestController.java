package com.ssafy.ssafit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.dto.Comment;
import com.ssafy.ssafit.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "코멘트 컨트롤러")
@RequestMapping("/api-comment")
public class CommentRestController {

	@Autowired
	private CommentService commentService;

	//1. 댓글 등록
	@ApiOperation(value = "댓글 등록")
	@PostMapping("/comment")
	public ResponseEntity<Integer> regist(@RequestBody Comment comment) {
		int result = commentService.writeComment(comment);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	//2. 댓글 삭제
	@ApiOperation(value = "댓글 삭제")
	@DeleteMapping("/comment/{commentId}")
	public ResponseEntity<Void> delete(@PathVariable int commentId) {
		commentService.removeComment(commentId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	//3. 댓글 수정
	@ApiOperation(value = "댓글 수정")
	@PutMapping("/comment")
	public ResponseEntity<Void> update(Comment comment) {
		commentService.modifyComment(comment);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	//4. 비디오아이디에 맞는 코멘트 리스트 검색
	@ApiOperation(value = "비디오아이디에 맞는 코멘트 리스트 검색")
	@GetMapping("/comment/{videoid}")
	public ResponseEntity<?> search(@PathVariable String videoid) {
		List<Comment> list = commentService.getCommentList(videoid);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Comment>>(list, HttpStatus.OK);
	}

	//5. 코멘트 상세
	@ApiOperation(value = "리뷰 상세보기")
	@GetMapping("/detail/{commentId}")
	public ResponseEntity<Comment> detail(@PathVariable int commentId) {
		Comment comment = commentService.getComment(commentId);
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}

}
