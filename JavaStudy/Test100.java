/*===================================
클래스와 인스턴스
static 변수와 static 메소드
================================*/

//1.static : 탄생시점
//
//2.static : 공유


//실습 편의상 접근제어지시자 생략


public class Test100
{

	//클래스 변수 또는 클래스 메소드는
	//클래스 정보가 로딩되는 순간 메모리 할당이 이루어지며
	//	클래스 이름 또는 객체를 통해 접근할 수 있다.
	//	즉 new연산자를 통해 메모리르 ㄹ할당 받지 않아도 사용이 가능하다.


	static int a = 10;   //static 변수(클래스 변수) ,정적 변수


	//인스턴스 변수 또는 인스턴스 메소드는
	//동일한 클래스의 메소드에서는 바로 접근하는 것이 가능하지만
	//클래스 메소드에서는 접근할수 없다.

	int b = 20;          //non static 변수(인스턴스 변수),

	void write()	//인스턴스 메소드
	{
		System.out.println("클래스 변수 a"+a);
		System.out.println("인스턴스 변수 b"+b);
	}

	static void print() //스태틱 메소드 (클래스 메소드, 정적 메소드)
	{	
		System.out.println("클래스 변수 a"+a);
		//System.out.println("인스턴스 변수 b"+b); //에러
	}




	public static void main(String[] args)
	{

		System.out.println("main() -> 클래스 변수 a   "+Test100.a); //이렇게 static 변수를 부를수 있다.
																  //글래스 변수에 접근하기위해서는
																  //클래스명.변수명 의 형태로 클래스의 이름을 통해
																  //접근하는 것이 가능


		System.out.println("main() -> 클래스 변수 a   "+a);    //같은 클래스에 들어있어서 그냥 접근이 가능했던것

		
		Test100.print();//원래는 이렇게 불러야한다. 클래스명.메소드();

		print();//같은 클래스 안에있으니 생략
		//System.out.println("main() -> 인스턴스 변수 b"+b); //에러

		//Test100.write(); //에러 객체 생성 안됬으므로

		//write(); //에러 객체 생성 안됬으므로

		//Test100 클래스 기반 객체 생성

		Test100 ob = new Test100();

		ob.write(); 
		System.out.println("main() -> 인스턴스 변수 b"+ob.b);
		//write(); 이것도 안대 무조건 생성된 객체를 통해서 들어와야 한다. static으로 컴파일러가 처음 스캔하면서 메모리에 퍼올리지 않았으므로

		//static 변수 메소드는 생성된 객체.변수  객체.메소드()로도 호출할 수 있따.

		//생성된 인스턴스를 통해 클래스 변수 호출
		System.out.println("main() -> 클래스변수 a :"+ob.a);

		//생성된 인스턴스를 통해 클래스 메소드 호출
		ob.write();

		//클래스 변수나 메소드는
		// 생성된인스턴스명.변수명
		// 생성된인스턴스명.메소드명()
		//의 형태로도 호출이 가능하나
		//	클래스명.변수명
		//	클래스명.메소드명()
		//	의 형태로 호출하는것이 일반적인 룰이다.

		System.out.println("main() -> 클래스 변수 a : " + a);
		System.out.println("main() -> 클래스변수 a   :" +Test100.a);
		System.out.println("main() -> 클래스변수 a   :" +ob.a);
		

		/*
		main() -> 클래스 변수 a : 10;
		main() -> 클래스 변수 a : 10
		main() -> 클래스 변수 a : 10
		*/
		
		System.out.println(); //개행

		//Test100 클래스 기반 인스턴스 생성

		Test100 ob2 = new Test100();

		ob2.a = 10000;	//클래스 변수 초기화
		ob2.b = 20000; //인스턴스 변수 초기화

		ob2.write();

		ob.write(); //클래스 변수라서 클래스 변수를 초기화 해도 이것이 공유되서 같이 a가 10000이 되었다.

		




	}
}