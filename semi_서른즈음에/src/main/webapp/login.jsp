<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>가지마켓 : 로그인</title>
		<link rel="stylesheet" type="text/css" href="./css/login.css">
	</head>

	<body>
		<div class="login-box">
            <h2>로그인</h2>
            <form action="LoginLogoutServlet" method="post">
                <div class="items">
                    <label for="accountId">아이디</label><br>
                    <label for="password">비밀번호</label><br>
                </div>
                <div class="blanks">
                    <input placeholder="아이디를 입력해주세요." type="text" id="accountId" name="accountId" required><br>
                    <input placeholder="비밀번호를 입력해주세요." type="password" id="password" name="password" required><br>
                </div>
                <button id="login_button" type="submit">로그인</button>
                <button id="join_button" type="button" onclick="location.href='register.jsp'">회원가입</button>
            </form>
        </div>
	</body>
</html>