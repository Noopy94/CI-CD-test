package com.ssafy.ssafit.dto;

public class Comment {
	
	private int id;
	private String youtube_id;
	private String content;
	private int user_id;
	
	public Comment() {
	}

	public Comment(int id, String youtube_id, String content, int user_id) {
		super();
		this.id = id;
		this.youtube_id = youtube_id;
		this.content = content;
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getYoutube_id() {
		return youtube_id;
	}

	public void setYoutube_id(String youtube_id) {
		this.youtube_id = youtube_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
