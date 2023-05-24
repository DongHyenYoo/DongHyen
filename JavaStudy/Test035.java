//제어문 실습
// if문
//if - else 문 실습

//프로그램을 작성할 때 주어진 조건에 따라
//	분기 방향을 정하기 위해 사용하는 제어문에는
//  if문 if ~ else 문. 조건 연산자 , 복합 if 문 )if 문 중첩
//  switch문이있다.

//2.if문은 if 다음의 조건이 참일 경우
//	특정 문장을 수행하고자 할 때 사용되는 구문이다.

//과제
//사용자로부터 임의의 연도를 입력받아
// 입력받은 연도가... 윤년인지, 평년인지 판별하여
//그 결과를 출력하는 프로그램을 작성

//단, 입력은 BufferedReader
// if 조건문을 활용하여 연산을 수행할 수 있도록 한다.

//400의 배수이거나 4의 배수이면서 100의 배수는 아니거나 가 윤년이다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test035
	{

		public static void main(String[] args)throws IOException
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("연도입력 : ");
			int year = Integer.parseInt(br.readLine());

			if(year % 400 == 0){
				
				System.out.print("\n윤년입니다");


			}

			else if (year % 4 ==0 && year % 100 != 0)
			{
				System.out.print("\n윤년입니다");

			}
			else if (year % 400 != 0)
			{
				System.out.print("\n평년입니다.");
			}
			else if( year % 4 !=0 || year % 100 ==0)
			{
				System.out.print("\n평년입니다.");

			}





		}



	}
