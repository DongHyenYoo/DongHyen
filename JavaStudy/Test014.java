//변수와 자료형
//자바 기본 입출력 : BuffteredReader클래스
//사용자로부터 이름 국어점수 영어점수 수학점수를 입력받아
//이름과 총점을 출력하는 프로그램 구현

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Test014{

	public static void main(String[] args)throws IOException{

		String name;

		int strTemp;
		int korean, english, math, sum;
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //InputStreamReader isr = new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(isr);
		//제일 첫줄과 밑의 두줄이 같은 BufferedReader 인스턴스를 생성함를 가진다.


		System.out.print("이름을 임력하세요 : ");
		
		name = br.readLine();
		
		System.out.print("\n국어 점수 입력 : ");
		
		korean = Integer.parseInt(br.readLine());

		//strTemp = br.readLine();
		//korean = Integer.parseInt(strTemp);



		System.out.print("\n수학 점수 입력 :");
		
		math = Integer.parseInt(br.readLine());

		//strTemp = br.readLine();
		//math = Integer.parseInt(strTemp); strTemp는 중간저장공간으로 앞의 변수를 저장했다가 새로운 변수가 들어오면 덮어쓰기한다.

		System.out.print("\n영어 점수 입력 :");
		
		english = Integer.parseInt(br.readLine());

		sum = korean+english+math;

		System.out.printf("이름 :  %s \n",name );
		System.out.printf("총점 : %d\n", sum);

/*
이름을 임력하세요 : 유동현

국어 점수 입력 : 40

수학 점수 입력 :40

영어 점수 입력 :40
이름 :  유동현
총점 : 120
계속하려면 아무 키나 누르십시오 . . .
*/





	}




}


