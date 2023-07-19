package com.ssafy.ssafit.dao;

import java.util.List;

import com.ssafy.ssafit.dto.Linktable;

public interface LinktableDao {
	
	// 유저 아이디로 해당된 그룹을 찾기 위해서 
	public List<Linktable> selectbyuser(int userid);
	// 해당 그룹에서 속한 유저를 찾기 위해서 
	public List<Linktable> selectbygroup(int groupid);
	// 추가해주기 
	public int insertLinktable(Linktable linktable);

}
