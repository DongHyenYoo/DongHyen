//제어문 실습
// if문
//if - else 문 실습

//프로그램을 작성할 때 주어진 조건에 따라
//	분기 방향을 정하기 위해 사용하는 제어문에는
//  if문 if ~ else 문. 조건 연산자 , 복합 if 문 )if 문 중첩
//  switch문이있다.

//2.if문은 if 다음의 조건이 참일 경우
//	특정 문장을 수행하고자 할 때 사용되는 구문이다.

//2의 배수/ 3의 배수 /2와 3의 배수/ 2와 3의 배수가 아니다 라고 출력하는것

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Test034{

	public static void main(String[] args)throws IOException
		{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("정수 입력 :  ");

		int a = Integer.parseInt(br.readLine());
	
		
		if(a == 0 ){
			System.out.print("0이네요\n");
		}		
		else if( a%2 == 0 && a%3 ==0)
			{
			System.out.print("2와 3의 배수입니다");
			}

			else if(a%2 != 0 || a%3 != 0) // &&가 아닌이유? 
			{
				System.out.print("2와 3의 배수가 아닙니다");
			}
			else if( a%2 ==0 )
			{
				System.out.print("2의 배수입니다.");
			}
			else if(a%3 ==0)
			{
				System.out.print("3의 배수입니다.");
			}

			
			
			/*
				if( a%2 == 0 && a%3 ==0 )
				{
					System.out.print("2와 3의 배수");
					if(a%2 != 0 && a%3 != 0)
					{
						System.out.print("2와 3의 배수가 아니에요");
						if(a%2 == 0)
							{
							System.out.print("2의 배수에요");
						if(a%3 == 0)
							{
							System.out.print("3의 배수에요");
							}
							}
					}
				}
			


		*/



	}

}

