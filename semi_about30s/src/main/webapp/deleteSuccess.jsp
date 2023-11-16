<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title></title>
		<script>
			//3초후 홈페이지로 이동하는 js
			setTimeout(function(){
				//이동할 페이지 경로 설정
				window.location.href="mainpage.jsp";
			},4000); //4000 : 4초
		</script>
		<style>
			h3{
				text-align: center;
				line-height: 10px;
			}
			img{
			    width:600px;
			    height:500px;
			}
		</style>
	</head>

	<body>
		<br>
		<h3>정상적으로 탈퇴되었습니다.</h3>
		<br>
		<h3>4초후 홈페이지로 이동합니다.</h3>
		<h3><img src="./img/gajikun-unscreen.gif" alt="gajikun" class="gajijun"></h3>
	</body>
</html>