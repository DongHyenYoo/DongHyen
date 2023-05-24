/*====================================
■■■실행 흐름의 컨트롤(제어문■■■
=====================================*/

// break 실습

//	 ※ break 키워드가 지나는 의미
//		멈춘다 + 그리고 빠져나간다

// 다음과 같은 처리가 이루어지는 프로그램을 구현한다.
// 단 입력받은 정수는 1~100 범위 안에서만
// 가능하도록 작성한다.

// 실행 예 )

// 임의의 정수 입력 : -10

// 임의의 정수 입력 : 0

// 임의의 정수 입력 : 2022

// 임의의 정수 입력 : 10
// >> 1~10까지의 합 : 55
// 계속하시겠습니까(Y/N)? : Y(y)

//임의의 정수 입력 : 100
// >> 1~100까지의 합 : 5050
// 계속하시겠습니까(Y/N)? : N(n)
// 계속...							→ 프로그램 종료

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Test065
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

/*
//ㅅㅂ모르겟다
		System.out.print("임의의 정수 입력 : ");
		int num = Integer.parseInt(br.readLine());
		int a;
		int sum = 0;
		char answer;

		while (true)
		{
			if (num>=1 && num<=100)
			{
				for (a=1; a<=num; a++)
					{
						sum +=a;
						a++;
					}
			}
			System.out.printf("1 ~ %d까지의 합 : %d\n", num,sum);


			System.out.print("계속하시겠습니까(Y/N)? : ");
			answer = (char)System.in.read();
			System.in.skip(2);
			//테스트
			System.out.println(answer);


			if (answer=='n'|| answer=='N')
			{
				break;
			}

		
		
		}
*/



		//함께
		//check~!!
		//누적합 변수의 초기화 위치~!!
		int n,s,i;
		//-- n : 사용자로부터 입력값을 담아둘 변수
		//	 s : 누적합 연산 결과를 담아낼 변수
		//	 i : 1부터 1씩 사용자의 입력값까지 증가할 변수

		char ch;
		//-- ch : 프로세스를 계속 진행할지 말지의 여부를 담아둘 변수


		while (true)
		{
			// 무한 반복(무한 루프)
			do
			{
				System.out.print("\n임의의 정수 입력 : ");
				n=Integer.parseInt(br.readLine());

			}
			while (n<1 || n>100);

			//테스트(확인)
			//System.out.println("유효한 정수 입력 완료~!!");

			//누적합 변수의 초기화 위치 check~!!!
			s = 0;

			for (i=1; i<=n; i++)
			{
				s += i;			//-- 누적합 연산
			}

			System.out.printf("1 ~ %d까지의 합 : %d\n", n,s);

			System.out.print("계속하시겠습니까(Y/N)? : ");

			ch = (char)System.in.read();
			//-- 계속할지 말지에 대한 여부(의사표현)
		//	System.in.skip(2);		//엔터값 처리 Y만 에러가 나는것은 ch에 string이 들어갔기때문
		//	모든게 뒤에 엔터값이 나오는데 안할거에요 하면 엔터값을 버리게 된다.
		//		근데 계속하겠다고하면 y 엔터값이 버려지지않고 앞쪽의 readLine())부분에서 땡겨쓰기때문에
		//		그렇게된것 y랑 Y라서 그런게 아니라 계속하겠다고  했기에 그렇게된것

			//-- 그만할래~ → 빠져나감
			//if (ch=='n' || ch=='N')  ==>이 경우 N이 아닌 다른 문자여도 다시 루프기때문에
			//Y나 Y가 아닐 경우 빠져나가는 조건을 다는것이 좋다**
			
			//if (ch=='y'|| ch=='Y') ==> ||를 쓸경우 y가 아니면 뒷부분 체크를 안하기때문에 &&사용


			if (ch!='y'&& ch!='Y')	//-- y 또는 Y 입력한거 아닌거 맞아?

		
			{
				//반복문을 멈추고 빠져나갈 수 있는 코드 작성 필요
				//위와 같은 의사표현을 했다면
				//그동한 수행했던 반복문을 멈추고 빠져나가야 한다.
				break;
				//멈춘다 + 그리고 빠져나간다

		}// end if (블레스가 많아서 헷갈릴땐 이렇게 체크하기)






		}//end while(true)





	}//end main()

}//end class Test064

/*

임의의 정수 입력 : 55
1 ~ 55까지의 합 : 1540
계속하시겠습니까(Y/N)? : n
계속하려면 아무 키나 누르십시오 . . .


임의의 정수 입력 : 40
1 ~ 40까지의 합 : 820
계속하시겠습니까(Y/N)? : p
계속하려면 아무 키나 누르십시오 . . .


임의의 정수 입력 : 30
1 ~ 30까지의 합 : 465
계속하시겠습니까(Y/N)? : y

임의의 정수 입력 : 5
1 ~ 5까지의 합 : 15
계속하시겠습니까(Y/N)? : n
계속하려면 아무 키나 누르십시오 . . .
*/