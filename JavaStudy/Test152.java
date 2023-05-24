/*===================================
\\\\\\\\\\\예외 처리/////////
================================*/


public class Test152
{
	public static void main(String[] args)
	{
		Test152 ob = new Test152();

		try
		{
			int a = ob.getValue(-2); //8.예외 발생
			System.out.println("a : " + a);
		}
		catch (Exception e)     //9.예외 잡아내기
		{
								//10.잡아낸 예외에 대한 처리

			System.out.println("printStackTrace......");
			e.printStackTrace();

								//11.잡아낸 예외를 던지지 않았으므로 main에는 예외처리가 필요없다.
		}


	}
							    //2. 발생한 예외 던지기
	public int getData(int data)throws Exception
	{
		if(data<0)
		{
			// 1. 예외발생
			throw new Exception("data가 0보다 작습니다.");
		}
		return data+10;

	}

	public int getValue(int value)throws Exception//7.catch에서 날라온 예외를 밖으로 던짐 이게없으면 getValue에서 에러발생
	{											//즉 throws , try catch둘다 필요한 상황이 존재한다.
		int a = 0;								//try catch가 없으면 예외를 확인하지 않고 그냥 발생한 예외를 던짐

		try
		{
			a = getData(-2);   //3.예외 발생
		}
		catch (Exception e)    //4.예외를 잡은
		{
			System.out.println("printStackTrace.....");
			e.printStackTrace();  //5.잡아낸 예외에 대한 처리
			
			throw e; //제일 중요한 구문
			         //6.잡아서 처리한 예외를 다시 던짐 
		}
		return a;
	}
}