package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBConn;

/*
 -데이터베이스 액션 처리 전용 클래스
 (TBL_MEMBER 테이블 전용 DAO)
 
 */

public class MemberDAO
{
	
	private Connection conn;
	
	//데이터 베이스 연결 담당 메소드
	public Connection connection() throws ClassNotFoundException, SQLException
	{
		
		conn = DBConn.getConnection();
		return conn;
		
	}
	
	
	//데이터 입력 담당 메소드
	public int add(MemberDTO dto) throws SQLException
	{
		
		int result = 0;
		
		//sql정의
		
		String sql = "INSERT INTO TBL_MEMBER(SID,NAME,TEL) VALUES(MEMBERSEQ.NEXTVAL, ?, ?)";
		
		//작업객체
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//들어갈 변수 넣기
		
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getTel());
		
		result = pstmt.executeUpdate();
		
		
		pstmt.close();
		
		return result;
		
	}
	
	//회원 리스트 출력 담당 메소드
	public ArrayList<MemberDTO> list() throws SQLException
	{
		
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		
		//sql
		String sql = "SELECT SID,NAME,TEL FROM TBL_MEMBER ORDER BY SID";
		
		//작업객체
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			MemberDTO dto = new MemberDTO();
			
			dto.setSid(rs.getString("SID"));
			dto.setName(rs.getString("NAME"));
			dto.setTel(rs.getString("TEL"));
			
			result.add(dto);
		}
		
		rs.close();
		pstmt.close();
		
		return result;
		
		
	}
	
	//인원수 확인 담당 메소드
	public int count() throws SQLException
	{
		int result = 0;
		//sql
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_MEMBER";
		
		//작업객체
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next())
		{
			result = rs.getInt(1);
		}
		
		rs.close();
		pstmt.close();
		
		return result;
		
	}
	
	
	//회원 데이터 검색 담당 메소드(sid 가지고 회원 데이터 조회)
	
	public MemberDTO searchMember(String sid) throws SQLException
	{
		
		MemberDTO result = new MemberDTO();
		
		String sql = "SELECT SID, NAME, TEL FROM TBL_MEMBER WHERE SID = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, sid);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			result.setSid(rs.getString("SID"));
			result.setName(rs.getString("NAME"));
			result.setTel(rs.getString("TEL"));
			
		}
		
		rs.close();
		
		pstmt.close();
		
		return result;
	}
	
	
	//회원 데이터 수정 메소드 정의
	
	public int modify(MemberDTO dto) throws SQLException
	{
		int result=0;
		
		String sql = "UPDATE TBL_MEMBER SET NAME= ?, TEL=? WHERE SID=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, dto.getName() );
		pstmt.setString(2, dto.getTel());
		pstmt.setString(3, dto.getSid());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		
		return result;
		
	}
	
	
	//회원데이터 삭제 담당 메소드
	
	public int remove(String sid) throws SQLException
	{
		int result=0;
		
		String sql = "DELETE FROM TBL_MEMBER WHERE SID = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, sid);
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		
		return result;
	}
	
	
	//자식 테이블의 참조 데이터 레코드 수를 확인하는 메소드
	public int refCount(String sid) throws SQLException
	{
		int result=0;
		
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_MEMBERSCORE WHERE SID = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, sid);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next())
		{
			result = rs.getInt("COUNT");
		}
		
		return result;
	}
	
	
	
	//데이터베이스 연결 종료 담당 메소드
	public void close() throws SQLException
	{
		DBConn.close();
	}

}
