//자바 기본 입출력 : System.util.Scanner
/*
java.util.Scanner
단란 문자 패턴을 사용하여 입력을 토큰에 따라 분할하며
디폴트로 사용되는 단란문자는 공백
작성된 다음 토큰은 next() 메소드를 사용
다른형태(자료형)의 값으로 변환할수 있다.
*/

import java.util.Scanner;

public class Test018{
	
	public static void main(String[] args){

		//주요 변수 언언
		Scanner sc= new Scanner(System.in);

		// java.util.Scanner sc = new java.util.Scanner(System.in));
        
		String name;
		int kor, eng, mat, tot;

		System.out.print("이름 국어 수학 영어 점수 입력");
		
		name = sc.next();
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		tot = kor + eng + mat;


		System.out.println();
		System.out.println("이름 : "+ name);
		System.out.println("총점 : "+ tot);

		//엔터나 스페이스 같은 부분도 알아서 잘 갈무리? 한다.







	}






}