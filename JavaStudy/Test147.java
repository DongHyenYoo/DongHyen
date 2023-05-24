/*===================================
\\\\\\\\\\\예외 처리/////////
================================*/

/*프로그램에서 발생하는 오류는

1.잘못된 문법을 사용하거나 변수등을 정의하지 않은 상태에서
  사용함으로써 컴파일 단계에서 발생하는 문법적인 오류(Error)와

  2.프로그램을 실행하는 과정에서 발생되는 런타임 오류(Error)로
  나눌수 있다.

  -문제 분석을 잘못하거나 실수에 의해
	잘못된 결과를 가져오게 되는 논리적인 오류(Error)와

  -시스템 이상에서 발생되는 시스템 오류(Error),그리고

  -프로그램 실행 중 발생되는 비정상적인 상황을 의미하는
   예외사항(Exception)이 있다.

   예를 들어
   -어떤 수를 0으로 나누거나
   -배열을 제어하는 과정에서 첨자를 벗어나는 상황이 발생하거나
   -존재하지 않는 파일을 오픈하여 읽어들인다거나

   =>개발자가 이런 예외 사항이 발생할 경우를 미리 예측하여
   적절히 대응하기 위한 절차를 구현하도록 문법을 정리해 놓은 것이
   예외처리다

  정리해 놓은 문법! (Exception 클래스)

  -예외는 프로그램 실행 중에 발생할 수 있는
	명령어의 정상적인 흐름을 방해하는 이벤트로
	자바에서 예외는 하나의 오브젝트(Object, 객체)이다.

	-프로그램 실행 중에 메소드 안에서 오류(Error)가 발생할 경우
	메소드는 그 오류에 해당하는 예외 오브젝트를 만들고
	그것을 자바 런타임 시스템(Runtime System)에 전달해 준다.

	-자바에서의 모든 예외 클래스는 Throwable 클래스나
	Throwable 클래스의 하위 클래스를 상속받아 사용한다.

	-Throwable 클래스는 예외를 설명하는 문장이나
	예외가 발생할 때의 프로그램의 상태에 관한 정보를 포함하고 있다.

	-Throwable 클래스에서 파생된 클래스

		Exception 클래스
		Exception 예외 클래스는 일반적으로 프로그래머에 의해
		복원될 수 있는 예외 상황으로
		메소드가 실행 중에 던지는 예외를 가리킨다.

		Error클래스
		심각한 예외의 형태로 개발자가 복원할 수 없는 형태의 예외이다.

-==예외의 종류

-checked exception
	메소드 내에서 예외가 발생한 경우
	메소드를 정의할 때 throws 문에 메소드 내에서 발생할 수 있는
	예외들을 명시해 주거나 또는 그 예외를 try-catch해서
	처리해 주어야만 하는 예외이다.
	컴파일러가 컴파일 하는 과정에서 checked exception이
	throws되는가의 여부 혹은 try-catch되는지의 여부를 판단하여
	프로그램에서 예외를 어떤 방식으로든 처리하지 않으면
	컴파일 자체가 불가능하다.

	-unchecked exception
	사전에 처리하지 않아도 컴파일러가 체크하지 않는
	런타임 시에 발생할 수 있는 예외이다.
	//배열 크기 에러같은 경우 컴파일은 되는데 런타임에러가 났다. 
	//그게 언첵 예외


	모든 Exception은 던질 수 있다.

		*/

	/*
java.lang.Throwable 클래스의 주요 메소드

-String toString()
:Throwable 각각에 대한 설명을 문자열 형태로 반환한다.

-void printStackTrace(PrintStream s)
-void pirntStackTrace(PrintWriter w)
:표준 출력 스트림에 스택 호출 목록을 마지막 메소드부터 출력한다.

주요 런타임 예외 클래스

-ArithmeticException
:수치 계산상의 오류(0으로 나누기 등)

-ArrayStoreException
:배열에 잘못된 데이터 형을 저장하려 했을 경우 발생하는 오류
-IndexOutofBoundsException
 : 배열,문자열,벡터 등에서 인덱스 범위가 벗어난 경우 발생하는 오류
-ClassCastException
:클래스 변환을 잘못한 경우 발생하는 오류
-NullPointerException
:빈 객체를 참조하는 경우(초기화 되지 않은 변수 사용 등)
 발생하는 오류
-SecurityException
 :자바의 내부 보안 사항을 위반하였을경우 발생하는 오류

	 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test147
{                                           //1.무슨에러인지는 모르지만 던지기
	public static void main(String[] args) //throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//주요 변수 선언
		int a,b,c;
	
		/*2 3
		try //문제가 있을만한 코드
		{
			System.out.print("첫 번째 정수 입력 : ");
		a = Integer.parseInt(br.readLine());
		System.out.print("두번째 정수 입력 :");
		b= Integer.parseInt(br.readLine());

		c = a+b;

		System.out.println("결과 : "+c);
			
		}
		catch (IOException e) //IOException을 일으킨 문제가 생긴것을 잡아라
		{
			//발생한 예외를 처리하는 방법을 작성하는 공간
			//발생한 에러 IOException = checked exception
			//메소드를 정의하는 과정에서 throws 한 예외
			// 잡아내거나 던지지 않을경우 컴파일 에러가 발생하는 예외이다.
			System.out.println(e.toString());
			//첫 번째 정수 입력 : asd
			//Exception in thread "main" java.lang.NumberFormatException: For input string: "asd"
			//우리는 넘버포맷을 정의안했는데 걸린걸 보면 넘버포맷은 Unchecked Exception이다.
		}
		catch (NumberFormatException e2)
		{
			//NumberFormatException = unchecked Exception
			//런타임시 발생할 수 있는 예외로
			//반드시 던질필요도, 잡아낼 필요도없는 에러라는것
			System.out.println(e2.toString());
			System.out.println("숫자형태의 데이터입려갛세요");
			//java.lang.NumberFormatException: For input string: "asd"
			//숫자형태의 데이터입력하세요
			//Throwable클래스를 상속받은 것들이므로 Object의 toString을 Throwable에서 오버라이딩함
		}
		*/


