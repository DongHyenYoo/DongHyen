//�޼ҵ��� ���ȣ��


public class InfRecul
{
	public static void main(String[] args)
	{

		showHi(3);

		//�ڵ� ������ 2���� ��ġ�� �ٲ۴�.
	}

	public static void showHi(int cnt) 
	{
		
		System.out.println("Hi~");
		showHi(cnt--); //���ѷ��� �ذ��غ���
		if(cnt==1) 
			return;
		
		;
		
	}





	public static void showHi(int cnt)
	{
		
		System.out.println("Hi~");
		if(cnt==1)
			return;
		cnt--; //�̷��� ��
		showHi(cnt);
		

	}

	public static void showHi(int cnt)
	{
		
		System.out.println("Hi~");
		if(cnt==1)
			return;
		showHi(--cnt); //������ �ڵ�
		

	}

	public static void showHi(int cnt)
	{
		if(cnt==0)
			return;
		System.out.println("Hi~"); //�� �ڵ�
		showHi(--cnt);
		

	}





/*
	public static void showHi(int cnt) //�����̸��� ���� �������൵ �ȴ�. �� ���� �������� �����ΰ� ���� �����ɵ�
	{
		
		System.out.println("Hi~");
		if(cnt==1) 
			return;
		System.out.println(cnt);
		showHi(cnt--);  //������ ȣ���Ҷ� -�� �� ������ cnt�� ������ showHi�� 3���� ���´�.
		System.out.println(cnt+"������"); //������ ����ع����� ���� ���������� �ʴ´�.
	}
/*
	public static void showHi(int cnt) 3
	{
		
		System.out.println("Hi~");
		showHi(cnt--);   //showHi(2) ȣ��
		if(cnt==1) 
			return;
		System.out.println(cnt);
		 //������ �θ��� 2���Ұž�
	}

	public static void showHi(int cnt) 2
	{
		
		System.out.println("Hi~");
		showHi(cnt--);	//showHi(1) ȣ��
		if(cnt==1) 
			return;
		System.out.println(cnt);
		 //������ �θ��� 2���Ұž�
	}

	public static void showHi(int cnt)
	{
		
		System.out.println("Hi~");
		showHi(cnt--);	//showHi(0) ȣ��
		if(cnt==1) 
			return;
		System.out.println(cnt);
		 //������ �θ��� 2���Ұž�
	}
		

*/


}