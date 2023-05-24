/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
Wrapper 클래스
================================*/

import java.math.BigInteger;

public class Test132
{
	public static void main(String[] args)
	{
		//int a1 = 123456789123456789;
		
		//System.out.println(a1);

		//long d1 = 123456789121231233456789L;

		BigInteger a = new BigInteger("12345678912398234"); //큰수를 담기위해 int에 담지말라고 문자열로 넘겨받게 만들었다.
		BigInteger b = new BigInteger("12345678912398234"); 
		
		//BigInteger c = a+b;
		//System.out.println(c);

		//덧셈
		BigInteger c = a.add(b); //사용방법
		System.out.println("덧셈결과 : "+c);

		//빼기
		BigInteger d = a.subtract(b);
		System.out.println("뺄셈 결과 :" + d);
		//뺄셈 결과 : 0

		//곱하기
		BigInteger e = a.multiply(b);
		System.out.println("곱셈 결과 : "+a);
		//곱셈결과 : 
		
		//나누기
		BingInteger f = a.divide(b);
		System.out.println("나눗셈 결과 : "+f);

		//지수승
		BigInteger g = new BigInteger("2");
		System.out.println("2의 3승"+g.pow(3));


	}
}