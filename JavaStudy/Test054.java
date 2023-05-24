//사용자로부터 원하는 단을 입력받아
//해당하는 구구단을 출력하는 프로그램을 구현한다.
//단, 1단~9단사이의 수를 입력받은 상황이아니라면
// 이에대한 안내를 한후 프로그램을 종료할 수 있도록 처리;

//실행 예
//원하는 단 입력 : 7
// 7 * 1 = 7
//~ 7 * 9 = 63


//원하는 구구단 입력 : 11
// 1부터 9까지의 정수만 입력이 가능


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Test054
{
	public static void main(String[] args)throws IOException
	{


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("원하는 단 입력 : ");

		int num = Integer.parseInt(br.readLine());

		if(num > 9)
			{ // num > 9 || num<1 가 더 좋은듯!
			System.out.print("1부터 9까지의 정수만 입력이 가능\n");
			return;
		}

		int i =1; //구구단 곱셈해줄놈

		while(i<=9){
			
			System.out.printf("%d * %d = %d\n",num,i,(num*i));
			i++;
		}

	
	}


}