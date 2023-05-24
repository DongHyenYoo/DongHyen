/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
Wrapper 클래스
================================*/


public class Test135
{
	public static void main(String[] args)
	{

		System.out.println(Integer.MAX_VALUE); //정수형의 최대값을 보여준다.
		System.out.println(Integer.MIN_VALUE);  //클래스명.변수므로 Integer의 클래스에 클래스 변수로 MIN_VALUE,MAX_VALUE

		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);

		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);

		//2147483647
		//-2147483648

		//9223372036854775807
		//-9223372036854775808
		//1.7976931348623157E308
		//4.9E-324


		System.out.println(); 


		//실수 기반의 나눗셈 연산 몫을 얻어내기위해 계속 나눔
		//

		System.out.println(" 1 : " + 3.0/0); //0으로나누면 무한대가 나오므로 출력결과 무한
		System.out.println(" 2 : " + -3.0/0); //0으로나누면 무한대가 나오므로 출력결과 마이너스 무한

		System.out.println(" 3: " + (3.0/0 == 3.0/0));
		System.out.println(" 4: " + (3.0/0 == -3.0/0));
		//true
		//false

		//Double.isInfinite() 앞이 is이므로 맞는지 아닌지 판단해서 true false로 반환

		System.out.println(" 5 : "+ Double.isInfinite(3.0/0));
		System.out.println(" 6 : "+ Double.isInfinite(-3.0/0));
		//5 : true
		//6 : true

		System.out.println(" 7 : " + (3.0/0 + -3.0/0)); 
		//NaN (Not a Number)
		System.out.println(" 8 : "+ (0.0/0));
		//NaN

		System.out.println("9 : " + (0.0/0 == 0.0/0));
		//false 둘다 NaN인데?? 피연산자에 NaN이 포함되있을경우 무조건 false가 나온다.
		System.out.println("10 : " + (0.0/0 != 0.0/0));
		//true

		//NaN 값과 임의의 수를
		// 크기 비교를 수행하는 == 연산자를 통해 비교 연산을 수행하게 되면
		// 결과는 언제나 false를 반환한다.

		//if(x == NaN) 이런식이면 무조건 if 는 실행이 안된다. false라서
		
		//Double.isNaN()
		System.out.println("11 : " + Double.isNaN(0.0/0)); //true NaN이므로
		System.out.println("12 : " + Double.isNaN(1.1+2.2)); //false  NaN이 아니므로 false
	}
}