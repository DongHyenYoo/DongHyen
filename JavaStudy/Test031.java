//제어문 실습
// if문
//if - else 문 실습

//프로그램을 작성할 때 주어진 조건에 따라
//	분기 방향을 정하기 위해 사용하는 제어문에는
//  if문 if ~ else 문. 조건 연산자 , 복합 if 문 )if 문 중첩
//  switch문이있다.

//2.if문은 if 다음의 조건이 참일 경우
//	특정 문장을 수행하고자 할 때 사용되는 구문이다.

// 사용자로부터 이름. 국어점수. 영어점수. 수학점수를 입력받아
//등급은 평균 점수 기준으로 처리한다.

//90점 이상 A
//80점 이상 90점 미만 : B
//70 점 이상 80점 미만 : c
// 60점 이상 70점 미만 : D
// 60점 미만 : F
//BufferReader 활용해 데이터 입력받게 하며
//printf 메소드 통해 출력


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Test031
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
		String name;
		int kor,eng,mat;
		double totav;
		char grade;

		totav = (kor+eng+mat)/3.0;

		System.out.print("당신의 이름을 입력 : ");
		name = br.readLine();

		System.out.print("\n당신의 국어점수를 입력 : ");
		kor = Integer.parseInt(br.readLine());

		System.out.print("\n당신의 영어점수를 입력 : ");
		eng = Integer.parseInt(br.readLine());

		System.out.print("\n당신의 수학점수를 입력 : ");
		mat = Integer.parseInt(br.readLine());*/


//선언한 변수들은 위에 몰아서 써놓는게 아닌 그때그때 선언하는것이 가독성이좋다.

		String strName = br.readLine();
		String strKor = br.readLine();
		String strEng = br.readLine();
		String strMat = br.readLine();

		int nKor = Integer.parseInt(strKor);
		int nEng = Integer.parseInt(strEng);
		int nMat = Integer.parseInt(strMat);

		int nTot = nKor + nEng + nMat;
		double fAvg = nTot / 3.0;

		char grade;




		if(fAvg >= 90){

			grade = 'A';
		}
			

			else if( fAvg >= 80){ //위의 구분때문에 평균이 90미만인 조건이 포함되어있따.
				grade = 'B';

			}
			
			else if(fAvg >= 70 ){

				grade = 'C';

			}
			else if(fAvg >= 60){

				grade = 'D';
			}
			else
			{
				grade = 'F';

			}
		
		//여기서 else가 없으면 에러가 나는데 이는 else가 없어서가 아니라 
		// 출력구문에서 grade가 작성되어있다. java는 나중에 생각했을때 문제가 생길거같으면 안넘어가는데
		//else가 없으면 grade 가 완전치 못하다고 생각하고 어떤경우에서라도 grade에 값이 채워져야 한다고 생각함
		//해서 D에서 <= 70으로 바꾸더라도 생각지도 못한 범위에서 에러가 날수있으므로 안됨

	   //만약 char grade = 'F'를 기본적으로 채우게 된다면 else가 없어도 출력구문에 문제가 없다고 판단해서 출력함
	   //if 혼자 사용가능 else 혼자사용 불가능 
	   //if else는 하나의 혼합체로 봐야하는데 if/else사이에는 어떠한것도 문법적으로 들어올수 없기에
	   //if문 안에서 int와 같은 자료형을 새로 선언할 수 있다. 단 이것이 이 문단 안에 종속되며 밖으로 나갈수 없다.

	   //만약 main문이 끝난다면 새로운 메소드를 생성하고 같은 이름의 변수를 선언해도 된다.

			

		
		System.out.printf("당신의 이름은 %s 입니다.%n",strName);
		System.out.printf("국어점수는 %d 입니다.%n",nKor);
		System.out.printf("영어점수은 %d 입니다.%n",nEng);
		System.out.printf("수학점수은 %d 입니다.%n",nMat);
		System.out.printf("평균점수는 %.2f 입니다.%n",fAvg);
		System.out.printf("학점은 : %c%n",grade);


		//조건문에서 당부할것
		//














	}







}