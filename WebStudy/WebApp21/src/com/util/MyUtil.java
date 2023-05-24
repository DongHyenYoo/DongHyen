/*==================
   MyUtil.java
   - 게시판 페이징 처리
==================*/

/*
 check~!!
 지금 같이 확인해보고자 하는 페이징 처리 기법은
 다양한 방법들 중 한 가지(그나마 가장 기본적이고 쉬운 것을 골라..) 이다.
 학습을 마친 이후에..
 꼭 추가적으로 개념을 정리하고 확장시키고, 
 다른 방법들도 찾아보고 공부해야 할 것이다.
*/

package com.util;

public class MyUtil
{
   // ■ 전체 페이지 수를 구하는 메소드
   // numPerPage : 한 페이지에 표시할 데이터(게시물)의 수 
   // dataCount : 전체 데이터(게시물) 수
   public int getPageCount(int numPerPage, int dataCount)
   {
      int pageCount = 0;
      
      pageCount = dataCount / numPerPage;
      
      if(dataCount % numPerPage != 0)
         pageCount++;
      
      return pageCount;
   }
   //-- 한 페이지에 10 개의 게시물을 출력할 때
   //   총 32 개의 게시물을 페이지로 구성하기 위해서는
   //   『32 / 10』 의 연산을 수행하여 결과 3을 얻을 수 있다.
   //   → 『pageCount = dataCount/numPerPage;』
   //   그런데 이 때, 나머지 2개의 게시물을 출력해주기 위해서는
   //   페이지 하나가 더 필요하다.
   //    → pageCount++;
   
   
   // ■ 페이징 처리 기능의 메소드
   // currentPage : 현재 표시할 페이지
   // totalPage : 전체 페이지 수
   // listUrl : 링크를 설정할 url
   public String getIndexList(int currentPage, int totalPage, String listUrl)
   {
      // 실제 페이징을 문자열 형태로 저장할 StringBuffer 변수 
      StringBuffer strList = new StringBuffer();
      
      int numPerBlock = 10;
      //-- 페이징 처리 시 게시물 리스트 하단의 숫자를 10개씩 보여주겠다.
      int currentPageSetup;
      //-- 현재 페이지 (이 페이지를 기준으로 구성하여 보여주는 숫자가 달라져야 하기 때문)
      int page;
      int n;
      //-- 이전 페이지 블럭과 같은 처리에서 이동하기 위한 변수
      //   (얼마만큼 이동해야 하는지)
      
      // 페이징 처리가 별도로 필요하지 않은 경우
      //-- 데이터가 존재하지 않거나 데이터의 수가 
      //   1 페이지라도 못 채우는 경우는 별도로 페이징 처리를 할 필요가 없다.
      if(currentPage == 0)
         return "";
      
      // 페이지 요청을 처리하는 과정에서
      // URL 경로의 패턴에 대한 처리
      /*
           - List.jsp
           - → List.jsp + 『?』
           
           - List.jsp?키1=값1
           - List.jsp?키1=값1&키2=값2 
           - → List.jsp?키1=값1 + 『&』 
           - → List.jsp?키1=값1&키2=값2 + 『&』
       */
      
      if(listUrl.indexOf("?") != -1)   // 링크 설정할 URL 에 『?』가 들어있으면
         listUrl = listUrl + "&";
      else                     // 링크 설정할 URL 에 『?』가 없으면
         listUrl = listUrl + "?";
      //-- 예를들어, 
      //   검색값이 존재하면 이미 request 값에
      //   searchKey 값과 searchValue 값이 들어있는 상황이므로
      //   『&』를 붙여서 추가해주어야 한다.
      
      // currentPageSetup = 표시할 첫 페이지 - 1
      currentPageSetup = (currentPage / numPerBlock) * numPerBlock;
      //-- 만약 현재 페이지가 5 페이지이고 (currentPage = 5)
      //   리스트 하단에 보여줄 페이지 개수가 10이면 (numPerBlock = 10)
      //   『5 / 10 = 0』 이며, 여기에 『* 10』(10을 곱해도) 0 이다.
      //   하지만, 현재 페이지가 11페이지라면 (currentPage = 11)
      //   『11 / 10 = 1』 이며, 여기에 『* 10』(10을 곱하면) 10 이다.
      //   그러면 currentPageSetup 은 10이 되는 것이다.
      
      if(currentPage % numPerBlock == 0)
         currentPageSetup = currentPageSetup - numPerBlock;
      //만약 위처리(라인 88)에서
      // 현재 페이지가 20페이지였다면(currentPage==20)
      //currentPageSetUp은 20이 나오므로  11~20이 나올수 있도록
      //20-10으로 10으로 셋해준다.
  
      
      //1페이지
      if( (totalPage > numPerBlock) && (currentPageSetup > 0) )
         strList.append(" <a href='" + listUrl + "pageNum=1'>1</a>");
      //listUrl은 전처리가 이미 끝난상황이라 끝에 ? or ?...&가 붙어있다.
      
      
      
      //이전페이지로 돌아가는 부분을 담당함
      n= currentPage - numPerBlock;
      //n은 해당 페이지만큼 앞으로(30~40 -> 20~29페이지로 가기위한 변수)
      if( (totalPage > numPerBlock) && (currentPageSetup > 0) )
         strList.append(" <a href='" + listUrl + "pageNum=" + n + "'>Prev</a>");
      //currentPageSetup이 0보다크다라는 조건이 있는데 
      //이 조건은 현재 10페이지 이상이라는 의미이며
      //이때 현재 페이지(currentPage)가 11페이지 이상일경우
      // Prev를 붙이기 위한 내용이다.
      // Prev를 클릭할 경우
      //n 변수 페이지로 이동하게 되는데
      // 12에서 prev할 경우
      // 2페이지가 된다.
      //또한 22페이지에서 prev할경우 12페이지가 된다.
      
      
      //실제로 화면에서 밑에 그려지는 페이지들
      page = currentPageSetup +1;
      // + 1 을 하는 이유는
      //앞의 currentPageSetup 에서 10을 가져왔다면
      // 실제 그려주어야하는 바로가기 페이지는 11부터 시작해야 하기 때문임
      
      
      while( (page <= totalPage) && (page <= currentPageSetup + numPerBlock) )
      {
         if (page == currentPage)
            strList.append(" <span style='color:orange; font-weight:bold;'>" + page + "</span>");
         else
            strList.append(" <a href='" + listUrl + "pageNum=" + page + "'>" + page + "</a>");
         
         page++;
         
       //currentPageSetup : 20
       //currentPAge : 23
       // -> <a>21</a> 22 <a>23</a> <a>24</a> <a>25</a> <a>26</a> <a>27</a> <a>28</a>
       
         
      }
      
      // Next
      n = currentPage + numPerBlock;
      if ( (totalPage - currentPageSetup) > numPerBlock )
         strList.append(" <a href='" + listUrl + "pageNum=" + n + "'>Next</a>");
      
      // 마지막 페이지
      if ( (totalPage > numPerBlock) && ( (currentPageSetup + numPerBlock) < totalPage ))
         strList.append(" <a href='" + listUrl + "pageNum=" + totalPage + "'>" + totalPage + "</a>");
      
      return strList.toString();
      
   } // end getIndexList(int currentPage, int totalPage, String listUrl)
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}