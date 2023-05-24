package com.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Process
{
	private ScoreDAO dao;

	public Process()
	{
		dao = new ScoreDAO();
		// TODO Auto-generated constructor stub
	}

	public void Scoreadd()
	{
		// 연결 객체 생성
		dao.connect();

		Scanner sc = new Scanner(System.in);
		// 7번 학생 성적 입력(이름 국어 영어 수학) : 이원영 50 60 70
		try
		{
			int count = dao.count();
			System.out.println();
			do
			{
				System.out.printf("%d 번 학생 성적 입력(이름 국어 영어 수학) : ", (++count));
				String name = sc.next();
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int mat = sc.nextInt();

				// dto생성 및 set
				ScoreDTO dto = new ScoreDTO();
				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				dto.setMat(mat);

				int result = dao.add(dto);

				if (result > 0)
				{
					System.out.println("데이터 입력 성공");

				}

				System.out.print("그만 입력하시려면 Y : ");
				String response = sc.next();
				if (response.equalsIgnoreCase("Y"))
				{
					break;
				}

			} while (true);

		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}

		dao.close();
	}

	public void ScoreSelectAll()
	{
		// 연결
		dao.connect();
		try
		{
			// 인원수
			int count = dao.count();

			// 전체 인원 : 8명
			// 번호 이름 국어 영어 수학 총점 평균 석차

			System.out.println("전체 인원 : " + count + "명");
			System.out.println("번호  이름  국어  영어  수학  총점  평균  석차");
			for (ScoreDTO dto : dao.list())
			{
				System.out.printf("%3d %3s %3d %3d %3d %3d %3.1f %3d\n", dto.getSid(), dto.getName(), dto.getKor(), dto.getEng(), dto.getMat(), dto.getTot()
									, dto.getAvg(), dto.getRank());
			}

		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		dao.close();

	}
	
	public void ScoreSearch()
	{
		
		//연결 객체 생성
		dao.connect();
		//이름 입력받을 스캐너
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.print("검색할 이름을 입력하세요 : ");
		String name = sc.next();
		try
		{
			System.out.println("번호  이름  국어  영어  수학  총점  평균  석차");
			for (ScoreDTO dto : dao.list(name))
			{
				System.out.printf("%3d %3s %3d %3d %3d %3d %3.1f %3d\n", dto.getSid(), dto.getName(), dto.getKor(), dto.getEng(), dto.getMat(), dto.getTot()
									, dto.getAvg(), dto.getRank());
			}
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		
		//연결 종료
		dao.close();
		
	}
	
	
	public void ScoreModify()
	{
		//연결
		dao.connect();
		Scanner sc = new Scanner(System.in);
		ArrayList<ScoreDTO>aList = new ArrayList<ScoreDTO>();
		
		try
		{
			System.out.print("수정할 대상의 번호를 입력하세요 : ");
			int sid = sc.nextInt();
			
			//번호로 검색해서 찾기
			aList = dao.list(sid);
			
			if(aList.size()>0)
			{
				System.out.println("번호  이름  국어  영어  수학  총점  평균  석차");
				for(ScoreDTO dto: aList)
				{
					System.out.printf("%3d %3s %3d %3d %3d %3d %3.1f %3d\n", dto.getSid(), dto.getName(), dto.getKor(), dto.getEng(), dto.getMat(), dto.getTot()
							, dto.getAvg(), dto.getRank());
				}
			}
			else
			{
				System.out.println("해당 번호의 학생은 없습니다.");
			}
			
			
			
			System.out.print("수정하실 대상이 맞나요? : ");
			String response = sc.next();
			
			if(!response.equalsIgnoreCase("Y"))
			{
				System.out.println("수정을 종료합니다.");
				return;
			}
			else //수정 진행 -> 수정할 사항 입력받기 -> dto 생성 및 넘겨주기
			{
				System.out.print("학생 성적 입력(이름 국어 영어 수학) : ");
				String name = sc.next();
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int mat = sc.nextInt();

				// dto생성 및 set
				ScoreDTO dto = new ScoreDTO();
				dto.setSid(sid);
				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				dto.setMat(mat);

				int result = dao.modify(dto);

				if (result > 0)
				{
					System.out.println("데이터 수정 성공");

				}
				
				
			}
			
			
			
			
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
		
		dao.close();
	}
	
	public void ScoreDelete()
	{
		//연결
		dao.connect();
		Scanner sc = new Scanner(System.in);
		ArrayList<ScoreDTO>aList = new ArrayList<ScoreDTO>();
		
		try
		{
			System.out.print("삭제할 대상의 번호를 입력하세요 : ");
			int sid = sc.nextInt();
			
			//번호로 검색해서 찾기
			aList = dao.list(sid);
			
			if(aList.size()>0)
			{
				System.out.println("번호  이름  국어  영어  수학  총점  평균  석차");
				for(ScoreDTO dto: aList)
				{
					System.out.printf("%3d %3s %3d %3d %3d %3d %3.1f %3d\n", dto.getSid(), dto.getName(), dto.getKor(), dto.getEng(), dto.getMat(), dto.getTot()
							, dto.getAvg(), dto.getRank());
				}
			}
			else
			{
				System.out.println("해당 번호의 학생은 없습니다.");
			}
			
			
			
			System.out.print("삭제하실 대상이 맞나요? : ");
			String response = sc.next();
			
			if(!response.equalsIgnoreCase("Y"))
			{
				System.out.println("삭제프로세스를 종료합니다.");
				return;
			}
			else //삭제 진행
			{
				int result = dao.delete(sid);
				
				if(result >0)
					System.out.println("삭제 성공");
				
				
			}
	
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
		
		dao.close();
	}
	
	

}