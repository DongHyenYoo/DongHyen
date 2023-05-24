/*=================================================
    XmlDomTest02.java
    - 콘솔 기반 자바 프로그램
    - XML DOM 활용 → 로컬(Local) XML 읽어내기
        (memberList.xml)
 ==================================================*/
/*
 김태민 010-1212-3434
 유동현 010-7878-8989
 */

package com.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlDomTest02
{
   public static void main(String[] args)
   {
      //1.XML 파일 (memberList.xml)을 메모리에 로드
      //    → XML DOM 생성
      //2.루트 엘리먼트 접근
      //    → memberList
      //3.루트 엘리먼트의 특정 하위 엘리먼트 접근
      //    → 위치, 이름 등을 기준으로 접근
      //4.텍스트 노드(속성 노드) 접근
      //    → 원하는 데이터 얻어내기
      //5.결과 출력
      
      try
      {
         //1. XML 파일을 메모리에 로드 → XML DOM형성
         //   DocumentBuilderFactory → DocumentBuilder →XML
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();
         //팩토리로부터 새로운 도큐먼트를 얻어내는 빌더를 찍어냄
         Document xmlObj = null;
         //빌더를 활용해서 XML객체를 얻어내려고함
         
         String url="memberList.xml";
         xmlObj = builder.parse(url);
         //문서를 넘겨서 XML객체를 읽어냈음
         
         //2. 루트 엘리먼트 접근 
         Element root = xmlObj.getDocumentElement();
		//		                get + documentElement
		//-- 문서의 대표 엘리먼트(루트 엘리먼트)를 얻어내는 과정
		
		// 테스트
		//System.out.println(root.getNodeName());
		//--==>> memberList
         
         
         //루트 엘리먼트를 활용하여 특정 하위 엘리먼트에 접근
         //멤버 인포들에 접근 하는 것
         NodeList memberInfoNodeList = root.getElementsByTagName("memberInfo");
         //-- 이 때, 『getElementByTagName()』메소드는
         //    태그의 이름을 가지고 자식이나 자손 노드에 접근하는 메소드
         //                      (특정 노드)
         
         // ※ 이렇게 얻어낸 NodeList  객체를 구성하는 Node의 갯수를
         //     『getLength()』메소드를 통해 확인할 수 있다.
         
			  // ※ check~!!!
			//    XML 의 모든 노드는 루트 엘리먼트 하위에 존재~!!!!!
			
			// 이렇게 얻어낸 NodeList 객체에 포함되어 있는 Node 의 개수를 
			// 『getLength()』 메소드를 통해 확인할 수 있다.
         
         
         //확인
         //System.out.println(memberInfoNodeList.getLength());
         //--==>>2
         
         for(int i=0; i<memberInfoNodeList.getLength(); i++)      // 0~1
         {
            Node memberInfoNode = memberInfoNodeList.item(i);
            //--『getElementsByTagName()』메소드가 이름을 통해 대상을 획득하는 과정을 수행했다면,
            //   『item()』 메소드는 위치(인덱스)를 통해 대상을 획득하는 과정을 수행하게 된다.
         
            //캐스팅
            Element memberInfoElement = (Element)memberInfoNode;
          //-- 엘리먼트가 노드의 하위 개념이기 때문에 가능한 구문
            
            
            System.out.printf("%s %s\n"
			 		 , getText(memberInfoElement, "name")
			 		 , getText(memberInfoElement, "telephone")
			 		 );
            
            NodeList curriculumnNodeList = memberInfoElement.getElementsByTagName("curriculumn");
            //System.out.println(curriculumnNodeList.getLength());
            //  커리 큘럼이 있으면 1 없으면 0이나옴
            
            if(curriculumnNodeList.getLength()>0)  //커리큘럼이라는 노드가 존재한다면
            {
            Node curriculumnNode = curriculumnNodeList.item(0); //커리큘럼
            Element curriculumnElement = (Element)curriculumnNode;
            
            NodeList subNodeList =  curriculumnElement.getElementsByTagName("sub");
            //System.out.println(subNodeList.getLength());
            //태민 3  동현 nullpointError = 당연히 동현은 sub가 없으므로
            
            	for(int j=0;j<subNodeList.getLength();j++)
            	{
            		Node subNode = subNodeList.item(j);
            		Element subElement = (Element)subNode;
            		System.out.printf("%s\n", subElement.getTextContent());
            	}
            }
            
         }
         
         
         /*
         // 커리큘럼에 대한 처리 추가 --------------------------------------------------
				// 하나의 반복문 → 하나의 memberInfo를 처리하는 과정
				// 커리큘럼 있는 사람도 있고, 없는 사람도 있음
				// → memberInfo 안에서 처리해야되는 내용
				
				// memberInfo 엘리먼트로부터 name, telephone 에는 접근했고,
				// 이제는 name, telephone 와 똑같은 방법으로 curriculum에 접근하면 됨
				
				// memberInfoElement 로 부터 curriculumn NodeList 얻어오기
				NodeList curriculumnNodeList = memberInfoElement.getElementsByTagName("curriculumn");
				//--> 나중에는 xml 익숙해지면 이름들 몰라도 가져와서 처리하는 거 얼마든지 가능함
				
				// curriculumn 있는 경우도 있고, 없는 경우도 있기 때문에 
				// 조건문 통해서 작성
				// check~!!!
				if (curriculumnNodeList.getLength() > 0)
				{
					Node curriculumnNode = curriculumnNodeList.item(0);
					Element curriculumnElement = (Element)curriculumnNode;
					
					// subject 처리하는 방법 2가지로 나눠서 보자
					// 방법 1.
					/*
					NodeList subNodeList = curriculumnElement.getElementsByTagName("sub");
					for (int m=0; m<subNodeList.getLength(); m++)
					{
						Node subNode = subNodeList.item(m);
						Element subElement = (Element)subNode;
						System.out.printf("%s ", subElement.getTextContent());
						//--==>>
						//김상기 010-1213-4546
						//JAVA SE ORACLE Servlet&JSP 
						//김민성 010-5678-6789
					 */
					
					// ★방법 2. Node Type 이용하는 방법
					// → 실제로 우리가 알면 더 좋은 방법
					/*
					-----------------------------------------------------
					Node Type		Named Constant
					-----------------------------------------------------
					  1				ELEMENT_NODE
					  2				ATTRIBUTE_NODE
					  3				TEXT_NODE
					  4				CDATA_SECTION_NODE
					  5				ENTITY_REFERENCE_NODE
					  6				ENTITY_NODE
					  7				PROCESSING_INSTRUCTION_NODE
					  8				COMMENT_NODE
					  9				DOCUMENT_NODE
					 10				DOCUMENT_TYPE_NODE
					 11				DOCUMENT_FRAGMENT_NODE
					 12				NOTATION_NODE
					 13
					----------------------------------------------------- 
					*/
					/*
					//커리큘럼의 자식노드로부터 자식을 얻어냄
					NodeList subNodeList = curriculumnElement.getChildNodes();			// check~!!!
					//-- 결과적으로 NodeList 얻어낸다는 건 똑같음
					
					//테스트
					//System.out.println(subNodeList.getLength());
					//-->> 7
					
					for (int m = 0; m < subNodeList.getLength(); m++)
					{
						Node subNode = subNodeList.item(m);
						
						// Node Type 을 체크해서 접근하는 방법
						// 특정노드.getNodeType() 의 NodeType 번호
						if (subNode.getNodeType() == 1 )		// ELEMENT_NODE			// check~!!!
						{
							Element subElement = (Element)subNode;
							System.out.printf("%s", subElement.getTextContent());
						}
						System.out.println();
					}
					
				}
				
				
				
				// -------------------------------------------------- 커리큘럼에 대한 처리 추가  
          
         */
          
         
         
      } catch (Exception e)
      {
         System.out.println(e.toString());
      }
   }
   
   
   private static String getText(Element parent, String tagName)
   {
	   
	   String result = "";
	   
	   //대상 태그(tagName) 객체의 첫 번째 자식 노드 얻어오기
	   Node node = parent.getElementsByTagName(tagName).item(0);
	   Element element = (Element)node;
	   
	   //대상 엘리먼트(element)의 자식 노드(텍스트 노드)의 값 얻어오기
	   result = element.getChildNodes().item(0).getNodeValue();
	   //item 1~ 어떤게 들어있을까? 도 혼자 해보자
	   
	   return result;
   }
   
   
}