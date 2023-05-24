/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
Wrapper 클래스
================================*/

import java.math.BigDecimal; //굉장히 큰 실수를 다루기 위한 클래스


public class Test133
{
	public static void main(String[] args)
	{
		BigDecimal a = new BigDecimal("12345678.123456677");

		//movePointLeft() 소수점을 왼쪽으로 이동

		BigDecimal b = a.movePointLeft(3);
		System.out.println(b);

		//나눗셈 연산(대체 속성 확인,)

		BigDecimal c = a.divide(b);
		System.out.println(c);
		//1E+3

		BigDecimal d = a.divide(b, BigDecimal.ROUND_DOWN); //반올림을 하지 않는다. -> 절삭
		System.out.println(d);
		//
		
		//BigInteger객체로 변환
		System.out.println(a.toBigInteger());
		//12345678 
		

	}
}
