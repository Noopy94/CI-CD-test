package com.ssafy.ssafit.service;

import java.util.List;

import com.ssafy.ssafit.dto.Calendar;

public interface CalendarService {
	//유저 아이디랑/몇월인지 확인해서 전체 조회
	public List<Calendar> getCalendarList(int userid, int month);
	//특정  Calendar 찾기 
	public Calendar getCalendar(int userid, int month, int day);
	//추가하기 
	public void registCalendar(Calendar calendar);
	
	//전체 랭킹 찾기 
	public List<Calendar> rankAll(int month, int day);
	public List<Calendar> rankbyGroup(int month, int day, int groupid);
	
}
