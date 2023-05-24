public class Test003{
	//전체적으로는 클래스의 영역

   public static void main(String[] args){
   // 클래스의 영역안이나 main이라는 메소드의 영역
   int a; //a라는 이름으로 정수를 담을 메모리를 할당

   a = 10; // 10을 10ㅏ=라는변수에 대입함으 로써 변수를 초기화한다.

  //변수 선언및 초기화
  //int a =10;
   //만약 선언만 하고 값을 담지않으면 초기화를 하지 않았다는 에러가 뜬다.
   int b = 20;

   int c;

   c = a+b;
   System.out.println(c);

   //System.out.println( a b c);
   //-> 컴파일부분 에러

   System.out.println(a + " " + b + " " + c);
   // 10 20 30
   //""이 등장되어있으면 무조건 문자열로치고 +가 있으면 문자열끼리 연결시킨다. 해서 10 20 30으로 합쳐진것
   
   System.out.println("a 의 값은 " + a + "입니다.");
   System.out.println("b 의 값은 " + b + "입니다.");
   System.out.println("c 의 값은 " + (a+b) +"입니다.");

   
   System.out.println("1" +2); //문자열 결합연산자로써의 + 
   
   }


}