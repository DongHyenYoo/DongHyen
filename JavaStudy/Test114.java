/*===================================
클래스 고급
-상속
================================*/

/*
메소드 오버라이딩 재정의 의 특징
-메소드 이름,리턴타입,파라미터수나 타입이 완전히 일치해야 한다.
-반드시 상속광계가 있어야한다.
-재정의된 하위 클래스의 메소드 접근제어지시자는
  상위클래스의 메소드 접근제어지시자보다 범위가 크거나 같아야한다.
  예를들어 상위클래스 메소드의 접근제어지시자가 protected인 경우
  하위 클래스가 이 메소드를 오버라이딩하는 경우
  접근제어지시자는 public or protected이어야한다.
  -static /final/ private 메소드는 오버라이딩 할 수 없다.
   static인 메소드는 먼저 태어나있기에 그건 덮어쓰기가 안된다.
   final 도 상수화 시키겠다라는 의미인데 메소드 앞에붙으면 메소드의 최종버전이라는 뜻
   이라서 재정의 하지말라는 의미로 붙이는 키워드 이다.

  -Exception의 추가가 불가능하다.
  오류의 종류들을 구분하기 위해 자바에서는 이 오류를 각각의 Exception객체로 
  구분하기에 부모가 123에 대한 Exception을 해놨다면 자식클래스는 456에 대한
  Exception을 추가할수 없다.

  즉 상위 메소드가 가지고있는 기존 예외사항에
  새로운 Exception을 추가하는 것은 불가능 하다는것

*/


class SuperTest114 //부모
{
	private int a =5;
	protected int b = 10;
	public int c = 20;

	public void write()
	{
		System.out.println("Super write() 메소드 : "+a+" : "+b+" : "+c);
	}
}
class SubTest114 extends SuperTest114 //자식
{
	protected int b = 100;//덮어쓰는것이 아니다?!
	                      //변수와 메소드는 저장되는 메모리의 위치가 다르다
						  //실제 메소드는 호출이 됬을때 메모리에 독립적인 공간에 적재가된다.
                          //메소드가 상시로 계속 메모리에 어떤 공간을 차지하고 있는것이 아님
						  //변수와는 다르다.
						  //즉 상속받을시 메모리에 퍼올려지는 것은 메소드가 아닌 변수만이며
						  //부모의 변수와 자식의 변수는 이름이 같을지라도 서로 다른위치의 메모리에 저장되며
						  //메소드는 같은 독립적 공간에 저장된다.
	public void print()
	{
		//System.out.println("Sub print() 메소드 : "+a+" : "+b+" : "+c);
		//컴파일 에러
		//슈퍼클래스에서 선언된 변수a에는 접근할 수 없다.
		//private 변수이기 때문에...
		System.out.println("Sub print() 메소드 : "+b+" : "+c);//물려받은 b 이지만 내가 선언했으므로 내 b
		System.out.println("Sub print() 메소드 : "+this.b+" : "+c);//내 b이지만 내께 없다면 상속받아 내꺼된 b
		System.out.println("Sub print() 메소드 : "+super.b+" : "+c);//부모꺼
	}
	@Override
		public void write()
	{
		System.out.println(b+" : "+c);
	}

	
}
public class Test114
{
	public static void main(String[] args)
	{
		//자식 클래스 인스턴스 생성
		SubTest114 ob = new SubTest114();
		ob.print();
		System.out.println(ob.b);
		//->100
		System.out.println(((SuperTest114)ob).b); //상속받은 클래스기반으로한 객체를 부모클래스로 형변환을 한것으로
		                                        //이는 ob가 부모클래스로부터 상속받은 클래스이기에 가능하다.
		//--->10								//이를 문법적으로 슈퍼부름이라고 한다. (((부모클래스)객체).변수or메소드);

		((SuperTest114)ob).write(); //100 : 20이건 왜 슈퍼부름이 안됬지?
		                           //Test114.png를 보면 부모,자식 메소드는 서로 내용이 같으면
								   //겹쳐지기때문에 자식클래스가 오버라이드해서임
									//하지만 write에 부모의 프라이빗인 a를 쓰는순간 a를 찾을수 없다고나오는것을 보니 오버라이드 한쪽에 들어가서 그쪽 변수를 받아와서 출력하는 것
									//super 명령어가 먹히기도 하고
		SuperTest114 ob1 = new SuperTest114(); //하지만 부모클래스로만 객체를 생성한다면 오버라이드 한지도 모르기에 부모는 자식을 모른다. 본인의 write를 실행시킨다.
		//System.out.println(((SuperTest114)ob).a);
		ob1.write();
		//System.out.println(ob1.a);
		//오버라이드 해제하면 
		//Super write() 메소드 : 5 : 10 : 20이런결과가 나온다.

		//부모클래스 -> 자식클래스(상속받음) -> 손자클래스(자식클래스 상속받음)
		//저것도 가능하다.
		//이때는 손자클래스의 생성자 안에서 자식클래스의 생성자를 그리고 이안에서 부모클래스의 생성자호출
	}
}