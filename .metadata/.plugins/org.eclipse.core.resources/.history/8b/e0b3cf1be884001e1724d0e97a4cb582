<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="semi.qna.QnADAO" %>
<%@ page import="semi.qna.QnAVO" %>
<%@ page import="semi.qna.QnADeleteServlet" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/mainpage.css">
	<title>가지고 싶은 물건, 가지가지 다~ 있다! 가지마켓</title>
	<script src="https://kit.fontawesome.com/def66b134a.js" crossorigin="anonymous"></script>
	</head>

	<body>
		<div class="wrap">
	        <div class="inner">
		        <div>
				<%
			        if (session.getAttribute("USER_NAME") != null) {
			    %>
			        
			    <%-- 세션에서 사용자 이름 가져오기 --%>
			    <% String user_name = (String)session.getAttribute("USER_NAME"); %>
			    
			    <p class="sessionState"><%= user_name %>님 환영합니다! &nbsp;&nbsp;<a href="logout.jsp">로그아웃</a></p>
			    <%
			        } else {
			    %>
				<p class="sessionState"><a href="login.jsp">로그인</a> &nbsp;&nbsp; <a href="register.jsp">회원가입</a></p>
			    <%
			        }
			    %>
	                <header>
	                    <div class="logo">
	                        <a href="mainpage.jsp" style="text-decoration: none;"><p class="gajimarket">가지마켓</p></a>
	                    </div>
	                    <div class="mascot">
	                        <a href="mainpage.jsp"><img src="./img/gajidori.png" alt="gajidori" class="gajidori"></a>
	                    </div>
	                </header>
	                <nav>
	                    <ul>
	                        <li><a>자유게시판</a></li>
	                        <li><a>리뷰게시판</a></li>
	                        <li><a href="QnAList.jsp">문의게시판</a></li>
	                        <li><a href="productRetrieve.jsp">마이페이지</a></li>
	                    </ul>
	                </nav>
		        </div>
        
		<h1>게시글 상세 정보</h1>
		<%
			//String = id 값을 가지고 오겠다.
			String qnaNoValue = request.getParameter("qnaNo");
			int qnaNo = (qnaNoValue != null && !qnaNoValue.isEmpty())?Integer.parseInt(qnaNoValue):0;
			// DAO 작업
			QnADAO qnaDao = new QnADAO();
			QnAVO qna = qnaDao.getQnaNo(qnaNo);
		%>
		<p>
		<% if (qna != null) { %>
		사용자 ID : <%=qna.getAccountID() %><br>
		제목 : <%=qna.getQnaTitle() %><br>
		내용 : <%=qna.getQnaText() %><br>
		작성 시간 : <%=qna.getQnaTime() %>
		<% }else{ %>
		not post.
		<% } %>
		</p>
		
		<form action="QnADelete.jsp?qnaNo=<%=qnaNo%>" method="post">
			<button type="submit" id="deleteButton" onclick="Location.href='QnADelete.jsp?qnaNo=<%=qnaNo%>'">삭제</button>
		</form>
		
		<button id="updateButton" onclick="location.href='QnAUpdate.jsp?qnaNo=<%=qnaNo%>'">수정</button>
		
		
	        <footer>
	        </footer>
	        </div>
	    </div>
	</body>
</html>