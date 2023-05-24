/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
Wrapper 클래스
================================*/
/*
Wrapper 클래스

1.자바에서는 언어 수준에서 제공하는 기본형 데이터를 제외한
   나머지는 클래스로 설계하여 객체 단위로 처리한다.
   따라서 자바에서는 이러한 기본형 데이터를
   객체 단위로 처리 할 수 있도록 클래스를 제공할 수 밖에 없는데
   이러한 클래스들을 가리켜 Wrapper 클래스라 한다.

 2. 기본 자료형인
   byte, short, int, long, float, double, char , boolean형에 대응하는 
   Byte, Short, Integer, Long, Float , Double, Character, Boolean의 //앞이대문자니까 클래스임

   Wrapper 클래스 및 큰 숫자들을 다루기 위한
   java.math.BigInteger와 java.math.BigDecimal 클래스를 제공한다.

   Wrapper 클래스는 java.lang 패키지에 포함되어 있으므로
   별도의 import 과정 없이 바로 사용하는 것이 가능하며
   기본형과 마찬가지로 Wrapper 클래스도 내부 메소드를 통해
   형 변환이 가능하고, 동등 비교와 같은 연산도 가능하다.

   ex) java.lang.Integer 클래스
   int 기본 자료형의 Wrapper 클래스로
   정수를 다루는데 필요한 상수나 메소드, 진수 변환 등에 필요한
   메소드 등을 포함하고있따.

   static int parseInt(String s)
   문자열 형식으로 저장된 숫자를 정수 형태로 변환하여 반환한다.

   static Integer valueOf(int i)
   int형을 Integer형으로 변환한다.

   byte byteValue(), int intValue(), //해당 자료형으로 반환하는 메소드들
   short shortValue(), long longValue(),
   float floatValue(), double doubleValue()
   해당 기본 자료형으로 형 변환한 값을 반환한다.




	오토 박싱(auto-boxing) 오토 언박싱(auto -unboxing)

	일반적으로 레퍼런스 형과 기본 자료형은 호환되지 않으며
	이 경우 발생하는 문제 해결을 위해 자바에서는 Wrapper 클래스를 제공하게 되었다.
	하지만, JDK 1.5 부터 레퍼런스 형과 기본 자료형이 다음과 같이 형 변환이 가능하게되었따.

	int a=10, b;
	Integer ob; ob= 참조변수로써 값을가지고 있음 그런데 값을 가진 변수와 연산이 가능
	ob = a;(오토박싱)
	//Integer ob = new Integer(20); 이렇게 해야 ob에 20이 담겼었다. 이제 이것이 자동!	//20이라는 데이터가 담겨있는 Integer기반의 객체 생성


	b = ob;(오토언박싱) 객체 ->primitive
	Integer객체가 기본 자료형 int형으로 자동변환
	실제로 : b = ob.intValue();



	언박싱 = 객체타입 -> primitive
	박싱 = 위와 반대


	이는 JDK 1.5 이후 추가된 오통 박싱 오토 언박싱이라는 기능으로 인해 가능해진 것이다.




*/

public class Test130
{
	public static void main(String[] args)
	{

		int a=10, b;
		Integer c;
		Object d;

		b = a;
		//c = new Integer(0); //객체 생성
		c =0;
		b=c;                  //Integer형 데이터(객체) -> int 형 변수(오토 언박싱)
		b = c.intValue();         //객체의 메소드 호출을 통해 결과값 반환(언박싱)

		d = new Object();     //객체 생성

		System.out.println(d.toString());
		
		d = new Integer(10);   //업캐스팅     
		System.out.println("d.toStirng() :" + d.toString());
		//10
		//Integer에서 부모클래스 Object의 toString메소드를 오버라이드한것

		d = new Double(12.345); // 업캐스팅
		System.out.println("d.toString() :" + d.toString());
		
		d = 10;    //오토 박싱
		System.out.println("d.toString() :"+d.toString());

		//c = a+1;
		//d=a;
		//d=c;

	}

}