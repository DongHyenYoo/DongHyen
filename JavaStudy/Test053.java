// 과제
//임의의 정수 입력받아
//1부터 입력받은 그 정수까지의
//전체합 짝수의 합  홀수의 합을
//각각 결과값으로 출력하는 프로그램을 구현한다.

// 임의의 정수 입력 :
//1~123 까지 정수의합 : ''
//이하 동문

import java.util.Scanner;

public class Test053
{

	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);
		System.out.print("임의의 정수 입력 : ");


		int oddSum,evenSum;
		oddSum = evenSum = 0;

		int num = sc.nextInt();
		if( num == 0){
			System.out.print("0은 안되요");
			return;
		}

		int i = 1; //1~를 담당할 변수i

		while(i<=num){


			if((i%2) == 0){
				evenSum += i; //짝수합
			}
			else if((i%2) != 0){
				oddSum += i; //홀수합
			}

			i++;
		}

		System.out.printf("1부터 %d 까지 정수의 합 : %d\n",num,(evenSum+oddSum));  //홀수+짝수합은 정수합
		System.out.printf("1부터 %d 까지 짝수의 합 : %d\n",num,evenSum);
		System.out.printf("1부터 %d 까지 홀수의 합 : %d\n",num,oddSum);

	}

}

/*
임의의 정수 입력 : 100
1부터 100 까지 정수의 합 : 5050
1부터 100 까지 짝수의 합 : 2550
1부터 100 까지 홀수의 합 : 2500
계속하려면 아무 키나 누르십시오 . . .
*/