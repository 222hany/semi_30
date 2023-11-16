package semi.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginLogoutServlet")
public class LoginLogoutServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
		String jdbcUsername = "thirties";
		String jdbcPassword = "3030";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
			String accountId = request.getParameter("accountId");
			String password = request.getParameter("password");
			
			String login = "SELECT * FROM USERINFO WHERE ACCOUNT_ID = ? AND PASSWORD = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(login);
			
			preparedStatement.setString(1, accountId);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				HttpSession session = request.getSession();
				
				session.setAttribute("USER_NO", resultSet.getInt("USER_NO"));
				session.setAttribute("ACCOUNT_ID", resultSet.getString("ACCOUNT_ID"));
				session.setAttribute("PASSWORD", resultSet.getString("PASSWORD"));
				session.setAttribute("USER_NAME", resultSet.getString("USER_NAME"));
				session.setAttribute("EMAIL", resultSet.getString("EMAIL"));
				session.setAttribute("PHONENUMBER", resultSet.getString("PHONENUMBER"));
				
				session.setMaxInactiveInterval(1800); //1800 = 30Î∂? ?õÑ ?ûê?èô Î°úÍ∑∏?ïÑ?õÉ
				response.sendRedirect("mainpage.jsp");
			}else {
				request.setAttribute("loginError", "true");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}