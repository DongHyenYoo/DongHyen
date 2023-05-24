//자바의 개요 및 특징
//변수와 자료형 - 5일차
//변수와 자료형 실습 및 테스트 : char
public class Test008{

	public static void main(String[] args){

		//주요 변수 선언
		char ch1, ch2, ch3;
		int a;


		//연산 및 처리
		ch1 = 'A';
		ch2 = '\n';//개행 문자로 하나로 취급된다.
		ch3 = '대'; // ㄷ + ㅐ 로 보는것이 아닌 대라고 하나의 문자로 인식
		
		a = (int)ch1; // 컴파일 에러가 나지않는건 자동형 변환 char -> int 규칙에 부합하기때문
		              //강제형변환 2번째 (의도적으로 실수하지 않았음을 강조하기위한 강제형변환

		// 결과 출력

		System.out.println("ch1 : " + ch1);

		System.out.println("ch2 : " + ch2);

		System.out.println("ch3 : " + ch3);
		
		System.out.println("a : " + a); //아스키 코드로 변환되서 출력

		System.out.printf("%c %c %c %d\n", ch1 , ch2, ch3, a);






	}

}