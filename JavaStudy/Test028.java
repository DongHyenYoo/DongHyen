//조건 연산자 == 삼항연산자
//사용자로부터 임의의 정수를 입력받아
//입력받은 정수가 양수인지. 음수인지, 0인지 구분하여
//이 결과를 출력하는 프로그램을 구현한다.
// 단, 입력데이터는 BufferedReader이용
//조건연산자 활용하여 기능구현
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test028
{

	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n;
		String strResult;

		n = Integer.parseInt(br.readLine());

		strResult = ( n > 0 ) ? "양수" : (n < 0 ) ? "음수" : "영";
		//strResult = ( n > 0 ) ? "양수" : (n < 0 ) ? "음수" : (n ==0) ? "영" : "몰라";

		System.out.printf("%d -> %s\n",n,strResult);

0







	}








}