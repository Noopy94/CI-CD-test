package com.ssafy.ssafit.dto;

public class Linktable {
	
	private int id;
	private int userid;
	private int groupid;
	
	public Linktable() {
	}

	public Linktable(int id, int userid, int groupid) {
		this.id = id;
		this.userid = userid;
		this.groupid = groupid;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	
	

}
