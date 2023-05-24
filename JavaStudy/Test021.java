//자바 프로그래밍
//-산술 연산자
//-BufferedReader
//-printf()


/*사용자로부터 임의의 정수를 두번 입력받아
사칙연산 및 나머지 연산을 수행하여
그 결과를 출력하는 프로그램 구현
단 입력받는 과정은 BufferedReader를 활용할 수 있도록 하고
출력받는과정은 printf 메소드 활용할 수 있도록 한다.
또한 나눗셈 연산은 편의상 정수 기반으로 처리한다.

//첫 번째 정수 입력 : 10
//두 번째 정수 입력 : 2

10 + 2 = 12
10 - 2 = 8
10 * 2
10 /2 
10 % 2
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test021{

	public static void main(String[] args)throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int strNum1, strNum2;

		int f,g;

		
		
		System.out.print("첫 번째 정수 입력 : ");
		strNum1 = Integer.parseInt(br.readLine());
		System.out.print("\n두 번째 정수 입력 : ");
		strNum2 = Integer.parseInt(br.readLine());

		f = strNum1/strNum2;
		g = strNum1%strNum2;

		System.out.printf("\n%d + %d = %d",strNum1,strNum2,(strNum1+strNum2));
		System.out.printf("\n%d - %d = %d",strNum1,strNum2,(strNum1-strNum2));
		System.out.printf("\n%d * %d = %d",strNum1,strNum2,(strNum1*strNum2));

		System.out.printf("\n%d / %d = %d",strNum1,strNum2,(strNum1/strNum2));
		System.out.printf("\n%d %% %d = %d",strNum1,strNum2,(strNum1%strNum2));
		//printf를 썻을때 %를 쓰면 뒤에 뭐가나오는지 집중하기에 %하나만 쓰면 에러남
		//System.out.println("\n"+strNum1+" /" + strNum2 + "=" + (strNum1/strNum2));
		System.out.println("\n"+strNum1+"%" + strNum2 + "=" + (strNum1%strNum2));










	}







}