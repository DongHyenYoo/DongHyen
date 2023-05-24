/*===================================
■■■자바의 기본 입출력(I/O)■■■ 
================================*/

import java.io.OutputStream;
import java.io.IOException;

public class Test173
{
	public static void main(String[] args)throws IOException
	{
		//System.in : 자바의 표준 입력 스트림
		//System.out : 자바의 표준 출력 스트림

		OutputStream out = System.out;

		//배열 구성
		byte[] ch = new byte[3];

			ch[0] = 65;
			ch[1] = 97;
			ch[2] = 122;
			
			out.write(ch); //out은 outputstream이고 out이라는 물줄기에 ch라는 배열 데이터를 기록한것
			
			out.flush(); //버퍼가 장착되어 있는 스트림에서는 무조건 써줘야하는것
			           //앞에서본 StringBuffer클래스 에서나왔던 버퍼에 데이터가 쌓이고나서 가만히 두면
					   //데이터가 흘러가지 않으므로 버퍼에 쌓인 데이터를 옆으로 넘겨주는 역할이 flush()
					  //입력과 출력 모두 버퍼가 존재하므로 둘다 쓸때 쓰여야한다.

					  //쌤정리 : 기록된 스트림을 내보내는 기능을 수행
					  //지금은 Buffer를 활용하지 않고 있는 상황이라 생략이 가능한 코드
					  //다만 Buffered되어 있는 스트림일 경우 생략이 안된다.
			
			
			out.close(); //출력 스트림에 대한 리소스를 반납하는 메소드
			
			System.out.println("출력됨?"); //out.close()로 인해 출력할 out stream이 닫혀서 이구문은 출력이 되지 않는다.
			//출력 스트림을 닫아버려서 출력이 안된다.
	}
}