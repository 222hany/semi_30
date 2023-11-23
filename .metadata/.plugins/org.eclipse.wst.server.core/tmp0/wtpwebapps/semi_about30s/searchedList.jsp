<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*"
    import="java.sql.*"
    import="semi.main.*"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/searchedList.css">
		<title>가지고 싶은 물건, 가지가지 다~ 있다! 가지마켓</title>
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
				<form class="search-box" action="searchedList.jsp" method="post">
					<input name="searchTitle" class="search-text" type="text" placeholder="찾으시는 상품을 검색하세요.">
	            	<button class="search-button" type="submit"><i class="fas fa-search fa-2x"></i></button>
	        	</form>
				<%
					request.setCharacterEncoding("utf-8");
					String searchTitle = request.getParameter("searchTitle");
					Product product = new Product();
					product.setProductTitle(searchTitle);
					ProductDAO productDAO = new ProductDAO();
					List<Product> products = productDAO.searchList(searchTitle);
				%>
	        	<h4>'<%= searchTitle %>'에 대한 검색 결과</h4>
				<div class="searchList">
					<%
						for(Product p : products){
					%>
					<div class="productBox">
						<p><a href="productDetail.jsp?productNo=<%= p.getProductNo() %>"><img src="<%= p.getProductFile() %>" style="width:288px; height:288px;"></a></p>
						<p id="list_Id"><img src="./img/gazi.png" style="width:20px; height:18px;"><%= p.getAccountId() %></p>
						<p><a id="list_title" href="productDetail.jsp?productNo=<%= p.getProductNo() %>"><%= p.getProductTitle() %></a></p>
						<p id="list_price"><%= p.getProductPrice() %> 원</p>
					</div>
					<%
						}
					%>
				</div>
				<footer>
						<p>회사소개 | 인재채용 | 제휴제안 | 이용약관 | 개인정보처리방침 | 청소년보호정책 | 고객센터 | GAZI Corp.</p>
				</footer>
	        </div>
	    </div>
	</body>
</html>