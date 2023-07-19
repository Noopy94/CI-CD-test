package com.ssafy.ssafit.dto;

public class Groupcreate {

	private int userid;
	private int id;
	private String name;
	private String password;
	private String detail;
	private String notice;
	private String master;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public Groupcreate(int userid, int id, String name, String password, String detail, String notice, String master) {
		super();
		this.userid = userid;
		this.id = id;
		this.name = name;
		this.password = password;
		this.detail = detail;
		this.notice = notice;
		this.master = master;
	}

	public Groupcreate() {
	}

}
