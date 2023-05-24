//continue 실습


//continue 키워드가 지니는 의미

//(뒷부분 무시하고) + 계속해라

//continue 를 활용하여
//다음과 같이 출력될 수 있도록 프로그램

//반복문을 쓰는것으로 조건문 쓰지마라
//홀수만 연산에 되도록 continue써라

public class Test066
{
	public static void main(String[] args)
	{
		int sum = 0;

		

		for(int i =1;i<=100;i++){

			if(i%2 ==0)
				continue; //반복문 내부의 뒤쪽을 모두 무시하고 반복문의 증감연산자로 돌아가는것

			sum+=i;
			//System.out.println(i); 중간 확인용
				}
				
		System.out.println(sum); //Tab+shift 하면 앞쪽으로 땡겨진다.





	}


}