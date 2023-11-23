<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "semi.board.*" %>
<!DOCTYPE html>
<html>
<head>
<title>가지고 싶은 물건, 가지가지 다~ 있다! 가지마켓</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="product-retrieve.css">
<title>가지마켓</title>
	<script src="https://kit.fontawesome.com/def66b134a.js" crossorigin="anonymous"></script>
</head>
<body>

                     <%
		String boardNoValue = (String)request.getParameter("boardno");
        int boardNo = Integer.parseInt(boardNoValue);
		BoardDAO dao = new BoardDAO();
		int result =  dao.delete(boardNo);
        if(result>0){
       	%>
        	<script type="text/javascript">
        		alert("글 삭제 성공");
        		location.href="BoardList.jsp";
        	</script>
        <%
        } else {
        %>
        
        <script type="text/javascript">
        	alert("글 삭제 실패");
        	location.href="BoardList.jsp";
        </script>
        <%
        }
        %>	

	            </div>
            </div>
        <footer>
        </footer>
        </div>
    </div>
    </body>

</body>
