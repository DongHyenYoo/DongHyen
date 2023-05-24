//클래스와 인스턴스
// - 직사각형 클래스 설계 실습

/* 직사각형의 넓이와 둘레 계산 -> 클래스로 표현

클래스의 정체성 -> 직사각형의 설계도
클래스의 속성 -> 가로,세로,넓이,색,무게 등드읃ㄷ응
클래스의 기능 -> 넒이 계산, 둘레 계산, 가로 세로 입력

객체를 구성 -> 데이터(속성,상태)+ 기능(동작,행위)

클래스 설계  ->  변수          + 메소드


class 직사각형

//데이터(속성,상태) -> 변수 (순서 의미 없음)

//기능(동작,행위)    -> 메소드 ( 순서 의미 없음)
가로세로입력()



*/
class Rect
{
	int w,h; //데이터



	void input(){//기능 //안에 int a, int b 와 같은 매개변수를 받게안한이유는 변수를 받아오는게 아니라
		               //실제 사용자에게 값을 입력받기위해만든것
					   //이미 값을 다 입력했고 전역변수 w,h에 이미 값을 담았다. 
					   //그러니 리턴 자료형이 int 가 아니라 void일것
					   //호출한 지점에 값을 놓고오는것이 아닌
					   //호출됬을때 이미 전역변수 w,h에 값을 넣어놨으므로
					   //반환할 값은 없다. 그러니 void
					   //받은 값을 자기가 가지고 있는 w,h에 넣은것
		
		java.util.Scanner sc = new java.util.Scanner(System.in);

		System.out.print("가로 입력");
		w= sc.nextInt();
		System.out.print("세로 입력");
		h= sc.nextInt();


	}


	int callLength(){

		int round = 2*(w+h);
		return round;

		//return (w+h)*2;

	}
	int CalArea(){ //매개변수가 없는 이유는 손이 닫는거리에 변수가 있어서임

		int area = w*h;
		return area;
		//return w*h;

	}

	void sendResult(int a,int l){ //넓이와 둘레는 main에 돌아가있지 class안에 가로 세로처럼 출력되어있지 않음 //String이 아닌이유는 리턴으로 String이 아닌것은 //그저 출력만 하기때문
		System.out.println("가로 : "+w);  //이 메소드의 기능은 가로 세로 넓이 둘레를 출력하는것
		System.out.println("세로 : "+h);
		System.out.println("둘레 : "+a);
		System.out.println("넓이 : "+l);

	}
}

	/*
	class두개가 한개의 java파일 안에 저장되는것이 가능하다.

다만 파일의 이름은 public이 붙어있는 class의 이름으로만 저장이 가능하다

public 클래스는 하나만 가능하다.

다만 가급적으로 main이 포함되어있는 class를 주 이름으로 저장하는것이 좋다.

일반적으로는(실무적으로) 하나의 파일에 하나의 클래스를 설계한다.
또한 여러개의 클래스가 설계뙨 파일을 컴파일하게되면
내부에 설계된 클래스의 수 만큼 클래스 파일이 파생된다.
*/

public class Test070
{


	public static void main(String[] args)
	{
		Rect ob = new Rect(); //Rect 클래스 기반의 인스턴스 생성

		//입력 메소드 호출
		ob.input();

		int area = ob.CalArea();
		int length = ob.callLength();

		ob.sendResult(length,area);





	}


}