/*===================================
�ڹ��� �ֿ� Ŭ����
-�ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
Wrapper Ŭ����
================================*/

public class Test134
{
		public static void print(Number i)//Number n = new Integer(); �� �����ϴ�! Number�� �߻�Ŭ�����ε�
	{
		System.out.println(i);
		if(i instanceof Integer)
		{
			System.out.println(i.intValue());
		}
		else if(i instanceof Double)
		{
			System.out.println(i.doubleValue());
		}

		//java.lang.Number Ŭ����(�߻� Ŭ����)��
		//��� ������ wrapperŬ������ �θ� Ŭ����
		//����Ŭ���� ���� Ŭ���� �̴�.
		//b2 i2 �ڷ����� Number�� �Ѿ���鼭
		//��ĳ������ �Ͼ��.
	}

	

	public static void main(String[] args)
	{
		byte b = 3;
		int i =256;

		Byte b2 = new Byte(b);
		Integer i2 = new Integer(i); 

		System.out.println(b2);
		System.out.println(i2);
		
		print(b2);
		print(i2); //Numer���� i��ü��  Integer���� ��ü�� ��ĳ���õǾ� ����.
		print(3); //3-> ��ü�� ���ϴ� ���� �ڽ�


		

	






	}
}