//�ݺ����� Ȱ���Ͽ� ������ ���� ����
//                    ������
import java.io.*;


public class Test050
{
	public static void main(String[] args)throws IOException
		{
/*
		int n, tot, sum;
		n = sum = 0;
		tot = 1;//�ʱ�ȭ�� 0 �� ������ �������� �ȵǹǷ� ������ 1�� �ʱ�ȭ�Ұ�

		while(++n<=10){
			
			sum += n;
			tot *= n;





		}

		System.out.printf("���� �� : %d\n���� �� : %d\n",sum,tot);

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