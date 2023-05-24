/*===================================
클래스 고급
인터페이스
================================*/

interface ADemo
{
	public void write();
}

interface BDemo
{
	public void print();
}

//인터페이스는 2개 이상을 구현할 수있다. 
//클래스에서 다중 상속이 되지 않는 부분을 보완하는 개념

//abstract  class DemoImpl implements ADemo, BDemo 
class DemoImpl implements ADemo, BDemo
{
	@Override //인터페이스의 오버라이드는 JDK1.6부터다
			  //단 상속받은 클래스의 메소드를 오버라이딩할때는 1.5에서도 가능
	public void write()
	{
		System.out.println("ADemo 인터페이스 메소드 write");
	}
	
	@Override
	public void print()
	{
		System.out.println("BDemo 인터페이스 메소드 print");
	}

}


public class Test118
{
	public static void main(String[] args)
	{
		//ADemo ob = new ADemo();
		//BDemo ob = new BDemo();
		DemoImpl ob0 = new DemoImpl();

		DemoImpl ob = new DemoImpl();

		ob.write();
		ob.print();

		ADemo ob2 = new DemoImpl();//(ADemo)ob0;
		BDemo ob3 = new DemoImpl(); //(BDemo)ob0;
		
		ob3.print();
		
		ob2.write();

		((BDemo)ob2).print(); //대신 위치를 B로 이동했기에 write가 안보인다. ->자식 -> A인터페이스 -> B인터페이스로 위치 변경
		((ADemo)ob3).write(); //위와 비슷한 상황
		//DemoImpl 클래스가 두 인터페이스를 모두 구현했기에
		// 이와 같은 처리가 가능하다.
		//만약 DemoImpl 클래스가 두 인터페이스들 중 한 인터페이스만 구현했다면
		//이 구문은 런타임 에러가 발생하는 구문이된다.

		((DemoImpl)ob2).write(); //이건 다운캐스팅
	}
}