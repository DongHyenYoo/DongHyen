//과제

//사용자로부터 임의의 알파벳 한문자를 입력받아
//이를 판별하여 입력받은 알파벳이 모음일 경우
//결과를 출력하는 프로그램을 구현한다.
//단, 대소문자를 모두 적용할  수 있도록 처리한다.
//또한 알파벳 이외의 문자가 입력되었을 경우
//입력 오류에 대한 내용을 사용자에게 안내해 줄 수 있도록 한다.

//실행 예)
//임의의 알파벳 한 문자 입력 :'A' <- 대문자 모음

//임의의 알파벳 한 문자 입력 :'e' <- 소문자 모음
//임의의 알파벳 한 문자 입력 :'B' <- 대문자 자음

// 모음 ok
// 숫자입력시 입력오류

//자음은 A E I O U				a e i o u
 //        65 69 73 79 85         97 101 105 111 117
//모음은 나머지

import java.io.IOException;

public class Test039
{

	public static void main(String[] args)throws IOException
	{
		System.out.print("임의의 알파벳 한 문자 입력 : ");
		
		
		char a = (char)System.in.read();                        //수업이 끝나기전 이제 switch도 char형을 받을수 있다고 했다.

 /*
 		int a = System.in.read();

		if(a == 65 || a == 69 || a == 73 || a == 79 || a == 85)    //하나라도 맞으면 실행되는 대문자 모음
			System.out.printf("%c 는 대문자 모음입니다.\n",a);

		else if(a == 97 || a == 101 || a == 105 || a == 111 || a == 117)    //하나라도 맞으면 실행되는 소문자 모음
			System.out.printf("%c 는 소문자 모음입니다.\n",a);

		else if(a >= 65 && a<= 90)
			System.out.printf("%c 는 대문자 자음입니다.\n",a);     //모음을 제외한 대문자 

		else if(a >= 97 && a<= 122)
			System.out.printf("%c 는 소문자 자음입니다.\n",a);     //모음을 제외한 소문자
		
		else
			System.out.printf("입력 오류입니다.\n");              //알파벳을 모두 걸렀으니 남은건 숫자와 기호들이다. 이들을 모두 입력 오류라고 말해준다.

	*/ 
	  
	  
		boolean strExp =  a >= 65 && a<= 90;       //논리형인 boolean에 a가 대문자일때 true 을 아닐때 false를 담는다.

		int strResult = strExp ? 2 : 0;           //switch에는 boolean형이 안들어가므로 대문자일때 2의 값을 아닐때 0의 값을 strResult에 담아 모음을 구별하고 나서 입력오류와 대/소 자음을 구별할때 쓴다.

		strExp = (a >= 97 && a<= 122);           //boolean에 a 가 소문자일때 true을 아닐때 false를 담는다.

		strResult = strExp ? 1 : strResult;      //소문자일때 1의 값을 아닐때는 58번째 줄에서 넣은 값을 그대로 따라가게 만든다.  1 : 0 으로 넣으니 소문자가 아닌경우 무조건 0이 나왔다.

		switch(a)
		{
		  case 'A' : System.out.printf("%c 는 대문자 모음입니다.\n",a); break;
		  case 'E' : System.out.printf("%c 는 대문자 모음입니다.\n",a); break;
		  case 'I' : System.out.printf("%c 는 대문자 모음입니다.\n",a); break;
		  case 'O' : System.out.printf("%c 는 대문자 모음입니다.\n",a); break;
		  case 'U' : System.out.printf("%c 는 대문자 모음입니다.\n",a); break;
		  default : switch(a){                                                             //첫번째 switch에서는 대문자 모음을 거르고 [ㅁ소문자인 경우 ㅁ대/소 자음 ㅁ입력오류] 3가지를 나타내기 위해 
		  case 'a' : System.out.printf("%c 는 소문자 모음입니다.\n",a); break;             // default의 문장부분에 switch를 새로만들어 소문자 모음을 거른다.
		  case 'e' : System.out.printf("%c 는 소문자 모음입니다.\n",a); break;
		  case 'i' : System.out.printf("%c 는 소문자 모음입니다.\n",a); break;
		  case 'o' : System.out.printf("%c 는 소문자 모음입니다.\n",a); break;
		  case 'u' : System.out.printf("%c 는 소문자 모음입니다.\n",a); break;
		  default : switch(strResult){                                                      //중요한 대/소 모음을 걸렀으니 위 56~62줄에서 선언한 strResult 값을 이용해 대/소 자음과 입력오류를 나타낸다.
			  case 2 : System.out.printf("%c는 대문자 자음입니다\n",a); break;
			  case 1 : System.out.printf("%c는 소문자 자음입니다\n",a); break;
			  case 0 : System.out.print("입력 오류\n"); break;
			  default : return;

		}

	 }
  }

	/* switch(a){
			case 3 : System.out.print("★"); 
			case 2 : System.out.print("★"); 
			case 1 : System.out.print("★\n"); break;
			default : System.out.println("입력오류"); 
			 
			 

		} */ 


/*

		boolean strExp =  a >= 65 && a<= 90;

		int strResult = strExp ? 2 : 0;             //위와 같다.

		strExp = (a >= 97 && a<= 122);

		strResult = strExp ? 1 : strResult;



		switch(a)
		{
		  case 'A' : case 'E' : case 'I' : case 'O' : case 'U' : System.out.printf("%c 는 대문자 모음입니다.\n",a); break;     //Test042를 했을때 case는 break가 없으면 case구문에서 default까지 실행했다.  
																															   //해서 case안에 case를 썻더니 case를 나눠쓴것과 같았다. 이를 이용해 대문자 모음을 거른다.
		  default : switch(a){
		 
		  case 'a' : case 'e' : case 'i' : case 'o' : case 'u' : System.out.printf("%c 는 소문자 모음입니다.\n",a); break;     //위와 같이 소문자 모음을 거른다.
		 
		  default : switch(strResult){
			  case 2 : System.out.printf("%c는 대문자 자음입니다\n",a); break;
			  case 1 : System.out.printf("%c는 소문자 자음입니다\n",a); break;
			  case 0 : System.out.print("입력 오류\n"); break;
			  default : return;

			}


		 }

		}
		
*/		
		
	}

}
/*
실행결과

임의의 알파벳 한 문자 입력 : A
A 는 대문자 모음입니다.
계속하려면 아무 키나 누르십시오 . . .

임의의 알파벳 한 문자 입력 : a
a 는 소문자 모음입니다.
계속하려면 아무 키나 누르십시오 . . .

임의의 알파벳 한 문자 입력 : b
b는 소문자 자음입니다
계속하려면 아무 키나 누르십시오 . . .

임의의 알파벳 한 문자 입력 : 3
입력 오류
계속하려면 아무 키나 누르십시오 . . .


*/

