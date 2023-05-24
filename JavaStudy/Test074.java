/*===================================
클래스와 인스턴스
-생성자(Constructor)
================================*/

/* 생성자의 역할

1. 인스턴스 생성->과정중에 메모리 할당
2. 초기화

생성자(Constructor)의 특징

1.생성자는 메소드이지만, 일반 메소드처럼 호출될 수 없으며,
  반환자료형을 가질수 없다. void조차 가질수 없으며 값을 반환할 수도 없다.
  2.생성자는 클래스와 동일한 이름을 가져야한다.
    (대소문자 명확히 구분)
  3.생성자는 객체를 생성하는 과정에서 단 new 생성자();의 형태로 호출된다.
    (인스턴스 생성시 단 한번만 호출)
	-final 변수(상수화된 변수)를 초기화 가능하다.


*/

class NumberTest
{

	int num; //전역변수는 초기화 안시켰을경우 자동으로 0으로 초기화

	//사용자 정의생성자가 없다면
	//컴파일 과정에서 default생성자가 자동으로 삽입된다.(이 생성자는 아무것도 정의되어있지 않다)
	//사용자 정의 생성자(사용자가 직접 작성한 생성자)
	NumberTest()
	{
		num = 10;
		System.out.println("사용자 정의 생성자 호출");
	}

	int getNum()
	{

		return num;
	}


}


public class Test074{

	public static void main(String[] args){

		//클래스 기반의 인스턴스 생성
		NumberTest ob = new NumberTest();
		//인스턴스가 생성되는 시점에서
		//이와 동시에 강제로 생성자 호출이 이루어진다.
		//                   ----------
		//                    NumberTest();
		/*
		NumberTest ob = new NumberTest;
		                     +
					        NumberTest(); 구문이 합쳐진것

		ob.NumberTest();
		---> 컴파일 에러 찾을수없다고 나옴 //생성자는 객체 생성시 단 한번만 호출된다.
		*/
		System.out.println(ob.getNum());

		ob.num = 200; //NumberTest의 num값을 200으로 바꾼다.

		System.out.println(ob.getNum());

		NumberTest ob1 = new NumberTest(); //객체가 한번탄생할때 생성자가 한번 생성되는것이므로
		                                   //설계도가 같을뿐 다른 객체이다.

        System.out.println(ob1.num); //10 객체의 전역변수 받아오는 구문
		System.out.println(ob1.getNum()); //같은 설계도(class)이나 다른객체이므로 10이 나온다.
		
		int testResult = ob1.getNum(); // ob1.num; 과 같은 값이 나온다.
		System.out.println(testResult); //같은class에서 나온 객체들이 결과적으로 다른이유는 생성자덕분이다.


		

	}

}