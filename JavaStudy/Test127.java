/*===================================
�ڹ��� �ֿ� Ŭ����
-�ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
================================*/

//126�� ��

//import java.lang.*;
//import java.lang.Object �� ���Ե�������

public class Test127 //extends Object
{

	@Override
		public String toString()
	{
		return "�������� toString()";

	}
	public static void main(String[] args)
	{
		Test127 ob = new Test127();

		System.out.println(ob.toString());
		//�������� toString() //127�� ���� ������Ʈ�� tostring�� ������ �ߴ�.

		System.out.println(ob);
		//�������� toString() // 127�� �������� ������Ʈ��� Ŭ������ ��ü�� �Է�������� toString�� ���� ����ǵ��� �������.

	}
}