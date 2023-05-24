/*===================================
배열
-배열의 기본적 활용
-배열의 선언과 초기화
================================*/


//과제 
// 사용자로부터 임의의 학생 수를 입력받고
//그만큼의 점수(정수 형태)를 입력받아
// 전체 학생 점수의 합, 평균, 편차를 구해서

//결과를 출력하는 프로그램을 구현

//학생수 입력 : 4
//1번 학생의 점수 입력 :98
//2번 학생의 점수 입력:65
//2번 학생의 점수 입력:78
//2번 학생의 점수 입력:6521

//합 : ~~~
//평균 : 74
//편차 :  (개인의점수 - 평균값)
//1번학생 90점의 편차 : -16
//2번학생 65점의 편차 : +9
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//2차원 배열과 메소드를 이용해보는 과제 시작
class Student									//아이디어 정리
{												//[입력받은수][2] 의 배열 생성
	int num;									//[2]에는 학생의 점수와 편차를 넣는다.
												//[입력받은수+1][2]에는 합과 평균을 넣어보자
	Student()throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("학생의 수를 입력 : ");
		num = Integer.parseInt(br.readLine());
	}

	int[][] scoreArr()throws IOException							//2차원 배열도 넘겨진다니 어디까지 넘겨지는건지
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[][] = new int[num+1][2];

		for(int i=0;i<num;i++)							//arr.length를 하면 합과 편차를 담을 곳도 점수로 채워짐
		{
			alert(i+1);
			arr[i][0] = Integer.parseInt(br.readLine()); 
		}

		return arr;
	}

	void alert(int i)								//n번째 학생의 수를 출력할 alert메소드
	{
		System.out.printf("%d번째 학생의 점수 : ",i);
	}

	int sum(int[][] arr)							//학생들의 점수가 담긴 배열을 받아 합을 리턴할 sum메소드
	{
		int result=0;
		for(int i=0;i<num;i++)
		{
			result += arr[i][0];
		}
		return result;
	}

	int average(int sum)
	{
		int result = sum/num;
		return result;
	}

	int[][] deviation(int[][] arr, int average)
	{
		
		for(int i=0;i<num;i++)
		{
			arr[i][1] = arr[i][0]-average;
		}


		return arr;

	}
	
	void print(int[][] arr)
	{
		System.out.printf("합 : %2d\n",arr[arr.length-1][0]);
		System.out.printf("평균 : %2d\n",arr[arr.length-1][1]);
		for(int i=0;i<arr.length-1;i++)
		{
			System.out.printf("%d번 학생의 편차 :%2d\n",i+1,arr[i][1]);

		}

	}



}
public class Test084
{

	public static void main(String[] args)throws IOException
	{
		Student ob = new Student();
		int arr[][] = new int[ob.num+1][2];
		int num = arr.length-1;					//배열은0부터 시작이다.고로 제일 끝의 배열은 배열 길이의 -1
		arr = ob.scoreArr();
		
		//for(int i=0;i<arr.length;i++)		//arr.length는 num+1값과 같다. 출력도 정상
		//	System.out.println(arr[i][0]);

		arr[num][0] = ob.sum(arr);	//sum메소드로부터 정상적으로 값을 받아오는것 확인
		int sum = arr[num][0];
		//System.out.println(sum);

		arr[num][1] = ob.average(sum);
		int average = arr[num][1];
		//System.out.println(average);	//sum값을 받아 평균을 받아온것 확인

		arr = ob.deviation(arr,average);

		ob.print(arr);
		
/*학생의 수를 입력 : 4
1번째 학생의 점수 : 90
2번째 학생의 점수 : 65
3번째 학생의 점수 : 67
4번째 학생의 점수 : 87
합 : 309
평균 : 77
1번 학생의 편차 :13
2번 학생의 편차 :-12
3번 학생의 편차 :-10
4번 학생의 편차 :10
계속하려면 아무 키나 누르십시오 . . .

*/




		


	
	}
}



