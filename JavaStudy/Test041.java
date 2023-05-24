//switch 문 실습

/* 다중 선택문으로 switch 문 다음의 수식 값에 따라
실행 순서를 여러 방향으로 분기할 때 사용하는 문장이다.

형식 및 구조

switch(수식)
{
	case 상수1 : 문장 1; [break;]    [] 의 의미는 안에있는것은 생략해도 된다는 의미
	case 상수2 : 문장 2; [break;]

	[default : 문장 n+1; [break;]
	}

	switch문의 수식과 case의 상수는 byte short int long형이어야 한다.

	case문 뒤에 break;가 없는 형태인 경우
	다음 case문의 문장을 계속해서(이어서)수행하게 된다( 기본모델_
	break가 존재하는경우
	해당 지점에서 수행을 멈춘후 switch문을 빠져나간다.(일반모델)

	switch는 수식의 값이 몇이냐에 따라 정해진 위치에 들어가 문장을 수행한다.

	default는 무조건 실행되는것

	*/

import java.io.*;


public class Test041
{

	public static void main(String[] args)throws IOException
		{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String name;
		int kor, eng, mat, tot ,avg;
		//double avg;
		char grade;

		System.out.print("이름 입력 : ");
		name = br.readLine();

		System.out.print("국어 점수 입력 : ");
		kor = Integer.parseInt(br.readLine());
		System.out.print("영어 점수 입력 : ");
		eng = Integer.parseInt(br.readLine());
        System.out.print("수학 점수 입력 : ");
		mat = Integer.parseInt(br.readLine());
        
		tot = kor + eng + mat;
		avg = tot / 3;

		/*

		if(avg>=90)
			grade='A';
		else if(avg>=80)
			grade='B';
		else if(avg>=70)
			grade='C';
		else if(avg>=60)
			grade='D';
		else 
			grade='F';


		System.out.printf("\n당신의 이름은 %s 입니다.\n", name);
		System.out.printf("\n당신의 총점은 %d 평균은 %d 입니다.\n", tot,avg);
		System.out.printf("\n당신의 등급은 %c 입니다.\n", grade);

*/

/*
		switch(avg/10)
			{
			case 10: grade='A'; break;
			case 9: grade='A'; break;
			case 8: grade='B'; break;
			case 7: grade='C'; break;
			case 6: grade='D'; break;
			default :  grade='F'; break; //default를 없애고 싶다면 초기 grade 선언시 'F'라는 값으로 초기화시켜주어야한다.
										 //if - else에서 else를 없애는 방법과동일
			}
			*/

			switch(avg/10)
			{
			case 10: case 9 : grade='A'; break;
			case 8: grade='B'; break;
			case 7: grade='C'; break;
			case 6: grade='D'; break;
			default :  grade='F'; break;
			}
		System.out.printf("\n당신의 이름은 %s 입니다.\n", name);
		System.out.printf("\n당신의 총점은 %d 평균은 %d 입니다.\n", tot,avg);
		System.out.printf("\n당신의 등급은 %c 입니다.\n", grade);

			

		//printf format \n %n 을 쓸수있으나
		//println print 에서는 %n쓸수 없다.


	}


}