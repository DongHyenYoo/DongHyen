//자바의 기본 입출력 : System.in.read()
//System.in.read() 메소드는 (입력 대기열로부터) 한문자만 가져온다.
//단 입력받은 하나의 문자를 그대로 가져오는것이 아니라
//아스키코드 값으로 반환한다.

import java.io.IOException;


public class Test015{

	public static void main(String[] args)throws IOException
		{
/*
		char ch; //문자

		//연산 및 처리

		System.out.println("문자입력:"); //A
		ch = (char)System.in.read(); //65이어서 char로 변환
		
		System.out.println(ch);
*/
		char ch1;
		int strNum;

		//char temp; // 임시로 추가 선언한 변수


		

		System.out.print("한문자 입력 :");

		ch1 = (char)System.in.read();

		
		System.out.print("입력할 정수 :");  // 두줄 이상 입력이 안되서 하나만 입력해도 바로 결과가 나와버림
/*
		System.in.read(); //Enter는 단순한 엔터가 아니라 \r, \n이 합쳐진것
		System.in.read(); // -----------------------------------------
		                  //   A + 엔터(\r+\n) 이 됬으므로
						  //----------------------------------------
						  //  1    2   3
						  // -----------------------------------------
		                  //   A + \r+\n
						  //-----------------------------------------
						  //이렇게되서 1번을 입력받아들이고 strNum값을 받는것대신 \r을 바로 받아들여버린것
*/
        System.in.skip(2); // 앞으로 나올 \r + \n두글자를 읽어내지 않고 건너뛴다.
		//strNum = System.in.read();
		//temp = (char)System.in.read();

		strNum = System.in.read();

		//read는 문자로써 가져오므로
		//숫자에 + 48을 하여 아스키코드값으로 가져옴
		//그러니 '0'이 48이므로  -48을 해줘야한다.

		//strNum -= 48;

		

		System.out.printf("\n입력한 문자 %c\n",ch1);
		//System.out.printf("\n입력한 정수 %d\n",strNum);
		// System.out.println("\n입력한 정수 "+temp);
		System.out.println("\n 입력한 정수" + strNum);








	}




}
