/*===================================
\\\\\\\\\\\���� ó��/////////
================================*/

//Test150.java ���ϰ� ��
//throw  cf) throws �ʹ� �ٸ���. throw�� �ǵ������� ���ܸ� ������ ����.

class Demo
{
	private int value;

	public void setValue(int value)throws Exception
	{
		if(value<=0)
		{

			//return;
			throw new Exception("value�� 0���� �۰ų� ���� �� �����ϴ�.");//���ܰ� ������ �ٿ�
			//������ ������ �Ϻη� ������̹Ƿ� throws Exception����ߵ� 
		}
		this.value = value;
	}

	public int getValue()
	{
		return value;
	}
}

public class Test151
{
	public static void main(String[] args)//throws Exception
	{
		Demo ob = new Demo();
		
		try
		{
			ob.setValue(-3);
			int result = ob.getValue();
			System.out.println(result);

		}
		catch (Exception e)
		{
			System.out.println("������");
		} //���ܸ� ��� �����ų� �ϴ°� �ƴ϶� ��� ��ġ�� ������ �ִ�.
		
		
		
	}
}