/*===================================
클래스와 인스턴스
메소드 오버로딩(중복 정의)가 가능한 형태와 불가능한 형태
================================*/

public class Test104
{
	public static void main(String[] args)
	{

		print(4.0);
		
		
	}

	public static void print(int i){
		System.out.println("1");
	}
	//public static void print(int j){} 매개변수의 이름은 상관이없다.
	
	public static void print(char c){
		System.out.println("2");
	} //가능하지만 이런식으로는 하지 않아야된다.
//int char는 자동형변환 규칙에 해당되서 꼬일수 있다.
	//'a'를 넘겨줬을때 65로 자동형변환이 가능하다.

	public static void print(double d){
		System.out.println("3");
	} //int -> double char -> double의 자동형변환 규칙을 조심해야한다.
//	public static double print(double e){return 10.0;}
}