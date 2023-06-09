/*===================================
배열
-배열의 선언과 초기화
================================*/

/*
	배열의 개요

	1.배열이란 크기와 자료형이 같은 원소들이 모여
	   공동의 집합 구조를 갖는 자료의 집합체를 의미하느 것으로
	   같은 성격의 자료들 에 대해
	   개별적으로 자료형을 부여하지 않고
	   하나의 이름을 가지고 일괄적으로 처리할 목적으로 사용된다.

	 2. 자바에서의 배열은 다음과 같은 순서에 의해 사용된다.
	   배열 선언 -> 배열에 메모리 할당 -> 배열 요소 접근(배열 요소의 사용)


	형식 및 구조

	자료형[] 변수명 ;
	변수명 = new 자료형[요소크기];
	변수명[인덱스] = 값;
	
	변수들에게 메모리를 서로 떨어진곳에 할당하는게 아닌 
	배열은 한줄로 쭉이어서 메모리를 할당한다.

	또한 변수들이 각각 주소를 가지고있는것에 비해 배열은 제일 첫부분인 0번째의 주소만 기억하고있다.
	int형이면 4바이트씩 넘어가서 자료를 찾고 double 는 8바이트씩 넘어가서 찾는다.
	즉 자료형마다 크기가 달라지므로 같은 자료형이어야 한다.
	자바는 배열에게 메모리를 할당할때 다른 변수가 할당받은 메모리의 영역은 침범하진 않지만
	배열의 크기를 보고 다른변수의 메모리에 할당받은곳에 거의 딱 붙도록 메모리를 할당한다.

	배열의 길이는 변화시킬 수 없다.
	자바의 배열은 많약 다른 변수의 메모리를 침법할거같으면 새로 지정될 여유로운 메모리를 다시 할당받는다.
	즉 주소를 바꿔버린다. 그리고 기존주소에 있던 메모리는 -> 배열의 길이를 변화시킬 수 없기때문에 

	ex) int[] arr;
	  arr = new int[3];
	  arr[0,1,2] = ?;




*/

public class Test079
{

	public static void main(String[] args)
	{

		//배열 선언
		//int[] = arr; //배열의 자료형 = 이름;
		//arr = new int[10]; //이름 = 새로운 자료형 배열 //메모리 할당방법
		//arr[] = ; //이름[위치] = 값; 할당된 메모리에 값을 집어넣기

		int[] arr = new int[10]; //int[] = arr + arr = int[10]; 과 같다.
		int[] arr2 = {1,2,3,4,5,6,7,8,9,0}; //배열 크기를 지정하지 않고 넣음
		int arr2[] = {1,2,3,4,5,6,7,8,9,0};// 위와 같다.

		//배열요소 사용
		
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		//값을 할당하지 않는 나머지 공간은 자동으로 0츠로 초기화된다.

		//System.out.println(arr);
		//이상한 결과
		//배열을출력하기 위해 배열 변수를 일반변수처럼 출력하는 구문으로 작성하면
		//각방의 데이터가 출력되는것이 아니라 이상한 코드가 출력됨
		//자바는 메모리 주소값에 사용자가 접근하는 것을 허용하지 않으므로 자바가 내부적으로 객체를 구별하기 위해 구별한 시리얼넘버가 출력되는것
		
		//System.out.println(arr2[1]);

		for(int i=0;i<10;i++){
		//System.out.println(arr2[i]);
		System.out.printf("%2d",arr[i]);
		 //1 2 3 0 0 0 0 0 0 0계속하려면 아무 키나 누르십시오 . . .
		}


	}

}