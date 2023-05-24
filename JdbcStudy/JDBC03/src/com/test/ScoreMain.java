/*====================

○실습 문제

성적 처리 프로그램 구현 -> 데이터베이스 연동 -> ScoreDAO, ScoreDTO 활용


여러 명의 이름 국어점수 영어 점수 수학점수를 입력받아
총점, 평균을 연산하여 출력하는 프로그램을 구현한다.
출력 시 번호(이름 총점 등) 오름차순 정렬하여 출력한다.

실행예)

1번 학생 성적 입력(이름 국어 영어 수학) : 박원석 80 75 60
2번 학생 성적 입력(이름 국어 영어 수학) : 조영관 100 90 80
3번 학생 성적 입력(이름 국어 영어 수학) : 김보경 80 85 80


-----------------------------------------------
번호  이름   국어  영어 수학 총점 평균
-------------------------------------------------
1   주루룩
2
3


 =========================*/


package com.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

public class ScoreMain
{
	public static void main(String[] args)
	{
		try
		{
			ScoreDAO dao = new ScoreDAO();
			Scanner sc = new Scanner(System.in);
			
			
			
			while (true)
			{
				
				
				//DTO 객체 생성하고 스캐너로 이름, 성적 3개 입력받기
				System.out.printf("%d번 학생 성적 입력(이름 국어 영어 수학) : ",dao.count()+1);
				ScoreDTO dto = new ScoreDTO();
				String name = sc.next();
				//이름에서 N를 입력하면 입력 끝내기
				if (name.equals("N") || name.equals("n"))
				{
					break;
				}
					
				
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int mat = sc.nextInt();
				
				//입력받은 데이터 set하고 add()를 통해 insert하기
				
				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				dto.setMat(mat);
				int result = dao.add(dto);
				//위 반복
				
			} //end while
			
			//데이터 출력
			System.out.println("---------------------------------------------------");
			System.out.println("번호   이름    국어  영어 수학 총점 평균");
			for( ScoreDTO obj : dao.list())
			{
				int sum = obj.getKor() + obj.getEng() + obj.getMat();
				double avg = (float)sum/3;
				
				System.out.printf("%3s %6s %4s %4s %4s %5d %5.1f\n",obj.getSid(), obj.getName(), obj.getKor(), obj.getEng(), obj.getMat(), sum, avg);
				
			
			}
			System.out.println("---------------------------------------------------");
			
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		finally {
			try
			{
				DBConn.close();
				System.out.println("데이터베이스 연결 종료");
				System.out.println("프로그램 종료");
				
				
			} catch (Exception e2)
			{ 
				e2.toString();
				// TODO: handle exception
			}
		} // end finally
		
		
		
		
	} //end main

}// end class
