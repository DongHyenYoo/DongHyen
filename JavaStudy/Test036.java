//제어문 실습
// if문
//if - else 문 실습

//프로그램을 작성할 때 주어진 조건에 따라
//	분기 방향을 정하기 위해 사용하는 제어문에는
//  if문 if ~ else 문. 조건 연산자 , 복합 if 문 )if 문 중첩
//  switch문이있다.

//2.if문은 if 다음의 조건이 참일 경우
//	특정 문장을 수행하고자 할 때 사용되는 구문이다.

//사용자로부터 임의의 두정수 연산자 입력
// 해당 연산자의 연산 처리 결과를 출력하는 프로그램을 구현
//단 if조건문을 활용하여 처리할 수 있도록 하며,
//연산 결과는 편의상 정수 기반으로 처리될 수 있도록한다.

import java.util.Scanner;
import java.io.IOException;

public class Test036
{

	public static void main(String[] args)throws IOException
	{

	//	Scanner sc = new Scanner(System.in);

		//int strNum1 , strNum2, strSign 이렇게 연산자도 정수형으로 받겠다.

/*
			System.out.print("첫번째 정수 입력 : ");
			int strNum1 =  sc.nextInt();

			System.out.print("첫번째 정수 입력 : ");
			int strNum2 =  sc.nextInt();

			System.out.print("연산자 입력[+-/*] : ");
			char strSign = (char)System.in.read();
			//int strSign = System.in.read();

			if(strSign == '*') // strSign == 42(곱셈연산자의 아스키코드)
		{
				System.out.printf("%d %c %d = %d",strNum1,strSign,strNum2,(strNum1*strNum2));

		}
		else if(strSign == '/') //strSign == 47(곱셈연산자의 아스키코드)
		{
			System.out.printf("%d %c %d = %d",strNum1,strSign,strNum2,(strNum1/strNum2));
		}
		else if (strSign == '+') //strSign == 43(곱셈연산자의 아스키코드)
		{
			System.out.printf("%d %c %d = %d",strNum1,strSign,strNum2,(strNum1+strNum2));
		}
		else if (strSign == '-') //strSign == 46(곱셈연산자의 아스키코드)
		{
			System.out.printf("%d %c %d = %d",strNum1,strSign,strNum2,(strNum1-strNum2));

		}
		
*/
		//System.in.read() : 하나의 단일문자가 가지고 있는 아스키코드를 반환하는것
		//parInt : 숫자형태를 가지고있는 문자열을 숫자형으로 바꿔주는것

		Scanner sc = new Scanner(System.in);

		int a, b, result;
		char op;
		result=0;

		System.out.print("첫번째 정수 입력 : ");
		a = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		b = sc.nextInt();
		System.out.print("연산자 입력 : ");
		op = (char)System.in.read();
		

		if (op == '+') //if나 elseif 안에 문장이 하나일경우 {} 등호를 제거해도된다.
		
			result = a+b;
		else if(op == '-')
			
			result = a-b;
		else if(op == '*')
			
			result = a*b;
		else if(op == '/')
			
			result = a/b;


	System.out.printf("%d %c %d = %d",a,op,b,result);




				
		





	}





}