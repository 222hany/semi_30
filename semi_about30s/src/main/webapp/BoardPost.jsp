<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/boardPost-styles.css">
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
			    <% user_name = (String)session.getAttribute("USER_NAME"); %>
			    
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
            <div class="contents">
	            <div class="sidebar">
	            	<!-- 좌측 메뉴 -->
		          
	            </div>
	            <div class="main">
                	<!-- 우측 페이지 --> 
                	
<form action="BoardPostServlet" method="post" enctype="multipart/form-data">
	<input type="hidden" id="user_name" name="user_name" value="<%=user_name%>">
	<input type = "text" id="BOARD_TITLE" name="BOARD_TITLE" required value="제목을 작성해 주세요."><br>
	<input type = "textarea" id="BOARD_TEXT" name="BOARD_TEXT" required value="내용을 작성해 주세요."><br>
	<input type="file" name="BOARD_FILE" id="BOARD_FILE" required><br>
	<input type = "submit" value="글쓰기" class="subbutton">
	<button class="cancellationbtn"><a href="BoardList.jsp">돌아가기</a></button>

</form>

	            </div>
            </div>
       
        </div>
    </div>
    </body>

</body>
<footer>
	<p>회사소개 | 인재채용 | 제휴제안 | 이용약관 | 개인정보처리방침 | 청소년보호정책 | 고객센터 | GAZI Corp.</p>
	</footer>
</html>
