/*===================================
�ڹ��� �ֿ� Ŭ����
-�ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
Wrapper Ŭ����
================================*/

import java.math.BigDecimal; //������ ū �Ǽ��� �ٷ�� ���� Ŭ����


public class Test133
{
	public static void main(String[] args)
	{
		BigDecimal a = new BigDecimal("12345678.123456677");

		//movePointLeft() �Ҽ����� �������� �̵�

		BigDecimal b = a.movePointLeft(3);
		System.out.println(b);

		//������ ����(��ü �Ӽ� Ȯ��,)

		BigDecimal c = a.divide(b);
		System.out.println(c);
		//1E+3

		BigDecimal d = a.divide(b, BigDecimal.ROUND_DOWN); //�ݿø��� ���� �ʴ´�. -> ����
		System.out.println(d);
		//
		
		//BigInteger��ü�� ��ȯ
		System.out.println(a.toBigInteger());
		//12345678 
		

	}
}
