/*===================================
배열
-배열의 기본적 활용
-배열의 선언과 초기화
================================*/

//사용자로부터 인원수를 입력받고
//입력받은 인원수 만큼의 학생 이름과 전화번호를 입력받고
//이렇게 입력받은 데이터를 이름 배열과 전화번호 배열로 구성하여
//결과를 출력할 수 있는 프로그램 구현

//입력 처리할 학생 수 입력(1~10) :
//입력 수 초과할 경우 다시 입력해라 라고 해라

//이름 전화번호 입력[1]( 공백 구분): 유동현 010-3578-3912
//이름 전화번호 입력[2](공백 구분) :



import java.util.Scanner;
/*
class Student
{
	int num;

	Student(){

		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.print("입력할 학생 수를입력하세요 : ");
			num = sc.nextInt();

		}
		while (num <1 || num >10);
	}


	String[] inputInfo(){
		String arr[] = new String[num];
		String arr1[] = new String[num];
		

		Scanner sc = new Scanner(System.in);

		for(int i=0;i<num;i++)
			{
			System.out.printf("학생의 이름과 전화 번호를 입력[%d] : ",i);
			arr[i] = sc.next();
			arr1[i] = sc.next();
			}
			System.out.println();
			return arr;


			이거 중간에 다른함수 호출해서 거기에 저장할수 없을까!!!!!!
		}
	
	

	}
집가서 만들어보기
*/ 

public class Test082
{

	public static void main(String[] args)
	{
		int studentNum; //학생수 입력받을 변수
		
		String name;
		String number;
		

		Scanner sc = new Scanner(System.in);

		do{
		System.out.print("입력 처리할 학생 수 입력(1~10) : ");
		studentNum = sc.nextInt();
		}
		while(studentNum < 1 || studentNum >10); //studentNum < 1 || studentNum >10

		String nameArr[] = new String[studentNum]; //학생 이름 배열
		String phoneArr[]= new String[studentNum]; // 학생 전화번호 배열 //String phoneArr[]= new String[nameArr.length]; 로 해도된다.
		
		
			for(int i=0;i<studentNum;i++){
				System.out.printf("이름 전화번호 입력[%d] : ",i+1);
				nameArr[i] = sc.next();    //String name = sc.next();
				phoneArr[i] = sc.next();   //String number = sc.next();
				// nameArr[i] = name + " " + number; //이렇게 해도 된다.
			
		}
		System.out.print("=====================\n");
		System.out.printf("전체 학생 수 : %d\n",studentNum);
		System.out.print("======================\n");
		System.out.print("이름   전화번호\n");
		for(int i=0;i<studentNum;i++){
			System.out.printf("%s \t%s\n",nameArr[i],phoneArr[i]);
		}
		System.out.println();

		


	}

}