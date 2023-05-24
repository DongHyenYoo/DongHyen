/*===================================
클래스와 인스턴스
-생성자(Constructor)
================================*/

public class Test078
{

	int n;
	int m;

	//n=100; 될거같지만
	//m=200; 이러한 연산은 안된다.
	//대입도 연산이다. 이건 초기화가 아니다.

	//int n=100;
	//int m=200;//이건 된다 이건 대입이 아니라 초기화라서

	{
		n=100; //다만 {안에 넣어놓으면 된다.왜?
		m=200; //이 {}를 초기화 블럭(Intitialized Block) 이라고 한다.
		System.out.println("초기화블럭 실행"); //이 블럭안에서는 변수를 초기화 할 수 있다.
				//초기화 블럭은 특별하지 않은 값인 기본속성들을 즉 생성자에서 건드리지않을
				//값들을 초기화블럭이 담당한다. 
	}		   

	Test078(){

		n=10;
		m=20;
		System.out.println("생성자 실행.."); 

	}

	Test078(int n,int m){

		this.n = n;
		this.m = m;
		System.out.println("매개변수있는 생성자");



	}

	void write(){
		System.out.println("n :"+n+" m : "+m);

	}


	public static void main(String[] args)
	{
		Test078 ob = new Test078();
		ob.write(); //생성자의 위치와 초기화블럭의 위치는 아무상관업시
		            //생성자가 더 나중에 실행되기에 생성자 실행시 만든 값으로 변하게된다.

		Test078 ob1 = new Test078(20231,3321);
		ob1.write();



	}


}