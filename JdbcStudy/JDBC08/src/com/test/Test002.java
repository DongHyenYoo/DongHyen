package com.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.util.DBConn;

import oracle.jdbc.OracleTypes;

public class Test002
{

	public static void main(String[] args)
	{
		
		try
		{
			Connection conn = DBConn.getConnection();
			
			if(conn != null)
			{
				System.out.println(">>>데이터베이스 연결 성공!");
				
				try
				{
					String sql = "{call PRC_MEMBERSELECT(?)}";
					CallableStatement cstmt = conn.prepareCall(sql);
					
					//check~!!!
					//프로시저 내부에서 SYS_REFCURSOR 를 사용하고 있기 때문에
					// OracleTypes.CURSOR 를 사용하기 위한 등록 과정이 필요한 상황
					
					//1. 프로젝트명 마우스 우클릭 > Build Path > Configure Build Path...
					//   → 대화창 호출
//					  2. Libraries 탭 클릭 > Add External JARs 버튼 클릭
//					     > 『ojdbc6.jar』 파일 추가 등록
					// 『import oracle.jdbc.OracleTypes;』 구문추가
					
					cstmt.registerOutParameter(1, OracleTypes.CURSOR);
					cstmt.execute();
					ResultSet rs = (ResultSet)cstmt.getObject(1); //이름을 가지고 넘겨주는게 아니라 인덱스로 받음
					//getObject는 반환자료형이 Object일뿐 넘겨주는것은 ResultSet이기에 다운캐스팅이 가능하다
					//즉
					//Object 메소드()
//					{
//					
//						result = new ResultSet 
//								
//						return result
//					}
					//과 같이 만들어져서 result 는 ResultSet이나 반환자료형이 Object인것
					
			
					while (rs.next())
					{
						String sid = rs.getString("SID");
						String name = rs.getString("NAME");
						String tel = rs.getString("TEL");
						
						String str = String.format("%3s %7s %12s", sid, name, tel);
						
						System.out.println(str);
						
					}
					
					rs.close();
					cstmt.close();
					
				} catch (Exception e)
				{
					System.out.println(e.toString());
					// TODO: handle exception
				}
				
				
			}
			
			DBConn.close();
			
			System.out.println("데이터 베이스 연결종료");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		
		// TODO Auto-generated method stub

	}//end main

}//end class 
