//swtich�� �ǽ�

//����ڷκ��� 1 ���� 3������ ���� �� �ϳ��� �Է¹޾�
//�Է¹��� ������ŭ�� �����ڰ� ��µǴ� ���α׷� �ۼ�
// �� �ΰ��� ������� ����

// 1. switch���� �Ϲ� ���� ����Ͽ� break;

//2. switch���� �⺻���� ����ϵ� break�� �� �ѹ��� ����� �� �ֵ���

//������ ���� �Է� 1 -3 
//7 �̸� �Է� ����

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test042
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("������ ���� �Է� : ");
		int a = Integer.parseInt(br.readLine());

		

/*
		switch(a){
			case 3 : System.out.println("�ڡڡ�"); break;
			case 2 : System.out.println("�ڡ�"); break;
			case 1 : System.out.println("��"); break;
			default : System.out.println("�Է¿���"); break;

		}
*/
		switch(a){
			case 3 : System.out.print("��"); 
			case 2 : System.out.print("��"); 
			case 1 : System.out.print("��\n"); break;
			default : System.out.println("�Է¿���"); 
			 
			 

		}
		

	}


}
