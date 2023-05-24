package com.test;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IMemberDAO
{
	public ArrayList<Member> list() throws SQLException;
	public int add(Member dto) throws SQLException;
	public int modify(Member dto) throws SQLException;
	public int remove(String id) throws SQLException;
	public Member searchId(String id) throws SQLException;
	public String login(String id, String pw) throws SQLException; 		// 학생 로그인 메소드
	public String loginAdmin(String id, String pw) throws SQLException; // 관리자 로그인 메소드
	
}
