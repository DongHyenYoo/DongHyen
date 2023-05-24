/*===================================
주민등록번호 유효성 검사
================================*/

/*
주민등록번호 검증 공식

	1.마지막 자리를 제외한 앞자리의 수를 규칙에 맞게 곱한다.

	123456-1234567
	****** *******
	234567 892345 주민번호에 각자리에 밑의 수를 곱하기

	2.규칙에 맞게 곱셈 연산을 수행한 결과를 모두 더한다.

	3.더해진 결과값을 11로 나누어 나머지를 취한다.


		11/217  = 몫이 19고 나머지는 8

	4.11에서 나머지 8을 뺀 결과값을 구한다.

		11-8 = 3 이과정에서 나머지가 0인 경우는 결과값이 11이다.
									1 인 경우는            10
	
		두자리로 나올경우 다시 10으로 나누어 나머지를 취한다.

			11 -> 1로  10 -> 0으로 바꾼다.

	5.4의 연산 결과가 주민번호의 마지막 숫자와 일치하는지를 비교하여 확인한다.

	일치하면 유효한 주민번호고 불일치 하면 잘못된 주민번호다.


	940601 102441   9

	234567 892345

//입력개수 초과 미달 둘다 입력오류를 띄우고 프로그램을 종료한다.

//유효한 주민번호와 잘못된 주민번호도 구별하자

//문제 해결을 위한 추가 팁
//배열.length -> 배열방의 갯수를 반환하는 형태 속성값이고

//문자열.length() 메소드를 사용할 수 있다. 이건 문자열의 길이를 알려주는 것

//문자열.substring() -> 문자열을 추출하는 함수로 매개변수로 m n을 넘기면
// 문자열 m번째 위치에서 n-1위치까지 추출하는데 시작은 0부터

문자열.substring(0,6)
문자열.substring(7,13)

문자열 을 초과하면 stringindexoutof boundexception 나오고
 배열을            array

 매개변수를 하나만 넣으면 매개변수의 위치에서 문자열 끝까지 추출하게 된다.



1.문자열 입력받기

1.문자열.length()가 13보다 작거나 크면 잘못된 주민번호라고 하고 끝내기


2.문자열.substring(0,1)->(5,6)까지 배열에 저장하자.

3.곱할것도 문자열을 통해 앞부분과 뒷부분을 나눠 저장할 배열로 저장하고

for문을 통해 값을 하나씩 tot라는 값에 저장하고

11로 나눈나머지를 제일 끝의 문자열.substring(13)과 비교한다.
		



*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test106
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("주민번호를 입력하세요");

		String str = br.readLine();
		int tot=0;

		if(str.length()!=14)
			System.out.println("입력오류");

		int[] chk = {2,3,4,5,6,7,0,8,9,2,3,4,5};

		for(int i=0;i<13;i++)
		{

			if(i==6) //-의 영역
			{
				continue; //뒷부분 무시하고 계속해라 뒷부분이란 tot값 말하는것
			}
			tot += chk[i] * Integer.parseInt(str.substring(i,i+1));//잘나온다.

		}

		int result =11 - tot%11;

		result = result%10;

		if(result == Integer.parseInt(str.substring(13)))
		{
			System.out.println("정확 주민번호");
		}
		else
		{
			System.out.println("잘못 주민번호");
		}
		

		



/*
		
		//940601-1024419
		//2345 67 89 2345		str.substring(0,4) = str.substring(9,13)     4,5  7,8 이다.
		
		for(int i=0,n=2;i<4;i++)
		{
			tot += Integer.parseInt(str.substring(i,i+1))*n;
			tot += Integer.parseInt(str.substring(i+9,i+10))*n;
			n++;
			
		}

		for(int i=0,n=6;i<2;i++)
		{
			tot += Integer.parseInt(str.substring(i+4,i+5))*n;
			tot += Integer.parseInt(str.substring(i+7,i+8))*(n+2);
			n++;
		}
        

		System.out.println(tot);
*/
		
		/*
		
		System.out.print("주민번호를 입력하세요 : ");
		String iD = br.readLine();
		
		if(iD.length() < 14)
		{
			System.out.print("입력개수 미달.");	
			return;
		}
		else if(iD.length() > 14)
		{
			System.out.print("입력개수 초과.");	
			return;
		}

		//int num = Integer.parseInt(iD.substring(0,6));
		//System.out.printf("%d",num); 되네
		int[] numBefore = new int[6];
		
		for(int i=0;i<6;i++)
		{
			numBefore[i] = Integer.parseInt(iD.substring(i,i+1));
		}
		
		int[] numAfter = new int[7];

		for(int i=0;i<7;i++)
		{
			numAfter[i] = Integer.parseInt(iD.substring(i+7,i+8)); // 7~13까지
		}



		for(int i=0;i<6;i++)
		{
			System.out.println(numBefore[i]);
		}

		for(int i=0;i<7;i++)
		{
			System.out.println(numAfter[i]);
		}

		
		int[] gobBefore ={2,3,4,5,6,7}; //앞에 곱할수
		int[] gobAfter = {8,9,2,3,4,5}; //뒤에 곱할수

		int tot=0;

		for(int i=0;i<numBefore.length;i++)
		{
			tot += numBefore[i]*gobBefore[i];
			tot += numAfter[i]*gobAfter[i];
		}
		//for(int i=0;i<numAfter.length-1;i++)
			
		
		//System.out.print(tot);
		

		int halfResult = tot%11;

		System.out.println(halfResult);


		if(halfResult>=10)
			halfResult = halfResult%10;

		
		int result = 11-halfResult;
		
		System.out.println(result);

		if(result == numAfter[6])
			System.out.println("정확한 주민번호~!!!!");
		else
			System.out.println("잘못된 주민번호~!!!!");
*/

		
		

	}
}