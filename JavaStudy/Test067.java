//return 실습


//return 키워드가 지니는 의미

//1. 값의 반환
//2. 메소드 종료

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Test067
{
	public static void main(String[] args)throws IOException
		
	{
		BufferedReader br = new BufferedReader(new InputStream(System.in));
		
		int n,s;
		System.out.print("임의의 정수 입력 10이상 : ");
		n = Integer.parseInt(br.readLine());

		if(n<10){
			System.out.println("10 이상의 정수를 입력해야 합니다");
			return;//무조건 main을 종료시키는게 아닌 
			     //return을 품고있는 메소드가 종료되는것 -> 프로그램 종료
		}




		s=0;
		for(int i=1;i<=n;i++){

			s += i;


		}




	}

}