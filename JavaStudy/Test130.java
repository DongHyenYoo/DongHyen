/*===================================
�ڹ��� �ֿ� Ŭ����
-�ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
Wrapper Ŭ����
================================*/
/*
Wrapper Ŭ����

1.�ڹٿ����� ��� ���ؿ��� �����ϴ� �⺻�� �����͸� ������
   �������� Ŭ������ �����Ͽ� ��ü ������ ó���Ѵ�.
   ���� �ڹٿ����� �̷��� �⺻�� �����͸�
   ��ü ������ ó�� �� �� �ֵ��� Ŭ������ ������ �� �ۿ� ���µ�
   �̷��� Ŭ�������� ������ Wrapper Ŭ������ �Ѵ�.

 2. �⺻ �ڷ�����
   byte, short, int, long, float, double, char , boolean���� �����ϴ� 
   Byte, Short, Integer, Long, Float , Double, Character, Boolean�� //���̴빮�ڴϱ� Ŭ������

   Wrapper Ŭ���� �� ū ���ڵ��� �ٷ�� ����
   java.math.BigInteger�� java.math.BigDecimal Ŭ������ �����Ѵ�.

   Wrapper Ŭ������ java.lang ��Ű���� ���ԵǾ� �����Ƿ�
   ������ import ���� ���� �ٷ� ����ϴ� ���� �����ϸ�
   �⺻���� ���������� Wrapper Ŭ������ ���� �޼ҵ带 ����
   �� ��ȯ�� �����ϰ�, ���� �񱳿� ���� ���굵 �����ϴ�.

   ex) java.lang.Integer Ŭ����
   int �⺻ �ڷ����� Wrapper Ŭ������
   ������ �ٷ�µ� �ʿ��� ����� �޼ҵ�, ���� ��ȯ � �ʿ���
   �޼ҵ� ���� �����ϰ��ֵ�.

   static int parseInt(String s)
   ���ڿ� �������� ����� ���ڸ� ���� ���·� ��ȯ�Ͽ� ��ȯ�Ѵ�.

   static Integer valueOf(int i)
   int���� Integer������ ��ȯ�Ѵ�.

   byte byteValue(), int intValue(), //�ش� �ڷ������� ��ȯ�ϴ� �޼ҵ��
   short shortValue(), long longValue(),
   float floatValue(), double doubleValue()
   �ش� �⺻ �ڷ������� �� ��ȯ�� ���� ��ȯ�Ѵ�.




	���� �ڽ�(auto-boxing) ���� ��ڽ�(auto -unboxing)

	�Ϲ������� ���۷��� ���� �⺻ �ڷ����� ȣȯ���� ������
	�� ��� �߻��ϴ� ���� �ذ��� ���� �ڹٿ����� Wrapper Ŭ������ �����ϰ� �Ǿ���.
	������, JDK 1.5 ���� ���۷��� ���� �⺻ �ڷ����� ������ ���� �� ��ȯ�� �����ϰԵǾ���.

	int a=10, b;
	Integer ob; ob= ���������ν� ���������� ���� �׷��� ���� ���� ������ ������ ����
	ob = a;(����ڽ�)
	//Integer ob = new Integer(20); �̷��� �ؾ� ob�� 20�� ������. ���� �̰��� �ڵ�!	//20�̶�� �����Ͱ� ����ִ� Integer����� ��ü ����


	b = ob;(�����ڽ�) ��ü ->primitive
	Integer��ü�� �⺻ �ڷ��� int������ �ڵ���ȯ
	������ : b = ob.intValue();



	��ڽ� = ��üŸ�� -> primitive
	�ڽ� = ���� �ݴ�


	�̴� JDK 1.5 ���� �߰��� ���� �ڽ� ���� ��ڽ��̶�� ������� ���� �������� ���̴�.




*/

public class Test130
{
	public static void main(String[] args)
	{

		int a=10, b;
		Integer c;
		Object d;

		b = a;
		//c = new Integer(0); //��ü ����
		c =0;
		b=c;                  //Integer�� ������(��ü) -> int �� ����(���� ��ڽ�)
		b = c.intValue();         //��ü�� �޼ҵ� ȣ���� ���� ����� ��ȯ(��ڽ�)

		d = new Object();     //��ü ����

		System.out.println(d.toString());
		
		d = new Integer(10);   //��ĳ����     
		System.out.println("d.toStirng() :" + d.toString());
		//10
		//Integer���� �θ�Ŭ���� Object�� toString�޼ҵ带 �������̵��Ѱ�

		d = new Double(12.345); // ��ĳ����
		System.out.println("d.toString() :" + d.toString());
		
		d = 10;    //���� �ڽ�
		System.out.println("d.toString() :"+d.toString());

		//c = a+1;
		//d=a;
		//d=c;

	}

}