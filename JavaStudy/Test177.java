/*=============================================
 ■■■ 객체 직렬화(Object Serialization) ■■■
=============================================*/

/*
 --객체 직렬화는 //메모리에 있는 객체를 번호를 붙여 쪼갠뒤 전송해서 번호에 맞춰 조립할수 있게(역직렬화)만드는 개념
                 //01  12  23 34 이렇게 연결부를 표시해서 쪼갠다.
				
				 
   메모리에 생성된 클래스 객체의 멤버 변수의 현재 상태를
   그대로 보존해서 파일에 저장하거나
   네트워크를 통해 전달할 수 있는 기능으로
   멤버 변수의 값을 보존한다거나
   다른 네트워크에 있는 호스트에 값을 보낼 경우 사용하게 된다.

   즉 객체 직렬화는 내용물을 바이트 단위로 변환하여
   파일 또는 네트워크를 통해 송수신(스트림)이 가능하게
   만들어주는 것으로 이때, 객체란 멤버 변수의 메모리만으로 구성된 것을 말한다.

   따라서, 메소드와 생성자는 객체 직렬화의 대상에서 제외된다.


 --객체 직렬화의 장점
   
   객체 자체의 내용을 입출력 형식에 구애받지 않고
   객체를 파일에 저장함으로써 영구적인 속성을 제공할 수 있으며 즉 초기상태만 유지하는것이 아니라 변동된 상태도 저장할 수있다.
   객체 자체를 네트워크를 통해 손쉽게 교환할 수 있게된다.

   객체 직렬화는 자바 자바 1.1이후에 도입되었는데
   그 이유는 RMI와 Bean때문 이었다. RMI 앞에서 System.out.exit(-1)

   RMI는 원래 객체 통신을 지원해야 하기 때문에
   객체가 그대로 이동할 수 있어야 한다.
   따라서 이를 지원하기 위해서는 객체 직렬화가 필수적이었따.

   또한 Bean은 설계시 상태에 대한 정보를 저장할 때
   이 객체 직렬화를 사용하면 편하게 객체 상태를 저장할 수 있다.

   --RMI(Remote Method Invocation)
   서로 다른 가상 기계장치에 존재하는 함수를
   호출하고 실행하는 기능을 담당한다.
   서로 다른 통신 구조에 위치한 각각의 원격 객체들 간의
   통신 구조를 지원하는 개념

   --Bean (규칙/규약)이다.
   C/S구조적 모델에서 서버측 구조에 해당하며
   재사용 가능한 소프트웨어 개체를 만들 수 있게 하는 컴포넌트 기술.
   작성된 개체의 공유가 가능하며 프로젝트에 쉽게 포함시킬 수 있도록한다.
   클라이언트에게 빈이라는 프로그램 컴포넌트를 분배하는 방식으로 처리


 --Serializable 인터페이스

   객체 직렬화를 하기 위해 먼저 객체 직렬화가 가능하도록
   java.io.Serializable 인터페이스를 구현해 주어야 한다.
   이 인터페이스는 객체 직렬화가 제공되어야 한다는 사실을
   JVM에 알려주는 역할을 수행한다.
   또한,Serializable 인터페이스는
   다른 인터페이스와 달리 구현해야 할 메소드가 없기 때문에
   단지 선언만 해주면 된다.

   형식)
   1)

   public class 클래스명 implements Serializable
   {
   }

   2)
   Serializable 인터페이스를 구현한후
   ObjectInputStream 클래스와 ObjectOutputStream 클래스를 이용하여
   객체 단위로 입출력을 수행하게 된다.

   --멤버 변수가 static 으로 선언된 경우
   (즉, 클래스 변수일 경우)
   객체 직렬화의 대상에서 제외된다.


   --Object Stream

   java.io.ObjectInputStream
   ObjectInputStream 클래스는 ObjectOutputStream 클래스에 의해
   바이트기반으로 입/출력하는 스트림에 객체를 올릴수 있다.

   파일에 저장되어 있는 객체나 네트워크를 통해 전달된 객체의
   직렬화를 해제하는 기능을 제공한다.
   단, java.io.Serializable 인터페이스와
   java.io.Externalizable 인터페이스를 지원해주는 객체에 대해서만
   사용이 가능하다
   즉,Serializable 인터페이스와 Externalizable 인터페이스를
   구현한 객체에서만 사용이 가능하다는 것이다.
   이때, readObject()메소드를 이용하여
   스트림으로부터 직렬화된 객체를 읽을 수 있으며

   이렇게 읽은 객체는 배열, 문자열 또는 각 객체 등
   원래의 형(Type)으로 캐스팅 해주어야한다.(Object형으로 올라갔으니 원래대로 다운캐스팅해줘야한다.)
*/
import java.io.File;
import java.util.Hashtable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Enumeration; //여기서 Iterator는 쓰지못한다.



