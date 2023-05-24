import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Test013{



	public static void main(String[] args)throws IOException
		{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int height, width;
		double area;

		System.out.print("삼각형의 높이 입력 : ");
		
		height = Integer.parseInt(br.readLine());

		System.out.print("\n삼각형의 밑변 입력 : ");
		width = Integer.parseInt(br.readLine());

		//사용자가 입력한 데이터(문자열)을 정수 형태로 변환한 후
		//변수 width에 담아내자
		//br.readLine() 이부분은 어떤데이터를 입력하든 문자열형태의 데이터로 반환하게됨
		//Inter.parInt라는 도구를 통해서 이 문자열을 정수형태로 변환하여 width에 담아낸다.


		area = (double)(height * width)/2;

		
		

		System.out.printf("\n밑변이 %d 높이가 %d인 삼각형의 넒이 : %.2f\n",width,height,area);
		



/*삼각형의 높이 입력 : 3

삼각형의 밑변 입력 : 5

밑변이 5 높이가 3인 삼각형의 넒이 : 7.50
*/


	}








}