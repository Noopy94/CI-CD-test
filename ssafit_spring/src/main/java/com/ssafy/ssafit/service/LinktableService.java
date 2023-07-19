package com.ssafy.ssafit.service;

import java.util.List;

import com.ssafy.ssafit.dto.Linktable;

public interface LinktableService {
	
	public List<Linktable> selectbyuser(int userid);
	public List<Linktable> selectbygroup(int groupid);
	public int registLinktable(Linktable linktable);

}
