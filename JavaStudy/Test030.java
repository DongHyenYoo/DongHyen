//조건 연산자 == 삼항 연산자

//사용자로부터 임의의 연도를 입력받아
//입력받은 연도가 윤년인지 평년인지 판별하여
//그 결과를 출력하는 프로그램구현 
//입력버퍼리더
//조건연산자

//400의 배수이거나 4의 배수이면서 100의 배수는 아니거나

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Test030
{

	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int year;
		String strResult;

		year = Integer.parseInt(br.readLine());

		strResult = (( year % 4 == 0 && year%100 != 0) || year % 400 == 0) ? "윤년" : "평년";

		//strResult = (year % 4 ==0 && year % 100 !=0) ? "윤년" : (year % 400 == 0) ? "윤년" : "평년;
		//

		System.out.println(strResult);

		





	}







}