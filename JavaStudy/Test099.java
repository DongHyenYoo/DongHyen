/*===================================
클래스와 인스턴스
-클래스 설계
-배열의 활용
-접근제어지시자와 정보은닉
================================*/

//사용자로부터 년 , 월,일을 입력받아

//해당 날짜의 요일을 출력하는 프로그램을 구현
//단 달력 클래스는 사용하지 않는다.
//또한 클래스의 개념을 활용하여 작성할 수 있도록 한다. (Weekday 클래스 설계
//그리고 배열의 개념도 적용
//접근 제어 지시자의 개념도 확인

//최종적으로 Wekkday클래스 설계를 통해
//main() 메소드가 정상적으로 실행될 수 있게 한다.

//실행 예)
//년 월 일 입력 공백구분


//힌트
//1년 1월 1일 = "월요일"
//1년은 365일이 아니다
//윤년의 판별조건 4의 배수이나 100의 배수는 아니거나  400의 배수이면 윤년
//윤년 = 366일 평년 = 365일


import java.util.Scanner;

class WeekDay
{
	private int y;
	private int m;
	private int d;
	private String type;

	public void input() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("년 월 일 입력:");
		y = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();

	}

	//일단 먼저 생각

	//윤년의 조건 4 && 100 != || 400
	//평년 else

	//그럼 전년도 까지의 평년 윤년의 결과를 통해 총일수에 더하기
	//

	//배열에 월화수목금토일
	//7로 나눈 나머지가 1이면 월 즉 0이면 일

	//필요한 메소드
	//윤년 평년 구분 메소드
	//윤년 평년 결과 구분해서 해당년도의 전년도까지의 일수를 구하는 메소드
	//7로 나누는 값을 반환하는 메소드
	//반환값을 입력받아서 배열에서 요일을 꺼내 출력하는 메소드

/*
	void deciy()
	{
		

		if(y%4==0 && y%100!=0 || y%400==0)
		{
			type = "윤년";
		}
		else
		{
			type = "평년";
		}
	}



	int mathDay()
	{
		int numDay=0;

		for(int i=1;i<y;i++)
		{
			if(i%4==0 && i%100!=0 || i%400==0)
			{
				numDay+=366;
			}
			else
			{
				numDay+=365;
			}
		}


		int numMonth[] = {31,0,31,30,31,30,31,31,30,31,30,31};
		
		switch(type)
		{
			case "윤년" : numMonth[1] = 29;break;
			case "평년" : numMonth[1] = 28;break;
		}

		
		for(int i=0;i<month-1;i++)
			{
			numDay += numMonth[i];		
			}


		numDay += day;

		return numDay%7;

	}


	}
}

	void printDay(int num)
	{
		String[] nameDay={"일","월","화","수","목","금","토"};

		System.out.println("입력하실 날짜는"+nameDay[num]+"입니다");

	}
}

*/
		//메소드 정의 -> 기능 : 요일 산출하기

	public String week() //void 였다가 마지막 return 때문에 String로 바꿈
	{
		//각월의 마지막 날짜(각 월의 최대값)을 배열 형태로 구성
		int[] months = {31,0,31,30,31,30,31,31,30,31,30,31};

		//테스트
		//System.out.println(months.length);
		//=> 12

		//각각 요일의 이름을 배열 형태로 구성
		String[] weekNames = {"일","월","화","수","목","금","토","일"};

		//날 수를 종합할 변수
		int nalsu;

		//윤년에 따른 2월의 날 수 계산
		//윤년 : 29 평년 : 28


		if(y%4==0 && y%100!=0 || y%400==0)
		{
			//2월의 마지막 날짜를 29일로 설정
			months[1] = 29;
		}

		else
		{
			months[1]=28; //배열에 28만 넣어놓고 if하나만 써도대
		}

		//1년 1월 1일 부터 입력받은 년도의 이전 년도 12월 31일 까지의 날수 계산

		//2.입력받은 월의 이전 월 까지의 날수 계산 후
		//  이계산결과를 1번에 더하기

		//입력받은 일의 날짜만큼 날 수 계산후
		//이 계산결과를 2번결과에 더하기

		nalsu = (y-1)*365   +  (y-1)/4 - (y-1)/100             + (y-1)/400;  //반복문이 필요할때도 필요없을때도 있다.
		//		1년 기본주기
		//					  4년마다+1
		//								100년마다+1을 안하는 연산(100은 4의 배수이므로 둘이 겹칠때 더해진 1을 빼야한다)
		//														 400년마다+1


		//10년중에 4년에 한번씩 1을 더한다면? 10*365 + 10/4 = 10*365 + 2(4년마다 하루씩을 더한다는뜻)

		//System.out.println("날수 : "+nalsu);
		//이것의 결과는 1.1.1~2021.12.31 까지의 날수다
		
		for(int i=0;i<m-1;i++)
			nalsu += months[i];

		//테스트
		//System.out.println("날 수 "+ nalsu);

		nalsu += d;

		System.out.println("날 수 "+ nalsu);
		
		//마지막에 얻게 되는 날짜는 1년1월1일 ~ 2022년 7월 15일 까지의 날 수

		int w = nalsu%7; //전체날수%7 == 1 월요일

		//System.out.println(w);

		return weekNames[w]; //배열에 w를 넣어서 반환한다.

	}
		public void print(String day)
		{
			System.out.printf(">> %d년, %d월 %d일 -> %s요일\n",y,m,d,day);
		}




}

public class Test099
{

	public static void main(String[] args)
	{
		WeekDay ob = new WeekDay();
		ob.input();
		String day=ob.week();
		ob.print(day);

	}
}
