<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이페이지 : 회원탈퇴</title>
		<link rel="stylesheet" type="text/css" href="./css/deleteAccount.css">
	</head>

	<body>
		<div class="delete-box">
            <h2>회원탈퇴</h2>
            <form action="DeleteAccountServlet" method="post">
                <div class="items">
                    <label for="account_id">아이디</label><br>
                    <label for="password">비밀번호</label><br>
                </div>
                <div class="blanks">
                    <input placeholder="아이디를 입력해주세요." type="text" id="account_id" name="account_id" required><br>
                    <input placeholder="비밀번호를 입력해주세요." type="password" id="password" name="password" required><br>
                </div>
                <button type="submit">회원탈퇴</button>
            </form>
        </div>
	</body>
</html>