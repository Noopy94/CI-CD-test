package com.ssafy.ssafit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.dao.LinktableDao;
import com.ssafy.ssafit.dto.Linktable;

@Service
public class LinktableServiceImpl implements LinktableService{

	private LinktableDao linktableDao;
	
	@Autowired
	public void setLinktableDao(LinktableDao linktableDao) {
		this.linktableDao = linktableDao;
	}
	
	@Override
	public List<Linktable> selectbyuser(int userid) {
		return linktableDao.selectbyuser(userid);
	}

	@Override
	public List<Linktable> selectbygroup(int groupid) {
		return linktableDao.selectbygroup(groupid);
	}

	@Transactional
	@Override
	public int registLinktable(Linktable linktable) {
		return linktableDao.insertLinktable(linktable);
	}
	

}
