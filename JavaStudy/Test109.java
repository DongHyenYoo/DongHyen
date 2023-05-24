/*===================================
정렬 알고리즘


-향상된 버블 정렬
================================*/
//버블과 선택정렬 둘다 성능차이는 없다.
//반복횟수가 같기때문에

//하지만 향상된 버블정렬은 대상 데이터의 구조에 따라서
//일반적인 버블정렬이나 선택정렬에 비해 성능이 좋을 수 있다.

//원본데이터 : 61 15 20 22 30

//향상된 버블정렬은 한 회전에서 스왑이 발생하지 않으면(정렬이 끝났다면) 그대로 프로그램을 종료한다.
//즉 불필요한 추가 연산은 무의미한 것으로 판단하여 수행 x

public class Test109
{
	public static void main(String[] args)
	{

		int[] a = {10,50,20,30,40};

		for(int n : a)
			System.out.print(n+" ");

		System.out.println();

		boolean flag;
		int pass=0;

		do //이상황 아무리못해도 한번은 돌아야되는 상황
		{
			flag = false; //기본적으로 자리바꿈이 없을거라는 것으로 정함
			pass++;

			for(int i=0;i<a.length-pass;i++) //작고 빠르게도는것
			{
				if(a[i]>a[i+1])
				{
					a[i] = a[i] ^ a[i+1];
					a[i+1] = a[i+1] ^ a[i];
					a[i] = a[i] ^ a[i+1];

					flag = true;
					//단 한번이라도 스왑되면 true가 되게
				}

			}

		}
		while (flag); //크게도는것

		//flag 변수가 false라는 것은 회전이 발생하는 동안 스왑이 일어나지 않은 경우로
		//반복문 수행이 더이상 무의미하는것으로 볼수있다.

		for(int n : a)
			System.out.print(n+" ");
/*
		for(int i=1,count;i<a.length;i++)
		{
		count=0;

			for(int j=0;j<a.length-i;j++)
		{
				if(a[j]>a[j+1])
			{
					a[j] = a[j] ^ a[j+1];
					a[j+1] = a[j+1] ^ a[j];
					a[j] = a[j] ^ a[j+1];
					count++;
			}
			
		}
		System.out.println(count);
		if(count==0)
			break;

	}*/
	
	
	
	}

}