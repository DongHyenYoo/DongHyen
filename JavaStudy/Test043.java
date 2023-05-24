//두정수와 연산자를 입력받아
//해당 연산자의 연산 처리 결과를 출력하는 프로그램을 구현한다.
//단 , switch 문을 활용하여 처리할 수 있도록하며
//연산 결과는 편의상 정수 형태로 처리할 수 있도록 한다.

import java.util.*;
import java.io.*;


public class Test043
{
	public static void main(String[] args)throws IOException
	{
	/*	
		Scanner sc = new Scanner(System.in);


		System.out.print("첫번째 정수 입력 : ");
		int strNum1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int strNum2 = sc.nextInt();
		System.out.print("연산자 입력 : ");
		int signMat = System.in.read();
		
		//char sign = (char)signMat;

		int result;
		*/
/*
		switch(signMat)
		{   
			
			case 42 : System.out.printf("%d %c %d = %d\n",strNum1,sign,strNum2,(strNum1*strNum2)); break;
			case 43 : System.out.printf("%d %c %d = %d\n",strNum1,sign,strNum2,(strNum1+strNum2)); break;
			case 47 : System.out.printf("%d %c %d = %d\n",strNum1,sign,strNum2,(strNum1/strNum2)); break;
			case 45 : System.out.printf("%d %c %d = %d\n",strNum1,sign,strNum2,(strNum1-strNum2));break;
			case 37 : System.out.printf("%d %c %d = %.2f\n",strNum1,sign,strNum2,(float)(strNum1%strNum2));break;
			


		}
*/
/*
		switch(signMat)
		{   
			
			case 42 : result = strNum1*strNum2; break;
			case 43 : result = strNum1+strNum2; break;
			case 47 : result = strNum1/strNum2; break;
			case 45 : result = strNum1-strNum2;break;
			case 37 : result = strNum1%strNum2;break;
			default: return; //return 은 1.값의 반환
			                 //return 2.~값을 반환한다라는 의미가 기본이나 메소드를 종료시키는 기능 이 두가지 기능을 모두가지고있다.
							//return뒤에 값이 명시되어있다면 1번이지만 아무것도 없다면 2번
							//return이 종료시키는 메소드는 return을 포함하고있는 메소드를 의미하고 이곳에서는 main메소드를 종료하는 것이다.
							//main을 종료시킨다는 의미는 프로그램을 종료시킨다는 의미이다.
		}
		System.out.printf("%d %c %d = %d\n",strNum1,signMat,strNum2,result);
		//int로 받은것을 %c로 출력하면 %c로 출력이가능

		//switch는 버전업이 되면서
		//문자 타입(char) 과 문자열(Strign)가 switch 수식과 case 상수에 쓰일수 있게되었다.

		*/

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a, b, result;
		char op;
		//String op;

		System.out.print("첫번째 정수 입력 : ");
		a = Integer.parseInt(br.readLine());
		System.out.print("두번째 정수 입력 : ");
		b = Integer.parseInt(br.readLine());
		System.out.print("연산자 입력 : ");
		op = (char)System.in.read();

		switch(op)
		{
			case '+' : result = a+b; break;
			case '-' : result = a-b; break;
				case '*' : result = a*b; break;
				case '/' : result = a/b; break;
				default : return;
		}
		System.out.printf("\n %d %c %d = %d\n",a,op,b,result);




		

	}



}