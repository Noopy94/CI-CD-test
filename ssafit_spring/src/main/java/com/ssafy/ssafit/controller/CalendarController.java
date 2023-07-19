package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.dto.Calendar;
import com.ssafy.ssafit.service.CalendarService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "달력 컨트롤러")
@RequestMapping("/api-calendar")
public class CalendarController {

	@Autowired
	private CalendarService calendarService;

	// 1. 현재 달에 맞는 캘린더 리스트 가져오기
	@ApiOperation(value = "운동 기록 조회", notes = "달과 userid로 검색")
	@GetMapping("/calendar")
	public ResponseEntity<?> list(int userid, int month) {
		List<Calendar> list = calendarService.getCalendarList(userid, month);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Calendar>>(list, HttpStatus.OK);
	}
	
	// 2. 특정 날짜에 맞는 캘린더 가져오기 
	@ApiOperation(value="날짜별 운동 기록 조회")
	@GetMapping("/calendar/{day}")
	public ResponseEntity<Calendar> detail(int userid, int month, @PathVariable int day){
	    Calendar calendar = calendarService.getCalendar(userid, month, day);
		return new ResponseEntity<Calendar>(calendar, HttpStatus.OK);
	}
	
	//3. 캘린더 추가하기 
	@ApiOperation(value="하루하루 기록 등록")
	@PostMapping("/calendar")
	public ResponseEntity<Calendar> write(Calendar calendar){
		calendarService.registCalendar(calendar);
		return new ResponseEntity<Calendar>(calendar, HttpStatus.CREATED);
	}
}
