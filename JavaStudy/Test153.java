/*===================================
\\\\\\\\\\\예외 처리/////////
================================*/

//다른 예외 다시 던지기

public class Test153
{
	public int getValue(int value)throws Exception // 7.호출한 곳으로 예외 던짐(2번째 폭탄)
	{
		int a=0;
		
		try
		{
			a = getData(-2); //3.예외 발생	
		}
		catch (Exception e)  //4.예외 잡아내기
		{
			System.out.println("printStackTrace....");
			e.printStackTrace(); //5. 예외 처리

			throw new Exception("value가 음수입니다."); //6.예외 발생 (2번째 폭탄)
		}
		

		return a;
	}

	public int getData(int data)throws Exception//2.예외를 호출한곳으로 던짐
	{
		if(data <0)
		{
			throw new Exception("data가 0보다 적어"); //1.예외발생
		}
		return data+10;

	}


	public static void main(String[] args)
	{
		Test153 ob = new Test153();
		
		try
		{
			int a = ob.getValue(-2);  //8.던져진 예외(2번째 폭탄)
			System.out.println("a : " + a);
		}
		catch (Exception e) //9.예외 잡기(2번째 폭탄)
		{
			System.out.println("printStackTrace....");
			e.printStackTrace();
		}
		


		

	}
}