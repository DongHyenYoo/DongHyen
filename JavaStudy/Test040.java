//if~ else구문

//사용자로부터 임의의 문자를 하나 입력받아
// 대문자이면 소문자로, 소문자이면 대문자로
// 알파베시 아닌 기타 문자면 입력 오류 처리하는 프로그램구현

//실행 예)
// 한문자 입력 : A
// A -> a

//한문자 입력 : b
//b -> B

//한 문자입력 : 3
//입력 오류

//업로드는 따로따로 각각의 게시물로 업로드

import java.io.IOException;

public class Test040
{
	public static void main(String[] args)throws IOException
		{

		System.out.print("한문자 입력 : ");
		int a = System.in.read();
		int b = a; //이후 처음입력한 값을 알기위해 처음의 a를 b에 대입
		
		if( a >= 65 && a <= 90) //대문자인지 물어보는 부분
			{
			a += 32;// 소문자로변환
			System.out.printf("%c -> %c\n",b,a);
	
			}

		else if(a >= 97 && a <= 122) //소문자인지 물어보는 부분
			{
			a -= 32; //대문자로 변환
			System.out.printf("%c -> %c\n",b,a);
			}

		else //알파벳은 위에서 모두 걸러졌으니 더이상 알파벳이 없다.
			System.out.print("입력 오류\n");

		

		
	}

}

/* 실행 결과
한문자 입력 : A
A -> a
계속하려면 아무 키나 누르십시오 . . .

한문자 입력 : a
a -> A
계속하려면 아무 키나 누르십시오 . . .

한문자 입력 : 2
입력 오류
계속하려면 아무 키나 누르십시오 . . .



*/