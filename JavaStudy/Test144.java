/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
-Calendar 클래스
================================*/

//실습 문제
//오늘은 기준으로 입력받는 날짜만큼 후의 연 월 일 요일을
//확인하여 결과를 출력하는 프로그램을 구현

//예
//오늘 날짜 : 2022-07-26 ghkdydlf
//몇일후의 날짜를 확인하고자 하십니까 : 200

//200일후 : xxxx-xx-xx x요일

import java.util.Calendar;
import java.util.Scanner;
public class Test144
{
	public static void main(String[] args)
	{
		//오늘 날짜 get을 이용해서 받아오기


		Scanner sc = new Scanner(System.in);
		
		Calendar cal = Calendar.getInstance();

		String[] weekArr = {"일","월","화","수","목","금","토"};

		//있다가 String+= 해서 앞에 0붙이자

		System.out.printf("오늘 날짜 : %d-%d-%d  %s요일",cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE),weekArr[cal.get(Calendar.DAY_OF_WEEK)-1]);
		
		

		//add(필드,더할수) 이다.

		System.out.print("몇일 후의 날짜를 확인하고자 하십니까 : ");
		
		int addDate = sc.nextInt();

		cal.add(Calendar.DATE,addDate);

		
		
		System.out.printf("%d일 후 : %tF %tA\n요일",addDate,cal,cal);

	
	/*
		printf 추가사항 %tF : 하면  변수로 캘린더 객체를 넣었을때 년-월-일 형태의 문자열을 반환
		                %tA : 하면  변수로 캘린더 객체를 넣었을때 문자열형태의 요일을 반환 
		
		String.format("%tF",달력객체); 해서도 쓸수 있다.

	*/
	
	
	}
}