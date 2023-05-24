/*===================================
■■■자바의 기본 입출력(I/O)■■■ 
================================*/
public class Test175
{
	public static void main(String[] args)
	{

		System.out.write(65);//A
		System.out.write(66);//B

		System.out.write(180);//
		System.out.write(235);// 180 + 235= '대' 라는 한글이 나온다.

		//여기까지 수행하면 아무것도 출력이 안된다 
		//자바의 기본 스트림은 buffer를 가지기에

		System.out.flush(); //버퍼가 가지고있는 데이터를 내놔라
		//출력 버퍼가 채워지지 않으면
		//출력할 데이터(자료)를 출력 디바이스(장치)로 보내지 않기에
		//flush() 메소드를 통해 아직 다 채워지지 않은 출력 버퍼의 내용을
		//출력 장치로 밀어내야 보낼 수 있도록 처리해야 한다.

		//즉 현재 구문에서는 System.out.flush() 구문을 생략할 수 없다.
	}
}