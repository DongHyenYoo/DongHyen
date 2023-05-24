//for문 실습

//1부터 100까지의 정수중에서
//4의 배수만 출력하는 프로그램을 구현
//단 for문 사용
//한줄에 5개씩만 출력

// 4  8  12  16  20


public class Test058
{
	public static void main(String[] args)
	{

		int i;
		int strLine =0; //처음에 1이라고했는데 5번째에서 바로 넘어가버림
						//당연히 1로 시작하면  4에서 출력이 되고나서 2가된다.
						//즉 16일때 strLine이 5가되어 개행이되어 20이 밑에 출력된것
		for(i=4;i<=100;i+=4){ // *******i =1 대신 4의 배수이므로 i =4 그리고 i+=4로하면 반복문의 수를
							 // 줄일수있따.*****

			//if(i%4==0){	 //i=4 i+=4를 하면 if도 없앨수 있다.
				System.out.printf("%d\t",i);
				strLine++;
			//	System.out.printf("%d",strLine); //strLine이 4에 배수에 맞춰서 증가하는지
				
			if(strLine%5 ==0)
				System.out.println("");
				
			}
		}

/*
		int i;			
						
		for(i=4;i<=100;i+=4){ //i = 4로 바꾸기

				System.out.printf("%d\t",i);
				
			if(i%(4*5)==0) 첫줄출력해보면 (20)에서 단란이 나눠지므로 20의배수  이후마다 개행한다.
				System.out.println("");
				
			}
		}
*/



	
	}


}