/*===================================
�����ڹ��� �⺻ �����(I/O)���� 

-Reader �ǽ�
================================*/

import java.io.Reader;
import java.io.InputStreamReader; //����Ʈ ��Ʈ���� ���ڿ� ��Ʈ������ �ص�
import java.io.IOException;

public class Test174
{
	public static void main(String[] args)throws IOException
	{
		int data;
		char ch;

		Reader rd = new InputStreamReader(System.in);

		System.out.println("���ڿ� �Է�(���� : Ctrl+z)");
		
		while((data = rd.read())!=-1)
		{
			ch = (char)data;
			System.out.print(ch);
			//������ ���� ���ڿ�������� �Է¹ް� ���ڿ��� ����ϹǷ� �ȱ���

			System.out.write(ch); //write �� ����Ʈ ����� ��� //Test174�� ��
			//�� ������
		}

	}
}