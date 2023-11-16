<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이페이지 : 회원정보변경</title>
		<link rel="stylesheet" type="text/css" href="./css/changePassword.css">
		<script>
	        function submitPassword(){
	            var password = document.getElementById("password").value;
	            var passwordCheck = document.getElementById("passwordCheck").value;
	            var errorMsg = document.getElementById("pm");

	            if(password !== passwordCheck){
	            	errorMsg.textContent = "※비밀번호가 일치하지 않습니다.";
	                return false;
	            }else{
	            	errorMsg.textContent = "";
	            }
	            alert('비밀번호가 변경되었습니다! 다시 로그인 해주세요.');
	            return true;
	        }
        </script>
	</head>

	<body>
		<div class="update-box">
            <h2>비밀번호 변경</h2>
            <form action="UpdateUserinfoServlet" method="post" onsubmit="return submitPassword()">
                <div class="items">
                	<label for="account_id">아이디</label><br>
                    <label for="password">현재 비밀번호</label><br>
                    <label for="passwordCheck">현재 비밀번호 확인</label><br>
                    <label for="newPassword">새 비밀번호</label><br>
                </div>
                <div class="blanks">
                	<input placeholder="아이디를 입력해주세요." type="text" id="account_id" name="account_id" required><br>
                    <input placeholder="현재 비밀번호를 입력해주세요." type="password" id="password" name="password" required><br>
                    <input placeholder="비밀번호를 한번 더 입력해주세요." type="password" id="passwordCheck" name="passwordCheck" required><br>
                    <input placeholder="변경하실 비밀번호를 입력해주세요." type="password" id="newPassword" name="newPassword" required><br>
                </div>
                <button type="submit">변경하기</button>
            </form>
            <p id="pm"></p>
        </div>
	</body>
</html>