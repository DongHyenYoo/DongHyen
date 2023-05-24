/*===================================
배열
-배열의 기본적 활용
-배열의 선언과 초기화
================================*/


//과제
// 사용자로부터 임의의 정수를 이므이의 갯수만큼 입력받아
// 입력받은 수 중에서 가장 큰 수를 출력하는 프로그램을 구현한다.
// 단 배열을 활용하여 구현할 수 있도록 한다.

//입력할 데이터의 갯수 : 12
//데이터 입력(공백 구분) : 1 2 3 4 5 6 7 8 9 10 11 12
//가장 큰 수 -> 099

//가장 큰수를 어디 저장하고 
//따로 큰수를 담았다가 출력
import java.util.Scanner;


class Numarr
{
	
	int num;											//입력받을 수의 갯수 num 선언
	

	Numarr()											//생성자
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 데이터의 갯수 : ");
		num = sc.nextInt();								//객체 생성과 동시에 입력할 데이터 갯수받기
	}

	int[] input(){										//num 값에 해당하는 수 받는 메소드 리턴 자료형은 int형 배열

		//System.out.println(num); 값은 잘 전달이 됬는데...
		//System.out.println(arr[0]); 배열은 초기화가 안되나?;; 여기서 에러가 난다.
		
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[this.num];						//num값에 해당하는 배열 생성
		System.out.print("데이터 입력(공백 구분) : ");
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = sc.nextInt();						

		}
		return arr;										//배열 리턴
		
	
	}

	int cal(int[] arr){									//제일 큰값을 리턴하는 메소드

		int max = arr[0];								//배열의 0번째 값을 임의로 제일큰 수로 둔다.
		for(int i=1;i<arr.length;i++)
		{
			if(max<=arr[i])								//반복문을 통해 배열을 돌리면서 max값보다 큰값들을 계속 max에 넣는다.
			{
				max = arr[i];
			}
		}

		return max;										//제일큰수 리턴
	}

	

}



public class Test083
{

	public static void main(String[] args)
	{		
		
		
		Numarr ob = new Numarr();

		int arr[] = new int[ob.num];					//객체.변수이름 으로 Numarr에 있는 num값을 가져와 배열생성
		arr = ob.input();			//arr[ob.num] 하면
									//Test083.java:72: error: incompatible types: int[] cannot be converted to int
									//arr[ob.num] = ob.input(); 와 같은 에러

		int max = ob.cal(arr);							//받아온 제일큰 값을 max에 저장
		System.out.println("가장 큰 수: "+max);

		
		/*
		입력할 데이터의 갯수 : 12
		데이터 입력(공백 구분) : 97 98 97 99 34 25 54 37 93 72 62 63
		가장 큰 수: 99
		계속하려면 아무 키나 누르십시오 . . .
		*/

		
		
		


	/*
		Scanner sc = new Scanner(System.in);

		int num;
		
		System.out.print("입력할 데이터의 갯수 : ");
		num = sc.nextInt();
		
		int arr[] = new int[num];

		System.out.print("데이터 입력(공백 구분) : ");
		for(int i=0;i<arr.length;i++)
			{
			arr[i] = sc.nextInt();
			}

		
		int max = arr[0];

		for(int i=1;i<arr.length;i++)
			{
			if(max<=arr[i])
				max=arr[i];

			}
		
		System.out.println("입력받은 수 중에 가장 큰 값은  : "+max);
	*/
	}

	/*
		입력할 데이터의 갯수 : 12
		데이터 입력(공백 구분) : 97 98 97 99 34 25 54 37 93 72 62 63
		가장 큰 수: 99
		계속하려면 아무 키나 누르십시오 . . .
		*/

}