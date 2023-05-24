/*===================================
클래스 고급
인터페이스
================================*/

interface Demo
{
	public void write();
	public void print();
}

abstract class DemoImpl implements Demo
{
	@Override
	public void write()
	{
		System.out.println("write() 메소드 재정의");
	}
	
	
}

class DemoImplSub extends DemoImpl
{
	//재정의한 write를 물려받는다.
	@Override
	public void print()
	{
		System.out.println("print() 메소드 재정의");
	}
}


public class Test119
{
	public static void main(String[] args)
	{
		DemoImplSub ob = new DemoImplSub();
		
		//DemoImpl에서는 print()재정의 안해서 객체 생성이 안되고
		//DemoImpl에서 재정의한 write()를 물려받고 print()를 재정의한 DemoImplSub로 객체 생성이 가능하다.
	}
}