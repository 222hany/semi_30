<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="semi.mypage.*" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/product-styles.css">
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
             	<li><a id="li_link" href="BoardList.jsp" style="text-decoration: none;">자유게시판</a></li>
	            <li><a id="li_link" href="reviewList.jsp" style="text-decoration: none;">리뷰게시판</a></li>
	            <li><a id="li_link" href="QnAList.jsp" style="text-decoration: none;">문의게시판</a></li>
	            <li><a id="li_link" href="productRetrieve.jsp" style="text-decoration: none;">마이페이지</a></li>
	         </ul>
        </nav>
	</div>
	<div class="contents">
<div class="sidebar">
		<p class="para"><a href="changePassword.jsp" class="links">비밀번호 변경</a></p>
		<p class="para"><a href="deleteAccount.jsp" class="links">회원 탈퇴</a></p>
		<p class="para"><a href="productRetrieve.jsp" class="links">상품 조회</a></p>
		<p class="para"><a href="productRegister.jsp" class="links">상품 등록</a></p>
	</div>
	<div class="main">
		<div class="detail-main">
			<%
				String productIdValue = (String)request.getParameter("productNo");
				int productNo = Integer.parseInt(productIdValue);
				
				ProductDAO productDAO = new ProductDAO();
				ProductVO product = productDAO.getProductByNo(productNo);
				
   				if (product != null) {
			%>
			<img src="<%= product.getProductFile() %>" class="detail-img">
			<p class="detail-title"><%= product.getProductTitle() %></p>
			<p class="detail-text"><%= product.getProductText() %></p>
			<p class="detail-category"><%= product.getProductCategory() %></p>
			<p class="detail-price"><%= product.getProductPrice() %> 원</p>
			<p class="detail-id">작성자 : <%= product.getAccountId() %></p><br>
			<button type="button" class="detail-btn" onclick="location.href='productRetrieve.jsp'">목록</button>
			<button type="button" class="detail-btn" onclick="location.href='productUpdate.jsp?productNo=<%= product.getProductNo() %>'">수정</button>
			<button type="button" class="detail-btn" onclick="location.href='productDelete.jsp?productNo=<%= product.getProductNo() %>'">삭제</button>
			<%
   				} else {
			%>
      		<p>product is null</p>
			<%
   			}
			%>
		</div>
	</div>
	</div>
	<footer>
	<p>회사소개 | 인재채용 | 제휴제안 | 이용약관 | 개인정보처리방침 | 청소년보호정책 | 고객센터 | GAZI Corp.</p>
	</footer>
	</div>
	</div>
</body>
</html>