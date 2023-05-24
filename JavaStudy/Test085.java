/*===================================
배열
-배열의 기본적 활용
-배열의 선언과 초기화
================================*/

public class Test085
{

	public static void main(String[] args)
	{
		//배열의 배열 선언과 초기화
		//방법 1
		//int[] arr1 = new int[3];
		int[][] arr1 = new int[3][3];

		arr1[0][0] = 1;
		arr1[0][1] = 2; //1번째방의 1번째2번째3번째에 값을 넣는다. 이하 동일
		arr1[0][2] = 3;

		arr1[1][0] = 4;
		arr1[1][1] = 5;
		arr1[1][2] = 6;

		arr1[2][0] = 7;
		arr1[2][1] = 8;
		arr1[2][2] = 9;

		//방법 2
		//int[] arr2 = {1,2,3};
		int[][] arr2 = {{1,2,3},{4,5,6},{7,8,9}};

		//방법 3
		int[][] arr3 = new int[3][3];
		int n=1;
		for(int i=0; i<arr3.length; i++) //주의해야 될사항 arr3.length는 커다란 요소를 3개를 만들었기에 값은 9가 아닌 3이 나온다.
										//즉 for 중첩문을 써야한다.
		{
			for(int j=0;j<arr3[i].length;j++) //이것은 안에들어있는 작은배열의 길이 즉 숫자 자체가 담겨있는 곳의 길이이다.
			{
				System.out.println("i "+i+" j "+j);           // 0     1        2
														// 0 1 2  0 1 2    0 1 2 이렇게 된다.
				arr3[i][j] = n;
				n++;
				
			}
			
		}

		for(int i=0;i<arr3.length;i++){
			
				for(int j=0;j<arr3[i].length;j++){
					System.out.printf("%2d", arr3[i][j]);
				}
			}

	}
}