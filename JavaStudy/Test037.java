//사용자로부터 임의의 정수 세개를 입력받아
//작은 수에서 큰수 순으로 출력하는 프로그램


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test037
{
	public static void main(String[] args)throws IOException
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("첫번째 정수 입력");
		int a = Integer.parseInt(br.readLine());
		System.out.print("두번째 정수 입력");
		int b = Integer.parseInt(br.readLine());
		System.out.print("세번째 정수 입력");
		int c = Integer.parseInt(br.readLine());

		if( a > b)
		{
			a = a ^ b;     
			b = b ^ a;    
			a = a ^ b;  
			}

		if( b > c)
		{
			b = b ^ c;
			c = c ^ b;
			b = b ^ c;
		}
		if(a > b)
		{
			a = a ^ b;
			b = b ^ a;
			a = a ^ b;
		}


/*
		if( a > b)
		{
			a = a ^ b;     
			b = b ^ a;    
			a = a ^ b;  
			}

		if( a > c)
		{
			a = a ^ c;
			c = c ^ a;
			a = a ^ c;
		}
		if(b > c)
		{
			b = b ^ c;
			c = c ^ b;
			b = b ^ c;
		}
		*/
		System.out.printf("정렬 결과 : %d  %d  %d",a,b,c);


}
}

			
