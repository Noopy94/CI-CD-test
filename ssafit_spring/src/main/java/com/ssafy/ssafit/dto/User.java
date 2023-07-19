package com.ssafy.ssafit.dto;


public class User {
	
	private int id;
	private String password;
	private String nickname;
	private String user_id;
	private int height;
	private int weight;	
	private int exp;
	
	public User() {
	}
	
	public User(int id, String password, String nickname, String user_id, int height, int weight, int exp) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.user_id = user_id;
		this.height = height;
		this.weight = weight;
		this.exp = exp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", nickname=" + nickname + ", user_id=" + user_id
				+ ", height=" + height + ", weight=" + weight + ", exp=" + exp + "]";
	}

	

}
