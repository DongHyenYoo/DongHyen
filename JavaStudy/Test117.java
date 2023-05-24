/*===================================
클래스 고급
인터페이스
================================*/

/*인터페이스란

  완전히 미완성된 채로 남겨져
  인터페이스 안에 존재하는 그 어떤 메소드도
  몸체(정의부)가 없기에 사실상 실행 부분이 존재하지 않는다.
  클래스를 위한 템플릿으로써의 기능을 수행하는 
  추상 클래스의 한 종류


  인터페이스는 클래스와 달리 다중 상속이 가능하며
  인터페이스 자체도 상속됨
  기존의 c++등에서 지원되는 다중 상속이
  사용 과정에서 많은 문제점을 노출시켜
  자바에서는 다중 상속의 개념을 인터페이스라는 개념으로 변형하여
  인터페이스를 통해 다중 상속을 구현하는 방법을 지원

  인터페이스는 상수와 추상 메소드만 가질 수 있으며
  인터페이스 안의 메소드들은 접근제어지시자를 명시하지 않아도
  public으로 설정되어 클래스에서 구현 함으로써
  바로 접근이 이루어질 수 있다.


  특징
  -추상 클래스의 일종으로 선언만 하고 정의가 없다.
  -final변수는 가질 수 있다.(상수의 개념)
  -인터페이스를 구현하기 위해서는 extends대신에
  -implements를 이용한다.
  -하나 이상의 인터페이스를 implements할 수 있다.
  -인터페이스를 implemnts한 클래스는
  -인터페이스의 모든 메소드를 Overrriding해야 한다.
  -인터페이스가 다른 인터페이스를 상속받을 수 있으며
    이때 extends 키워드를 사용한다.
	또한 클래스와 달리 인터페이스는 다중 상속이 가능하다.

interface 인터페이스명
{
	자료형 메소드1();
	자료형 메소드1();
	자료형 메소드1();
	자료형 메소드1();
	자료형 메소드1();
	{

abstract class 클래스명 implements 인터페이스명
{
	이렇게된다. 다만
	인터페이스의 모든 메소드를 오버라이드 하게 된다면
	abstract를 뗄수 있다.
}

class 클래스 extends 클래스

class 클래스 extends 추상클래스

class 클래스 implements 인터페이스 이건 다중상속이 가능

class 클래스 implements 인터페이스 implements 인터페이스 implements 인터페이스 implements 인터페이스 


interface 인터페이스 extends 인터페이스 extends 인터페이스extends 인터페이스extends 인터페이스


	*/
interface Demo
{
	public static final double PI = 3.141592;

	public int a = 10; //이거도 된다. 왜냐면 자동으로 static final이 붙는다.
	//인터페이스의 멤버 변수는
	//static final을 별도로 명시하지 않아도
	//자동으로 static final인 상태

	public void print(); //선언은 가능하나 정의(기능)은 불가능하다. 추상메소드여서
	                    //abstract를 붙여야할 것같지만 자동으로 붙여준다.
	
}

//class DemoImpl
//class DemoImpl extends Demo 안된다. 
//abstract class DemoImpl implements Demo
class DemoImpl implements Demo //인터페이스의 메소드를 오버라이드 했으므로 추상클래스가 아니다.
{
	@Override
		public void print()
	{
		System.out.println("인터페이스 메소드 재정의..");
	}

	public void write()
	{
		System.out.println("인터페이스 메소드 정의..");
	}
	

}
//main() 메소드를 포함하는 외부의 다른 클래스

public class Test117
{
	public static void main(String[] args)
	{
		//Demo ob = new Demo(); //인터페이스는 객체 생성이 불가능하다.
	
		DemoImpl ob = new DemoImpl();
		//인터페이스를 implements 만 한상태에서는 불가
		//print() 메소드를 재정의한 후 abstract를 떼어낸 후 가능

		
		//DemoImpl obTemp = new DemoImpl();
		//Demo ob1 = (Demo)obTemp;
		//Demo ob1 = obTemp;

		//업캐스팅
		//인터페이스 객체는 상위 객체
		Demo ob2 = new DemoImpl();
		ob2.print();
		//->인터페이스 메소드 재정의
		//ob2.write();
		//에러남 현재 ob는 업캐스팅으로 부모의 자리로 가있으므로
		((DemoImpl)ob2).write(); //다운캐스팅으로 자식의 자리로 내려오면 된다.

		System.out.println(Demo.PI); //static이라 된다.
		System.out.println(Demo.a);  //static이라 된다.

		//Demo.a = 30; 이건 final이라 안됨 컴파일 에러






		

		
	}
}