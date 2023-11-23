package semi.mypage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateUserinfoServlet")
public class UpdateUserinfoServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
		String jdbcUsername = "thirties";
		String jdbcPassword = "3030";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
			String newPassword = request.getParameter("newPassword");
			String account_id = request.getParameter("account_id");
			String password = request.getParameter("password");
			
			String updatePassword = "UPDATE USERINFO SET PASSWORD = ? WHERE ACCOUNT_ID = ? AND PASSWORD = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(updatePassword);
			
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, account_id);
			preparedStatement.setString(3, password);
			
			preparedStatement.executeUpdate();
			
			response.sendRedirect("login.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
