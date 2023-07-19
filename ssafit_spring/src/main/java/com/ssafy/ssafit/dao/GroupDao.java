package com.ssafy.ssafit.dao;

import java.util.List;

import com.ssafy.ssafit.dto.Group;

public interface GroupDao {
	
	public List<Group> selectAll(int userid);
	public Group selectOne(int groupid);
	public void updateGroup(Group group);
	public List<Group> search(String groupname);
	public int insertGroup(Group group);
	public int lastnumGroup();
	
}
