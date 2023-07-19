package com.ssafy.ssafit.dto;

public class Exercise {

	private int id;
	private int user_id;
	private String name;
	private int time;
	
	public Exercise() {	
	}

	public Exercise(int id, int user_id, String name, int time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.name = name;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	

}
