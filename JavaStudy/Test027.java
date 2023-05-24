//연산자
//-조건 연산자 == 삼항연산자
// 피연산자 연산자 피연산자 연산자 피연산자
//  1항              2항              3항

// 피연산자 ? 피연산자 : 피연산자
// 1항          2항        3항

//1항의 연산결과 -> true -> 2항을 수행해서 종료
// 1항의 연산결과 -> false -> 3항을 수행해서 종료

//사용자로부터 임의이ㅡ 정수를 입력받아
//입력받은 정수가 짝수인지 홀수인지 판별하는 프로그램을 구현
// 단 조건연산자 를 활용하여 문제해결



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Test027
{

	public static void main(String[] args)throws IOException
		
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n;          //사용자로부터 입력받은 임의의 정수를 담아둘 변수
		String strResult; // 홀수인지 짝수인지에 대한 판별 결과를 담게된 변수

		//홀수인지 짝수인지에 대한 판별 연산
		// 수식1 ? 수식 2 : 수식3

		//수식1 : true(참) 또는 거짓(false)을 반환할 수 있는 수식 형태로 작성
		//수식2 : 수식1의 처리 결과가 참(true)일 결우 수행하는 영역
		//수식3 : 수식1의 처리 결과가 거짓(false)일 경우 수행하는 영역

		//입력받은 정수n이 홀수인지 짝수인지 확인하는방법
		//n을 2로 나눠 나머지가 0이면 짝수
		// 0이 아니라면 홀수




		//연산 및 처리
		System.out.print("임의의 정수 입력 :");
		n = Integer.parseInt(br.readLine());

	//	(n % 2 != 0) ? "홀수" : "짝수";
	//	(n % 2 == 0) ? "작수"  : "홀수";
		//31 % 2 ==0 ? "짝수" : "홀수"
		// 1 == 0 ? "짝수" : "홀수"
		//false ? "짝수 " : "홀수";
		//이 문장 전체가 "홀수" 가된다.

		strResult = (n % 2 == 0) ? "짝수" : "홀수";
		//strResult = (40 % 2 ==) ? "짝수" : "홀수";
		//strResult = 0 ? 짝수 : "홀수"
		// '' = true ? "짝수 : 홀수"
		//strResult = "짝수";

		
		System.out.printf("%d -> %s\n", n, strResult);

		//
		







	}




}