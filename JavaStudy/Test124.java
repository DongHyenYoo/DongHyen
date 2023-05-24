/*===================================
클래스 고급
중첩 클래스
================================*/
class InnerOuterTest
{
	static int a = 10;
	int b =20;

	class InnerNested
	{
		int c = 30;

		void write()
		{
			System.out.println("Inner의 write()...");
			System.out.println("a: "+a);
			System.out.println("b: "+b);
			System.out.println("c: "+c);
		}
	}

	void write()
	{  
		System.out.println("outer의 write()..");
		
		InnerNested ob1 = new InnerNested();
		ob1.write(); //inner 의 write() 메소드 호출
	
	}

}
//main() 메소드를 포함하고 있는 외부의 다른 클래스

public class Test124
{
	public static void main(String[] args)
	{
		//InnerOuterTest(outer) 클래스 기반 인스턴스 생성
		InnerOuterTest ob2 = new InnerOuterTest();
		ob2.write(); //outer의 write 메소드 호출

		//InnerNested ob3 = new InnerNested();
		
		//InnerOuterTest.InnerNested ob4 = new InnerOuterTest.InnerNested(); //아까는 inner가 static이어서 클래스명으로 호출이 가능했던거고 이건 안됨 
	
		//중첩 내부 클래스(static 중첩 클래스)와는 달리
		//외부 클래스의 인스턴스(객체)를 사용하지 않고
		//단독으로 내부 클래스의 인스턴스를 생성하는 것은 불가능하다.
		//->외부 클래스의 객체를 사용하면
		//내부 클래스의 객체를 생성하는 것이 가능하다.

		InnerOuterTest.InnerNested ob5 = ob2.new InnerNested();
		ob5.write();

		InnerOuterTest.InnerNested ob6 = new InnerOuterTest().new InnerNested();
		ob6.write();

		//outer클래스명.inner클래스명 참조변수명 = new outer생성자().new inner생성자();

		//cf) static - 중접 내부 클래스
		//outer클래스명.inner클래스명 참조변수명 = new outer클래스명.inner생성자();
	}
}