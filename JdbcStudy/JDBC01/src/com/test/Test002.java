/*================================
  Test002.java
  -데이터 입력 실습 진행
  
===============================*/
package com.test;

import java.sql.Connection;
import java.sql.Statement;

import com.util.DBConn;

public class Test002
{
	public static void main(String[] args)
	{
		Connection conn = DBConn.getConnection();
		
		if (conn == null)
		{
			System.out.println("데이터 베이스 연결 실패");
			System.exit(0);
			
		}
		
		//System.out.println("데이터 베이스 연결 성공");
		
		try
		{
			//작업 객체 준비
			Statement stmt = conn.createStatement(); //Connection 연결객체에 작업객체를 달아놓음
			
			//데이터 입력 쿼리 실행 과정
			//한번 실행하면 PK 제약조건 때문에
			//다시 실행하지 못한다.
			// 기본기 제약조건이 설정되어 있으므로...
			
			//쿼리문 준비 작업객체에 DB에 전달할 
			String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(2, '민찬우' , '010-2222-2222')";
			//주의 쿼리문 끝에 ; 안쓰게 주의
			// 주의. 자바에서 실행한 DML구문은 내부적으로 자동 커밋된다.
			// 주의. 오라클에서 트랜잭션 처리가 끝나지 않으면
			//       데이터 액션 처리가 이루어지지 않는다.
			//       (즉, 오라클에서 직접 쿼리문을 테스트할 경우 COMMIT 또는 ROLLBACK을 반드시 해야댐
			
			int result = stmt.executeUpdate(sql);
			//executeUpdate = 데이터의 변화에 영향을 미칠때쓴다.
			//executeQuery = 데이터에 영향이 없음 ex)SELECT
			
			if (result > 0)
			{
				System.out.println("데이터 입력 성공~!!!");
			}
			else 
			{
				System.out.println("데이터 입력 실패..");
				
			}
			
			
		} catch (Exception e)
		{
			
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		DBConn.close();
	}
	

}
