//클래스와 인스턴스
// Test071은 CircleTest.java파일과 세트다
//원의 넓이와 둘레를 구하기
//(클래스명 : CircleTest) -> CircleTest.java
//BufferedReader 의 readLine();

//원의 넓이 = 반지름 * 반지름 * 3.141592
//원의 둘레 = 반지름 * 2*3.141592

//실행 예

//반지름 입력

//반지름이 xxx인 원의
//넓이

//둘레출력하게 하기
//여기 클래스에는 메소드가 없다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CircleTest
{  //주요 속성(데이터) 이것이 가지고있는 변수들은 CircleTest의 멤버 변수 / 가지고있는 메소드는 멤버 메소드라고 한다. 즉 소속관계를 의미하는것
	//이것만 있고 컴파일하면 에러가 나야한다 = main메소드가 없으므로
	int r;
	double PI = 3.141592;


	//주요 기능(동작, 행위) -> 멤버 메소드
	// 반지름 입력 기능 -> 메소드 정의

	//넓이 계산 기능 -> 메소드 정의
	// 둘레 계산 기능 -> 메소드 정의
	//결과 출력 기능 -> 메소드 정의

	void input()throws IOException{ //입력은 이 안에서만 벌어지는 일이기에 이안에서 예외처리를 해야한다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //class 의 영역에 다가 객체르르 생성하는 구문을 넣은것은 그렇게 좋지 않음
																				  //main에서 이 class를 메모리에 퍼올리는데 이때 class영역에 생성한 객체도 바로 메모리에 퍼올려짐
		System.out.print("반지름 입력 : ");										  //즉 아직 필요에 없는 객체가 메모리에 올라감 즉 입력받을 상황이 아닌데도 Buffered 객체가 계속 메모리에 상주함 -> 세수를 안할때도 계속 물이틀어진것과같다.
		r = Integer.parseInt(br.readLine());									   //input에 Buffered 객체를 생성할 경우 input을 호출했을때만 이 객체가 생성되었다가 메모리에서 없어짐
																					//단 클래스 영역에 BufferedReader br만 생성하고 메소드안에서 나머지를 작성하면 모든 메소드가 br을 사용한다면 이건 나쁘지않다.
	}

	double callRound(){

		double result;

		result = 2*r*PI;

		return result;
		
		
	}

	double callArea(){
		double result;

		result = r*r*PI;
		return result;

}

	void print(double a, double b){

		System.out.printf("둘레가 %d인 원의\n",r);
		System.out.printf("넒이 : %.2f\n",a);
		System.out.printf("둘레 : %.2f\n",b);

	}
}