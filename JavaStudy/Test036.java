//��� �ǽ�
// if��
//if - else �� �ǽ�

//���α׷��� �ۼ��� �� �־��� ���ǿ� ����
//	�б� ������ ���ϱ� ���� ����ϴ� �������
//  if�� if ~ else ��. ���� ������ , ���� if �� )if �� ��ø
//  switch�����ִ�.

//2.if���� if ������ ������ ���� ���
//	Ư�� ������ �����ϰ��� �� �� ���Ǵ� �����̴�.

//����ڷκ��� ������ ������ ������ �Է�
// �ش� �������� ���� ó�� ����� ����ϴ� ���α׷��� ����
//�� if���ǹ��� Ȱ���Ͽ� ó���� �� �ֵ��� �ϸ�,
//���� ����� ���ǻ� ���� ������� ó���� �� �ֵ����Ѵ�.

import java.util.Scanner;
import java.io.IOException;

public class Test036
{

	public static void main(String[] args)throws IOException
	{

	//	Scanner sc = new Scanner(System.in);

		//int strNum1 , strNum2, strSign �̷��� �����ڵ� ���������� �ްڴ�.

/*
			System.out.print("ù��° ���� �Է� : ");
			int strNum1 =  sc.nextInt();

			System.out.print("ù��° ���� �Է� : ");
			int strNum2 =  sc.nextInt();

			System.out.print("������ �Է�[+-/*] : ");
			char strSign = (char)System.in.read();
			//int strSign = System.in.read();

			if(strSign == '*') // strSign == 42(������������ �ƽ�Ű�ڵ�)
		{
				System.out.printf("%d %c %d = %d",strNum1,strSign,strNum2,(strNum1*strNum2));

		}
		else if(strSign == '/') //strSign == 47(������������ �ƽ�Ű�ڵ�)
		{
			System.out.printf("%d %c %d = %d",strNum1,strSign,strNum2,(strNum1/strNum2));
		}
		else if (strSign == '+') //strSign == 43(������������ �ƽ�Ű�ڵ�)
		{
			System.out.printf("%d %c %d = %d",strNum1,strSign,strNum2,(strNum1+strNum2));
		}
		else if (strSign == '-') //strSign == 46(������������ �ƽ�Ű�ڵ�)
		{
			System.out.printf("%d %c %d = %d",strNum1,strSign,strNum2,(strNum1-strNum2));

		}
		
*/
		//System.in.read() : �ϳ��� ���Ϲ��ڰ� ������ �ִ� �ƽ�Ű�ڵ带 ��ȯ�ϴ°�
		//parInt : �������¸� �������ִ� ���ڿ��� ���������� �ٲ��ִ°�

		Scanner sc = new Scanner(System.in);

		int a, b, result;
		char op;
		result=0;

		System.out.print("ù��° ���� �Է� : ");
		a = sc.nextInt();
		System.out.print("�ι�° ���� �Է� : ");
		b = sc.nextInt();
		System.out.print("������ �Է� : ");
		op = (char)System.in.read();
		

		if (op == '+') //if�� elseif �ȿ� ������ �ϳ��ϰ�� {} ��ȣ�� �����ص��ȴ�.
		
			result = a+b;
		else if(op == '-')
			
			result = a-b;
		else if(op == '*')
			
			result = a*b;
		else if(op == '/')
			
			result = a/b;


	System.out.printf("%d %c %d = %d",a,op,b,result);




				
		





	}





}