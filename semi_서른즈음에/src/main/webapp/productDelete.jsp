<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="semi.mypage.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>
	<%
		String productIdValue = (String)request.getParameter("productNo");
		int productNo = Integer.parseInt(productIdValue);
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.deleteProduct(productNo);
	%>
	<p>삭제 완료</p>
	<%	
		response.setHeader("Refresh", "1; url=productRetrieve.jsp");
	%>
</body>
</html>