/*===================================
■■■자바의 기본 입출력(I/O)■■■ 

-Reader 실습
================================*/

import java.io.Reader;
import java.io.InputStreamReader; //바이트 스트림을 문자열 스트림으로 해독
import java.io.IOException;

public class Test174
{
	public static void main(String[] args)throws IOException
	{
		int data;
		char ch;

		Reader rd = new InputStreamReader(System.in);

		System.out.println("문자열 입력(종료 : Ctrl+z)");
		
		while((data = rd.read())!=-1)
		{
			ch = (char)data;
			System.out.print(ch);
			//가나다 현재 문자열기반으로 입력받고 문자열로 출력하므로 안깨짐

			System.out.write(ch); //write 는 바이트 기반의 출력 //Test174와 비교
			//가 나샂憮
		}

	}
}