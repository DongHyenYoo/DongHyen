/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
================================*/

/*
   개요

   일반적으로 클래스는 하나만 존재하는 것이 아니라
   같은 종류의 클래스를 여러 개 묶어서 사용하게 되는데
   이러한 크래스나 인터페이스의 묶음을 패키지(package)라고 한다.
   Sun(Oracle)사에서는 자바 프로그램을
   효율적으로 작성할 수 있도록 자바 표준 패키지를 제공하며,
   자바 표준 패키지에는 그래픽, 네트워크, 데이터베이스 등의
   다양하고 유용한 클래스들이 포함되어 있다.

   import 구문

   자바 표준 패키지나 사용자에 의해 외부에서 만들어진 패키지를
   사용하기 위해서는 컴파일을 수행하기에 앞서 프로그램에 포함시키는
   과정이 필요한데, 이 때 import 문을 이용하여 패키지 또는
   클래스를 프로그램에 포함시키게 된다.
   하지만, java.lang.* 패키지는 자바 프로그램에 기본적으로
   import 되어 있기 때문에 이 패키지의 클래스들은 import 하지 않고
   바로 사용하는 것이 가능하다.

   import 문은 반드시 클래스 설계 구문 전에 선언되어 있어야 하며
   형식은 다음과 같은 두 가지가 있다.

   import[static] 패키지.클래스;
   import[static] 패키지.*'

   jdk1.5 부터는 import 다음에 static 키워드를 사용할 수 있게 하였고
   정적으로 import 할 수 있는 기능을 제공하게 되었다.
   만약 패키지를 정적으로 import 한 경우라면 모든 접근 가능한
   메소드와 멤버 변수들은 접두사(ob br sc등을 ) 붙이지 않고 
   사용하는 것이 가능





   Object 클래스
   java.lang.Object 클래스는 자바 클래스의 최상위 클래스
*/

public class Test126
{
	

	public static void main(String[] args)
	{

		Test126 ob = new Test126();

		//객체.xxx();
		//해당 객체를 생성시키는 대상 클래스의 메소드 xxx()호출

		//Rect ob = new Rect();
		// ob.input();
		//ob객체를 생성시키는 대상 클래스 -> Rect
		// Rect 클래스에 정의되어 있는 input() 메소드 호출

		//객체.yyy();
		//해당 객체를 생성시키는 대상 클래스에 
		// yyy()메소드가 존재하지 않을 때..
		// 에러 발생(컴파일 에러)

		//System.out.println(ob.action());
		//에러 발생(컴파일 에러)
		//---Test126 클래스에 action() 이라는 메소드가
		// 존재하지 않기 때문에 에러 발생하는 상황

		System.out.println(ob.toString());
		//에러안남 즉 Test126가 Object를 상속받았으니 Object안에 toString이 포함되어있다.
		//메모리 주소가 아니라 자바가 객체를 구분하기위해 임의로 부여하는 식별번호이다.
		//Test126 클래스에 toString() 메소드가
		//존재하지 않음에도 불구하고 에러가 발생되지 않는다.
		//Object로부터 상속받았기에
		System.out.println(ob);






		System.out.println(ob.toString());
		//ob의 설계도인 클래스의 부모클래스인 Object클래스의 메소드인 toString을 호출 
		//toString의 리턴값이 String이므로 객체의 식별번호를 문자열로 받아와서 println(String 문자열) 메소드를 이용해 호출
		//호출된순서 :  Object 클래스의 toString 메소드 ----->System 클래스의 println(String 문자열) 메소드
		

		System.out.println(ob);
		
		//System 클래스의 println(Object 객체) 인 메소드를 호출하고 해당메소드에 toString을 호출하는 구문이 있음
		//이는 System의 부모또한 Object이므로 자식클래스로써 상속받은 toString을 호출할 수있음 
		//호출된순서 : System 클래스의 println(Object 객체)메소드   -> Object 클래스의 toString 메소드 -> String으로 반환 -> System 클래스의 println(String 문자열)메소드?....
		//

		//그럼 println은 public 이므로 
	}
}