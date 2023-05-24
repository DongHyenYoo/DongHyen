//변수와 자료형
//-실수형 데이터타입의 정밀도 테스트 실습


public class Test020{

	public static void main(String[] args){



		float a = 0; // 0을보고 int형으로 4바이트에 메모리할당하여 저장
		            //float를 보고 실수형으로 새로 a 라는 메모리할당 하고 
					//0 -> float로 자동형변환이 가능 하므로 형변환되고 a라는 메모리에저장
		double b  = 0;

		//연산 및 처리
		for(int i=1 ; i<=100000; i++)

		{

			a+= 100000;
			b+= 100000; 







		}

		System.out.println(" a : " + (a/100000) + " b : " + (b/100000));

		 //a : 99996.055 b : 100000.0
		 //한번 발생된 오차가 중첩되어 계속 커지면서 값이 완전이 달라짐
		 // 이래서 double 쓰라는것






	}






}