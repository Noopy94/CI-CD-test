package com.ssafy.ssafit.dao;

import java.util.List;

import com.ssafy.ssafit.dto.Calendar;

public interface CalendarDao {

	public List<Calendar> selectAll(int user_id, int month);
	public Calendar selectOne(int user_id, int month, int day);
	public void insertCalendar(Calendar calendar);
	
	//랭킹 시스템에 필요한 Dao
	public List<Calendar> rankAll(int month, int day);
	public List<Calendar> rankbyGroup(int month, int day, int groupid);
	
}
