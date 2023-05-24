//변수와 자료형
//자바 기본 입출력 : BuffteredReader클래스
//이제 키보드를 생성해서 정해진 값을 선언해 결과값을 내는것이아닌 
//입력을 해서 결과를 내보는데 필요한것
//import 란 현재 class내에서 쓰이는 것들이 어디서 온 구문이라는것을 명시하는 것

import java.io.BufferedReader; //java에게 java폴더에 io폴더에 bufferedreader를 읽어라 라고 말하는것
						       //그럼 bufferedreader의 설계도를 읽고 이만큼 에 해당하는 이를 메모리에 필요한 공간만큼 할당하는것
import java.io.InputStreamReader;  //이를 추가해줘서 이것에 대한 설계도도 java에 장착시킴
import java.io.IOException; //읽고쓰는데 문제가 발생할시 그 값을 버리는데에 동의하는 각서 같은 느낌

//import의 역할은 컴파일러에게 소스파일에 사용된 클래스의 패키지에 대한 정보를 제공하는것
// 컴파일시에 컴파일러는 import문을 통해 소스파일에 사용된 클래스들의 패키지를 알아내고
//모든 클래스 이름 앞에 패키지명을 붙인다.

public class Test012{


	public static void main(String[] args) throws IOException //읽고 쓰는데 문제가 발생한다면 main 이라는 영역밖으로 값을 버려라라는 각서
	
	
	{


		//키보드 장착(생성)
		//BufferedReader 클래스 기반의 인스턴스 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new 라는 것은 java에게 새롭에 bufferedreader의 설계도 대로 메모리에 퍼올려 달라는 의미
		//------------------------------------  -------------------------------
		// 문자입력을 읽어들이는 장치            바이트-> 문자 번역기  바이트 입력값
		//문자 입력을 읽어들이는 장치가 되는 코드 //또한 괄호안에 바이트와 같은 코드 형태를 문자로 번역할 번역기의 역할을 하는 new InputStreamReader을 넣어야한다.
       //System.in은 바이트 입력값

	   //br.readline(); //이렇게 하면 자바가 실행시켜주지않음 왜냐면 입력값이 어떤 값인지 불확정하기 때문에 해서 thorws IOException을 사용한다.
	   

	   //주요 변수 선언
	   int r;
	   final double PI = 3.141592;
	   double a, b;


	   //연산 처리

	   System.out.print("원의 반지름 입력:");

	   //실행하면 여기까지 멈췄다가 밑에줄에서 readline을통해 값을 입력받은순간
	   //---------------------------
	   //45 
	   //-------------------------
	   //와 같이 입력되면 bufferedreader을 통해서 해당 값을 받아들인다.이후 27줄을 통해 
	   
	   //사용자가 입력한 값을 받아와 반지름 변수r에 담아내기

		//r =br.readline();//bufferedReader이 가지고 있는 readline이라는 메소드를 가져다가 쓰겠다.
		              //BufferedReader의 readline();은 입력 대기열에 남아있는 문자열 반환

					  //r =br.readline(); 이렇게 되면 문자열을 반환하기에 int형에는 넣을수 없다.
		
		
		//"80" -> parseInt() -> 80 이렇게 반환하는 parseInt를 사용한다.
		r = Integer.parseInt(br.readLine()); //Integer상자 안에있는 parseInt를 사용해야되므로 Integer앞에 
		
	





		//사용자가 입력한 값을 br의 readline() 메소드를 활용하여 문자열 형태로 읽고
		//그 값을 Integer.parseInt()를 통해 정수형으로 변환환후
		//정수 형태의 반지름 변수 r에 담아내는것

		b = 2 * PI * r;
		a = PI * r * r;
		
		System.out.printf("반지름이 %d인 원의 넓이는 %.2f 이며 \n",r,a);
		System.out.printf("반지름이 %d인 원의 둘레는 %.2f 이다.\n",r,b);

		


	   //결과 출력
	   /*원의 반지름 입력:45
		반지름이 45인 원의 넓이는 6361.72 이며
	반지름이 45인 원의 둘레는 282.74 이다.*/

  









	}







}