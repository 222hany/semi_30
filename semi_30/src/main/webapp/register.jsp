<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
    	<meta charset="UTF-8">
        <title>가지마켓 : 회원가입</title>
        <link rel="icon" href="data:;base64,iVBORw0KGgo=">
        <link rel="stylesheet" type="text/css" href="./css/register.css">
        <script>
	        function submitPassword(){
	        	var account_id = document.getElementById("account_id").value;
	        	var idPattern = /^[A-za-z0-9]{5,20}$/
	            var password = document.getElementById("password").value;
	            var confirmPassword = document.getElementById("confirmPassword").value;
	            var passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,32}$/
	            var errorMsg = document.getElementById("pm");
	            
	            //id가 영문,숫자를 포함하지 않을 경우
	            if(!account_id.match(idPattern)){
	            	errorMsg.textContent = "※아이디는 5 ~ 20자의 영문 대문자, 소문자, 숫자를 포함해야합니다.";
	            	return false;
	            }else{
	            	errorMsg.textContent = "";
	            }
	            
	            //비밀번호가 영문, 숫자, 특문을 포함하지 않을 경우
	            if(!password.match(passwordPattern)){
	            	errorMsg.textContent = "※비밀번호는 8 ~ 32자의 영문 대문자, 소문자, 특수문자, 숫자를 포함해야합니다.";
	                return false;
	            }else{
	            	errorMsg.textContent = "";
	            }
	            
	            //비밀번호가 일치하지 않을 경우
	            if(password !== confirmPassword){
	            	errorMsg.textContent = "※비밀번호가 일치하지 않습니다.";
	                return false;
	            }else{
	            	errorMsg.textContent = "";
	            }
	            alert('성공적으로 가입되었습니다! 다시 로그인 해주세요.');
	            return true;
	        }
        </script>
    </head>

    <body>
        <div class="join-box">
            <p id="necessity">*필수입력사항</p>
            <h2>회원가입</h2>
            <form action="JoinServlet" method="post" onsubmit="return submitPassword()">
                <div class="items">
                    <label for="account_id">아이디*</label><br>
                    <label for="password">비밀번호*</label><br>
                    <label for="confirmPassword">비밀번호 확인*</label><br>
                    <label for="user_name">이름*</label><br>
                    <label for="email">이메일</label><br>
                    <label for="phonenumber">연락처</label><br>
                </div>
                <div class="blanks">
                    <input type="text" id="account_id" name="account_id" placeholder="영문 소문자, 숫자 사용하여 5~20자." required><br>
                    <input type="password" id="password" name="password" placeholder="영문 대/소문자, 숫자, 특수문자 사용하여 8~32자." required><br>
                    <input placeholder="비밀번호를 한번 더 입력해주세요." type="password" id="confirmPassword" name="confirmPassword" required><br>
                    <input type="text" id="user_name" name="user_name" placeholder="이름을 입력해주세요." required><br>
                    <input type="email" id="email" name="email" placeholder="이메일을 입력해주세요." required><br>
                    <input type="text" id="phonenumber" name="phonenumber" placeholder="-없이 숫자만 입력해주세요." required><br>
                </div>
                <button type="submit">가입완료</button>
            </form>
            <p id="pm"></p>
        </div>
        
    </body>
</html>