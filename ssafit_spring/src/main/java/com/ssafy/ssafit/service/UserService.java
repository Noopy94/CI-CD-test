package com.ssafy.ssafit.service;

import java.util.List;

import com.ssafy.ssafit.dto.User;

public interface UserService {
	
	// 회원가입 하기 
	public int signup(User user);
	// 로그인 하기 
	public User login(String id, String password);
	// 유저 정보 수정하기 
	public void modifyUser(User user);
	// 유저 닉네임으로 검색하기
	public List<User> search(String nickname);
	//유저 하나 가져오기 
		public User selectOnebyId(String userid);
	
	//유저 아이디 중복확인
	public User checkbyId(String userid);
	// 유저 닉네임 중복확인
	public User checkbyNickname(String nickname);
	// 그룹에 속한 유저 다 가져오기 
	public List<User> selectAllbyGroup(int groupid);
	
	
}
