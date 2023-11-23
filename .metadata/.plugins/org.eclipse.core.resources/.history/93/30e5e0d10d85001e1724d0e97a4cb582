<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="com.kh.semi.Review"%>
<%@ page import="com.kh.semi.ReviewDAO"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/reviewDetail.css">
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
			String reviewNoValue = (String) request.getParameter("REVIEW_NO");
			int reviewNo = Integer.parseInt(reviewNoValue);
			ReviewDAO reviewDao = new ReviewDAO();
			Review review = reviewDao.getReviewNo(reviewNo);
		%>
			<div class="mainform">
				<p class="maintable">
					<br>번호 : <%=review.getREVIEW_NO()%><br>
					제목 : <%=review.getREVIEW_TITLE()%><br>
					내용 : <%=review.getREVIEW_TEXT()%><br>
					사용자ID : <%=review.getACCOUNT_ID()%><br>
					작성시간 : <%=review.getREVIEW_TIME()%>
				</p>
				<div class="buttons">
						<button class="btn1" id="listButton"><a href ="reviewList.jsp">목록</a></button>
						<button class="btn1" id="updateButton" onclick="location.href='reviewUpdate.jsp?REVIEW_No=<%=reviewNo%>'">수정</button>
						<form action="reviewDelete.jsp?REVIEW_No=<%=reviewNo%>" method="post">
							<button class="btn1" type="submit" id="deleteButton" onclick="Location.href='reviewDelete.jsp?REVIEW_NO=<%=reviewNo%>'">삭제</button>
						</form>
				</div>
			</div>
			<div class="returnMain">
	        	<a href="reviewList.jsp">
	       			<img src="./img/goToMain.jpg" width="120px">
	       		</a>
       		</div>
	        </div>
	    </div>
	</body>
	<footer>
	<p>회사소개 | 인재채용 | 제휴제안 | 이용약관 | 개인정보처리방침 | 청소년보호정책 | 고객센터 | GAZI Corp.</p>
	</footer>
</html>