/*===================================
�ڹ��� �ֿ� Ŭ����
-�ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
Wrapper Ŭ����
================================*/

import java.math.BigInteger;

public class Test132
{
	public static void main(String[] args)
	{
		//int a1 = 123456789123456789;
		
		//System.out.println(a1);

		//long d1 = 123456789121231233456789L;

		BigInteger a = new BigInteger("12345678912398234"); //ū���� ������� int�� ��������� ���ڿ��� �Ѱܹް� �������.
		BigInteger b = new BigInteger("12345678912398234"); 
		
		//BigInteger c = a+b;
		//System.out.println(c);

		//����
		BigInteger c = a.add(b); //�����
		System.out.println("������� : "+c);

		//����
		BigInteger d = a.subtract(b);
		System.out.println("���� ��� :" + d);
		//���� ��� : 0

		//���ϱ�
		BigInteger e = a.multiply(b);
		System.out.println("���� ��� : "+a);
		//������� : 
		
		//������
		BingInteger f = a.divide(b);
		System.out.println("������ ��� : "+f);

		//������
		BigInteger g = new BigInteger("2");
		System.out.println("2�� 3��"+g.pow(3));


	}
}