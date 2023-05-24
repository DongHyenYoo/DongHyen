/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
================================*/

//126과 비교

//import java.lang.*;
//import java.lang.Object 도 포함되있을것

public class Test127 //extends Object
{

	@Override
		public String toString()
	{
		return "재정의한 toString()";

	}
	public static void main(String[] args)
	{
		Test127 ob = new Test127();

		System.out.println(ob.toString());
		//재정의한 toString() //127이 받은 오브젝트의 tostring을 재정의 했다.

		System.out.println(ob);
		//재정의한 toString() // 127이 물려받은 오브젝트라는 클래스는 객체만 입력했을경우 toString이 같이 실행되도록 만들었따.

	}
}