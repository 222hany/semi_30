�α���, ����
1. ȸ������^^
String join = "INSERT INTO USERINFO(ACCOUNT_ID, PASSWORD, USER_NAME, EMAIL, PHONENUMBER)" + "VALUES (?, ?, ?, ?, ?)";
2. �α���
String login = "SELECT ACCOUNT_ID FROM USERINFO WHERE ACCOUNT_ID = ? AND PASSWORD = ?";
(���̵� ��й�ȣ ã���� B���� ����)
3. ȸ����������
3-1. �̸��� ����
String updateEmail = "UPDATE USERINFO SET EMAIL = ? WHERE PASSWORD = ?";
3-2. ����ó ����
String updatePhonenumber = "UPDATE USERINFO SET PHONENUMBER = ? WHERE PASSWORD = ?";
3-3. ��й�ȣ ����
String updatePassword = "UPDATE USERINFO SET PASSWORD = ? WHERE PASSWORD = ?";
4.Ż��
String deleteAccount = "DELETE FROM USERINFO WHRE ACCOUNT_ID = ? AND PASSWORD = ?";
(���������� DB�� ������ �������ʰ� ���� ����)
5.���������� �˻�â
String search = "SELECT * FROM PRODUCTS WHERE PRODUCT_TITLE LIKE '%?%'";
