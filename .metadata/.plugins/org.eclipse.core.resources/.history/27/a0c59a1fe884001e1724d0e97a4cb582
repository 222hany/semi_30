<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLDecoder" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="semi.qna.QnADAO" %>
<%@ page import="semi.qna.QnAVO" %>
<%@ page import="semi.qna.Paging" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/mainpage.css">
	<title>가지고 싶은 물건, 가지가지 다~ 있다! 가지마켓</title>
	<script src="https://kit.fontawesome.com/def66b134a.js" crossorigin="anonymous"></script>
	</head>

	<body>
		<div class="wrap">
	        <div class="inner">
		        <div>
				<%
			        if (session.getAttribute("USER_NAME") != null) {
			    %>
			        
			    <%-- 세션에서 사용자 이름 가져오기 --%>
			    <% String user_name = (String)session.getAttribute("USER_NAME"); %>
			    
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
							<li><a id="li_link">자유게시판</a></li>
	                        <li><a id="li_link" href="reviewList.jsp" style="text-decoration: none;">리뷰게시판</a></li>
	                        <li><a id="li_link" href="QnAList.jsp" style="text-decoration: none;">문의게시판</a></li>
	                        <li><a id="li_link" href="productRetrieve.jsp" style="text-decoration: none;">마이페이지</a></li>
	                    </ul>
	                </nav>
		        </div>
		<section>
			<table id="topQnA" style="color : #6DA44C; width: 300px; height: 400px border : none; font-weight: bold;">
				<tr>
					<th style="text-align: center;"><img src="img/gazi.png">자주 묻는 질문 TOP10<img src="img/gazi.png"></th>
				</tr>
				<tr>
					<td><a href="QnADetail.jsp?qnaNo=1">1. 비밀번호를 변경하고 싶어요.</a></td>
				</tr>
				<tr>
					<td><a href="QnADetail.jsp?qnaNo=2">2. 비밀번호를 분실했어요.</a></td>
				</tr>
				<tr>
					<td><a href="QnADetail.jsp?qnaNo=3">3. 아이디를 분실했어요.</a></td>
				</tr>
				<tr>
					<td><a href="QnADetail.jsp?qnaNo=4">4. 탈퇴하고 싶어요.</a></td>
				</tr>
				<tr>
					<td><a href="QnADetail.jsp?qnaNo=5">5. 상품을 등록하고 싶어요.</a></td>
				</tr>
				<tr>
					<td><a href="QnADetail.jsp?qnaNo=6">6. 상품을 삭제하고 싶어요.</a></td>
				</tr>
				<tr>
					<td><a href="QnADetail.jsp?qnaNo=7">7. 상품을 수정하고 싶어요.</a></td>
				</tr>
				<tr>
					<td><a href="QnADetail.jsp?qnaNo=8">8. 내 정보를 수정하고 싶어요.</a></td>
				</tr>
				<tr>
					<td><a href="QnADetail.jsp?qnaNo=9">9. 새 상품이 아니에요.</a></td>
				</tr>
				<tr>
					<td><a href="QnADetail.jsp?qnaNo=10">10.가입 없이 게시판 이용하고 싶어요.</a></td>
				</tr>
	        </table>
	        
	        
			<table border="1" id="qnA" style="vertical-align: middle;">
				<tr style="background-color : #6C44BB; color : white; font-weight: bold; text-align: center;">
					<th>게시글 번호</th>
					<th>제 목</th>
					<th>작성자</th>
					<th>작성시간</th>
					<th>조회수</th>
				</tr>
				<%
				QnADAO qnaDAO = new QnADAO();
							List<QnAVO> qnas = qnaDAO.getAllQnAs();
							
							for(QnAVO qna : qnas){
				%>
				<tr style="  border-bottom: 1px solid rgba(0,0,0,.1);">
					<td> <%= qna.getQnaNo() %> </td>
					<td><a href="QnADetail.jsp?qnaNo=<%=qna.getQnaNo()%>"> <%= qna.getQnaTitle() %> </td>
					<td><a href="QnADetail.jsp?qnaNo=<%=qna.getQnaNo()%>"> <%= qna.getAccountID() %> </td>
					<td><%= qna.getQnaTime() %> </td>
					<td><%= qna.getQnaHit()%> </td>
				</tr>
				<%		
					}
				%>
				
			</table><br><br>
			
		</section>
		<button id="postButton" onclick="location.href='QnAPost.jsp'">글쓰기</button>
			<footer>
	        </footer>
	        </div>
	    </div>
	</body>
</html>