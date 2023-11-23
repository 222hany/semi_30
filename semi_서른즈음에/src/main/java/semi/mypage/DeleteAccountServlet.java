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

@WebServlet("/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
		String jdbcUsername = "thirties";
		String jdbcPassword = "3030";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
			String account_id = request.getParameter("account_id");
			String password = request.getParameter("password");
			
			String deleteAccount = "DELETE FROM USERINFO WHERE ACCOUNT_ID = ? AND PASSWORD = ?";
			
			preparedStatement = connection.prepareStatement(deleteAccount);
			
			preparedStatement.setString(1, account_id);
			preparedStatement.setString(2, password);
			
			preparedStatement.executeUpdate();
			
			response.sendRedirect("deleteSuccess.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
