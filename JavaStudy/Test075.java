/*===================================
클래스와 인스턴스
-생성자(Constructor)
================================*/

class NumberTest2
{
	int num;
	//사용자 정의 생성자

	NumberTest2(int n)
	{

		num = n; //생성자에서 num을 호출함
		System.out.println("생성자 호출시 매개변수 전달 : "+n);
	}

	int getNum(){

		return num;

	}
}

public class Test075
{

	public static void main(String[] args)
	{
		//NumberTest2 ob1 = new NumberTest2(); //생성자를 호출했는데 int형의 매개변수를 주지않아  에러가 남
									//컴파일 에러
									//NumberTest2 클래스에는
									//사용자 정의 생성자가 존재하므로 디폴트 생성자는 생성되지 않고
									//사용자 정의 생성자는 매개변수를 갖는 형태이기 때문에
									//위와 같이 매개변수 없는 생성자를 호출하는 형태의 구문은
									// 문제를 발생시키게된다.

		NumberTest2 ob1 = new NumberTest2(10);

		System.out.println("사용자 입력 변수값"+ob1.num);
		System.out.println("사용자 입력 변수값"+ob1.getNum());

	}
}