public class Test177
{
	public static void main(String[] args)throws Exception //디렉터리를 생성해줬음에도 불안정하다고 생각하는 자바가 예외처리를 요구
	{
		String appDir = System.getProperty("user.dir");
		//System.out.println(appDir);
		//C:\JavaStudy 현재 Test177파일이 어디에 있는가.

		//파일 객체 생성
		File f0 = new File(appDir,"\\data\\test.ser");
		//appDir: C:\JavaStudy 
		//appDir 위치를 기준으로 \\data\\test.ser 를
		//구성하겠다는 의미
		//결과적으로 C:\JavaStudy\data\test.ser를 구성하겠다는 의미
		//""안에서는 \\ = \이다.

		//System.out.println(f0.getParentFile().exists());
		//부모들은 C:\JavaStudy\data 이므로 이 C:\JavaStudy\data가 존재하는가라고 물어본것
		//false
		//test.ser파일이 만들어질 디렉터리 경로가 구성되어 있지 않다.

		//C:\JavaStudy위치에 data 디렉터리 생성후 다시 확인

		//System.out.println(f0.getParentFile().exists());
		//true 가 나왔다.

		if(!f0.getParentFile().exists())
		{
			//디렉터리 만들겠다.
			f0.getParentFile().mkdirs(); 
		}
		Hashtable<Integer,String>h1 = new Hashtable<Integer,String>();
		//객체 직렬화시 순서가 보장되지 않기에 map자료구조를 주로 쓴다.
		
		//생성한 h1이라는 Hashtable 자료구조에 요소 추가

		h1.put(2206428,"엄소연");
		h1.put(2206436,"유동현");
		h1.put(2206512,"임시연");
		h1.put(2206524,"한은영");
		h1.put(2206537,"조현하");

		//테스트
		//System.out.print(h1.get("2206524"));

		//파일 전용 출력 스트림 생성
		FileOutputStream fos = new FileOutputStream(f0);

		//파일 전용 출력 스트림에
		//f0이라는 파일 객체를 띄운다.
		//InputStreamReader isr = new InputStreamReader(System.in);

		//객체 전용 출력 스트림 생성
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//객체 전용 출력 스트림으로 fos라는 파일전용 출력 스트림을 감싸겠다.
		//BufferedReader br = new BufferedReader(isr) 과 같다.

		//위의 line 152 ~159와 동일한 구문
		//ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f0));
		//과 같다. 즉 구조적으로 동일한 구문

		//ObjectOutputStream 클래스는
		//객체들을 출력하는 기능을 제공하는 클래스로
		//출력 스트림에 출력하기 전에
		//내부적으로 객체 직렬화를 수행하게 된다.
		//자바 기본형 데이터 또는 객체들을
		//파일에 저장하거나 네트워크를 통해 전달하기 위해
		//전달할 객체를 직렬화하는 기능을 제공하는 것이다.

		//생성된 스트림에 내보낼 객체를 기록
		oos.writeObject(h1);
		//out.write(ch);와 같은 개념의 구문 


		//객체 전용 리소스 반납
		
		oos.close();
		//ObjectOutputStream 리소스 반납

		//파일 전용 리소스 반납
		fos.close();
		//FileOutputStream 리소스 반납

		//(객체를 직렬화하여 파일로) 내보내기 끝

		//(객체를 직렬화하여 내보낸 파일)읽어들이기 시작

		if(f0.exists())
		{
			//f0파일을 파일 입력 스트림(fis, FileInputStream)으로 읽어들이고
			FileInputStream fis = new FileInputStream(f0);

			//fis 파일 입력 스트림으로부터 객체 입력 스트림을 얻어내어
			ObjectInputStream ois = new ObjectInputStream(fis);

			//객체 입력 스트림(oos, ObjectInputStream)으로 부터 읽어들인 객체(Object)를
			//캐스팅(Hashtable)하여 
			//h2라는 Hashtable 자료구조에 담아내기
			//Object obj = ois.readObject();
			Hashtable h2 = (Hashtable)ois.readObject();

			ois.close();

			fis.close();

			//읽어들이기 끝--------------------------
		//읽어들인 h2객체 내용 확인

		int key;
		String value;

		//Iterator사용 불가

		Enumeration e = h2.keys();

		while(e.hasMoreElements())
		{
			key = (int)e.nextElement();
			//Hashtable 자료구조를 대상으로 key값을 읽어들이는 과정

		//System.out.println(key);

		value = (String)h2.get(key);
		//Hashtable자료구조를 대상으로 key를 활용하여 value를 얻어내는 과정

		System.out.println(key+" -> "+ value);


		}
		
		}
		
	}
} 
