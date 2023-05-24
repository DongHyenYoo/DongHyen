/*===================================
■■■컬렉션 프레임워크■■■ 
================================*/

//Test163 클래스를 완성하여 다음기능을 가진 프로그램을 구현한다.

/*
실행 예)
실행되면
 [메뉴 선택]
 1.요소 추가 add  do while
 2.요소 출력 elementAt
 3.요소 검색 
 4.요소 삭제
 5. 요소 변경
 6.종료    switch 써야될듯?

 >>메뉴 선택(1-6) : 1

 1버째 요소 입력 : 장현성
 1번째 요소 입력 성공!
 요소 입력 계속(Y/N) : y 이거 while문 이었던거같다.

 2번째 요소 입력 : 엄소연

 요소 입력 계속(Y/N) : N
 그럼 다시 메뉴안내 페이지로 돌아가기
 [메뉴 선택]
 1.요소 추가 add  do while
 2.요소 출력 elementAt
 3.요소 검색 
 4.요소 삭제
 5. 요소 변경
 6.종료

  >>메뉴 선택(1-6) : 2

  [벡터 전체 출력]
  장현성
  엄소연
  벡터 전체 출력완료~!!

   [메뉴 선택]
 1.요소 추가
 2.요소 출력
 3.요소 검색 
 4.요소 삭제
 5. 요소 변경
 6.종료

  >>메뉴 선택(1-6) : 3

  >> 검색할 요소 입력: 장현성

  [검색 결과 출력]
  항목이 존재합니다.

   [메뉴 선택]
 1.요소 추가
 2.요소 출력
 3.요소 검색 
 4.요소 삭제
 5. 요소 변경
 6.종료

  >>메뉴 선택(1-6) : 3

  >>검색할 요소 입력: 반보영
  
  [검색 결과 출력] -> if위에 선언해야할듯
  항목이 존재하지 않습니다.

   [메뉴 선택]
 1.요소 추가 
 2.요소 출력 
 3.요소 검색 
 4.요소 삭제
 5. 요소 변경
 6.종료

  >>메뉴 선택(1-6) : 4

  >>삭제할 요소 입력 : 김보경

  [삭제 결과 출력]
  항목이 존재하지 않아 삭제할 수 없다.

   [메뉴 선택]
 1.요소 추가 
 2.요소 출력 
 3.요소 검색 
 4.요소 삭제
 5. 요소 변경
 6.종료

  >>메뉴 선택(1-6) : 4

  >>삭제할 요소 입력: 장현성

  [삭제 결과 출력]
  장현성 항목이 삭제되었습니다.

   [메뉴 선택]
 1.요소 추가 
 2.요소 출력 
 3.요소 검색 
 4.요소 삭제
 5. 요소 변경
 6.종료

  >>메뉴 선택(1-6) : 5

>>변경할 요소 입력 : 엄소연

  [변경결과 출력]
  변경할 대상이 존재하지 않습니다.

   [메뉴 선택]
 1.요소 추가 
 2.요소 출력 
 3.요소 검색 
 4.요소 삭제
 5. 요소 변경
 6.종료

  >>메뉴 선택(1-6) : 5

>>변경할 요소 입력 : 엄소연
>>수정할 내용 입력 : 도규희

[변경 결과 출력]
변경이 완료되었습니다.

[벡터 전체 출력]

도규희
벡터 전체 출력

   [메뉴 선택]
 1.요소 추가 
 2.요소 출력 
 3.요소 검색 
 4.요소 삭제
 5. 요소 변경
 6.종료

 >>메뉴 선택 : 6

 프로그램 종료~!!!


 

 
*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.Iterator;

class Menus //완성된 클래스
{
	public static final int E_ADD = 1;
	public static final int E_DISP = 2;
	public static final int E_FIND = 3; //sel == Menus.E_DD 이렇게 쓰면될듯
	public static final int E_DEL = 4;
	public static final int E_CHA = 5;
	public static final int E_EXIT = 6;
}

public class Test163
{		//주요 속성 구성 -> 완료
	private static final Vector<Object> vt;
	private static BufferedReader br; //입력용
	private static Integer sel;		//선택 값
	private static String con;		//계속 진행 여부
	
	static //스태틱 초기화 블럭이라고 한다.
	{
		//Vector 자료구조 생성
		vt = new Vector<Object>();

		//BufferedReader 클래스 인스턴스 생성
		br = new BufferedReader(new InputStreamReader(System.in));

		//사용자 입력값 초기화
		sel = 1;
		con = "Y";

	}
   //메뉴 출력 -> 메뉴 선택 -> 해당기능 실행 -> 메뉴 출력
	//메뉴 출력 메소드
	public static void menuDisp()
	{	
		System.out.println("[메뉴 출력]");
		System.out.println("1.요소 추가");
		System.out.println("2.요소 출력");
		System.out.println("3.요소 검색");
		System.out.println("4.요소 삭제");
		System.out.println("5.요소 변경");
		System.out.println("6.종료");
	}

	//메뉴 선택 메소드
	public static void menuSelect()throws IOException
	{
		
		try
		{
		System.out.print(">>>메뉴 선택 : ");
		sel = Integer.parseInt(br.readLine()); //선택한 번호 입력		
		}
		catch (NumberFormatException e) //예외 잡아 처리 하므로 NumberFormatException에서 제외
		{
			System.out.println("[공백,특수문자,문자]는 입력항목에 포함되어있지 않습니다.");
			menuSelect(); //메뉴선택 재호출
		}
		
		
		
	}
	//선택된 메뉴 실행에 따른 기능 호출 메소드
	public static void menuRun()throws IOException
	{
		switch (sel)
		{
		case Menus.E_ADD : addElement(); break; 
		case Menus.E_DISP : dispElement(); break;
		case Menus.E_FIND : findElement(); break;
		case Menus.E_DEL : delElement(); break;
		case Menus.E_CHA : chaElement(); break;
		case Menus.E_EXIT : exit(); break;
		}
	}

	//자료구조에 요소 추가(입력) 메소드

	public static void addElement() throws IOException
	{//1번째 요소 입력 : 장현성
	 //1번째 요소 입력 성공!
	 //요소 입력 계속(Y/N) : y 이거 while문 이었던거같다.

	 //2번째 요소 입력 : 엄소연
	 //요소 입력 계속(Y/N) : N
	 
	 String name="";
	 do
	 {
		 System.out.printf("%d번째 요소 입력 : ",vt.size()+1); 
		 name = br.readLine();
		 vt.add(name); //String클래스이므로 자동으로 Object클래스로업캐스팅 될것
		 System.out.printf("%d번째 요소 입력성공\n",vt.size()); 
		 System.out.print("요소 입력 계속(Y/N)");
		 con = br.readLine();
		 con = con.toUpperCase(); //소문자y도  대문자로 인식하자
		// decision = (char)System.in.read();
		// System.in.skip(2); //\s \r 스킵
		 
	 }
	 while (con.equals("Y"));   //끝

	 System.out.println();
		 

	}
	//자료구조 출력메소드 여기서부터 Iterator 필요할듯
	public static void dispElement()
	{

		//[벡터 전체 출력]
		//  장현성
		// 엄소연
		// 벡터 전체 출력완료~!!
		Iterator<Object> vi = vt.iterator(); //hasNext() 와 next() 
		System.out.println("[벡터 전체 출력]");

		while (vi.hasNext()) 
		{
			System.out.println((String)vi.next()); //Object 클래스 형으로써 String으로 다운캐스팅해줘야한다.
		}
		System.out.print("요소 전체 출력 완료");
		System.out.println();
							//끝
	  
	}

	//자료구조내 요소 검색메소드  //.contain(Element) 사용
	public static void findElement() throws IOException
	{
	//	>>검색할 요소 입력: 반보영

	//	[검색 결과 출력] -> if위에 선언해야할듯
	//	항목이 존재하지 않습니다.

	System.out.print(">>검색할 요소 입력 : ");
	String eleMent = br.readLine();
	System.out.println("[검색 결과 출력]");
	if(vt.contains(eleMent))
		{
		int index = vt.indexOf(eleMent);
		System.out.println((String)vt.elementAt(index)+"이 존재합니다.");
		}
	else
		{
		System.out.print("항목이 존재하지 않습니다.\n");
		}
		
		
	}
	//자료구조내 요소 삭제 메소드 //요소 삭제의 과정 contains -> indexOf -> remove
	public static void delElement() throws IOException
	{
//	 >>삭제할 요소 입력: 장현성

 // [삭제 결과 출력]
 // 장현성 항목이 삭제되었습니다.
 		
		System.out.print(">>삭제할 요소 입력 : ");
		String name = br.readLine();
		System.out.println("[삭제 결과 출력]");
		if(vt.contains(name))
		{
		  int index = vt.indexOf(name);
		  vt.remove(index);
		  System.out.println(name+"  삭제.");
		}
		else
		{
			System.out.print("해당 요소는 존재하지 않습니다.\n");
		}


	}
	//요소 변환
	public static void chaElement() throws IOException
	{
	//	>>변경할 요소 입력 : 엄소연

	//	[변경결과 출력]
	//	변경할 대상이 존재하지 않습니다.
		System.out.print(">>변경할 요소 입력 : ");
		String name = br.readLine();
		
		if(vt.contains(name))
		{	
			System.out.print(">>변경 내용 입력 : ");
			String nameCh = br.readLine();
			int index = vt.indexOf(name);
			vt.set(index,nameCh);
			System.out.println(name+" 이(가) "+(String)vt.get(index)+"으로 변경되었습니다.");

		}
		else
		{
			System.out.println("[변경 결과 출력]");
			System.out.println("해당 요소는 존재하지 않습니다.");
		}
		
	}

	public static void exit()
	{
		System.out.println("프로그램 종료");
		System.exit(-1); // 
	}



//main 메소드 완성
	public static void main(String[] args)throws IOException, NumberFormatException
	{
		do
		{
			menuDisp();
			System.out.println();
			menuSelect();
			System.out.println();
			menuRun();
			System.out.println();
		}
		while (true);


	}
}