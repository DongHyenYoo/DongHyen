//��� �ǽ�
// if��
//if - else �� �ǽ�

//���α׷��� �ۼ��� �� �־��� ���ǿ� ����
//	�б� ������ ���ϱ� ���� ����ϴ� �������
//  if�� if ~ else ��. ���� ������ , ���� if �� )if �� ��ø
//  switch�����ִ�.

//2.if���� if ������ ������ ���� ���
//	Ư�� ������ �����ϰ��� �� �� ���Ǵ� �����̴�.

//2�� ���/ 3�� ��� /2�� 3�� ���/ 2�� 3�� ����� �ƴϴ� ��� ����ϴ°�

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Test034{

	public static void main(String[] args)throws IOException
		{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("���� �Է� :  ");

		int a = Integer.parseInt(br.readLine());
	
		
		if(a == 0 ){
			System.out.print("0�̳׿�\n");
		}		
		else if( a%2 == 0 && a%3 ==0)
			{
			System.out.print("2�� 3�� ����Դϴ�");
			}

			else if(a%2 != 0 || a%3 != 0) // &&�� �ƴ�����? 
			{
				System.out.print("2�� 3�� ����� �ƴմϴ�");
			}
			else if( a%2 ==0 )
			{
				System.out.print("2�� ����Դϴ�.");
			}
			else if(a%3 ==0)
			{
				System.out.print("3�� ����Դϴ�.");
			}

			
			
			/*
				if( a%2 == 0 && a%3 ==0 )
				{
					System.out.print("2�� 3�� ���");
					if(a%2 != 0 && a%3 != 0)
					{
						System.out.print("2�� 3�� ����� �ƴϿ���");
						if(a%2 == 0)
							{
							System.out.print("2�� �������");
						if(a%3 == 0)
							{
							System.out.print("3�� �������");
							}
							}
					}
				}
			


		*/



	}

}

