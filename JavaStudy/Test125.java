/*===================================
Ŭ���� ���
��ø Ŭ����
================================*/

/*
Annonymous Ŭ����(�͸��� Ŭ���� : ���� Ŭ����)

  -AMT �� �ȵ���̵� �̺�Ʈ ó������ �Ϲ������� ���
  -���� Ŭ���� �޼ҵ带 �ϳ� ���� �������� �ʿ伺�� ������ ���
  -Ŭ������ ��ü�� �ʿ��ϸ� �� �ٽ� Ŭ������ �����ؾ� �ϴ�
  ���ŷο����� ���� ����ϰ� ��ü ������ �ʿ��� ���
  �͸��� Ŭ������ �����Ͽ� ó���� �� �ִ�.

  ���� �� ����

  new ����Ŭ������ ������()
  {
	  �������������� �ڷ��� �޼ҵ�()
	  {

	  }
	  }; 
*/
class Test3
{
	public Object getString()
	{

		return new Object()
		{
			@Override
				public String toString()
			{
				return "�͸��� Ŭ����";
			}
	};
}

}

public class Test125 //extends object �� �ٰ� �پ��־���.������Ʈ Ŭ������ ��� ��ü�� ����Ŭ����
{
	public static void main(String[] args)
	{
		Test3 ob1 = new Test3();

		System.out.println(ob1.toString());

		System.out.println(ob1.getString());

	}
}