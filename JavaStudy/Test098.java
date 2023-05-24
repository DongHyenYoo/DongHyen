/*===================================
클래스와 인스턴스
-정보 은닉과 접근 제어 지시자(접근 지시자, 접근 제어자, 접근 지정자, 접근 제한자
================================*/

class CircleTest2
{	
	//circleTest2의 멤버 변수 num 혹은 인스턴스 변수라고도 한다.
	//전역변수라고도 함 (이 클래스 전체에서 다보이기에)
	int num;

	
	//private int num; //정보 은닉을 위해
					//private라는 접근제어지시자의 선언은
					//클래스 내부에서만 접근 및 참조가 가능하게 하겠다는 의미
					//int 형 전역 변수 -> 자동으로 0으로 초기화
					//외부에서는 num에 있는 값을 넣을수도 뺄수도 없다.

	//해서 쓸수 있게만드려고 보통 getter/setter로 구성한다. 멤버변수를 private으로 구성했다면 게터/세터를 만드는것이 암묵적인 약속이다.

/*
	int getter() //같은클래스의 메소드에서는 private에 접근이 가능함
	{
		return num; //num값이 어떤상태인지 얻어내게해주는 것
	}

	void setter(int num) //멤버변수와 같은 자료형을 가지는것을 전달해주는 세터
	{
		this.num = num;
	}
*/

	void input()
	{
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.print("반지름 입력");
		num = sc.nextInt();
	}

	double calArea()
	{
		return num*num*3.141592;
	}

	void write(double area)
	{
		System.out.println("반지름"+num);
		System.out.println("원의 넓이"+area);
	}





}



public class Test098
{
	public static void main(String[] args)
	{
		CircleTest2 ob = new CircleTest2();

		//ob.num = 10; //이거 되는거임
		//Test098.java:33: error: num has private access in CircleTest2 그리고 이제 안됨 
		
		//ob.setter(10);

		//System.out.println(ob.getter());

		ob.input();//private이 되고 객체가 만들어진후 유일하게 num에 접근할수 있는 방법
		//ob.num = 우리가 입력해주는 수

		double area = ob.calArea();
		ob.write(area);

		/*
		반지름 입력500
반지름500
원의 넓이785398.0
계속하려면 아무 키나 누르십시오 . . .

*/



	}
}