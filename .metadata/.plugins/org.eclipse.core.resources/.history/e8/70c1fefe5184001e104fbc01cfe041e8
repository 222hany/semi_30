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
		<title>게시물 상세페이지</title>
		<link rel="stylesheet" type="text/css" href="css/QnAstyles.css">
	</head>
	<body>
        <p id="login-join-link">로그인 회원가입</p>
        <header>
            <div id="logo">
                <p id="gajimarket">가지마켓</p>
            </div>
            <div id="mascot">
                <img src="img/gajidori.png" alt="gajidori" id="gajidori">
            </div>
        </header>
		<nav>
            <ul>
                <li><a>자유게시판</a></li>
                <li><a>리뷰게시판</a></li>
                <li><a>문의게시판</a></li>
                <li><a>마이페이지</a></li>
            </ul>
        </nav>
        
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
		
		
	</body>
</html>