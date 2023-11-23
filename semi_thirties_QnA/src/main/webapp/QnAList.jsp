<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLDecoder" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="semi.qna.QnADAO" %>
<%@ page import="semi.qna.QnAVO" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet"  type="text/css" href="css/QnAListStyles.css">
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
				<div class="contents">
					<div class="sidebar">
						<table id="topQnA">
							<tr>
								<th id = "top"><img src="img/gazi.png">자주 묻는 질문 TOP10<img src="img/gazi.png"></th>
							</tr>
							<tr>
								<td><a id="listlink" href="QnADetail.jsp?qnaNo=1">1. 비밀번호를 변경하고 싶어요.</a></td>
							</tr>
							<tr>
								<td><a id="listlink" href="QnADetail.jsp?qnaNo=2">2. 비밀번호를 분실했어요.</a></td>
							</tr>
							<tr>
								<td><a id="listlink" href="QnADetail.jsp?qnaNo=3">3. 아이디를 분실했어요.</a></td>
							</tr>
							<tr>
								<td><a id="listlink" href="QnADetail.jsp?qnaNo=4">4. 탈퇴하고 싶어요.</a></td>
							</tr>
							<tr>
								<td><a id="listlink" href="QnADetail.jsp?qnaNo=5">5. 상품을 등록하고 싶어요.</a></td>
							</tr>
							<tr>
								<td><a id="listlink" href="QnADetail.jsp?qnaNo=6">6. 상품을 삭제하고 싶어요.</a></td>
							</tr>
							<tr>
								<td><a id="listlink" href="QnADetail.jsp?qnaNo=7">7. 상품을 수정하고 싶어요.</a></td>
							</tr>
							<tr>
								<td><a id="listlink" href="QnADetail.jsp?qnaNo=8">8. 내 정보를 수정하고 싶어요.</a></td>
							</tr>
							<tr>
								<td><a id="listlink" href="QnADetail.jsp?qnaNo=9">9. 새 상품이 아니에요.</a></td>
							</tr>
							<tr>
								<td><a id="listlink" href="QnADetail.jsp?qnaNo=10">10.가입 없이 게시판 이용하고 싶어요.</a></td>
							</tr>
						</table>
					</div>
					
					<div class="main">
					<table border="1" id="qnA" style="border-collapse:collapse; vertical-align: middle;">
						<tr style="background-color : #75c945; color : white; text-align: center;">
							<th style="width:60px;padding:8px;">글번호</th>
							<th style="width:390px;padding:8px;">제 목</th>
							<th style="width:110px;padding:8px;">작성자</th>
							<th style="width:120px;padding:8px;">작성시간</th>
							<th style="width:60px;padding:8px;">조회수</th>
						</tr>
						<%
						QnADAO qnaDAO = new QnADAO();
									List<QnAVO> qnas = qnaDAO.getAllQnAs();
									
									for(QnAVO qna : qnas){
						%>
						<tr style="border-bottom: 1px solid rgba(0,0,0,.1);">
							<td style="text-align:center;padding:8px;"> <%= qna.getQnaNo() %> </td>
							<td style="padding:8px;"><a id="listlink" href="QnADetail.jsp?qnaNo=<%=qna.getQnaNo()%>"> <%= qna.getQnaTitle() %> </td>
							<td style="text-align:center;padding:8px;"><a id="listlink" href="QnADetail.jsp?qnaNo=<%=qna.getQnaNo()%>"> <%= qna.getAccountID() %> </td>
							<td style="text-align:center;padding:8px;"><%= qna.getQnaTime() %> </td>
							<td style="text-align:center;padding:8px;"><%= qna.getQnaHit()%> </td>
						</tr>
						<%		
							}
						%>
						
					</table>
					</div>
				</div>
				<button id="postButton" onclick="location.href='QnAPost.jsp'">글쓰기</button>
	        </div>
	    </div>
	</body>
	<footer>
			<p>회사소개 | 인재채용 | 제휴제안 | 이용약관 | 개인정보처리방침 | 청소년보호정책 | 고객센터 | GAZI Corp.</p>
	</footer>
</html>