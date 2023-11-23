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
                <li><a href="QnAList.jsp">문의게시판</a></li>
                <li><a>마이페이지</a></li>
            </ul>
        </nav>
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
	</body>
</html>