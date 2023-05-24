public class Test068
{

	//클래스의 영역

	//전역 변수 a 선언(클래스영역에서 전부 보이는 변수

	int a; //클래스에서 생성한 변수a
	double b;
	char c;
	boolean d;


	public static void main(String[] args)
	{

		Test068 ob = new Test068();//인스턴스 생성 //퍼올려진 Test068을 메모리에 할당하고 ob에는 Test068클래스가 퍼올려진 메모리의 주소가 담겨있고 
		//ob.a; //를 통해 class Test068이 퍼올려진 메모리를 참조하여 int a를 불러올수 있다.
		System.out.println("a : "+ob.a);
		System.out.println("b : "+ob.b);
		System.out.println("c : "+ob.c);
		System.out.println("d : "+ob.d);
/*
		a : 0 int 는 0으로 초기화를 시켜줌
		b : 0.0    double 는 0.0으로 초기화
		c :        char 는 빈문자로 초기화
		d : false boolean 은 false로 초기화
		계속하려면 아무 키나 누르십시오 . . . 와 같은 값이 나온다.
		즉 지역변수는 초기화를 시키지 않으면 에러가 나지만
		전역변수는 초기화를 시키지 않고 참조해도 초기화를 시켜준다.
*/





	}

}
/*
Test068.java:13: error: non-static variable a cannot be referenced from a static context
                System.out.println("a : "+a);
                                          ^
1 error
계속하려면 아무 키나 누르십시오 . .

069와 달리 초기화 되어있지 않아 발생하는 에러가 아님

static 변수가 아니라 에러가 발생한다. 라고 나와있음

main에는 static이 붙어있으나 class안에는 붙어있지않음


전역와 지역변수 둘다 값을 초기화 시키지 않으면 에러

클래스안의 전역변수라해도 그냥 쓸수 없음 class가 실체화 되어야 함

즉 Test068 클래스를 기반으로 인스턴스 생성이 필요



*/
