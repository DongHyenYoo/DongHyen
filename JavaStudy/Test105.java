/*===================================
만년 달력
-다음과 같은 기능의 프로그램 구현
================================*/

//연도를 입력하세요 : 2022
//월을 입력하세요 : 07


/*
[2022년 7월]

일 월 화 수 목 금 토
====================
				1 2
3  4  5  6  7  8  9
~
31
====================

이렇게 출력되도록 한다.

윤년 4의 배수이면서 100의 배수는 x 하지만 400의 배수
평년 나머지

순서 1.입력하는 년도 띄고 월 입력받기

    2.입력받은 년도의 윤년 평년 확인해서
	  월 배열에 2월 값 입력하기
	
	3.입력한 달의 전달 마지막날까지의 일수를 계산하기

	4. 7로 나눈 나머지의 다음날부터 

	5.월 배열에 값을 가지고와서
	쭉 출력하기?


*/
import java.util.Scanner;


public class Test105
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int[] monthArr = {31,28,31,30,31,30,31,31,30,31,30,31};

		System.out.print("연도를 입력하세요 : ");
		int year = sc.nextInt();
		System.out.print("월을 입력하세요 : ");
		int month = sc.nextInt();

		if(((year%4==0 && year%100!=0) || year%400==0))
			monthArr[1] =29;

		int day = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400; //전년도의 12월 31까지의 일수 여기에 담았어 day

		for(int i=0;i<month-1;i++)  //7월을 입력한다면 6월말까지의 일수를
		{
			day += monthArr[i]; //day
		}

		//System.out.println(day);

		int dayStart = (day%7)+1; //전달의 마지막날 +1 이 시작일이다.

		char [] nameDay={'일','월','화','수','목','금','토'}; 

		//System.out.println(nameDay[dayStart]);




		System.out.printf("[%d년 %d월]\n",year,month);
		for(int i=0;i<nameDay.length;i++)
		{
			System.out.printf("%2c",nameDay[i]);
		}
		System.out.println();
	





		

		for(int i=1;i<=dayStart;i++)
			System.out.print("   ");

		//공백 출력 끝


		//int[] monthArr = {31,28,31,30,31,30,31,31,30,31,30,31};

		for(int i=1;i<=monthArr[month-1];i++)
		{
			System.out.printf("%3d",i);
				day++;
			if(day%7==6){
			System.out.println();
			}
		}
	//	if((day)%7!=0)
	//	{
		System.out.println();
		}
	
	
/*	
		String[][] calender = new String[5][7]; //이걸 어떻게 쓰지
		
		//공백 삽입
		
		for(int i=0;i<=dayStart;i++)
			calender[0][i] = "   ";
		
		
		for(int i=0
		String[] 



		int n=1;

		for(int i=0;i<calender.length;i++)
		{
			calender[i][dayStart+i+1]= n;
			n++;
		}



		for(int i=0;i<calender.length;i++)
		{
			for(int j=0;j<calender[i].length;j++)
			{
			System.out.print(calender[i][j]);
			}
			System.out.println();
		}
		
*/

	
}

		








