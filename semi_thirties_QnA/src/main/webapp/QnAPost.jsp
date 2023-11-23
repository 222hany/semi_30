<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/QnAStyles.css">
	<title>가지고 싶은 물건, 가지가지 다~ 있다! 가지마켓</title>
	<script src="https://kit.fontawesome.com/def66b134a.js" crossorigin="anonymous"></script>
	</head>

	<body>
	<%! String user_name; %>
		<div class="wrap">
	        <div class="inner">
		        <div>
				<%	
			        if (session.getAttribute("USER_NAME") != null) {
			    %>
			        
			    <%-- 세션에서 사용자 이름 가져오기 --%>
			    <% 
			    	user_name = (String)session.getAttribute("USER_NAME"); 
			    	
			   
			    	%>
			    
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
		<div class="main">
			<form action="QnAPostServlet" method="post"> <!--form action="QnAPostServlet" method="post" enctype="multipart/form-data"-->
				<input type="hidden" id="user_name" name="user_name" value="<%=user_name%>">
				<table border="1" id="detailTable">
				<!-- input type="text" id="ACCOUNT_ID" name="ACCOUNT_ID" placeholder="아이디" required -->
					<tr>
						<th style="padding:15px;">제목</th>
						<td><input style="width:100%; border:none;" type="text" name="QNA_TITLE" size="13pt" id="QNA_TITLE" placeholder=" 제목을 입력하세요." required></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea rows="20" cols="60" id="QNA_TEXT" name="QNA_TEXT" style="width:100%; resize :none; border:none;" placeholder=" 내용을 입력하세요." required></textarea></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="file" id="fileInput" accept="image/*"></td>
					</tr>
				</table>
				<button type="button" onclick='location.href = "QnAList.jsp"'>취소</button>				
				<button type="submit" id="submitButton">작성</button>

			</form>
			</div>
	        </div>
	    </div>
	</body>
	<footer>
			<p>회사소개 | 인재채용 | 제휴제안 | 이용약관 | 개인정보처리방침 | 청소년보호정책 | 고객센터 | GAZI Corp.</p>
	</footer>
</html>