/*===================================
배열
-배열의 기본적 활용
================================*/

//임의의 정수들이 들어있는 배열의 숫자 데이터들 중
// 짝수인 요소만 골라서 출력하고 3의 배수인 요소만 골라서 출력하는
//프로그램을 구현한다.


import java.io.*;
import java.util.*;

public class Test080
{

	public static void main(String[] args)throws IOException
	{


		Scanner sc = new Scanner(System.in);

		char arr1[];
		int num=0;
		


		System.out.print("배열 받을 숫자 입력 : ");
		num = sc.nextInt();


		arr1 = new char[num]; //여기서 이걸 안해주면 배열크기가 없다고문제



		System.out.print("\n배열을 입력하세요");

		for(int i=0;i<num;i++){

			arr1[i] = sc.next(); 
			
		}

		//배열 숫자 입력받고 넣는순서
		//배열선언[] -> []안에들어갈 숫자선언 및 초기화 -> 배열수 입력받기 -> for문에서 배열수반큼
		//배열이름[i] nextInt로 받아내기

		

		
		
		//int arr[] = sc.nextInt(); int가 int가 안되는듯?
		//배열전체는 String형이라 안되는듯 
		//하고 싶으면 위에서 전부 선언하고 해야댐


/*
		int[] arr1 ={4,7,9,1,3,2,5,6,8};


		System.out.println(arr1.length); //배열의 길이는?
		
		System.out.println("배열의 요소 전체 출력"); 

		for(int i=0;i<arr1.length;i++) //와 같이 배열의 길이만큼 세서 넣어준다.
		System.out.printf("%2d",arr1[i]);
		
		System.out.println();

			System.out.println("짝수 선택적 출력");
			for(int j=0;j<9;j++){

				if(arr1[j]%2==0)
					System.out.printf("%2d",arr1[j]);

			}

			System.out.println("\n홀수 선택적 출력");			
			for(int j=0;j<9;j++){

				if(arr1[j]%3==0)
					System.out.printf("%2d",arr1[j]);
			}

			System.out.println();


					*/



	
	}

}