/*===================================
\\\\\\\\\\\���� ó��/////////
================================*/

//�ٸ� ���� �ٽ� ������

public class Test153
{
	public int getValue(int value)throws Exception // 7.ȣ���� ������ ���� ����(2��° ��ź)
	{
		int a=0;
		
		try
		{
			a = getData(-2); //3.���� �߻�	
		}
		catch (Exception e)  //4.���� ��Ƴ���
		{
			System.out.println("printStackTrace....");
			e.printStackTrace(); //5. ���� ó��

			throw new Exception("value�� �����Դϴ�."); //6.���� �߻� (2��° ��ź)
		}
		

		return a;
	}

	public int getData(int data)throws Exception//2.���ܸ� ȣ���Ѱ����� ����
	{
		if(data <0)
		{
			throw new Exception("data�� 0���� ����"); //1.���ܹ߻�
		}
		return data+10;

	}


	public static void main(String[] args)
	{
		Test153 ob = new Test153();
		
		try
		{
			int a = ob.getValue(-2);  //8.������ ����(2��° ��ź)
			System.out.println("a : " + a);
		}
		catch (Exception e) //9.���� ���(2��° ��ź)
		{
			System.out.println("printStackTrace....");
			e.printStackTrace();
		}
		


		

	}
}