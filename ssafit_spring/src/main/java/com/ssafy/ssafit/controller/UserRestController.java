package com.ssafy.ssafit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.dto.User;
import com.ssafy.ssafit.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "유저 컨트롤러")
@RequestMapping("/api-user")
public class UserRestController {

	@Autowired
	private UserService userService;

	// 회원가입
	@ApiOperation(value = "회원가입")
	@PostMapping("/user")
	public ResponseEntity<Integer> signup(@RequestBody User user) {
		int result = userService.signup(user);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	// 로그인
	@ApiOperation(value = "로그인")
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
		User tmp = userService.login(user.getUser_id(), user.getPassword());
		if (tmp == null)
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		else {session.setAttribute("loginUser", tmp);
		return new ResponseEntity<User>(tmp, HttpStatus.OK);}
	}

	// 로그아웃
	@ApiOperation(value = "로그아웃")
	@GetMapping("logout")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 정보 수정
	@ApiOperation(value = "정보 수정")
	@PutMapping("/user")
	public ResponseEntity<Void> update(@RequestBody User user) {
		userService.modifyUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 닉네임으로 검색
	@ApiOperation(value = "유저 닉네임으로 검색")
	@GetMapping("/search")
	public ResponseEntity<?> search(String nickname) {
		List<User> users = userService.search(nickname);
		if (users == null || users.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	//아이디 1개 가져오기
	@ApiOperation(value = "아디 한개 가져오기")
	@GetMapping("/getuser")
	public ResponseEntity<?> selectone(String userid) {
		User user = userService.selectOnebyId(userid);
		if (user != null) return new ResponseEntity<User>(user, HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	

	// 아이디 중복 확인
	@ApiOperation(value = "아디 중복확인")
	@GetMapping("/checkid/{userid}")
	public ResponseEntity<Boolean> checkbyid(@PathVariable String userid) {
	    User user = userService.checkbyId(userid); // 1, 0
	    if (user == null) {
	    	return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	    }
	    else {
	    	return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	    }
	}

	// 닉네임 중복 확인
	@ApiOperation(value = "닉네임 중복확인")
	@GetMapping("/checknickname/{nickname}")
	public ResponseEntity<Boolean> checkbyNickname(@PathVariable String nickname) {
	    User user = userService.checkbyNickname(nickname); // 1, 0
	    if (user == null)
	        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	    else
	        return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	}
	
	//그룹에 속한 유저들 가져오기
	@ApiOperation(value = "그룹에 속한 유저들")
	@GetMapping("/users")
	public ResponseEntity<?> getUsersbyGroup(int groupid) {
		List<User> users = userService.selectAllbyGroup(groupid);
		if (users == null || users.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	

}
