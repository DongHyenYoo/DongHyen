//����ڷκ��� ������ ���� ������ �Է¹޾�
//���� ������ ū�� ������ ����ϴ� ���α׷�


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test037
{
	public static void main(String[] args)throws IOException
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("ù��° ���� �Է�");
		int a = Integer.parseInt(br.readLine());
		System.out.print("�ι�° ���� �Է�");
		int b = Integer.parseInt(br.readLine());
		System.out.print("����° ���� �Է�");
		int c = Integer.parseInt(br.readLine());

		if( a > b)
		{
			a = a ^ b;     
			b = b ^ a;    
			a = a ^ b;  
			}

		if( b > c)
		{
			b = b ^ c;
			c = c ^ b;
			b = b ^ c;
		}
		if(a > b)
		{
			a = a ^ b;
			b = b ^ a;
			a = a ^ b;
		}


/*
		if( a > b)
		{
			a = a ^ b;     
			b = b ^ a;    
			a = a ^ b;  
			}

		if( a > c)
		{
			a = a ^ c;
			c = c ^ a;
			a = a ^ c;
		}
		if(b > c)
		{
			b = b ^ c;
			c = c ^ b;
			b = b ^ c;
		}
		*/
		System.out.printf("���� ��� : %d  %d  %d",a,b,c);


}
}

			
