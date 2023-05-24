/*===================================
클래스 고급
-상속
================================*/
//상속의 개념을 적용해서 작성한다.

//실행 예
//임의의 두 정수 입력 (공백구분)
//연산자 입력
// 20-15 = 5
//계쏙하려면 아무키나 누르세용

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


class Aclass
{
	protected int x,y;
	protected char op;

	Aclass()
	{
	}

	void write(double result)
	{
		System.out.printf(">> %d %c %d = %.2f\n",x,op,y,result);
	}
}

class Bclass extends Aclass
{

     boolean input()throws IOException //리턴으로 true와 false를 반환하므로 불린형
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		 System.out.print("임의의 두 정수 입력 (공백구분) : ");
		 String temp = br.readLine();
		 //문자열.split("구분자");
		 //문자열.split("\\s");  구분자가 공백이라는 뜻이다.

		 //"10 20 30 40 50".split("\\s");
		 //-> 반환 -> {"10","20","30","40","50"};과같이 문자열 배열로 반환

		 //ex) "010-3578-3912".split("-");
		 //->반환->{"010","3578","3912"};

		 String[] strArr = temp.split("\\s");
		 
		 if(strArr.length!=2) //배열.length = 속성이다./문자열.length();와는 조금 다름
		{
			return false;
		}

		 //여기서 에러가 나는데?? return true가 있으니 당연히 종료되지....

		//false를 반환 하며 input()메소드 종료
		//if코드가 수행될경우 false를 반환하고
		//아래 수행해야될 코드가 남아있더라도
		//false를 반환하며 메소드가 종료된다.

		x = Integer.parseInt(strArr[0]);
		y = Integer.parseInt(strArr[1]);


		 System.out.print("연산자 입력하세요(+ - * /) : ");
		 op = (char)System.in.read();

		 
		 if(op !='*' && op !='-' && op!='/' && op!='+')
			 return false;

		 //if(op =='*' || op =='-' || op=='/' || op=='+')
			// return true; //논리연산자 조심하자 
 
		 return true;


	}

	double calc()
	{
		double result=0;;
		switch(op)
		{
			case '*' : result = x*y;break;
			case '+' : result = x+y;break;
			case '-' : result = x-y;break;
			case '/' : result = (double)x/y;break;
		}

		return result;
	}

    

}

public class Test113
{
	public static void main(String[] args)throws IOException
	{
		Bclass ob = new Bclass();


		if(!ob.input()) //false->true
		{
			System.out.println("에러...");
			return;

		}
		double result = ob.calc();
		ob.write(result);

	}

}