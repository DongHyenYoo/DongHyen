/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
Wrapper 클래스
================================*/

public class Test134
{
		public static void print(Number i)//Number n = new Integer(); 이 가능하다! Number는 추상클래스인데
	{
		System.out.println(i);
		if(i instanceof Integer)
		{
			System.out.println(i.intValue());
		}
		else if(i instanceof Double)
		{
			System.out.println(i.doubleValue());
		}

		//java.lang.Number 클래스(추상 클래스)는
		//모든 숫자형 wrapper클래스의 부모 클래스
		//슈퍼클래스 상위 클래스 이다.
		//b2 i2 자료형이 Number에 넘어오면서
		//업캐스팅이 일어난다.
	}

	

	public static void main(String[] args)
	{
		byte b = 3;
		int i =256;

		Byte b2 = new Byte(b);
		Integer i2 = new Integer(i); 

		System.out.println(b2);
		System.out.println(i2);
		
		print(b2);
		print(i2); //Numer형의 i객체에  Integer형의 객체가 업캐스팅되어 들어간다.
		print(3); //3-> 객체로 변하는 오토 박싱


		

	






	}
}