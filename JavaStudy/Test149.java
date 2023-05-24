/*===================================
\\\\\\\\\\\예외 처리/////////
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
					System.out.print("이름 입력[종료 : Ctrl+z : "); //Ctrl+z = Null이라는 것이다.
				while( (str=br.readLine()) != null) //잘생각해보면 readLine에도 IOException이 되있는것이다.
				{
					data[n++] = str;
					System.out.print("이름 입력[종료 : Ctrl+z] : ");
				}
				
				System.out.println("입력된 내용...");
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
				System.out.println("배열 인덱스 관련 예외 발생~!!!");
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