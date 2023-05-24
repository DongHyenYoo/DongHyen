//swtich문 실습

//사용자로부터 1 부터 3까지의 정수 중 하나를 입력받아
//입력받은 정수만큼의 별문자가 출력되는 프로그램 작성
// 단 두가지 방법으로 구현

// 1. switch문의 일반 모델을 사용하여 break;

//2. switch문의 기본모델을 사용하되 break를 단 한번만 사용할 수 있도록

//임의의 정수 입력 1 -3 
//7 이면 입력 오류

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test042
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("임의의 정수 입력 : ");
		int a = Integer.parseInt(br.readLine());

		

/*
		switch(a){
			case 3 : System.out.println("★★★"); break;
			case 2 : System.out.println("★★"); break;
			case 1 : System.out.println("★"); break;
			default : System.out.println("입력오류"); break;

		}
*/
		switch(a){
			case 3 : System.out.print("★"); 
			case 2 : System.out.print("★"); 
			case 1 : System.out.print("★\n"); break;
			default : System.out.println("입력오류"); 
			 
			 

		}
		

	}


}
