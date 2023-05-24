//자바 기본 입출력 : System.util.Scanner
/*
java.util.Scanner
단란 문자 패턴을 사용하여 입력을 토큰에 따라 분할하며
디폴트로 사용되는 단란문자는 공백
작성된 다음 토큰은 next() 메소드를 사용
다른형태(자료형)의 값으로 변환할수 있다.
*/

import java.util.Scanner;

public class Test017{

	public static void main(String[] args){

		//Scanner 클래스 기반의 인스턴스 생성
		Scanner sc = new Scanner(System.in); 

		//                new Scanner + Scanner(); 이 합쳐진 구문이다.
		//new 를 이용해서 scanner의 설계도를 가져와서 여기에 받은것을 sc에 저장해줘
		//기능이 많다고 성능이 좋은것은 아님 

		String name;
		int kor, eng, mat;

		//연산
		
		System.out.print("이름을 입력 : ");
		name = sc.next(); //문자열 형태로 반환한다.
		                  //스캐너는 예외처리 (throws IOException 이 필요없다.

		System.out.println("입력한 이름 : " + name);

		System.out.print("국어점수 입력 :");
		kor = sc.nextInt();  //문자열이 아닌 정수형태로 받는다.
		System.out.println("입력한 점수 " + kor);

		System.out.print("수학점수 입력 :");
		mat = sc.nextInt();
		
		System.out.print("영어점수 입력 :");
		eng = sc.nextInt();

		System.out.println("총점 :" + (kor + eng + mat));

		
		






	}





}
