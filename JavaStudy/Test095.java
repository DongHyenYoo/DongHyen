/*===================================
배열
-배열과 난수 처리 Random 클래스 활용
================================*/

//사용자로부터 임의의 정수 입력받아
//정수의 개수만큼 난수(1~100)를 발생시켜 배열에 담고
//배열에 담겨있는 데이터들중
//가장 큰 값과 가장 작은값을 선택하여
//결과를 출력하는 프로그램을 구현한다.

//무작위 정수 개수 

//이 무작위로 발생된 정수들을 배열에 담아내기
//그중 가장 큰값 가장 작은값


import java.util.Scanner;
import java.util.Random;
public class Test095
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("발생시킬 난수의 입력 : ");

		int size = sc.nextInt(); //사용자의 입력값을 담아낼 변수 

		//size 변수에 담아낸 수 만큼의 배열방 만들기(배열길이)
		int arr[] = new int[size];

		//난수 발생 전용 객체 Random 필요
		Random rd = new Random();
		//Random 클래스 인스턴스 생성

		//Random 클래스의 nextInt() 메소드 //스캐너의 nextInt와는 다른 메소드이다.
		// 0~ 매개변수로 넘겨받은 정수 n-1까지의 수중 무작위 정수(난수) 1개를 발생시킨다.
		//rd.nextInt(10);

		//테스트
		//System.out.println("발생한 난수 "+rd.nextInt(10));
		//0~9까지의 범위를 의미하는 것이고 이 사이에서 무작위 정수 1개

		//배열구성
		for(int i=0;i<size;i++)
		{
			//rd.nextInt(101); //0~100
			
			//rd.nextInt(100)+1; // 0~99+1이므로 1~100이다

			arr[i] = rd.nextInt(100)+1;
			
			//rd.nextInt(100);  -> 0~99 까지의 무작위 정수 한 개 발생
			//rd.nextInt(100)+1; -> 1~100까지의 무작위 정수 한 개 발생

		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.printf("%4d",arr[i]);
		}
		
		int max, min;
		max = min = arr[0];

		for(int i=1;i<size;i++)
		{
			if(max<arr[i])
				max = arr[i];
		
			if(min>arr[i])
				min = arr[i];
		}

		System.out.printf("\n난수중 가장 큰 수는 %3d 이고 가장 작은 수는 %3d입니다.\n",max,min);



	}

}