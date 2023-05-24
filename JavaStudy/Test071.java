//클래스와 인스턴스
// Test071은 CircleTest.java파일과 세트다

import java.io.IOException;

public class Test071
{
	public static void main(String[] args)throws IOException//main이라는 영역안에서 br.readLine이 
											//오류를 내면 main이라는 영역 밖으로 br.readLine을 버려라
											//circletest의 input밖으로 br.readLine을 버린다해도
											//완전히 밖으로 버린게 아닌 Test071의 main안에 버린것
											//이 된다.(Test071 ( input()))이런식의 Test071
											//의 내집합 안에 있는거다.
	{

		CircleTest ct = new CircleTest();

		ct.input(); //왜 예외처리해야되느냐
					//
		double round = ct.callRound();
		double area = ct.callArea();
		ct.print(area,round);

	}


}