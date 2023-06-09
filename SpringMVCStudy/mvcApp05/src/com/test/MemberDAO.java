package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.test.Member;

public class MemberDAO implements IMemberDAO
{
	private DataSource dataSource;
	
	
	

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public ArrayList<Member> list() throws SQLException
	{
		Connection conn =  dataSource.getConnection();
		
		ArrayList<Member> result = new ArrayList<Member>();
		
		String sql="SELECT ID, NAME, TEL, EMAIL FROM MEMBERLIST";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			Member member = new Member();
			
			member.setId(rs.getString("ID"));
			member.setName(rs.getString("NAME"));
			member.setTel(rs.getString("TEL"));
			member.setEmail(rs.getString("EMAIL"));
			result.add(member);
			
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
		
	}

	@Override
	public int add(Member member) throws SQLException
	{
		int result = 0;
		
		String sql = "INSERT INTO MEMBERLIST(ID, PW, NAME, TEL, EMAIL)"
				   + " VALUES(?, CRYPTPACK.ENCRYPT(?, ?), ?, ?, ?)";
		
		Connection conn= dataSource.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPw());
		pstmt.setString(3, member.getPw());
		pstmt.setString(4, member.getName());
		pstmt.setString(5, member.getTel());
		pstmt.setString(6, member.getEmail());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public int modify(Member member) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "UPDATE MEMBERLIST"
				   + " SET ID=?, PW=CRYPTPACK.ENCRYPT(?,?), NAME=?, TEL=?, EMAIL=?"
				   + " WHERE ID = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPw());
		pstmt.setString(3, member.getPw());
		pstmt.setString(4, member.getName());
		pstmt.setString(5, member.getTel());
		pstmt.setString(6, member.getEmail());
		pstmt.setString(7, member.getId());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		
		
		return result;
	}

	@Override
	public int remove(String id) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "DELETE"
				   + " FROM MEMBERLIST"
				   + " WHERE ID = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, id);
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public Member searchId(String id) throws SQLException
	{
		Member result = new Member();
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT ID, PW, NAME, TEL, EMAIL"
				   + " FROM MEMBERLIST"
				   + " WHERE ID = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			result.setId(rs.getString("ID"));
			result.setPw(rs.getString("PW"));
			result.setName(rs.getString("NAME"));
			result.setTel(rs.getString("TEL"));
			result.setEmail(rs.getString("EMAIL"));
			
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}

	
	@Override
	public String login(String id, String pw) throws SQLException
	{
		String result = null;
		
		String sql = "SELECT NAME"
				   + " FROM MEMBERLIST"
				   + " WHERE ID=?"
				   + " AND PW=CRYPTPACK.ENCRYPT(?, ?)";
		
		Connection conn = dataSource.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, pw);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			result = rs.getString("NAME");
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public String loginAdmin(String id, String pw) throws SQLException
	{
		String result = null;
		
		String sql = "SELECT NAME"
				   + " FROM MEMBERLIST"
				   + " WHERE ID=?"
				   + " AND PW=CRYPTPACK.ENCRYPT(?, ?)"
				   + " AND GRADE = 0";
		
		Connection conn = dataSource.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, pw);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			result = rs.getString("NAME");
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}
	
	

}
