/*===================================
\\\\\\\\\\\���� ó��/////////
================================*/

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Test149
{
	

	private String[] data = new String[3];
	
	public void proc()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		int n=0;

			try
			{
					System.out.print("�̸� �Է�[���� : Ctrl+z : "); //Ctrl+z = Null�̶�� ���̴�.
				while( (str=br.readLine()) != null) //�߻����غ��� readLine���� IOException�� ���ִ°��̴�.
				{
					data[n++] = str;
					System.out.print("�̸� �Է�[���� : Ctrl+z] : ");
				}
				
				System.out.println("�Էµ� ����...");
				for(String s : data)
				{
					if(s != null)
					{
						System.out.println(s);
					}
				}
			}
			catch (IOException e)
			{


			}
			catch (ArrayIndexOutOfBoundsException e)
			{
				System.out.println("�迭 �ε��� ���� ���� �߻�~!!!");
				System.out.println("getMessage :"+e.getMessage());
				System.out.println("toString :" + e.toString());
				System.out.println("printStackTrace....");
				e.printStackTrace();
			}

	}

	public static void main(String[] args)throws IOException
	{
		Test149 ob = new Test149();
		ob.proc();
	}

	
}