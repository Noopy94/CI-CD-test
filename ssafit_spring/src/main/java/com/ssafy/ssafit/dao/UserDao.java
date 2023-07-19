package com.ssafy.ssafit.dao;

import java.util.List;
import com.ssafy.ssafit.dto.User;

public interface UserDao {
	
	public List<User> selectAll(int groupid);
//	public User selectOne(int userid); 
	public User selectOnebyId(String userid); 
	public int insertUser(User user);
	public List<User> search(String nickname);
	public void updateUser(User user);
	public User checkbyNickname(String nickname);
	public User checkbyId(String userid);

}
