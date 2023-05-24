//두정수 입력받고 그중
// 작은수부터 큰수까지의 합을 구하여 결과를 출력해라

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Test052
{
	public static void main(String[] args)throws IOException
		{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a,b,min,max,tot;
		tot = 0;
		
		System.out.print("첫 번째 정수 입력 : ");
		a = Integer.parseInt(br.readLine());
		System.out.print("\n두 번째 정수 입력 : ");
		b = Integer.parseInt(br.readLine());

		if(a>b){
			max = a; 
			min = b; //if안에 while을 넣어서 즉시처리도 가능
		}
		else{   // else if 안에도 넣어서 즉시처리가능  //기억하기 : if else 는 변수초기화가 상관없을수 있으나
			max = b;                                    //if-else if를 쓴순간 변수를 건드리는 문장이있다면 무조건 변수초기화
			min = a;
		}
		
		int i = min; //입력받은 값중 작은값을 받는 i


		while(i<=max){ //min 대신 i가 max가 될때까지 더하는데 이러면 max와 같아졌을때 그냥 나와버림
			tot += i;
			i++;

		}

		System.out.printf("\n%d ~ %d 까지의 합 : %d\n",min,max,tot);





	}

}