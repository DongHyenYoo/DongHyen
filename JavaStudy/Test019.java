//자바 기본 입출력 : System.util.Scanner
/*
java.util.Scanner
단란 문자 패턴을 사용하여 입력을 토큰에 따라 분할하며
디폴트로 사용되는 단란문자는 공백
작성된 다음 토큰은 next() 메소드를 사용
다른형태(자료형)의 값으로 변환할수 있다.
*/
//csv 데이터 타입
//데이터1,데이터2,데이터3 와같이 

import java.util.Scanner;

public class Test019{

	public static void main(String[] args){

		//주요변수 선언

		Scanner sc = new Scanner(System.in);
		String name;
		int kor, eng, mat, tot;

		

		//연산 및 처리
		System.out.print("이름 국어 영어 수학 입력 ,로 구분하고 공백입력금지");


		sc = new Scanner(sc.next()).useDelimiter("\\s*,\\s*");

		//               ----------   -----------------------
		//               1            2
		//이 순서대로 java에서 본다. 
		// 1번에 입력한 값을 얻어오고
		//sc = new Scanner(유동현,40,40,40).useDelimiter("\\s*,\\s*"); Delimiter는 구분자로 구분자를 사용하겠다는 의미
		// .useDelimiter = .구분자사용해서 입력된 값을 자르겠다는 의미이다. 
		//입력된 값들은 스캐너타입이라고 할수있고  스캐너패키지 안에 있는 메소드 들을  쓸수있다.
		
		// \\ = \하나를 표현하기위한것 즉 \s*,\s*을 전달한 것이고
		//								 임의의모든문자열,임의의모든문자열
		//							과 같이이들을 ,로 구분해달라는 의미

		//즉 
		//String temp = sc.next();
		// sc = new Scanner(temp).useDelimiter("\\s*,\\s*"); 이 두줄과 같다.
		
		name = sc.next();
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();

		tot = kor + eng + mat;


		//결과 출력
		
		System.out.println("\n 이름 : " + name);
		System.out.println(" 총점 : " + tot);


	}






}