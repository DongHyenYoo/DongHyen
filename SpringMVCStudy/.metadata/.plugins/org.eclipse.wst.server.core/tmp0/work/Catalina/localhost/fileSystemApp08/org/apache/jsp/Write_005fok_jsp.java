/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.82
 * Generated at: 2022-12-07 02:36:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import java.io.File;

public final class Write_005fok_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1668063564365L));
    _jspx_dependants.put("jar:file:/C:/SpringMVCStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/fileSystemApp08/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098678690000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.oreilly.servlet.multipart.DefaultFileRenamePolicy");
    _jspx_imports_classes.add("com.oreilly.servlet.MultipartRequest");
    _jspx_imports_classes.add("java.io.File");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();

      out.write('\r');
      out.write('\n');


	/*Write_ok.jsp */
	// 파일 업로드, 다운로드에서의 핵심은 multipart request
	// ① 주요 속성 값들 준비 (multipart request 한테 넘길 속성 값들을)
	//어플리케이션 루트 경로 확보
	String root = pageContext.getServletContext().getRealPath("/");
	
	//어플리케이션 루트 경로를 활용하여 업로드 파일의 저장 경로 구성
	String savePath = root + "pds" + File.separator+"saveFile";
								//	 --------------
								//       "\\"
								// 『\\』 대신에 『File.separator』 사용한 것
	
	//파일 객체 생성 → 파일 저장 경로 전달
	File dir = new File(savePath);
	
	// ②경로상 디렉터리가 존재하지 않으면 생성한다.
	if(!dir.exists())
		dir.mkdirs();
	
	//인코딩 방식과 파일 저장 시 최대 크기 지정
	String encType = "UTF-8";
	int maxFileSize = 5*1024*1024;
	
	// ③ MultipartRequest 구성
	MultipartRequest req = null;
	String urlFile = "";
	
	
	// fileNotFoundException 등등의 여러가지 예외 발생할 수 있어서 try~catch 구성
	
	try
	{
		//multipartRequest 객체의 생성자에 전달하는 인자 리스트
		//→ reqest, 파일저장경로, 최대크기, 인코딩방식, 중복파일명처리정책
		req = new MultipartRequest(request, savePath, maxFileSize, encType, new DefaultFileRenamePolicy());
		
		// ④ 구성한 MultipartRequest 로 부터 필요한 값 얻어내기
		//-- 다 get 하고 있다.
		out.println("작성자 : "+ req.getParameter("userName")+"<br>");
		out.println("제목 : "+ req.getParameter("subject")+"<br>");
		out.println("서버에 저장된 파일명 :" + req.getFilesystemName("uploadFile")+"<br>");
		out.println("사용자 업로드 파일명 :" + req.getOriginalFileName("uploadFile")+"<br>");
		out.println("업로드 파일의 유형 :" + req.getContentType("uploadFile")+"<br>");
	
		//요청 객체(request)를 활용하여 생성한 MultipartRequest 객체로 부터
		// 얻어낸 파일 객체 생성
		File f = req.getFile("uploadFile");
		
		// 파일 객체가 제대로 생성되었다면...
		if(f!=null)
		{
			out.println("업로드 파일의 크기 : " + f.length()+ "Bytes. <br>");
		}
		
		// ⑤ 다운로드 기능을 수행하기 위한 속성을 get 방식으로 처리
		//해당 파일의 URL 구성
		urlFile = "Download.jsp?saveFileName=" + req.getFilesystemName("uploadFile");
		urlFile += "&originalFilename=" + req.getOriginalFileName("uploadFile");
		
	}catch(Exception e)
	{
		System.out.println(e.toString());
	}


      out.write("\r\n");
      out.write("<!-- 구성된 url을 넘겨줌 -->\r\n");
      out.write("<br /><a href=\"");
      out.print(urlFile);
      out.write("\">파일 다운로드</a>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Download.jsp 만들자 -->");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
