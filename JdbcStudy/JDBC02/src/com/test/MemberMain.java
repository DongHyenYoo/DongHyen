/*
○ TBL_MEMBER 테이블을 활용하여
   이름과 전화번호를 여러 건 입력받고, 
   결과를 전체 출력하는 기능을 가진 프로그램을 구현한다.
   단, 데이터베이스 연동이 이루어져야 하고
   MemberDAO, MemberDTO 클래스를 활용해야 한다.
   
실행 예)

이름 전화번호 입력(1) : 장현성 010-1111-1111
>> 회원 정보 입력 완료~!!!!

이름 전화번호 입력(2) : 정미경 010-2222-2222
>> 회원 정보 입력 완료~!!!!

이름 전화번호 입력(3) : 엄소연 010-3333-3333
>> 회원 정보 입력 완료~!!!!

이름 전화번호 입력(4) : .
---------------------------------------
전체 회원 수 : 3명
---------------------------------------
번호       이름      전화번호
1         장현성      010-1111-1111
2         정미경      010-2222-2222
3         엄소연      010-3333-3333
---------------------------------------

*/
package com.test;

import java.util.Scanner;

import com.util.DBConn;

public class MemberMain
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			MemberDAO dao = new MemberDAO();
			
			//System.out.println("데이터베이스 연결 성공");
			
			int count = dao.count();
			
			do
			{
				System.out.printf("이름 번화번호 입력(%d) : ",(++count));
				String name = sc.next();
				if (name.equals("."))
				{
					break;
				}
				
				String tel = sc.next();
				
				//MemberDTO 객체 생성 및 멤버 구성
				MemberDTO dto = new MemberDTO();
				dto.setName(name);
				dto.setTel(tel);
				
				int result = dao.add(dto);
				
				if(result>0)
					System.out.println("회원정보 입력 끝");
				
				
			} while (true);
			
			
			System.out.println();
			System.out.println("-----------------");
			System.out.printf("전체 회원 수 : %d명\n", dao.count());
			System.out.println("-----------------");
			System.out.println("번호 이름 전화번호");
			
			for(MemberDTO obj : dao.list())
			{
				System.out.printf("%3s %6s %12s\n",obj.getSid(), obj.getName(), obj.getTel());
			}
			
			System.out.println("-----------------");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		finally {
			try
			{
				DBConn.close();
				System.out.println("데이터베이스 연결 닫힘");
				System.out.println("프로그램종료됨");
			} catch (Exception e2)
			{
				System.out.println(e2.toString());
				// TODO: handle exception
			}
			sc.close();
			
		}//end finally
		
	}//end main
}//end class MemberMain


/*
 이름 번화번호 입력(3) : 박원석 010-4444-4444
회원정보 입력 끝
이름 번화번호 입력(4) : 한은영 010-3333-3333
회원정보 입력 끝
이름 번화번호 입력(5) : .

-----------------
전체 회원 수 : 4명
-----------------
번호 이름 전화번호
  1    유동현 010-3578-3912
  2    김유림 010-5555-5555
  3    박원석 010-4444-4444
  4    한은영 010-3333-3333
-----------------
데이터베이스 연결 닫힘
프로그램종료됨
*/