/*===================================
\\\\\\\\\\\���� ó��/////////
================================*/


public class Test152
{
	public static void main(String[] args)
	{
		Test152 ob = new Test152();

		try
		{
			int a = ob.getValue(-2); //8.���� �߻�
			System.out.println("a : " + a);
		}
		catch (Exception e)     //9.���� ��Ƴ���
		{
								//10.��Ƴ� ���ܿ� ���� ó��

			System.out.println("printStackTrace......");
			e.printStackTrace();

								//11.��Ƴ� ���ܸ� ������ �ʾ����Ƿ� main���� ����ó���� �ʿ����.
		}


	}
							    //2. �߻��� ���� ������
	public int getData(int data)throws Exception
	{
		if(data<0)
		{
			// 1. ���ܹ߻�
			throw new Exception("data�� 0���� �۽��ϴ�.");
		}
		return data+10;

	}

	public int getValue(int value)throws Exception//7.catch���� ����� ���ܸ� ������ ���� �̰Ծ����� getValue���� �����߻�
	{											//�� throws , try catch�Ѵ� �ʿ��� ��Ȳ�� �����Ѵ�.
		int a = 0;								//try catch�� ������ ���ܸ� Ȯ������ �ʰ� �׳� �߻��� ���ܸ� ����

		try
		{
			a = getData(-2);   //3.���� �߻�
		}
		catch (Exception e)    //4.���ܸ� ����
		{
			System.out.println("printStackTrace.....");
			e.printStackTrace();  //5.��Ƴ� ���ܿ� ���� ó��
			
			throw e; //���� �߿��� ����
			         //6.��Ƽ� ó���� ���ܸ� �ٽ� ���� 
		}
		return a;
	}
}