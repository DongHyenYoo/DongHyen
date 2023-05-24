/*===================================
클래스와 인스턴스
메소드 오버로딩(중복 정의)
================================*/

/*
메소드 오버로딩의 개요

	메소드 오버로딩이란 메소드가 처리하는 기능은 같고,
	메소드 괄호속의 인자,매개변수,파라미터의 개수가 다르거나
	자료형이 다른경우
	메소드의 이름을 동일한 이름으로 부여하여 메소드를 정의할 수 있도록
	문법적으로 허용한것


*/
public class Test103
{
	public static void main(String[] args)
	{

	//static 으로 drawLine을 선언했기에
	//main의 탄생과 함께 탄생하므로
	//Test103.drawLine();로 불러서 가능하고
	//같은 class안에 있으므로 drawLine();로도 가능하다.
	drawLine();

	drawLine('a'); //둘이 같이 위치해도 메소드 오버로딩 덕분에 구분이 된다.

	drawLine('a',4);
	}

	public static void drawLine()
	{
		System.out.println("============");
	}

	public static void drawLine(char c)
	{
		for(int i=0;i<20;i++)
		{
			System.out.println("///////////////");
		}

		
	}

	public static void drawLine(char c,int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.print(c);
		}
		System.out.println();
	}
}