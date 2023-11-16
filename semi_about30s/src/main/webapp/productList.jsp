<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*"
    import="semi.main.*"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/productList.css">
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
	                        <li><a>자유게시판</a></li>
	                        <li><a>리뷰게시판</a></li>
	                        <li><a>문의게시판</a></li>
	                        <li><a>마이페이지</a></li>
	                    </ul>
	                </nav>
		        </div>
				<form class="search-box" action="productList.jsp" method="post">
					<input name="searchTitle" class="search-text" type="text" placeholder="찾으시는 상품을 검색하세요.">
	            	<button class="search-button" type="submit"><i class="fas fa-search fa-2x"></i></button>
	        	</form>
	        	<h2>검색 결과</h2>
				<%
					request.setCharacterEncoding("utf-8");
					String searchTitle = request.getParameter("searchTitle");
					Product product = new Product();
					product.setProductTitle(searchTitle);
					ProductDAO productDAO = new ProductDAO();
					List products = productDAO.listproducts(product);
				%>
				<table>
					<tr>
						<th>게시번호</th>
						<th>작성자</th>
						<th>상품카테고리</th>
						<th>제목</th>
						<th>내용</th>
						<th>가격</th>
					</tr>
					<%
						for(int i=0; i<products.size(); i++){
							Product product1 = (Product)products.get(i);
							int productNo = product1.getProductNo();
							String accountId = product1.getAccountId();
							String productCategory = product1.getProductCategory();
							String productTitle = product1.getProductTitle();
							String productText = product1.getProductText();
							int productPrice = product1.getProductPrice();
					%>
					<tr>
						<td><%= productNo %></td>
						<td><%= accountId %></td>
						<td><%= productCategory %></td>
						<td><%= productTitle %></td>
						<td><%= productText %></td>
						<td><%= productPrice %></td>
					</tr>
					<%
						}
					%>
				</table>
	        <footer>
	        </footer>
	        </div>
	    </div>
	</body>
</html>