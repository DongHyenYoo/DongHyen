//��� �ǽ�
// if��
//if - else �� �ǽ�

//���α׷��� �ۼ��� �� �־��� ���ǿ� ����
//	�б� ������ ���ϱ� ���� ����ϴ� �������
//  if�� if ~ else ��. ���� ������ , ���� if �� )if �� ��ø
//  switch�����ִ�.

//2.if���� if ������ ������ ���� ���
//	Ư�� ������ �����ϰ��� �� �� ���Ǵ� �����̴�.

//����
//����ڷκ��� ������ ������ �Է¹޾�
// �Է¹��� ������... ��������, ������� �Ǻ��Ͽ�
//�� ����� ����ϴ� ���α׷��� �ۼ�

//��, �Է��� BufferedReader
// if ���ǹ��� Ȱ���Ͽ� ������ ������ �� �ֵ��� �Ѵ�.

//400�� ����̰ų� 4�� ����̸鼭 100�� ����� �ƴϰų� �� �����̴�.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test035
	{

		public static void main(String[] args)throws IOException
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("�����Է� : ");
			int year = Integer.parseInt(br.readLine());

			if(year % 400 == 0){
				
				System.out.print("\n�����Դϴ�");


			}

			else if (year % 4 ==0 && year % 100 != 0)
			{
				System.out.print("\n�����Դϴ�");

			}
			else if (year % 400 != 0)
			{
				System.out.print("\n����Դϴ�.");
			}
			else if( year % 4 !=0 || year % 100 ==0)
			{
				System.out.print("\n����Դϴ�.");

			}





		}



	}
