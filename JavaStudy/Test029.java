//삼항 연산자 == 조건연산자

//사용자로부터 임의의 문자 하나 입력받아서
//대문자이면 소문자로, 소문자이면 대문자로
//알파벳이 아닌 기타문자라면 그 문자 그대로 출력하는 
// 프로그램 구현

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Test029
{
	public static void main(String[] args)throws IOException
		
	{
		
		
/*
		int temp;

		char strResult;
	    

		int stemp = System.in.read(); //무조건 int형으로 받아온다.

		System.out.println("변화전" + stemp);

		temp = stemp;


		strResult = ((97 <= temp) && (temp<= 122)) ? (char)(temp-=32) : ((65<=temp) &&  (temp<=90)) ?  (char)(temp+=32) : (char)temp; 
		
		System.out.println("결과" + strResult);
*/

		char temp;
		temp = (char)System.in.read();
		// 두개이상의 조건이 등장한다면 논리연산자 // 교집합이 필요하면 && 여집합이 필요하면 ||
		  // 'A' >=  temp &&  temp <= 'Z' ? "대문자" : "소문자";  //'A' >= 65 에서는 char인 A가 int로 바뀌어서 수행된다.
              // ture && true 형태로 참 거짓으로 바뀐다.

	    result = (temp >= 'A' && temp <='Z')? ((char)(temp+32)) : ((temp>='a' && temp <= 'z' ? ((char)(temp-32)) : ((char)temp));




/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//readLine과 스캐너의 scnext() 문자열의 형태로 읽어온다.
		//한글자를 넘겨도 숫자를넘겨도  해서 buffer과 scanner는 되지 않는것

		String strResult1;
		
		temp = Integer.parseInt(br.readLine());

		System.out.println("변환전" + temp);

		

		Scanner sc = new Scanner(System.in);

		temp = sc.nextInt();

		System.out.println("변환전"+temp);

		*/

		//Integer.parInt = 숫자모양의 문자열을 바꾸는 것일뿐 문자를 숫자로 바꿔주는것이 아니다.
		//sc.nextInt = 위와 동일


		
 
 
		

		





	}







}