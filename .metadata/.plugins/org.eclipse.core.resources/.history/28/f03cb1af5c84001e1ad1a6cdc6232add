<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.semi.ReviewUpdateServlet" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/reviewUpdate.css">
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
			<div class="innerReviewUpdate">
				<form action="ReviewUpdateServlet" method="post" enctype="multipart/form-data">
					<label for="REVIEW_TITLE">제목</label>
	                <input type="text" placeholder='제목을 수정해주세요.' id="REVIEW_TITLE" name="REVIEW_TITLE" required><br>
	
	                <label for="REVIEW_TEXT">내용</label>
	                <textarea rows="5" placeholder='내용을 수정해주세요.' id="REVIEW_TEXT" name="REVIEW_TEXT" required></textarea><br><br>
					
					<label for="REVIEW_NO">번호</label>
	                <input type="text" placeholder='수정할 게시글의 번호를 입력해주세요.' id="REVIEW_NO" name="REVIEW_NO" required><br><br>
					<div>
						<button class="btn1"><a href ="reviewList.jsp">목록</a></button>
						<button class="btn3"><a href ="reviewList.jsp">취소</a></button>
						<button class="btn3" type="submit" onclick="updatebutton()">수정</button>
					</div>
	            </form>
	        </div>
	        <div class="returnMain">
	        	<a href="reviewList.jsp">
	        		<img src="./img/goToMain.jpg" width="300px">
        		</a>
        	</div>
		 	<footer>
	        </footer>
	        </div>
	    </div>
	</body>
</html>
