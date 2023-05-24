//반복문을 활용하여 누적곱 연산 수행
//                    누적합
import java.io.*;


public class Test050
{
	public static void main(String[] args)throws IOException
		{
/*
		int n, tot, sum;
		n = sum = 0;
		tot = 1;//초기화로 0 을 넣으면 곱연산이 안되므로 무조건 1로 초기화할것

		while(++n<=10){
			
			sum += n;
			tot *= n;





		}

		System.out.printf("누적 합 : %d\n누적 곱 : %d\n",sum,tot);

*/

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a,b,c,max,min;

		a= Integer.parseInt(br.readLine());
		b= Integer.parseInt(br.readLine());
		  if(a>=b){
			  max = a;
			  min = b;
		  }else{
				  max = b;
			  	  min = a;
		  }
		c= Integer.parseInt(br.readLine());

			if(c>=max){
				max = c;
			}
			  if(min =< c){
				  min = min ^ c;
				  c = c ^ min;
				  min = min ^ c;
			  }
				  

			  System.out.printf("%d %d %d",min,c,max);
			   

				

				
		






	}



}