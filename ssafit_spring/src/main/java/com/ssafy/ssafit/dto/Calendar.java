package com.ssafy.ssafit.dto;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Calendar {
	
	private int idcalendar;
	private int user_id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private int timesum;

	public Calendar() {
	}

	public Calendar(int idcalendar, int user_id, LocalDate date, int timesum) {
		super();
		this.idcalendar = idcalendar;
		this.user_id = user_id;
		this.date = date;
		this.timesum = timesum;
	}

	public int getIdcalendar() {
		return idcalendar;
	}

	public void setIdcalendar(int idcalendar) {
		this.idcalendar = idcalendar;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getTimesum() {
		return timesum;
	}

	public void setTimesum(int timesum) {
		this.timesum = timesum;
	}

	
}
