/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
-Calendar 클래스
================================*/

/*
java.util.Calendar 클래스는
날짜와 시간을 객체 모델링화 한 클래스로
연월일 요일 시 분 초 까지의
시간과 날짜와 관련된 정보를 제공한다.
그리고, Calendar 클래스는 추상클래스 이므로 직접 객체를 생성할 수 없으며
실제적인 메소드 구현은 Calendar 클래스의 서브 클래스인
GregorianCalendar 클래스에 정의되어 있다.

시스템으로부터 현재 시스템 시간 정보를 얻어올 때
getInstance() 라는 정적(static) 메소드를 이용하여 객체를 생성할 수 있따.
생성된 Calendar 클래스 객체는 시스템의 현재 날짜와 시간 정보를 가지며,
이 객체가 생성되면 갖고있는 시간 정보들은
get() 메소드를 이용하여 쉽게 가져올(사용할) 수 있다.

getInstance() 메소드는 내부적으로 GregorianCalendar 객체를 생성하여
돌려주기 때문에 GregorianCalendar 객체를 직접 생성하여 시간 정보를 
구할 수도 있다.


*/

/*실습 문제
 사용자로부터 연, 월을 입력받아
 달력을 그려주는 프로그램을 구현한다.
 단, Calendar 클래스를 활용하여 작성할 수 있도록 한다.
 API DOC 참조하여 getActualMaximum() 메소드의 활용 방법을 검토해라.

 실행 예
 연도입력 : 2022
 월 입력 : 2
 
 [2022년 7월]

 일월화수목금토
 =============
            1 2
 3 4 5 6 7 8 9

 =============
 */

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test143
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int month,year;
		String[] weekArr = {"일","월","화","수","목","금","토"};
		Calendar ob = new GregorianCalendar();


		do
		{
		System.out.print("연도 입력 : ");
		year = Integer.parseInt(br.readLine());
		}
		while (year<1);
		
		do
		{
		System.out.print("월 입력 : ");
		month = Integer.parseInt(br.readLine());
		}
		while (month <0 || month>12);

		ob.set(year,month-1,1); 
		
		int w = ob.get(Calendar.DAY_OF_WEEK);
		
		System.out.printf("         [%d년 %d월]\n",year,month);
		
		for(String i : weekArr)
			System.out.printf(" %s",i);
		System.out.println();

		System.out.print("==========================");
		System.out.println();
	


		for(int i=1;i<w;i++)
			System.out.print("   ");

		
		for(int i=1;i<=ob.getActualMaximum(Calendar.DATE);i++,w++)
		{

			System.out.printf("%3d",i);
			
			if (i != ob.getActualMaximum(Calendar.DATE))
			{
			if(w%7==0)
			System.out.println();
			}
			
		}
		System.out.println();
		System.out.print("==========================");
		System.out.println();

	
		
		

	}
}