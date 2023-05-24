/*===================================
클래스 고급
중첩 클래스
================================*/

class Test2
{
	static int a = 10;
	int b = 20;

	void write() //첫번째 write메소두
	{
		System.out.println("write()...");
		final int c = 20;
		int d = 40;
		//메소드 안에 존재하느 또다른 클래스(로컬 클래스

		class LocalTest //객체생성이 되야 태어난다. 즉 태어나는 시점을 보장받을 수 없다.
		{               //근데 c는 상수화되서 절대 변화하지 않으므로 c에 대한 접근을 허락한다.
						//근데 d는 언제든지 변할수 있으므로 d에 대한 접근을 허락할 수 없다.
			void write() //두번째 write메소두
			{
				System.out.println("write()...");
				System.out.println("a : "+a);
				System.out.println("b : "+b);
				System.out.println("c : "+c);
				//System.out.println("d : "+d);
			}
		}
		
		//변수 c와 변수 d 는 둘 다 지역변수이지만..
		//(첫 번째 write() 메소드 안에서 선언된 변수이므로)
		//c는 final 변수이기 때문에
		//두번째 write() 메소드에서 언제 접근하더라도
		//고정된 값 20임을 보장받을 수 있다.
		//반면에 d는 그 값이 수시로 변할 수 있는 상황이므로
		//LocalTest 클래스의 인스턴스 생성 시점이
		//언제가 될지 알수 없기 때문에
		//이로인해 인스턴스 생성 시점에 d에 어떤 값이 담겨있는지
		//보장 받을 수 없기 때문에
		//변수 d에 접근하는 것을 피할 수 있도록 문법적 처리
	
	
		d += 10; //d가 변한다라고 말하는 구문을 없애니 컴파일 에러가 사라졌다. 즉 d가 변하지 않을거라고 말해주는것
		
		d += 20;

		LocalTest lt = new LocalTest();
		lt.write(); //두번에 write메소드 호출

		d += 30;
		d += 40;
	
	}
}


public class Test123
{
	public static void main(String[] args)
	{
		Test2 ob = new Test2();
		ob.write(); //첫번째 write메소드 호출
		System.out.print(ob.d);
	}
}