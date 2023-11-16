<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>가지가지 다 물어보는 QnA</title>
		<link rel="stylesheet" type="text/css" href="css/QnAstyles.css">
	</head>
	<body>
        <p id="login-join-link">로그인 회원가입</p>
        <header>
            <div id="logo">
                <p id="gajimarket">가지마켓</p>
            </div>
            <div id="mascot">
                <img src="img/gajidori.png" alt="gajidori" id="gajidori">
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
		
		<section>
			<form action="QnAPostServlet" method="post"> <!--form action="QnAPostServlet" method="post" enctype="multipart/form-data"-->
				
				<input type="text" id="ACCOUNT_ID" name="ACCOUNT_ID" placeholder="아이디" required><br>
				
				<input type="text" id="QNA_TITLE" name="QNA_TITLE" placeholder="제목" required><br>
				
				<input type="text" id="QNA_TEXT" name="QNA_TEXT" placeholder="내용" required><br>
				<input type="file" id="fileInput" accept="image/*">

				<button type="button" onclick='location.href = "QnAList.jsp"'>취소</button>				
				<input type="submit" id="submitButton" value="작성">
				

			
			
			</form>
		</section>
	</body>
</html>