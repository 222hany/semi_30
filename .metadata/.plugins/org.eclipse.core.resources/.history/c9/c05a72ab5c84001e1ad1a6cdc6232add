<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.kh.semi.Review" %>
<%@ page import="com.kh.semi.ReviewDAO" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/reviewList.css">
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
	        <div class="innerReviewList">
				<div style="overflow-y:scroll; width: 850px; height:500px;">
					<table border="1">
	        			<tr>
				            <th>번호</th>
				            <th>제목</th>
				            <th>본문</th>
				            <th>작성일</th>
				            <th>작성자</th>
				            <th>조회수</th>
						</tr>
						<%
			            ReviewDAO reviewDAO = new ReviewDAO();
			            List<Review> reviewList = reviewDAO.getAllReviews();
			            for (Review review : reviewList) {
						%>
						<tr>
							<td><center><a href="reviewDetail.jsp?REVIEW_NO=<%=review.getREVIEW_NO()%>"> <%= review.getREVIEW_NO() %> </a></center></td>
							<td><center><a href="reviewDetail.jsp?REVIEW_NO=<%=review.getREVIEW_NO()%>"> <%= review.getREVIEW_TITLE() %></a></center></td>
							<td><center><a href="reviewDetail.jsp?REVIEW_NO=<%=review.getREVIEW_NO()%>"> <%= review.getREVIEW_TEXT() %></a></center></td>
							<td><center><%= review.getREVIEW_TIME() %></center></td>
							<td><center><a href="reviewDetail.jsp?REVIEW_NO=<%=review.getREVIEW_NO()%>"> <%= review.getACCOUNT_ID() %></a></center></td>
							<td><center><%= review.getREVIEW_HIT()%></center></td>
						</tr>
							<%
							}
							%>
					</table>
				</div>
				<div class="returnMain">
	        	<a href="reviewList.jsp">
	        		<img src="./img/goToMain.jpg" width="300px">
        		</a>
	        	</div>
			</div>
			<foot>
				<div>
					<button class = "btn1"><a href="reviewPost.jsp">생성</a></button>
				</div>
			</foot>
			<footer>
	        </footer>
	        </div>
	    </div>
	</body>
</html>