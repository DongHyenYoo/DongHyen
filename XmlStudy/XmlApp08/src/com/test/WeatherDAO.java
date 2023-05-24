/* WeatherDAO.java
 	- DAO 구성
 	- XML DOM 활용 → 원격(remote) XML 읽어내기
 	https://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108
 */

package com.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class WeatherDAO
{
	
	//공통 멤버 구성 → 멤버 변수 → 초기화 →생성자
	private Document xmlObj;
	private XPath xPath;   //xml의 XPath
	private HashMap<String, String> map;
	
	//생성자 정의
	public WeatherDAO() throws ParserConfigurationException, IOException, SAXException
	{
		this("108"); //전국 기준
		// TODO Auto-generated constructor stub
		
		
		/*
		stnId=108   전국
		stnId=109   서울, 경기
		stnId=105   강원
		stnId=131   충북
		stnId=133   충남
		stnId=146   전북
		stnId=156   전남
		stnId=143   경북
		stnId=159   경남
		stnId=184   제주특별자치도
		*/
	}
	
	//생성자 정의 → 매개변수 있는 생성자
	public WeatherDAO(String stnId) throws ParserConfigurationException, IOException, SAXException
	{
		map = new HashMap<String, String>();
		map.put("맑음", "W_DB01.png");
		map.put("흐림", "W_DB04.png");
		map.put("비", "W_DB05.png");
		map.put("구름조금", "W_NB02.png");
		map.put("구름많음", "W_NB03.png");
		map.put("흐리고비", "W_NB08.png");
		map.put("구름많고비", "W_NB20.png");
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		String str = String.format("https://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=%s", stnId);
		URL url = new URL(str);
		InputSource is = new InputSource(url.openStream());
		
		xmlObj = builder.parse(is);
		
		xPath = XPathFactory.newInstance().newXPath();//javax.xml의 XPathFactory쓴다.
		//-----------------------
		   //XPathFactory타입
		                          //---------
		                          //XPath타입
		
		// XPath = XPathFactory.newInstance().newXPath();
				//  └--→ XPathFactory xFactory = XPathFactory.newInstance();
				//         XPath = xFactory.newPath
				// 		   와 동일한 구문
		
		
		
		/*
		 ○XPath 생성
		 
		 -XPathFactory 의 정적 메소드(static) 『newInstance()』호출을 통해
		  XPath 를 생성해줄 수 있는 XPathFactory를 생성하고
		 -이렇게 생성된 XPathFactory의 정적 메소드(static) 『newXPAth()』호출을 통해
		 XPath 객체를 생성한다.
		 
		 
		  ○ 노드 선택(Selecting Nodes)
		    - 브라우저마다 XPath 를 처리하는 방법에서 차이를 보인다.
		    - Chrome, Firefox, Edge, Opera, Safari 등은
		      『evaluation()』 메소드를 사용하여 노드를 처리한다.
		      → xmlDoc.evaluation(xpath, xmlDoc, null, xPathResult.ANY_TYPE, null)
		      	 → 사이사이에 null 넣은 건 1도 신경안써도 됨
		    - IE 는 『selectNodes()』 메소드를 사용하여 노드를 선택한다.
		    
		     ○ XPath 의 『compile(XPath 경로 표현식)』
		    - XML 데이터 Parsing
		      1. XML 이 제공되는 URL 로 접속하여 데이터를 수신한다.
		      2. DocumentBuilderFactory ... newInstance() 로 factory 를 생성한다.
		      3. DocumentBuilder ... newDocumentBuilder() 로 builder 를 생성한다.
		      4. InputSource is ... new InputSource() 로 InputSource 를 생성한다.
		         이 때, 파일로 수신한 경우라면 File 객체를 넘겨준다.
		      5. Document xmlObj = builder.parse(is) 로 XML 을 파싱(Parsing)한다.
		      6. XPath xPath = XPathFactory.newInstance().newXPath() 로
		         XPath 객체를 생성하고
		      7. XPathExpression expr = XPath.compile( XPath 경로 표현식 ) 으로
		         가져올 Element 를 선택하게 된다.
		      8. 해당 노드(Element)에 접근하여 필요한 데이터를 추출한다.
		 */
		
	
	
	}
	
	
	
	//<title>서울,경기도 육상중기예보</title>
	// → xPath 로 얻어와보자
		//    xPath 변수 선언해놨고, 생성자에서 XPath 만들어놨으니 사용하면 됨
	public String weatherTitle() throws XPathExpressionException
	{
		String result = "";
		
		// rss 부터 시작해서, 그 하위에 있는 channel로 접근하고,
				// 그 하위에서는 item 으로 접근하고,
				// 그리고 그 아래있는 title
		result = xPath.compile("/rss/channel/item/title").evaluate(xmlObj);
		//-- 이게 XML 의 구조적인 경로
		
		
		return result;
	}
	
	/*
	 <wf>
	<![CDATA[ ○ (하늘상태) 이번 예보기간에는 대체로 맑은 날이 많겠습니다.<br />○ (기온) 아침최저기온은 31일(토)와 1월 3일(화) -13~-5도로 평년(아침최저기온 -11~-4도)보다 조금 낮겠고, 그 밖의 날은 -10~-1도로 평년보다 조금 높겠습니다.<br /> 낮최고기온은 1월 2일(월), 3일(화), 6일(금), 7일(토) -1~3도로 평년(낮최고기온 1~3도)보다 조금 낮겠고, 그 밖의 날은 2~5도로 평년보다 조금 높겠습니다.<br />○ (해상) 서해중부해상의 물결은 1월 2일(월) 1.0~2.5m로 일겠고, 그 밖의 날은 0.5~2.0m로 일겠습니다.<br />○ (주말전망) 31일(토)은 오전에 구름많다가 오후에 대체로 맑겠고, 1월 1일(일)은 대체로 맑겠습니다. 아침 기온은 -13~-1도, 낮 기온은 2~5도가 되겠습니다. ]]>
	</wf>
	 */
	
	public String weatherInfo() throws XPathExpressionException
	{
		String result="";
		
		result = xPath.compile("/rss/channel/item/description/header/wf").evaluate(xmlObj);
		
		return result;
		
	}
	
	// check~!!!
		// XML 은 대게 이 방식을 사용하기 때문에 되게 중요함!!
		// 도시 이름 배열 구성
	public ArrayList<String> weatherCityList() throws XPathExpressionException
	{
		ArrayList<String> result = new ArrayList<String>();
		
		//이거는 배열로 값을 얻어내려고 함이 다르다는것을 인지
		
		//xPath.compile("rss/channel/item/description/body/location/city").evaluate(xmlObj); 여기까지하면 단일노드
		NodeList cityNodeList = (NodeList)xPath.compile("rss/channel/item/description/body/location/city")
				.evaluate(xmlObj, XPathConstants.NODESET); //이 경로를 통해 나오는 결과물의 정체성은 XPathConstants.NODESET(노드들)이다. 
		//-- NODESET을 return 하고 있음 
				//   NODESET 은 NODE들로 구성된거니까 type → NodeList
				//   그런데 넘길 때 객체형태로 넘기고 있으니까 casting 해줘야함
				//-- evaluate(파라미터1, 파라미터2) 로 넘겨주면
				//   내가 너한테 넘기는건 단일값 아니라, 여러 개야! 라는 의미 전달할 수 있음
		
		
		/*
		       ┌→ 파라미터 2개 갖는 evaluate() 있음
	○ XPath 의 『evaluate()』 메소드 두 번째 파라미터
	   - XPathConstants.NODESET : nodeset으로 넘겨줌
	   - XPathConstants.NODE	: 단일노드 넘겨줌
	   - XPathConstants.BOOLEAN : 속성에대한 결과값을 넘겨줌
	   - XPathConstants.NUMBER  : 거기에대한 값을 숫자형태로 넘겨줌
	   - XPathConstants.STRING  : 문자열로 넘겨준다
		  
		 
		 */
		
		for (int i = 0; i < cityNodeList.getLength(); i++)
		{
			
			Node cityNode = cityNodeList.item(i);
			result.add(cityNode.getTextContent());
			
		}
		return result;
	}
	
	
	//날씨 정보 리스트 배열 구성
	public ArrayList<WeatherDTO> weatherList(String idx) throws XPathExpressionException{
		
		ArrayList<WeatherDTO> result = new ArrayList<WeatherDTO>();
		
		NodeList dataNodeList = (NodeList)xPath.compile(String.format("/rss/channel/item/description/body/location[%s]/data", idx)).evaluate(xmlObj, XPathConstants.NODESET);
		//   n번째(인덱스idx)의 location의 데이터를 가져온다.
		
		for (int i = 1; i <= dataNodeList.getLength(); i++)
		{
			//-- tmEf	→ 날짜와 시간 태그	
			String tmEf  = xPath.compile(String.format("/rss/channel/item/description/body/location[%s]/data[%d]/tmEf", idx,i)).evaluate(xmlObj); //%s해도 자동 형변환 되긴함
			//-- wf		→ 날씨 예보 태그
			String wf = xPath.compile(String.format("/rss/channel/item/description/body/location[%s]/data[%d]/wf", idx,i)).evaluate(xmlObj);
			//-- tmn    → 최저 온도 태그
			String tmn = xPath.compile(String.format("/rss/channel/item/description/body/location[%s]/data[%d]/tmn", idx,i)).evaluate(xmlObj);
			//-- tmx    → 최고 온도 태그
			String tmx =xPath.compile(String.format("/rss/channel/item/description/body/location[%s]/data[%d]/tmx", idx,i)).evaluate(xmlObj);
			//-- rnSt	→ 강수 확률 태그
			String rnSt = xPath.compile(String.format("/rss/channel/item/description/body/location[%s]/data[%d]/rnSt", idx,i)).evaluate(xmlObj);
			
			//-- img	→ 날씨 예보에 따른 이미지
			
			WeatherDTO dto = new WeatherDTO();
			dto.setTmEf(tmEf);
			dto.setTmn(tmn);
			dto.setWf(wf);
			dto.setTmx(tmx);
			dto.setRnSt(rnSt);
			dto.setImg(map.get(wf));
			
			result.add(dto);
			
		}
		return result;
	}
	
	
	
	
	
	
}
