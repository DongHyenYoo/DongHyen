/*================================================
 	XMLDomTest05.java
 	- 콘솔 기반 자바 프로그램
 	- XML DOM 활용 → 로컬(local) XML 읽어내기
 	  (rss.xml)
 	  ※ 기상청 날씨누리로부터 얻어낸 데이터
=================================================*/

package com.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlDomTest05
{
	
	public static void main(String[] args)
	{
		
		
		try
		{
			// 1. XML 파일 메모리에 로드
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			String url = "rss.xml";
			Document xmlObj = builder.parse(url);
			
			
			// 2. 루트 엘리먼트 접근
			Element root = xmlObj.getDocumentElement();
			
			
			// 3-1. 타이틀 추출하기
			Node itemNode = root.getElementsByTagName("item").item(0);
			Element itemElement = (Element)itemNode;
			
			System.out.printf("%s\n\n", XMLDOM.getText(itemElement, "title"));
		
			
			//3-2.기상 현황 추출
			
			Node wfNode = root.getElementsByTagName("wf").item(0);
			Element wfElement = (Element)wfNode;
			
			
			System.out.println("[기상전망] ----------------------------------------------------------------------------------------------------------------------------------------------");
			//System.out.printf("%s\n\n", wfElement.getTextContent());
			//-- 마크업 문서이기 때문에 <br> 다 나옴
			//   → replaceAll() 로 <br /> 기호를 \n 으로 바꾸기
			System.out.printf("%s\n\n", wfElement.getTextContent().replaceAll("<br />", "\n"));
			
			//3-3.도시별 기상 예보 추출하기
			
			NodeList cityNodeList = itemElement.getElementsByTagName("location");
			
			
			//System.out.println("길이"+cityNodeList.getLength());
			//길이35
			
			System.out.println("[육상날씨] -------------------------------------------------");
			//도시 : 서울
			//--------------------
			// 날짜 시간
			// 날씨 예보
			// 최저 온도
			// 최고 온도
			// 강수 확률
			for (int i = 0; i < cityNodeList.getLength(); i++)
			{
				Node cityNode = cityNodeList.item(i);
				Element cityElement = (Element)cityNode;
				
				System.out.printf("\n\n도시 : %s\n\n\n",XMLDOM.getText(cityElement, "city"));
				
				NodeList dataNodeList = cityElement.getElementsByTagName("data");
				//System.out.println(dataNodeList.getLength());
				// 13
				for (int j = 0; j < dataNodeList.getLength(); j++)
				{
					Node dataNode = dataNodeList.item(j);
					Element dataElement = (Element)dataNode;
					System.out.printf("날짜 시간 : %s\n "
							        + "날씨 예보 : %s\n"
							        + "최저~최고온도: %s ~ %s\n"
							        + "강수확률 : %s\n ",XMLDOM.getText(dataElement, "tmEf")
							              ,XMLDOM.getText(dataElement, "wf")
							              ,XMLDOM.getText(dataElement, "tmn")
							              ,XMLDOM.getText(dataElement, "tmx")
							              ,XMLDOM.getText(dataElement, "rnSt")
							              );
					
				}
				System.out.println("--------------------------------------------------------");
			}
			
			System.out.println("--------------------------------------------------------");
			
		}catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		
	}
	
	

}
