package com.ssafy.ssafit.service;

import java.util.List;

import com.ssafy.ssafit.dto.Group;

public interface GroupService {
	
	//그룹 전체 
	public List<Group> getGroupList(int userid);
	// 그룹 하나 가져오기 
	public Group getGroup(int groupid);
	//그룹 서치 
	public List<Group> searchGroup(String groupname);
	//그룹 정보 수정하기 
	public void modifyGroup(Group group);
	//그룹 추가하기 
	public int registGroup(Group group);
	// 마지막 인트값 받아오기
	public int getlastGroup();
	

}
