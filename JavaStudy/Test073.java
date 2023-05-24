/*===================================
클래스와 인스턴스
================================*/


//사용자로부터 임의의 두 정수와 연산자를 입력받아
//해당 연산을 수행하는 프로그램을 구현한다.
//단 클래스와 인스턴스의 개념을 활용하여 작성할 수 있도록 한다.
//Calculate 클래스 설계

//실행 예
// 임의의 두 정수 입력(공백 구분)Scanner는 얘기 : 10 5
//임의의 연산자(+ = * /) : + (System.in.read)
//10 + 5 = 15 만들기

import java.util.Scanner;
import java.io.IOException; //System.in.read

class Calculate
{

	int a,b; //입력받은 두수를 저장할 변수
	char c; //입력받은 연산자를 저장할 변수
	int max,min;

	//변수를 전역으로 놓을지 않을지를 어떻게 나눠야하는가
	//연산에 대한 결과값을 왜 변수로 두지 않는가 = 필요하지 않아서
	//그럼 입력받는수도 왜 필요한가? = 계속 필요해서 메모리에 남아있어야됨
	//

	void inputNum(){

		Scanner sc = new Scanner(System.in);

		System.out.print("임의의 두 정수를 입력(공백 구분)");
		a = sc.nextInt();
		b = sc.nextInt();
	}

	void inputSign()throws IOException{ //System.in.read는 예외처리 스캐너만 예외처리 없음

		System.out.print("임의의 연산자(+ - * /)입력");
		
		c = (char)System.in.read();


	}

	void sum(int result){

		//int result=0; //return쓸때 무조건 초기화 되어있어야한다는거 까먹지말기

		
		
		if(a>b){ 
			max = a; min = b;}
			else{ 
				max = b; min =a;}

		switch(c){
			case '*' : result = max*min; break;
			case '/' : result = max/min; break;
			case '-' : result = max-min; break;
			case '+' : result = max+min; break;
			default : System.out.print("사칙연산자를 써주세요");
		} //else 없으면 변수 꼭 초기화

		//return result;
	}

	void print(int result){
		
		System.out.printf("%d %c %d = %d",max,c,min,result);
	}


}



public class Test073
{

	public static void main(String[] args)throws IOException{

		Calculate ob = new Calculate();
		
		ob.inputNum();
		ob.inputSign();
		int result=0;
		ob.sum(result);
		ob.print(result);

	}


}