/*		메소드를 이용한 과제 시작
class Student
{
	int num;									//사용자한테 입력받을 학생수
	

	Student()throws IOException					//객체 생성과 동시에 학생수 받기
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("학생수 입력 :\t");
		this.num = Integer.parseInt(br.readLine());
	}

												//필요한 메소드는 무엇?
												//입력받은 점수를 배열로써 저장하고 리턴할 int[] 메소드
												//넘겨받은 점수배열에서 합을 구할 메소드
												//평균을 구할 메소드
												//개인의 편차를 구해줄 메소드
												//위 3개를 출력해줄 메소드
	
	int[] scoreArr()throws IOException			//입력받은 점수를 배열로써 저장하고 리턴할 int[] 메소드
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[this.num];		
		for(int i=0;i<arr.length;i++)
		{
			alert(i);							//printf문을 이용해 n번째 학생을 출력해줄 메소드 반복호출
			arr[i] = Integer.parseInt(br.readLine()); //입력받은수를 scoreArr에서 선언한 arr배열에 저장
		}
		return arr;								//입력받은 점수 배열값 리턴
	}



	void alert(int i)							//void를 제외한 다른자료형 메소드에서는 printf를 쓰지못한다. 해서 scoreArr의 반복문의 변수i를 받아와 n번 학생수를 대신 출력할 메소드 alert
	{
		System.out.printf("%d번 학생의 점수 입력 :",i+1);
	}

	int sum(int[] arr)						//넘겨받은 점수배열에서 합을 구하고 출력할 메소드sum
	{
		int result=0;						//result에 값을 계속 더해넣을것이므로 초기화
		for(int i=0;i<arr.length;i++)
		{
			result += arr[i];
		}
		
		return result;
	}

	
	int average(int totalScore)			//넘겨받은 전체 합에서 평균을 구하고 넘길메소드 average
	{
		int result = totalScore/this.num;

		return result;
	}

	int[] deviation(int[] arr, int average)		//학생들의 점수 배열과, 평균값을 받아 개인의 편차를 배열에 저장해서 넘겨줄 메소드 Deviation
	{
		int result[] = new int[arr.length];		//학생의 수와 편차의 수는 같다.
		
		for(int i=0;i<result.length;i++)
		{
			result[i] = arr[i]-average;
		}

		return result;
	}

	void print(int sum, int average, int[] arrDevi)
	{	
		System.out.printf("\n학생들의 총 점수는 :%2d\n",sum);
		System.out.printf("학생들의 평균값 :%2d\n",sum);
		System.out.println();
		for(int i=0;i<arrDevi.length;i++)
		System.out.printf("%d번 학생의 편차 : %2d\n",i+1,arrDevi[i]);

	}

	


}
public class Test084
{

	public static void main(String[] args)throws IOException
	{
		Student ob = new Student();
		System.out.println();

		int arr[] = new int[ob.num];

		arr = ob.scoreArr();					//1.입력받은 점수들을 저장해줄 메소드 호출

		//for(int i=0;i<arr.length;i++)			//입력받은 점수 배열이 제대로 저장되는지 출력확인
		//System.out.printf("%d\t",arr[i]);     //출력됨
		
		//int sum = ob.sum(arr);				//합값 출력시도
		//System.out.println(sum);				//출력됨

		//int average = ob.average(sum);		//평균값 출력시도
		//System.out.println(average);

		//int arrDevi[] = new int[ob.num];		//편차를 담을 배열 선언
		
		//arrDevi = ob.deviation(arr,average);	//선언한 배열에 편차 담기

		//for(int i=0;i<arrDevi.length;i++)		//편차 출력시도
		//	System.out.printf("%d번 학생의 편차값 : %d\n",(i+1),arrDevi[i]);


		int sum = ob.sum(arr);				//2.배열을 넘겨주고 합을 구해주는 메소드 호출
		int average = ob.average(sum);		//3.합을 넘겨주고 평균을 구해주는 메소드 호출
		int arrDevi[] = new int[ob.num];   //4.편차를담을  학생의 수와 같은 수의 배열을 선언
		arrDevi = ob.deviation(arr,average); //5.편차를 계산할 메소드에 학생들의 점수와 평균값 넘겨 호출

		ob.print(sum,average,arrDevi);
		
		

	}
}메소드를 이용한 과제 끝*/


//그냥 만들어보기
/*public class Test084
{

	public static void main(String[] args)throws IOException
	{

		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("입력할 학생의 수 : ");
		int num = Integer.parseInt(br.readLine());

		int arr[] = new int[num];
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.printf("%d번 학생의 점수 입력 : ",i+1);
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		int sum=0;

		for(int i=0;i<arr.length;i++)
		{
			sum += arr[i];
		}

		int average;
		average = sum/num;

		System.out.printf("\n학생들의 점수의 합 : %2d\n",sum);
		System.out.printf("점수의 평균 %2d\n",average);
		System.out.println();

		for(int i=0;i<arr.length;i++)
		{	
			int deviation = arr[i]-average;
			System.out.printf("%d번 학생의 편차 : %2d\n",i+1,deviation);
		}

		


		

		



	}


}*/ //그냥 만들어보기 끝