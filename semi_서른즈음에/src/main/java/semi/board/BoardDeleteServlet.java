package semi.board;

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

/**
 * Servlet implementation class BoardDeliteServlet
 */
@WebServlet("/BoardDeleteServlet")
public class BoardDeleteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
		String jdbcUsername = "thirties";
		String jdbcPassword = "3030";
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

			int boardno = Integer.parseInt(request.getParameter("boardno"));
			BoardDAO dao = new BoardDAO();
			int result =  dao.delete(boardno);
			
			String deleteSql = "DELETE FROM BOARD WHERE BOARD_NO = ?";
			ps = connection.prepareStatement(deleteSql);
			ps.setInt(1, boardno);
			
			ps.executeUpdate();
			
			response.sendRedirect("BoardList.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}