/*===================================
클래스 고급
중첩 클래스
================================*/
/*

중첩 클래스

중첩 클래스란 클래스 안에 다른 클래스가 설계되어 있는 형태로
클래스 내부에서만 사용할 보조 클래스가 필요한 경우
클래스를 중첩하여 프로그램의 구조를 보다 더 간단하고 알아보기 쉽도록
만들 수 있는데 이러한 클래스를 중첩 클래스라 한다.
이는,특정 클래스를 자신의 클래스 내부적인 용도로만 사용할 목적으로 쓰이는데
특정 클래스를 마치 자신의 멤버 변수나 메소드처럼 사용할 수 있게한다.

중첩 클래스의 종류 4가지

1.static 중첩 클래스(중첩 내부 클래스)
2.내부 클래스(inner class)
3.지역 클래스(로컬 클래스, local class)
4.무명 클래스(익명 클래스, annoymous class) //안드로이드에서 이벤트처리할때 주로 쓰인다. 그쪽이 아니면... 잘 안쓸듯?

1.static 중첩 클래스(중첩 내부 클래스)
  클래스 내부에... public static class 클래스명

  중첩 클래스를 감싸는 외부 클래스의{} 안에
  static 을 붙인 새로운 클래스를 설계하는 것으로
  모두 접근제어지시자를 사용할 수 있따.
  static 중첩 클래스가 포함하고 있는 메소드에서는
  외부 클래스의 인스턴스 변수나 인스턴스 메소드에는 접근할 수 없고,
  (외부 클래스의 객체를 생성하지 않은 상태)
  클래스 변수와 클래스 메소드만 접근할 수 있다.

  -프로그램의 구조를 보다 더 간단하고 알아보기 쉽게 구성할 수 있다.
  -static 으로 선언된 내부 클래스이다.
  -중첩 클래스의 객체는 중첩 클래스를 포함하고 있는
   외부 클래스의 객체와 동등하다.
   -외부 클래스의 클래스 변수와 클래스 메소드는
    바로 접근하여 사용하는 것이 가능하다.
	- 중첩 클래스와 중첩클래스를 포함하고 있는 외부 클래스의
	 인스턴스 변수와 인스턴스 메소드는
	  객체를 생성하여 서로 접근하는 것이 가능하다.
	 - 중첩 클래스를 외부에서 단독으로 사용하는 것이 가능

	
	2.내부 클래스(inner class)
	클래스 내부에 ... public class 클래스명

	-static 중첩 클래스와 마찬가지로 프로그램 구조를 보다 더 간단하고
	  알아보기 쉽도록 한 것이다.
	  - 외부 클래스의 메소드에서 내부 멤버 클래스를 사용하기 위해서는
	   반드시 내부 멤버 클래스 객체를 생성해 주어야 한다.
	   - 외부 클래스의 멤버 변수와 메소드를
	    객체 생성 없이 바로 사용하는 것이 가능하다.
		- 내부 멤버 클래스는 외부에서 단독으로 객체를 생성하여
		 사용할 수 없다.
		 즉 내부 멤버 클래스는 외부클래스의 인스턴스 생성이 선행되어야 한다.
		 -static으로 선언된 변수 또는 메소드를 가질 수 없다.

		 3. 지역 클래스(로컬 클래스)
		 메소드 내부에.. public class 클래스명
		 또는  public static class 클래스명

		 -클래스의 메소드 안에서 클래스를 정의하는 것으로
		  내부 멤버 클래스와 유사한 성격을 가지고 있긴 하지만
		  접근제어지시자는 붙일 수 없다.

		  class
		  {
			  자료형 메소드()
			  {
				  public class {}
				  
				  }


		  4. 무명 클래스( 익명 클래스)

		  클래스 또는 인터페이스에 대한 객체를 생성하면서
		  바로 클래스 또는 인터페이스를 정의하는 클래스.
		  -정의하는 부분과 생성하는 부분이 하나로 묶여져
		  new수식이 있는 곳에서 바로 클래스 또는 인터페이스를
		  정의하는것을 의미한다.

		  new 메소드명()
		  { 
			  기능의 클래스를 정의한다.
		  };



*/


//outer 영역
class Test
{
	static int a = 10;
	int b = 20;
		//inner 영역
	public static class StaticNested
	{
		int c = 30;
		void write()
		{
			System.out.println("write()..");
			System.out.println("a : "+a);
			//System.out.println("b : "+b);
			System.out.println("c : "+c); //write가 생성됬을때 c도 이미 생성됬다. 그래서됨 둘다 인스턴스인데도
		}
	}

		void print()
		{
			StaticNested sn = new StaticNested();
			sn.write();
		}
	
}

public class Test122
{
	public static void main(String[] args)
	{
		
		Test ob1 = new Test();
		ob1.print();
		// a
		// c 나옴

		//외부에서.. StaticNested(inner)기반 인스턴스 생성
		//StaticNexted ob2 = new StaticNested();
		//에러 발생

		//중첩 내부 클래스는 외부에서 단독으로 객체를 생성한다.
		//단 위와 같은 방법으로 객체를 생성해서는 안되고
		//클래스 변수 접근이나 클래스 메소드 호출하는 것과 같은 방식을 통해
		//접근하여 인스턴스를 생성할 수 있도록 처리해야 한다.

		System.out.println(Test.a);
		
		//Test.StaticNested ob2 = new Test.StaticNested(); //이렇게 객체 생성가능
		//ob2.write(); 
		//write()..
		//a : 10
		//c : 30

		//클래스 변수 클래스 메소드 스태틱 인스턴스 차이를 알아야한다.
		//클래스 로딩시
	}
}