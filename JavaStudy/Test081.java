/*===================================
배열
-배열의 기본적 활용
-배열의 선언과 초기화
================================*/


//char 자료형의 배열
//그 배여르이 각 방에 알파벳 대문자를 채우고
//채워진 그 배열의 전체요소를 출력하는 프로그램
//단, 채우는 구문과 출력하는 구문은 따로 분리하여 처리할 수 있도록 한다.

//import java.util.Scanner;
//import java.io.*;

public class Test081
{
	public static void main(String[] args)
	{
/*
		char arr[]; //문자배열
		int num = 0; //문자배열수
		arr = new char[num];

		Scanner sc = new Scanner(System.in);

		System.out.print("입력받을 수를 입력하세요");
		num = sc.nextInt();

		for(int i=0;i<num;i++)
		{
			arr[i]= sc.nextChar();

		}

		for(int i=0;i<num;i++)
		System.out.println(arr[i]);


*/

		int arr[];
		arr = new int[26];
		int count =0;
		//arr = new char[count]; 
		//arr = new char[];
		//count가 안에 들어간게 문제였다. 숫자를 입력해야했나? count가 0이어서 그랬던것

		//char[] arr = new char[26];
		
	/*	
		for(int i=65;i<=90;i++){
			arr[count] = (char)i;
			count++;
		}
		*/

		for (int i=0, ch=65;i<arr.length;i++,ch++)
		{
			arr[i]=ch;
		}
		
		for(int i=0;i<arr.length;i++) //for안에 초기변수가 여러개일수 있고, 조건은 여러개일수있으나 논리연산자여야하고 (결과가 true 혹은 false이기에
			System.out.printf("%2c",(char)arr[i]); //왜 되는데?

	}

}