package com.ssafy.ssafit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.dao.CalendarDao;
import com.ssafy.ssafit.dao.ExerciseDao;
import com.ssafy.ssafit.dto.Calendar;

@Service
public class CalendarServiceImpl implements CalendarService {
	
	private CalendarDao calendarDao;
	private ExerciseDao exerciseDao; 
	
	// exercise를 돌면서 timesum을 구해줘야함 아직 어캐 짜는지 정확히 모르겠음;;
	//이거 계산해서 해줘야함 일단 5/20기준으로 아직 못함;;
	
	@Autowired
	public void setCalendarDao(CalendarDao calendarDao) {
		this.calendarDao = calendarDao;
	}

	@Override
	public List<Calendar> getCalendarList(int userid, int month) {
		if (month>12) return null;
		return calendarDao.selectAll(userid, month);
	}

	@Override
	public Calendar getCalendar(int userid, int month, int day) {
		if (month>12) return null;
		if (day>31) return null;
		return calendarDao.selectOne(userid, month, day);
	}

	@Transactional
	@Override
	public void registCalendar(Calendar calendar) {
		calendarDao.insertCalendar(calendar);
	}

	@Override
	public List<Calendar> rankAll(int month, int day) {
		return calendarDao.rankAll(month, day);
	}

	@Override
	public List<Calendar> rankbyGroup(int month, int day, int groupid) {
		return calendarDao.rankAll(month, day);
	}
	
	

}
