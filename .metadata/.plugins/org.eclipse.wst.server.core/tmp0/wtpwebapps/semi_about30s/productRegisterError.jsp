<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img src="./img/gazigun_error.png">
	<p>상품 등록에 실패했습니다.</p>
	<%
		response.setHeader("Refresh", "3; url=productRetrieve.jsp");
	%>
</body>
</html>