<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="semi.qna.QnADAO" %>
<%@ page import="semi.qna.QnAVO" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/QnAStyles.css">
	<title>가지고 싶은 물건, 가지가지 다~ 있다! 가지마켓</title>
	<script src="https://kit.fontawesome.com/def66b134a.js" crossorigin="anonymous"></script>
	</head>

	<body>
	<%! String account_id; %>
		<div class="wrap">
	        <div class="inner">
		        <div>
				<%	
			        if (session.getAttribute("USER_NAME") != null) {
			    %>
			        
			    <%-- 세션에서 사용자 이름 가져오기 --%>
			    <% 
					account_id = (String) session.getAttribute("ACCOUNT_ID");
			    	String user_name = (String)session.getAttribute("USER_NAME"); %>
			    
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
        <section>
			<%
					//String = id 값을 가지고 오겠다.
					String qnaNoValue = (String)request.getParameter("qnaNo");
					int qnaNo = Integer.parseInt(qnaNoValue);
					
					// DAO 작업
					QnADAO qnaDao = new QnADAO();
					QnAVO qna = qnaDao.getQnaNo(qnaNo);
			%>
			<form action="QnAUpdateServlet" method="post">
				<input type="hidden" name="qnaNo" value="<%=qna.getQnaNo()%>"><br>
				<table border="1" id="detailTable">
					<tr>
						<th style="padding:15px;"> 제목 </th><td><input style="width:100%; border:none;" type="text" name="qnaTitle" size="13pt" value="<%=qna.getQnaTitle() %>"></td>
					</tr>
						<th>내용	</th><td><textarea rows="20" cols="60" name="qnaText" style="width:100%; resize :none; border:none;"><%=qna.getQnaText() %></textarea></td>
					<tr>
						<td colspan="2">
						<input style="font-family: 'SUITE-Regular';" type="file" id="fileInput" accept="image/*"><br>
					</tr>		
				</table>
				<button type="submit" id="update">수정</button>
			</form>	
		</section>
	        </div>
	    </div>
	</body>
	<footer>
			<p>회사소개 | 인재채용 | 제휴제안 | 이용약관 | 개인정보처리방침 | 청소년보호정책 | 고객센터 | GAZI Corp.</p>
	</footer>
</html>