/* 4
		try //문제가 있을만한 코드
		{
			System.out.print("첫 번째 정수 입력 : ");
		a = Integer.parseInt(br.readLine());
		System.out.print("두번째 정수 입력 :");
		b= Integer.parseInt(br.readLine());

		c = a+b;

		System.out.println("결과 : "+c);
			
		}
		catch (Exception e) //Exception들의 상위클래스 즉 예외의 업캐스팅이 발생
		{
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			System.out.println("printStackTrace...");
			e.printStackTrace();
			}

	*/

		try //문제가 있을만한 코드
		{
			System.out.print("첫 번째 정수 입력 : ");
		a = Integer.parseInt(br.readLine()); //Integer.parseInt에서 문자열이라 정수로 변환할수 없어 에러가 발생
		System.out.print("두번째 정수 입력 :");//위에서 에러가 발생해서 이 밑으로 실행안됨 
		b= Integer.parseInt(br.readLine());

		c = a+b;

		System.out.println("결과 : "+c);
			
		}
		catch (Exception e) // main 옆에 throws Exception하면 대부분의 에러를 던진다.
					       //우리는 예외처리를 하려는것이 아니라 예외를 잡고 분석하려는것이므로 무지성남발 ㄴ
		{
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			System.out.println("printStackTrace...");
			e.printStackTrace();
		}
		finally //예외가 발생하거나 발생하지 않거나 언제나 실행되는 영역 
		{
			System.out.println("ㅅㄱd");

		}

		//만약 호출되는 메소드에서 throws하지 않고 try catch로 잡아버리면
		//호출한 메소드에서는 예외처리 할 필요 없다.

		//checked Exception = 1,2을 이용 컴파일 에러
		//unchecked Exception = 3,4 5을 이용 런타임 에러

	}
}