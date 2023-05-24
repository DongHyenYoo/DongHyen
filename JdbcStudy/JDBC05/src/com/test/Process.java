package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Process
{
	
	private MemberDAO dao;
	
	
	public Process()
	{
		dao = new MemberDAO();
		// TODO Auto-generated constructor stub
	}
	
	public void Memberinsert()
	{
		
		//연결객체 생성
		dao.connection();
		
		//전체 인원수
		int count = dao.count();
		//스캐너
		Scanner sc = new Scanner(System.in);
		
		
		
		try
		{
			
			
			
			do
			{
				
				
				//사원 정보 입력받기 이름, 주민번호, 입사일, 도시번호, 부서 아이디, 직위 아이디 기본급 수당 입력받기
				System.out.printf("\n%d번 사원정보 입력----------- \n",(++count));
				System.out.print("1.이름 입력: ");
				String name = sc.next();
				System.out.print("2.주민등록번호(yymmdd-nnnnnn): ");
				String ssn = sc.next();
				System.out.print("3.입사일(yyyy-mm-dd): ");
				String date = sc.next();
				
				
				
				System.out.print("4.지역 입력 ");
				System.out.print("(");
				for( String city : dao.cityList())
				{
					System.out.printf("/%s",city);
				}
				System.out.print(") : ");
				String city_loc = sc.next();
				
				
				
				System.out.print("5.전화번호 입력: ");
				String tel = sc.next();
				
				
				
				System.out.print("6.부서 입력 ");
				System.out.print("(");
				for( String buseo : dao.buseoList())
				{
					System.out.printf("/%s",buseo);
				}
				System.out.print(") : ");
				String buseo_name = sc.next();
				
				
				
				System.out.print("7.직위 입력: ");
				System.out.print("(");
				for( String jikwi : dao.jikwiList().keySet())
				{
					System.out.printf("/%s",jikwi);
				}
				System.out.print(") : ");
				String jikwi_name = sc.next();
				
				
				System.out.print("8.기본급 입력: ");
				System.out.print("(최소  "+dao.jikwiList().get(jikwi_name)+"이상) :");
				int basicPay = sc.nextInt();
				
				
				System.out.print("9.수당 입력: ");
				int suDang = sc.nextInt();
			
				//dto 객체 선언
				MemberDTO dto = new MemberDTO();
				dto.setName(name);
				dto.setSsn(ssn);
				dto.setIbsadate(date);
				dto.setCity_loc(city_loc);
				dto.setTel(tel);
				dto.setBuseo_name(buseo_name);
				dto.setJikwi_name(jikwi_name);
				dto.setBasicpay(basicPay);
				dto.setSudang(suDang);
				
				//입력된 정보를 dao.add를 통해 입력
				
				int result = dao.add(dto);
				if(result>0)
				{
					System.out.printf("%d번 사원 입력 성공",count);
				}
				
				//입력 종료의사 물어보기
				System.out.print("입력을 끝내시려면 N/n을 입력하세요 : ");
				String response = sc.next();
				
				if(response.equals("N") || response.equals("n"))
				{
					break;
				}
				
				
			} while (true);
			//위 반복
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		dao.close();
	
		
	}
	
	
	
	
	
	
	
	
	
	public void MemberSelectAll()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("원하시는 정렬방식을 선택해 주세요 1~5");
		System.out.println("1)사번 정렬     ");
		System.out.println("2)이름 정렬     ");
		System.out.println("3)부서 정렬     ");
		System.out.println("4)직위 정렬     ");
		System.out.println("5)급여 내림차순 정렬");
		System.out.print(">>>번호 선택 : ");
		
		int num = sc.nextInt();
		
		
		//연결 객체 생성
		dao.connection();
		
		try
		{
			System.out.println();
			System.out.printf("전체 인원 : %d명\n", dao.count());
			System.out.println("사번    이름    주민번호       입사일       지역   전화번호         부서       직위    기본급    최소기본급   수당     급여");
			//일단은 출력만 1.사원번호 EMP_ID , 2.이름 EMP_NAME, 3.주민번호 SSN 4.입사일 IBSADATE 5.도시 CITY_LOC 6.전화번호 TEL 7. 부서번호 BUSEO_NAME 8. 직위이름 JIKWI_NAME
			//9. 최기본급 MIN_BASICPAY  10. 기본급 BASICPAY , 11. 수당 SUDANG 12.급여 PAY
			for( MemberDTO dto : dao.list(num))
			{
				System.out.printf("%3s %6s %15s %10s %4s %15s %6s %6s %10d %10d %10d %10d", dto.getSid(), dto.getName(), dto.getSsn(), dto.getIbsadate(),
						dto.getCity_loc(), dto.getTel(), dto.getBuseo_name(), dto.getJikwi_name(), dto.getMin_basicpay(), dto.getBasicpay(), dto.getSudang(), dto.getPay());
				System.out.println();
			}
			
			System.out.println();  
			System.out.println();  
			System.out.println();  
			
			
			dao.close();
				
				
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
		
	}
	
	public void MemberSearch()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("원하시는 검색방식을 선택해 주세요 1~4");                                                                                                                       
		System.out.println("1)-사번 검색     ");                                                                                                                                 
		System.out.println("2)-이름 검색    ");                                                                                                                                 
		System.out.println("3)-부서 검색   ");                                                                                                                                 
		System.out.println("4)-직위 검색   ");                                                                                                                                                                                                                                                                
		System.out.print(">>>번호 선택 : ");                                                                                                                                    
		                                                                                                                                                                    
		int num = sc.nextInt();                                                                                                                                       
		                                                                                                                                                                    
		                                                                                                                                                                    
		//연결 객체 생성                                                                                                                                                          
		dao.connection();                                                                                                                                                   
		                                                                                                                                                                    
		try                                                                                                                                                                 
		{                                                                                                                                                                   
			//일단은 출력만 1.사원번호 EMP_ID , 2.이름 EMP_NAME, 3.주민번호 SSN 4.입사일 IBSADATE 5.도시 CITY_LOC 6.전화번호 TEL 7. 부서번호 BUSEO_NAME 8. 직위이름 JIKWI_NAME                               
			//9. 최기본급 MIN_BASICPAY  10. 기본급 BASICPAY , 11. 수당 SUDANG 12.급여 PAY                                                                                              
			System.out.println();
			
			for( MemberDTO dto : dao.Search(num))                                                                                                                             
			{                                                                                                                                                               
				System.out.printf("%3s %6s %15s %10s %4s %15s %6s %6s %10d %10d %10d %10d", dto.getSid(), dto.getName(), dto.getSsn(), dto.getIbsadate(),                    
						dto.getCity_loc(), dto.getTel(), dto.getBuseo_name(), dto.getJikwi_name(), dto.getMin_basicpay(), dto.getBasicpay(), dto.getSudang(), dto.getPay());
				System.out.println();                                                                                                                                       
			}                                                                                                                                                               
			
			System.out.println();  
			System.out.println();  
			System.out.println();  
			dao.close();                                                                                                                                                    
				                                                                                                                                                            
				                                                                                                                                                            
		} catch (Exception e)                                                                                                                                               
		{                                                                                                                                                                   
			// TODO: handle exception                                                                                                                                       
		}                                                                                                                                                                   
		                                                                                                                                                                    
		                                                                                                                                                                    
		
	}
	
	public void MemberModify()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("수정을 원하시는 사원번호를 입력해주세요 : ");                                                                                                                               
		                                                                                                                                                                    
		int sid = sc.nextInt();
		ArrayList<MemberDTO> memList = new ArrayList<MemberDTO>();
		
		try
		{
			//연결
			dao.connection();
			
			//수정을 원하는 번호의 대상 알려주기
			
			memList = dao.Searchfor(sid);
			
			if (memList.size()>0)
			{
				System.out.println("사번    이름    주민번호       입사일       지역   전화번호         부서       직위    기본급    최소기본급   수당     급여");
				for( MemberDTO dto : memList)
				{
					System.out.printf("%3s %6s %15s %10s %4s %15s %6s %6s %10d %10d %10d %10d", dto.getSid(), dto.getName(), dto.getSsn(), dto.getIbsadate(),
							dto.getCity_loc(), dto.getTel(), dto.getBuseo_name(), dto.getJikwi_name(), dto.getMin_basicpay(), dto.getBasicpay(), dto.getSudang(), dto.getPay());
					System.out.println();
				}
			}
			else
			{
				System.out.println("해당 사원번호는 존재하지 않음");
			}
			
			System.out.println();
			System.out.print("수정할 정보 입력");
			System.out.println();
	
			System.out.print("1.이름 입력: ");
			String name = sc.next();
			System.out.print("2.주민등록번호(yymmdd-nnnnnn): ");
			String ssn = sc.next();
			System.out.print("3.입사일(yyyy-mm-dd): ");
			String date = sc.next();
			
			
			
			System.out.print("4.지역 입력 ");
			System.out.print("(");
			for( String city : dao.cityList())
			{
				System.out.printf("/%s",city);
			}
			System.out.print(") : ");
			String city_loc = sc.next();
			
			
			
			System.out.print("5.전화번호 입력: ");
			String tel = sc.next();
			
			
			
			System.out.print("6.부서 입력 ");
			System.out.print("(");
			for( String buseo : dao.buseoList())
			{
				System.out.printf("/%s",buseo);
			}
			System.out.print(") : ");
			String buseo_name = sc.next();
			
			
			
			System.out.print("7.직위 입력: ");
			System.out.print("(");
			for( String jikwi : dao.jikwiList().keySet())
			{
				System.out.printf("/%s",jikwi);
			}
			System.out.print(") : ");
			String jikwi_name = sc.next();
			
			
			System.out.print("8.기본급 입력: ");
			System.out.print("(최소  "+dao.jikwiList().get(jikwi_name)+"이상) :");
			int basicPay = sc.nextInt();
			
			
			System.out.print("9.수당 입력: ");
			int suDang = sc.nextInt();
			
			//dto 객체 선언
			MemberDTO dto = new MemberDTO();
			dto.setSid(String.valueOf(sid));
			dto.setName(name);
			dto.setSsn(ssn);
			dto.setIbsadate(date);
			dto.setCity_loc(city_loc);
			dto.setTel(tel);
			dto.setBuseo_name(buseo_name);
			dto.setJikwi_name(jikwi_name);
			dto.setBasicpay(basicPay);
			dto.setSudang(suDang);
			//modify에 dto넘겨서 수정하기
			int result = dao.modify(dto);
			
			if (result>0)
			{
				System.out.println("수정끝");
			}
			
			dao.close();
			
			
			
			
		} catch (Exception e)
		{
			e.toString();
			// TODO: handle exception
		}
		
	}
	
	public void MemberDelete()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제를 원하시는 사원번호를 입력해주세요 : ");                                                                                                                               
		                                                                                                                                                                    
		int sid = sc.nextInt();
		ArrayList<MemberDTO> memList = new ArrayList<MemberDTO>();
		
		//연결
		dao.connection();
		
		//삭제를 원하는 번호의 대상 알려주기
		
		memList = dao.Searchfor(sid);
		System.out.println();
		
		if (memList.size()>0)
		{
			System.out.println("사번    이름    주민번호       입사일       지역   전화번호         부서       직위    기본급    최소기본급   수당     급여");
			for( MemberDTO dto : memList)
			{
				System.out.printf("%%3s %6s %15s %10s %4s %15s %6s %6s %10d %10d %10d %10d", dto.getSid(), dto.getName(), dto.getSsn(), dto.getIbsadate(),
						dto.getCity_loc(), dto.getTel(), dto.getBuseo_name(), dto.getJikwi_name(), dto.getMin_basicpay(), dto.getBasicpay(), dto.getSudang(), dto.getPay());
				System.out.println();
			}
		}
		else
		{
			System.out.println("해당 사원번호는 존재하지 않음");
		}
		
		
		
		int result = dao.delete(String.valueOf(sid));
		
		if (result>0)
		{
			System.out.println("삭제끝");
		}
		
		dao.close();
	
	}
	
	
	
	
}
