<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "semi.qna.QnADAO" %>
<%@ page import="semi.qna.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글 삭제</title>
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
        
        <%
		String qnaNoValue = (String)request.getParameter("qnaNo");
        int qnaNo = Integer.parseInt(qnaNoValue);
		QnADAO dao = new QnADAO();
		int result =  dao.delete(qnaNo);
        if(result>0){
       	%>
        	<script type="text/javascript">
        		alert("글 삭제 성공");
        		location.href="QnAList.jsp";
        	</script>
        <%
        } else {
        %>
        
        <script type="text/javascript">
        	alert("글 삭제 실패");
        	location.href="QnAList.jsp";
        </script>
        <%
        }
        %>
        
	</body>
</html>