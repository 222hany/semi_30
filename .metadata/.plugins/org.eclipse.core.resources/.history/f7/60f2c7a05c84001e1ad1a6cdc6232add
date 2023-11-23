<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.semi.Review"%>
<%@ page import="com.kh.semi.ReviewDAO"%>   
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/reviewDelete.css">
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
        	<%
			String reviewNoValue = (String)request.getParameter("REVIEW_No");
	        int reviewNo = Integer.parseInt(reviewNoValue);
			ReviewDAO rDAO = new ReviewDAO();
			int result =  rDAO.deleteReview(reviewNo);
	        if(result>0){
	       	%>
	        	<script type="text/javascript">
	        		alert("게시글 삭제 성공");
	        		location.href="reviewList.jsp";
	        	</script>
	        <%
	        } else {
	        %>
	        
	        <script type="text/javascript">
	        	alert("게시글 삭제 실패");
	        	location.href="reviewList.jsp";
	        </script>
	        <%
	        }
	        %>
			<footer>
	        </footer>
	        </div>
	    </div>
	</body>
</html>