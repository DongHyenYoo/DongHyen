package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBConn;

public class ScoreDAO
{
	private Connection conn;

	public Connection connect()
	{
		conn = DBConn.getConnection();

		return conn;
	}

	public void close()
	{
		DBConn.close();
	}

	public int count() throws SQLException
	{
		int count = 0;
		// sql
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_SCORE";

		// 작업객체 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next())
		{
			count = rs.getInt("COUNT");

		}

		pstmt.close();
		rs.close();

		return count;

	}

//	7번 학생 성적 입력(이름 국어 영어 수학) : 이원영 50 60 70
//	8번 학생 성적 입력(이름 국어 영어 수학) : 김선아 80 80 80
//	9번 학생 성적 입력(이름 국어 영어 수학) : .
//	====[ 성적 처리 ]====

	// 1. 성적 입력
	public int add(ScoreDTO dto) throws SQLException
	{
		// sql 생성
		String sql = "INSERT INTO TBL_SCORE(SID, NAME, KOR, ENG, MAT) VALUES(SCORESEQ.NEXTVAL, ?, ?, ?, ?)";

		// 작업 객체 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getName());
		pstmt.setInt(2, dto.getKor());
		pstmt.setInt(3, dto.getEng());
		pstmt.setInt(4, dto.getMat());

		// 작업 객체 실행

		int result = pstmt.executeUpdate();

		pstmt.close();

		return result;

	}
	// 2. 성적 전체 출력

	public ArrayList<ScoreDTO> list() throws SQLException
	{
		// 데이터를 담을 자료구조 선언
		ArrayList<ScoreDTO> result = new ArrayList<ScoreDTO>();

		// sql 준비
		// 전체 인원 : 8명 -> process에서 처리
		// 번호 이름 국어 영어 수학 총점 평균 석차

		String sql = "SELECT SID, NAME, KOR, ENG, MAT, (KOR+ENG+MAT) AS TOT" + ", ROUND((KOR+ENG+MAT) / 3,1) AS AVG"
				+ ", RANK() OVER(ORDER BY (KOR + ENG + MAT) DESC) AS RANK FROM TBL_SCORE";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		// sql 실행
		ResultSet rs = pstmt.executeQuery();

		while (rs.next())
		{
			// dto 객체 생성
			ScoreDTO dto = new ScoreDTO();
			dto.setSid(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setKor(rs.getInt(3));
			dto.setEng(rs.getInt(4));
			dto.setMat(rs.getInt(5));
			dto.setTot(rs.getInt(6));
			dto.setAvg(rs.getDouble(7));
			dto.setRank(rs.getInt(8));

			result.add(dto);
		}

		rs.close();
		pstmt.close();

		return result;

	}

	// 3. 이름 검색 출력

	public ArrayList<ScoreDTO> list(String name) throws SQLException
	{
		// 데이터 담을 자료구조 선언
		ArrayList<ScoreDTO> result = new ArrayList<ScoreDTO>();

		// sql 작성
		String sql = "SELECT SID, NAME, KOR, ENG, MAT, TOT, AVG, RANK FROM"
				+ " (SELECT SID, NAME, KOR, ENG, MAT, (KOR + ENG + MAT) AS TOT"
				+ ", (KOR + ENG + MAT) / 3 AS AVG, RANK() OVER(ORDER BY (KOR + ENG + MAT) DESC) AS RANK FROM TBL_SCORE)"
				+ " WHERE NAME LIKE '%' || ? || '%'";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, name);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next())
		{
			ScoreDTO dto = new ScoreDTO();
			dto.setSid(rs.getInt("SID"));
			dto.setName(rs.getString("NAME"));
			dto.setKor(rs.getInt("KOR"));
			dto.setEng(rs.getInt("ENG"));
			dto.setMat(rs.getInt("MAT"));
			dto.setTot(rs.getInt("TOT"));
			dto.setAvg(rs.getDouble("AVG"));
			dto.setRank(rs.getInt("RANK"));
			result.add(dto);

		}

		rs.close();
		pstmt.close();
		return result;

	}
	
	// 3-1 번호 검색 출력

		public ArrayList<ScoreDTO> list(int sid) throws SQLException
		{
			// 데이터 담을 자료구조 선언
			ArrayList<ScoreDTO> result = new ArrayList<ScoreDTO>();

			// sql 작성
			String sql = "SELECT SID, NAME, KOR, ENG, MAT, TOT, AVG, RANK FROM"
					+ " (SELECT SID, NAME, KOR, ENG, MAT, (KOR + ENG + MAT) AS TOT"
					+ ", (KOR + ENG + MAT) / 3 AS AVG, RANK() OVER(ORDER BY (KOR + ENG + MAT) DESC) AS RANK FROM TBL_SCORE)"
					+ " WHERE SID = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, sid);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				ScoreDTO dto = new ScoreDTO();
				dto.setSid(rs.getInt("SID"));
				dto.setName(rs.getString("NAME"));
				dto.setKor(rs.getInt("KOR"));
				dto.setEng(rs.getInt("ENG"));
				dto.setMat(rs.getInt("MAT"));
				dto.setTot(rs.getInt("TOT"));
				dto.setAvg(rs.getDouble("AVG"));
				dto.setRank(rs.getInt("RANK"));
				result.add(dto);

			}

			rs.close();
			pstmt.close();
			return result;

		}
	
	
	

	// 4. 성적 수정

	public int modify(ScoreDTO dto) throws SQLException
	{
		int result = 0;
		
		//SQL 작성
		String sql = "UPDATE TBL_SCORE SET NAME = ?, KOR = ?, ENG = ?, MAT = ? WHERE SID = ?";
		
		//작업객체 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//?값 채우기
		pstmt.setString(1, dto.getName());
		pstmt.setInt(2, dto.getKor());
		pstmt.setInt(3, dto.getEng());
		pstmt.setInt(4, dto.getMat());
		pstmt.setInt(5, dto.getSid());
		
		//실행
		result = pstmt.executeUpdate();
		
		pstmt.close();
		
		return result;

	}

	// 5. 성적 삭제
	public int delete(int sid) throws SQLException
	{
		int result = 0;
		
		//sql 작성
		String sql ="DELETE FROM TBL_SCORE WHERE SID = ?";
		
		//작업객체 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, sid);
		
		//실행
		result = pstmt.executeUpdate();
		
		pstmt.close();

		return result;

	}

}
