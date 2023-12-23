package com.rcs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.rcs.entity.Member;

public class RegisterDao {
	
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://localhost:3306/railway";
	private String dbUname = "root";
	private String dbPassword = "abdul123@";
	
	public void loadDriver(String dbDriver) {
		try {
		Class.forName(dbDriver);
		} catch (Exception e) {
		
			System.out.println(e);
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
		con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public String insert(Member member)
	{
	loadDriver(dbDriver);
	Connection con = getConnection();
	String result = "Data entered successfully";
	String sql = "insert into user values(?,?,?)";
	PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, member.getUname());
		ps.setString(2, member.getPassword());
		ps.setString(3, member.getEmail());
		ps.executeUpdate();
		
		} catch (Exception e) {
	
		System.out.println(e);
		result = "Data not entered";
		}
	
	return result;
	}
	

}