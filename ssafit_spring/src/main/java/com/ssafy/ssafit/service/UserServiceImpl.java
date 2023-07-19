package com.ssafy.ssafit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.dao.UserDao;
import com.ssafy.ssafit.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	@Override
	public int signup(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public User login(String id, String password) {
		User tmp = userDao.selectOnebyId(id);
		if(tmp != null && tmp.getPassword().equals(password))
			return tmp;
		return null;
	}

	@Transactional
	@Override
	public void modifyUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public List<User> search(String nickname) {
		return userDao.search(nickname);
	}

	@Override
	public User checkbyNickname(String nickname) {
		return userDao.checkbyNickname(nickname);
	}
	
	@Override
	public User selectOnebyId(String userid) {
		return userDao.selectOnebyId(userid);
	}

	@Override
	public User checkbyId(String userid) {
		return userDao.checkbyId(userid);
	}

	@Override
	public List<User> selectAllbyGroup(int groupid) {
		return userDao.selectAll(groupid);
	}

}
