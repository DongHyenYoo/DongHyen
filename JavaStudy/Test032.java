//제어문 실습
// if문
//if - else 문 실습

//프로그램을 작성할 때 주어진 조건에 따라
//	분기 방향을 정하기 위해 사용하는 제어문에는
//  if문 if ~ else 문. 조건 연산자 , 복합 if 문 )if 문 중첩
//  switch문이있다.

//2.if문은 if 다음의 조건이 참일 경우
//	특정 문장을 수행하고자 할 때 사용되는 구문이다.

//사용자로부터 임의의 정수를 입력받아
//홀수 / 짝수를 판별하는 프로그램을 구현한다.
//단 단일 if 구문을 활용하여 처리할 수 있도록한다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test032
{
	public static void main(String[] args)throws IOException
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("임의의 정수 입력 :");

		
		int a = Integer.parseInt(br.readLine());
		String stResult;


		if (a % 2 == 0)
		{
			stResult = "짝수입니다.";
		}
		
		else{
		 
			stResult = "0입니다.";
		}


		System.out.printf("%d 는 %s%n",a,stResult);

	}

  //stResult = 가 초기화 되지 않아서 에러
}