/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
Object 클래스
================================*/

class Test 
{

	private int a = 10;

	public void write()
	{
		System.out.println("a : " +a);
	}
}


public class Test128
{
	public static void main(String[] args)
	{
	Test ob1 = new Test();
	Test ob2 = new Test();

	System.out.println("10 == 9: " + (10 == 9));
	

	int a=10;
	int b=10;

	System.out.println("a == b : " + (a==b));

	//=비교 연산자는 피연산자의 크기를 비교함을 확인(관찰)

	System.out.println("ob1 == ob2 : "+ (ob1 == ob2));
	System.out.println("ob1 == ob2 : "+ ob1.equals(ob2));
	//객체를 비교하게 되면 객체의 (식별)9주소를 비교한다. 크기를 비교하진 않음
	//위 둘이 같은거라면 
	//equals 메소드를 통해 객체의 식별주소를 비교하고 리턴값이 boolean이니 boolean형으로
	

	System.out.println();
	System.out.println("---------------------------------------------------------------");
	System.out.println();
	System.out.println("ob1 : "+ ob1);
	System.out.println("ob1.toString() : "+ob1.toString());

	System.out.println("ob2 : "+ob2);
	System.out.println("ob2.toString() :"+ob2.toString());

	//클래스명@해시코드

	//해시코드
	//	자바 내부적으로 객체를 구분하기 위해 사용하는 것.
	//메모리의 주소값으로 생각하면 절대로 안된다.

	//객체가 같으면 hashcode도 같지만
	//  hashcode가 같다고해서 같은 객체는 아니다.
	


	}
}
