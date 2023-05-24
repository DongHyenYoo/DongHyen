/*===================================
클래스 고급
-상속
================================


상속이란
  새로 설계(생성)하고자 하는 클래스가
  이미 설계되어있는 클래스의 기능과 중복되는 경우
  이미 설계되어있는 클래스의 일부분이나 전체 구조를 공유할 수 있도록 하는 기능을 의미한다.

  즉, 상속은 객체를 좀 더 쉽게 만들 수 있는
  고수준의 재사용성을 확보하고
  객체 간의 관계를 구성함으로써
  객체 지향의 또 다른 특징인 다형성의 문법적 토대가 된다.

  상속은 기존 프로그램의 클래스 내용을 공유함으로써
  중복된 코드들을 재작성할 필요 없이
  반복적이고 세부적인 작업을 처리하지 않기 때문에
  프로그램을 작성하는 시간을 절약할 수 있고
  유지보수를 편리하게 할 수 있으며fd
  프로그램의 길이도 짧아지게 된다.

  또한 이미 작성된 프로그램들은 앞서 테스트되었기 때문에
  오류를 줄일 수 있어 현재 작성 중인 프로그램에만 전념할 수 있다.


주의할 점
  자바는 다중상속을 지원하지 않기에
  두개 이상의 클래스로부터 상속받을 수 없다.

  자바는 단일상속만을 지원한다.


*/

class SuperTest111 //부모클래스 == 상위 클래스 == 슈퍼 클래스 == 상속해주는 클래스
{
	protected double area; //클래스에서 쓰는 protected 보통 상속을 염두해둔 클래스에 protected 접근제어 지시자를 쓴다. 
	//생성자
	SuperTest111()
	{
		System.out.println("Super Class..");
	}

	void write(String title)
	{
		System.out.println(title + "-" + area);
		
	}
}




//자식클래스 == 하위 클래스 == 서브(Sub)클래스 == 물려받는 클래스

public class Test111 extends SuperTest111 // 상속해주는 주체보다 상속받는 주체가 중요하고 상속받을 부모클래스는 오직 1개여야한다.
{

	/*protected double area;  상속 받은 자식클래스는 클래스 영역에 이렇게 복붙된다고 보면 된다.
	                           부모로 부터 물려받은 area
	
	//단!!! 생성자는 상속의 대상에서 제외된다!



	void write(String title)      부모로 부터 물려받은 write()메소드
	{
		System.out.println(title + "-" + area);
		
	}*/

	public Test111() //이것도 생성자
		{
		//디폴트 생성자의 내부는 원래 비어있다 는건 사실 거짓말이었다.
		//사실 디폴트로 부모 클래스의 생성자 호출 구문이 들어있다.//

		//SuperTest111(); // (x) 스태틱이 선점해간 문법 클래스명();
		
		super(); //이것도 생성자이므로 생성자를 호출하고 싶다면 제일 앞에서 실행되야한다.
		System.out.println("Sub Class...");
		 //부모클래스의 생성자를 호출하는 구문이다.

		}

	public void actionCircle()
	{
		int r = 10;
		area = r*r*3.141592;
		write("원");

	}
	public void actionRect()
	{
		int w=20,h=5;
		area = w*h;
		write("사각형");
	}
	public static void main(String[] args)
	{
	Test111 ob = new Test111();
	//Super Class.. 자식클래스는 생성자를 상속받지 못하는데 왜 부모클래스의 생성자가?
	//자동으로 삽입되는 default 생성자!

	ob.actionCircle();
	/*
원-314.1592
계속하려면 아무 키나 누르십시오 . .
	*/
	ob.actionRect();
	
	




		
	}
}