/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.82
 * Generated at: 2023-11-23 03:39:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("    	<meta charset=\"UTF-8\">\r\n");
      out.write("        <title>가지마켓 : 회원가입</title>\r\n");
      out.write("        <link rel=\"icon\" href=\"data:;base64,iVBORw0KGgo=\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/register.css\">\r\n");
      out.write("        <script>\r\n");
      out.write("	        function submitPassword(){\r\n");
      out.write("	        	var account_id = document.getElementById(\"account_id\").value;\r\n");
      out.write("	        	var idPattern = /^[A-za-z0-9]{5,20}$/\r\n");
      out.write("	            var password = document.getElementById(\"password\").value;\r\n");
      out.write("	            var confirmPassword = document.getElementById(\"confirmPassword\").value;\r\n");
      out.write("	            var passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,32}$/\r\n");
      out.write("	            var errorMsg = document.getElementById(\"pm\");\r\n");
      out.write("	            \r\n");
      out.write("	            //id가 영문,숫자를 포함하지 않을 경우\r\n");
      out.write("	            if(!account_id.match(idPattern)){\r\n");
      out.write("	            	errorMsg.textContent = \"※아이디는 5 ~ 20자의 영문 대문자, 소문자, 숫자를 포함해야합니다.\";\r\n");
      out.write("	            	return false;\r\n");
      out.write("	            }else{\r\n");
      out.write("	            	errorMsg.textContent = \"\";\r\n");
      out.write("	            }\r\n");
      out.write("	            \r\n");
      out.write("	            //비밀번호가 영문, 숫자, 특문을 포함하지 않을 경우\r\n");
      out.write("	            if(!password.match(passwordPattern)){\r\n");
      out.write("	            	errorMsg.textContent = \"※비밀번호는 8 ~ 32자의 영문 대문자, 소문자, 특수문자, 숫자를 포함해야합니다.\";\r\n");
      out.write("	                return false;\r\n");
      out.write("	            }else{\r\n");
      out.write("	            	errorMsg.textContent = \"\";\r\n");
      out.write("	            }\r\n");
      out.write("	            \r\n");
      out.write("	            //비밀번호가 일치하지 않을 경우\r\n");
      out.write("	            if(password !== confirmPassword){\r\n");
      out.write("	            	errorMsg.textContent = \"※비밀번호가 일치하지 않습니다.\";\r\n");
      out.write("	                return false;\r\n");
      out.write("	            }else{\r\n");
      out.write("	            	errorMsg.textContent = \"\";\r\n");
      out.write("	            }\r\n");
      out.write("	            return true;\r\n");
      out.write("	        }\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"join-box\">\r\n");
      out.write("            <p id=\"necessity\">*필수입력사항</p>\r\n");
      out.write("            <h2>회원가입</h2>\r\n");
      out.write("            <form action=\"JoinServlet\" method=\"post\" onsubmit=\"return submitPassword()\">\r\n");
      out.write("                <div class=\"items\">\r\n");
      out.write("                    <label for=\"account_id\">아이디*</label><br>\r\n");
      out.write("                    <label for=\"password\">비밀번호*</label><br>\r\n");
      out.write("                    <label for=\"confirmPassword\">비밀번호 확인*</label><br>\r\n");
      out.write("                    <label for=\"user_name\">이름*</label><br>\r\n");
      out.write("                    <label for=\"email\">이메일</label><br>\r\n");
      out.write("                    <label for=\"phonenumber\">연락처</label><br>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"blanks\">\r\n");
      out.write("                    <input type=\"text\" id=\"account_id\" name=\"account_id\" placeholder=\"영문 소문자, 숫자 사용하여 5~20자.\" required><br>\r\n");
      out.write("                    <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"영문 대/소문자, 숫자, 특수문자 사용하여 8~32자.\" required><br>\r\n");
      out.write("                    <input placeholder=\"비밀번호를 한번 더 입력해주세요.\" type=\"password\" id=\"confirmPassword\" name=\"confirmPassword\" required><br>\r\n");
      out.write("                    <input type=\"text\" id=\"user_name\" name=\"user_name\" placeholder=\"이름을 입력해주세요.\" required><br>\r\n");
      out.write("                    <input type=\"email\" id=\"email\" name=\"email\" placeholder=\"이메일을 입력해주세요.\" required><br>\r\n");
      out.write("                    <input type=\"text\" id=\"phonenumber\" name=\"phonenumber\" placeholder=\"-없이 숫자만 입력해주세요.\" required><br>\r\n");
      out.write("                </div>\r\n");
      out.write("                <button type=\"submit\">가입완료</button>\r\n");
      out.write("            </form>\r\n");
      out.write("            <p id=\"pm\"></p>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
