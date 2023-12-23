package com.rcs.entity;

public class Member {
	
	private String uname; 
	private String password;
	private String email;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String uname, String password, String email) {
		super();
		this.uname = uname;
		this.password = password;
		this.email = email;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [uname=" + uname + ", password=" + password + ", email=" + email + "]";
	}
	
	
	
}

