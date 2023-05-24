//클래스와 인스턴스

//사용자로부터 임의의 정수를 입력받아
//1부터 입력받은 수 까지의 합을 연산하여
//결과값을 출력하는 프로그램을 구현한다.

//단, 지금까지 처럼 main() 메소드에 모든기능을 적용하는 것이 아니라
//클래스와 인스턴스의 개념을 황용하여 처리할 수 있도록한다.
//hap 클래스 설계
//또한 데이터 처리 입력과정에서 BufferedReader의 readLine을 사용하며
//입력데이터가 1보다 작거나 1000보다 큰경우
//다시 입력받을 수 있는 처리를 포함하여 프로그램을 구현 할 수 있도록 한다.

//실행 예)
//임의의 정수 입력(1~1000) : 

//do while문 쓰는듯 
//>> 1~ n까지의 합은 ~다
//
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Hap
{
	int n;
	//int result=0; result가 필요한 곳에만 선언하면 된다.



	void input()throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//while(true){ //무한 반복 do while안에서만 써도됨 //생각하고쓰기 while은 필요없었다.

			do
			{
				System.out.print("임의의 정수를 입력(1~1000) : ");
				n = Integer.parseInt(br.readLine());
			}
			while (n<1||n>1000);
			
		

	}

	//}


	int sum(){

		int result = 0;

		for(int i=1;i<=n;i++){
			result += i; 

		}
		return result;

		//System.out.printf("1부터 %d 까지의 합은 : %d입니다\n",n,result);
		//리턴값이 int인데 System.out.을 써서그런다.
		

	}

	void print(int result){

		System.out.printf("1부터 %d까지의 합은 %d\n",n,result);


	}

	
}


//import java.io.IOException; 한 파일 안에서는 예외처리 두번안해도댐 import는 class들이 설계되기
//이전에 모두 끝나있어야한다.

public class Test072
{
	public static void main(String[] args)throws IOException
	{

		Hap ob = new Hap();  //모든 인스턴스 호출은 
		//왜 class.input(); 이렇게는 못쓰나? 이걸 다른곳에서 선점했기에
		//생성한 인스턴스를 통해 입력 메소드 호출 -> input()
		// --------------------
		//  참조변수를 활용해야한다.

		ob.input();  //== new Hap().input(); 와 같다.
		int result = ob.sum();
		ob.print(result); //ob.print(ob.sum()); 해도 된다.

		//main안에 하던걸 따로나눠서 한다고생각하자 
		//자바는 그저 커다랗고 덩치큰 하나의 클래스보다 작은 여러개의 클래스가 훨씬 좋다.
		//간단하고 직관적인 여러개의 클래스들을 만드는 연습을해야한다.
		

	}


}