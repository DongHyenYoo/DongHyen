//��� �ǽ�
// if��
//if - else �� �ǽ�

//���α׷��� �ۼ��� �� �־��� ���ǿ� ����
//	�б� ������ ���ϱ� ���� ����ϴ� �������
//  if�� if ~ else ��. ���� ������ , ���� if �� )if �� ��ø
//  switch�����ִ�.

//2.if���� if ������ ������ ���� ���
//	Ư�� ������ �����ϰ��� �� �� ���Ǵ� �����̴�.

//����ڷκ��� ������ ������ �Է¹޾�
//Ȧ�� / ¦���� �Ǻ��ϴ� ���α׷��� �����Ѵ�.
//�� ���� if ������ Ȱ���Ͽ� ó���� �� �ֵ����Ѵ�.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test033{

	
	public static void main(String[] args)throws IOException
	{
       
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("������ ���� �Է� :");

		
		int a = Integer.parseInt(br.readLine());
		String stResult;


		if (a % 2 == 0 && a != 0)
		{
			stResult = "¦���Դϴ�.";
		}
		 if (a % 2 != 0)
		{
			stResult = "Ȧ���Դϴ�.";

		}
		else{
		    
			stResult = "0�Դϴ�.";
		}

/*		
		if (a % 2 != 0)
		{
			stResult = "¦���Դϴ�.";
		}
		 else if (a == 0)
		{
			stResult = "Ȧ���Դϴ�.";

		}
		else if (a%2 == 0)
		
		{
		    
			stResult = "0�Դϴ�.";
		} //stResult �� �ʱ�ȭ �����ʾƼ� else �� ������ ����� �Ƚ����ش�.
		//���� if�ȿ� System.out.print�� ����� �ع����� else�� ��� ����� �����ش�.
		//�Ҿ����� ������ ���⿡


*/
		System.out.printf("%d �� %s%n",a,stResult);

	}


}