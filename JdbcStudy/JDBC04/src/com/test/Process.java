/*
 Process.java
 */

package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Process
{
	// 주요 속성 구성 데이터베이스 액션 처리 전담 객체 -> ScoreDAO
	private ScoreDAO dao;

	// 생성자 정의 -> 사용자 정의 생성자
	public Process()
	{
		dao = new ScoreDAO();
		// TODO Auto-generated constructor stub
	}

	// 주요 기능 구성
	// -성적 입력 기능
	public void sungjukInsert()
	{
		try
		{
			// 데이터 베이스 연결
			dao.connection();

			int count = dao.count();
			Scanner sc = new Scanner(System.in);

			do
			{
				System.out.println();
				System.out.printf("%d번 학생 성적 입력(이름 국어 영어 수학) : ", (++count));
				String name = sc.next();

				if (name.equals("."))
					break;
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int mat = sc.nextInt();

				ScoreDTO dto = new ScoreDTO();

				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				dto.setMat(mat);

				int result = dao.add(dto);

				if (result > 0)
					System.out.println(">>>성적 입력 완료");

			} while (true);

			dao.close();

		} catch (Exception e)
		{
			System.out.println(e.toString());

			// TODO: handle exception
		}

	}

	// - 성적 전체 출력 기능
	public void sungjukSelectAll()
	{
		dao.connection();
		try
		{
			int count = dao.count();

			System.out.println();
			System.out.printf("전체 인원 : %d명\n", count);
			System.out.println("번호  이름  국어  영어  수학  총점  평균  석차");

			for (ScoreDTO obj : dao.list())
			{
				System.out.printf("%3s %4s %5d %4d %4d %5d %5.1f %5d\n", obj.getSid(), obj.getName(), obj.getKor(),
						obj.getEng(), obj.getMat(), obj.getTot(), obj.getAvg(), obj.getRank());

			}

			dao.close();

		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
	}

	// - 이름 검색 출력 기능

	public void sungjukSearchName()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.print("검색할 이름 입력 : ");
			String name = sc.next();
			
			//--필요한 경우 이 과정에서 프로그래밍적으로 검증(껌사) 수행
			
			//데이터베이스 연결
			
			dao.connection();
			
			ArrayList<ScoreDTO> result =  dao.list(name);
			
			if (result.size()>0)
			{
				for( ScoreDTO obj : result)
				{
					System.out.printf("%3s %4s %5d %4d %4d %5d %5.1f %5d\n", obj.getSid(), obj.getName(), obj.getKor(),
							obj.getEng(), obj.getMat(), obj.getTot(), obj.getAvg(), obj.getRank());

				}
				
			}
			else {
				System.out.println("검색대상이 없음");
			}
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		dao.close();
		

	}

	// - 성적 수정 기능
	public void sungjukUpdate()
	{
		try
		{   //수정할 데이터 입력
			Scanner sc = new Scanner(System.in);
			
			System.out.println("수정할 학생의 번호 입력");
			int sid = sc.nextInt();
			
			//입력받은 번호로 체크해야 할 로직 적용 삽입 가능
			
			
			dao.connection();
			//어레이 리스트에  한개의 dto를 넣음 list의 반환이 에러이 리스트인것
			ArrayList<ScoreDTO> result = dao.list(sid);
			
			if (result.size()>0)
			{//결과를 보여줌
				for( ScoreDTO obj : result)
				{
					System.out.printf("%3s %4s %5d %4d %4d %5d %5.1f %5d\n", obj.getSid(), obj.getName(), obj.getKor(),
							obj.getEng(), obj.getMat(), obj.getTot(), obj.getAvg(), obj.getRank());

				}
				//수정할 데이터 입력
				System.out.print("수정 데이터 입력(이름 국어 영어 수학) : ");
				String name = sc.next();
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int mat = sc.nextInt();
				//dto 객체 하나 선언
				ScoreDTO dto = new ScoreDTO();
				dto.setSid(String.valueOf(sid));
				dto.setName(name);
				dto.setEng(eng);
				dto.setKor(kor);
				dto.setMat(mat);
				//dao.modify 호출
				int resultnum = dao.modify(dto);
				if(resultnum >0)
				{
					System.out.println(">>>수정완료");
				}
				
			}
			else {
				System.out.println(">>>수정 대상 없음");
			}
			
			dao.close();
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}

	}

	// - 성적 삭제 기능
	public void sungjukDelete()
	{
		
		try
		{
			//삭제할 데이터의 학생 번호 입력
			Scanner sc = new Scanner(System.in);
			System.out.print("삭제할 번호입력");
			int sid = sc.nextInt();
			
			//입력 받은 번호에 대한 유효성 검사
			
			//데이터 베이스 연결
			//연결 객체 생성
			dao.connection();
			
			//dao의 list()메소드 호출
			ArrayList<ScoreDTO> arrayList = dao.list(sid);
			
			if(arrayList.size() > 0)
			{
				//삭제할 데이터를 찾았다.
				System.out.println("번호 이름 국어 영어 수학 총점 평균 석차");
				for ( ScoreDTO obj : arrayList)
				{
					System.out.printf("%3s %4s %5d %4d %4d %5d %5.1f %5d\n", obj.getSid(), obj.getName(), obj.getKor(),
							obj.getEng(), obj.getMat(), obj.getTot(), obj.getAvg(), obj.getRank());

				}
				System.out.print("정말 삭제하시 겠습니까");
				String response = sc.next();
				
				if(response.equals("Y") || response.equals("y"))
				{
					int result = dao.remove(sid);
					if(result > 0)
						System.out.println("삭제가 완료되었습니다.");
				}
				else
				{
					System.out.println("취소됨");
				}
				
			}
			
			else   // 0보다 작을 경우
	         {
	            // 검색 대상이 존재하지 않음
	            System.out.println("삭제할 대상이 존재하지 않습니다");
	         }
	         
	         dao.close();
	         
	      } catch (Exception e)
	      {
	         System.out.println(e.toString());
	      }
	   }
	   
	   
	}