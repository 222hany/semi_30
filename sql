로그인, 메인
1. 회원가입^^
String join = "INSERT INTO USERINFO(ACCOUNT_ID, PASSWORD, USER_NAME, EMAIL, PHONENUMBER)" + "VALUES (?, ?, ?, ?, ?)";
2. 로그인
String login = "SELECT ACCOUNT_ID FROM USERINFO WHERE ACCOUNT_ID = ? AND PASSWORD = ?";
(아이디 비밀번호 찾기기능 B순위 구현)
3. 회원정보변경
3-1. 이메일 변경
String updateEmail = "UPDATE USERINFO SET EMAIL = ? WHERE PASSWORD = ?";
3-2. 연락처 변경
String updatePhonenumber = "UPDATE USERINFO SET PHONENUMBER = ? WHERE PASSWORD = ?";
3-3. 비밀번호 변경
String updatePassword = "UPDATE USERINFO SET PASSWORD = ? WHERE PASSWORD = ?";
4.탈퇴
String deleteAccount = "DELETE FROM USERINFO WHRE ACCOUNT_ID = ? AND PASSWORD = ?";
(계정삭제시 DB에 데이터 남기지않고 전부 삭제)
5.메인페이지 검색창
String search = "SELECT * FROM PRODUCTS WHERE PRODUCT_TITLE LIKE '%?%'";
