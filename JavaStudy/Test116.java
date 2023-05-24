/*===================================
클래스 고급
-상속 관계에 있는 클래스들 간의 캐스팅
 (업 캐스팅, 다운 캐스팅)

================================*/

class SuperTest116
{
	public int a=10,b=20;
	private int d = 5;

	public void write()
	{
		System.out.println("슈퍼 클래스 write() 메소드..");
	}
	
	public int hap()
	{
		return a + b;
	}

}

class SubTest116 extends SuperTest116
{
	public int b=100, c=200;

	@Override
		public int hap()
	{
		return a+b+c;
	}
	public void print()
	{
		System.out.println("서브클래스의 print()메소드..");
	}

}




public class Test116
{
	public static void main(String[] args)
	{

		SubTest116 ob = new SubTest116();


		SuperTest116 ob1 = ob; //이걸 업캐스팅 이라고 한다. SuperTest116 ob1 = new SubTest116();이것도 된다 인터페이스 만들때랑 차이없음
		//ob = ob1;
		//SuperTest116 ob1 = (SuperTset116)ob; 과 같다.
		ob.print();  //????업캐스팅을 했는데 ob는 아무 문제가 없는데/?????? 
		//byte a = 10;
		//int b = a;
		// int b = (int)a; byte값은 int에 포함되어있고
		// byte를 int로 형변환후 b에 넣겠다.

		System.out.println(ob1.hap());
		//310의 결과 상위클래스로 업캐스팅된 ob1이지만 hap은 자식클래스에서 오버라이드했고
		//이것이 부모의 hap을 덮어씌웠으니 310이 나온다.
		//hap 메소드는 오버라이딩 되어있고
		//ob1은 ob을 업캐스팅한 상태의 객체이므로
		//SuperTest116의 hap() 메소드를 호출하는 것이 아니라
		//SubTest116에서 재정의한 hap()메소드를 호출하게 된다.
		//즉 메소드는 업캐스팅이 되더라도
		//재정의(덮어쓰기)한 이상 원래의 기능으로 되돌릴수 없다.

		SuperTest116 ob2 = new SuperTest116();
		System.out.println(ob2.hap());

		ob2.write();

		//ob1.print();// 현재 ob1의 위치는 SuperTest116이다.

		((SubTest116)ob1).print();
		((SubTest116)ob1).write();
		//결론적으로는 된다. 왜냐면 ob1은 슈퍼Test의 형이지만 기본적으로는 자식클래스를 기반으로 생성된
		//ob이므로 다운캐스팅이 된다.
		//자식클래스는 부모클래스의 생성자까지 가지고있어 부모를 기억하나
		//부모 클래스는 자식클래스의 생성자와같은 정보가 없어 모른다.
		//자식클래스로써 부모와 자식의 정보를 둘다가진 ob을 부모클래스로 격상시켜서 만든게 ob1니까 
		//ob1에는 부모와 자식의 정보가 둘다 들어있으니까 자식클래스로의 다운도 가능하다
		
		//추가 관찰
		//다운 캐스팅 가능 여부

		SuperTest116 ob3 = new SuperTest116();
		SubTest116 ob4 = new SubTest116(); //SubTest116은 그냥 이 타입으로 ob4를 만들겠다는것이지 SubTest116클래스를 불러온것이 아니다.
		//SuperTest116 ob3 = (SuperTest116)ob4 ; //이러면 되고 위에 주석처럼 하면 X
		//System.out.println(ob3.c);
		//컴파일 에러
		//상위객체는 하위객체의 것에 접근할수 없다.
		//상위 객체는 어떤 하위 객체가 존재하는지 알 수 없다.
		
		//ob4 = (SubTest116)ob3; //불가능하다. ob3는 부모로써 자식에 대한 정보가 없기에 (부모 클래스의 생성자만 가져왔기에)
		//런타임 에러main" java.lang.ClassCastException: SuperTest116 cannot be cast to SubTest116


		ob3 = ob4; //가능하다. ob4는 자식으로써 부모에 대한 정보가 있기에 (자식 객체 생성시 자식 클래스의 생성자와 부모클래스 생성자를 가져온다)
		ob4 = (SubTest116)ob3;
		ob4.write();
		ob4.print();

		//ob4 = (SubTest116)ob3; //하위인 ob4를 ob3에 넣었으므로 ob4에 다운캐스팅 해서 넣을수 있다. 
		
		//ob3.print(); //ob3는 자료형? 이 부모 클래스이다. 즉 오버라이드 된건 가져올수 있으나 자식의 메소드에는 접근 못하는것
		

		System.out.println(ob3.hap()); // 310 인 이유? : ob4는 자식객체 ob3는 상위객체이나 자식의 정보를 가지고있어 hap은 자식의 hap을 가짐


		//System.out.println(ob3.d); //상위클래스의 private에 접근못하는 이유 상위객체였으나 현재 자식객체를 넣었으므로 private에 접근하지 못한다.


		//부모 ob1 = new 부모(); //부모클래스만 메모리에 올려진다.

		//자식 ob2 = new 자식(); //부모와 자식이 둘다 올라간다.


/*
업 캐스팅, 다운캐스팅이 정상적으로 이루어지는 경우

	1.하위 객체 생성;
	2.상위 = 하위;  //업 캐스팅
	3.하위 = 상위; //에러 ob = ob1 이것과 같은의미로 ob1은 자식의정보와 부모의 정보 둘다가지고 있는것은 맞으나 현재의 위치가 부모기에 자식이 어디있는지 모른다.
	4.하위 = (하위)상위; //다운캐스팅

다운 캐스팅이 정상적으로 이루어지지 않는경우

  1.상위 객체 생성;
  2.하위 = 상위;
  3.하위 = (하위)상위; //문법은 다운캐스팅이나 런타임에러가 발생하는 케이스

	여기서 중요한건 생성된 객체가 하위 객체라는것

	업캐스팅은 항상 가능하나 다운 캐스팅은 경우에 따라 가능(생성된 객체가 하위인지 상위인지)

*/



		
		

	}
}