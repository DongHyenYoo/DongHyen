//while
// 1/2 + 2/3 + 3/4 + 4/5 ..... 9/10
//의 연산 처리 결과를 출력하는 프로그램을 구현한다.
//연산결과 : xxx


public class Test049
{

	public static void main(String[] args)
	{
		int n = 1;
		double tot =0;

		while(n<=9){
			
			//temp = n;
			//++n;
			//tot += (float)temp/n;
			tot += (float)n/++n; // n을 데리고 float로 먼저 변환후 연산을 수행한다.
    /*
	int n = 0;
	while(n<9)
		n++; //최종적으로 반복문의 조건을 무너트리는 열쇠

		tot = n/(n+1)

	*/


		}

		System.out.printf("연산결과 : %.4f ",tot); //printf에서 실수 자리수 조건을 걸지않으면 자동으로 6자리까지 출력한다.






	}
}





//다 안다생각하지말고 다시생각하고 보기