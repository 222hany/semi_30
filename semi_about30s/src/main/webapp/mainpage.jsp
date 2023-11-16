<%@ page language="java" contentType="text/html; charset=utf-8"
    import="semi.main.*"
    import="java.util.*"
    import="java.sql.*"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/mainpage.css">
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
	                        <li><a id="li_link">자유게시판</a></li>
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
	        		Product product = new Product();
	        		ProductDAO productDAO = new ProductDAO();
	        		List<Product> products = productDAO.mainList();
	        	%>
	        	<table>
					<%
						for(Product p : products){
					%>
					<tr>
						<td><img src="<%= p.getProductFile() %>" style="width:300px; height:200px;"></td>
					</tr>
					<tr>
						<td><%= p.getAccountId() %></td>
					</tr>
					<tr>
						<td><%= p.getProductTitle() %></td>
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