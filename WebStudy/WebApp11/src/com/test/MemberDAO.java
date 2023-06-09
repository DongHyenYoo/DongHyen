package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBConn;

/*=====================
 * 데이터베이스 액션 처리 전용 객체 활용
 */

public class MemberDAO
{
	//주요 속성 구성
	private Connection conn;
	
	
	//주요 기능 구성(메소드 정의)
	
	//데이터 베이스 연결 메소드 정의
		
	
	public MemberDAO() throws ClassNotFoundException, SQLException
	{
		conn = DBConn.getConnection();
		
	}
	
	
	//데이터 입력 메소드
	
	public int add(MemberDTO dto) throws SQLException
	{
		//결과값 변수 선언 및 초기화
		int result = 0;
		
		//쿼리문 준비
		String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL)" +" VALUES(MEMBERSEQ.nextval, ?, ?)";
		
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getTel());
		
		result = pstmt.executeUpdate();
		pstmt.close();
		
		
		//최종 결과값 반환
		
		
		
		return result;
		

		
	}
	
	
	
	//리스트 전체 출력 메소드 정의
	
	public ArrayList<MemberDTO> list() throws SQLException
	{
		
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		
		String sql = "SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			MemberDTO dto = new MemberDTO();
			dto.setSid(rs.getString("SID")); // get~ 는 오라클에서 어떤 형태로주는지 모르기에 
									//getString이면 값을 String 으로받아오고 Int면 Int로 받아온다는것
		
			dto.setName(rs.getString("NAME"));
			dto.setTel(rs.getString("TEL"));
			
			result.add(dto);
		}
		
		rs.close();
		pstmt.close();
		
		return result;
		
	}
	
	
	//인원 수 확인을 위한 메소드 정의
	
	public int count() throws SQLException
	{
		int result=0;
		
		String sql="SELECT COUNT(*) AS COUNT FROM TBL_MEMBER";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			result = rs.getInt("COUNT");
			
		}
		
		rs.close();
		pstmt.close();
		
		return result;
	}
	
	
	public void close() throws SQLException
	{
		DBConn.close();
	}
	
	//데이터 베이스 연결 종료 담당 메소드 정의
	
	
}
