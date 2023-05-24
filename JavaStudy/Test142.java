/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
-Calendar 클래스
================================*/

/*

	Calendar 클래스는 추상클래스이기에 객체를 생성할 수 없다.
	(추상 클래스 : 미완성된 클래스)
	
	Calendar ob = new Calendar(); 가 안된다.

	
	Calendar 클래스 객체를 생성할 수 있는 방법

	1.Calendar ob1 = Calendar.getInstance();

	2.Calendar ob2 = new GregorianCalendar(); 업캐스팅이라는 것 뒤에가 자식클래스 객체 앞에가 상위클래스 객체로 생성하겠다는것

	3.GregorianCalendar ob3 = new GregorianCalendar();

	//그레고리안캘린더 : Calendar 클래스의 하위 클래스

	


*/

//연 월 일 요일을 Calendar 객체로부터 가져와 출력
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test142
{
	public static void main(String[] args)
	{
		Calendar rightNow = Calendar.getInstance();
		//이러면 현재 시스템환경의 연월일을 가져와서 생성됨
		
		//생성된 Calendar 인스턴스를 통해
		//날짜 관련 정보를 얻어낼 수 있는 메소드 -> get()

		int y = rightNow.get(Calendar.YEAR);
		System.out.println(y);
		//2022 가나옴

		int m = rightNow.get(Calendar.MONTH)+1; //월을 얻어낼때는 +1해서 얻어내줘야한다. 월을 설정할때는 -1해야한다. 내부적으로 배열로 구성되어있기때문
		System.out.println(m);

		int d = rightNow.get(Calendar.DATE);
		System.out.println("d : "+d);

		int w = rightNow.get(Calendar.DAY_OF_WEEK);
		System.out.println("w : "+w);
		//w : 2
/*
		System.out.println(Calendar.SUNDAY); // 1 -> 일요일
		System.out.println(Calendar.MONDAY); // 2 -> 월요일
		System.out.println(Calendar.TUESDAY); // 3 -> 화요일
		System.out.println(Calendar.WEDNESDAY); // 4 -> 수요일
		System.out.println(Calendar.THURSDAY); // 5 -> 목요일
		System.out.println(Calendar.FRIDAY); // 6 -> 금요일
		System.out.println(Calendar.SATURDAY); // 7 -> 토요일
*/

		System.out.println(y+"-"+m+"-"+d+" "+w);
		//2022-7-25 2
		
		String week = "";
		switch (w)
		{
			/*
			case Calender.SUNDAY: week = "일요일"; break;
			case Calender.MONDAY: week = "월요일"; break;
			case Calender.TUESDAY: week = "화요일"; break;
			case Calender.WEDNESDAY: week = "수요일"; break;
			case Calender.THURSDAY: week = "목요일"; break;
			case Calender.FRIDAY: week = "금요일"; break;
			case Calender.SATURDAY: week = "토요일"; break;
		*/

			case 1: week = "일요일"; break;
			case 2: week = "월요일"; break;
			case 3: week = "화요일"; break;
			case 4: week = "수요일"; break;
			case 5: week = "목요일"; break;
			case 6: week = "금요일"; break;
			case 7: week = "토요일"; break;

		}

		System.out.println(y+"-"+m+"-"+d+" "+week);
		//2022-7-25 월요일
		

		Calendar rightNow2 = new GregorianCalendar();

		String[] week2 = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};

		//달력의 날짜 세팅 -> set() 메소드 활용
		rightNow2.set(2023,0,16); //2023년 1월 16일로 한것 세팅할때는 -1해야함

		System.out.println(rightNow2.get(Calendar.DAY_OF_WEEK));
		System.out.println(rightNow2.get(Calendar.MONTH));
		//5

		System.out.println(week2[rightNow2.get(Calendar.DAY_OF_WEEK)-1]);
		//배열이므로 -1 월요일 




	
	}
}