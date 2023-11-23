<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.kh.semi.Review" %>
<%@ page import="com.kh.semi.ReviewDAO" %>
<!DOCTYPE html>
<html>
	<head>
    	<meta charset="UTF-8">
    	<title>게시글 검색</title>
    	<link rel="stylesheet" type="text/css" href="css/reviewSearch.css">
		<script src="https://kit.fontawesome.com/def66b134a.js" crossorigin="anonymous"></script>
	</head>
	<body>
		<div class="inner">
			<p class="login-join-link"><a href="login.jsp">로그인</a> &nbsp;&nbsp; <a href="register.jsp">회원가입</a></p>
	    	<header>
	        	<div class="logo">
	            	<p class="gajimarket"><a href="reviewList.jsp">가지마켓</a></p>
	            </div>
	            <div class="mascot">
	            	<a href="reviewList.jsp"><img src="img/gajidori.png" alt="gajidori" class="gajidori"></a>
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
	        <!--
	        <div class="search-box">
            <input type="text" class="search-text" placeholder="찾으시는 상품을 검색하세요.">
            <a class="search-button" href="#"><i class="fas fa-search"></i></a>
        	</div>
        	-->
			<div class="innerReviewSearch">
				<form action="SearchServlet" method="post" enctype="multipart/form-data">
				<label for="REVIEW_TITLE">제목</label>
				<input type="text" placeholder='제목을 검색해주세요.' id="REVIEW_TITLE" name="REVIEW_TITLE"><br>
				<label for="ACCOUNT_ID">ID</label>
				<input type="text" placeholder='아이디를 검색해주세요.' id="ACCOUNT_ID" name="ACCOUNT_ID"><br><br>
					<div class="buttons">
						<button class="btn1"><a href ="reviewList.jsp">목록</a></button>
						<button class="btn3"><a href ="reviewList.jsp">취소</a></button>
						<button class="btn3" type="submit" onclick="searchbutton()">검색</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>