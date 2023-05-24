/*===================================
\\\\\\\\\\\예외 처리/////////
================================*/

//Test150.java 파일과 비교
//throw  cf) throws 와는 다르다. throw는 의도적으로 예외를 만들어낼때 쓴다.

class Demo
{
	private int value;

	public void setValue(int value)throws Exception
	{
		if(value<=0)
		{

			//return;
			throw new Exception("value는 0보다 작거나 같을 수 없습니다.");//예외가 나오는 근원
			//위에서 에러를 일부러 만든것이므로 throws Exception해줘야됨 
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
			System.out.println("으에에");
		} //예외를 잡고 끝내거나 하는게 아니라 잡고 고치고 던질수 있다.
		
		
		
	}
}