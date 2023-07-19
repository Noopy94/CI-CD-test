package com.ssafy.ssafit.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.dao.GroupDao;
import com.ssafy.ssafit.dto.Group;

@Service
public class GroupServiceImpl implements GroupService {
	
	private GroupDao groupDao;
	
	@Autowired
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	@Override
	public List<Group> getGroupList(int userid) {
		return groupDao.selectAll(userid);
	}

	@Override
	public Group getGroup(int groupid) {
		return groupDao.selectOne(groupid);
	}

	@Override
	public List<Group> searchGroup(String groupname) {
		return groupDao.search(groupname);
	}

	@Transactional
	@Override
	public void modifyGroup(Group group) {
		groupDao.updateGroup(group);
	}

	@Transactional
	@Override
	public int registGroup(Group group) {
		return groupDao.insertGroup(group);
	}

	@Override
	public int getlastGroup() {
		return groupDao.lastnumGroup();
	}

}
