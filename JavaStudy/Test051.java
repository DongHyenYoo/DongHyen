//���� �Է¹޾�
//�Է¹��� ������ �Ҽ����� �ƴ��� �Ǻ��Ͽ�
//����� ����ϴ� ���α׷� ����

//�Ҽ��� 1�Ǵ� �ڱ� �ڽ��� �� �̿ܿ� � ���ε� ������ ���������ʴ¼� �� 1�� �Ҽ��� �ƴ�

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test051
{

	public static void main(String[] args)throws IOException
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
		int i=2;

		System.out.print("���� �Է� : ");

		int num = Integer.parseInt(br.readLine());

		if(num == 1){
			System.out.printf("%d : �Ҽ��ƴ�\n",num);
			return;}

		while(!(num%i ==0))
		{

		//	if(num%i != 0)
		//		System.out.printf("%d -> �Ҽ�\n",num);
		//	return;

		//	else if(num%i == 0)
		//	System.out.printf("%d -> �Ҽ��� �ƴ�\n",num);
		//  return;

			i++;

			}

			if(num == i)
			System.out.printf("%d : �Ҽ���\n",num);

			else
				System.out.printf("%d : �Ҽ��� �ƴϴ�\n",num);
*/
				
/*

				int i = 1;
				int num = Integer.parseInt(br.readLine());


				if(num %2 == 0) //¦���� �Ҽ��� �ɼ������Ƿ� �Ÿ��� 1�� 2�γ����� ���� 0.5�� �������� �����Ƿ� ���⼭ �ɸ�
					return;

					while(i<num)
					{
						i += 2; //¦���� �ɷ����Ƿ� Ȧ���θ�
						
						if(num%i ==0 && num != i){
							System.out.printf("%d : �Ҽ���\n",num);
							return;}

							if(num%i ==0 && num == i){
								System.out.printf("%d : �Ҽ���\n",num);
								return;}

					}
*/

			int i = 1;
				int num = Integer.parseInt(br.readLine());   //�ݺ����� �����°� �ý��ۿ� ����.

				boolean flag = true; //���־��� ����� �ϳ���...

				while(i<num){   // 1<1 �� false�̹Ƿ� while��ü�� �����Ҽ� ����. //�ȿ� �����ϰ�� {} ��������
					//System.out.print("�ݺ���");
					if(num%i == 0){
						flag = false; //�̷��� 100�� �Է��ϸ� 99���� ������ �����ϰԵȴ�.
						break;// break�� ���尡��� �ݺ����� ����������. �� whilt���� ��������
							  //break�� �����Ƿ� �Է¹��� ���� �������� ���� ���̻� ������ ���ʿ䰡�������Ƿ� ��ǻ�� ���ҽ����� ���� 
							  //120�Է½� while -> if -> break�� �ٷ� ���������Ƿ� ���� �ݺ����� �ѹ��ۿ� ������ �ʴ´�.

					}

					i++;

				}

				if( flag && num != 1) //flag �� �⺻���� true�� ��� boolean�� �������ڷν� flag == true�� �� ���������� �׳� flag�� ��־�ȴ�.
					System.out.printf("%d : �Ҽ���\n",num);
				else
					System.out.printf("%d : �Ҽ��� �ƴ�\n",num);



				

					
					

		
		


   }

}