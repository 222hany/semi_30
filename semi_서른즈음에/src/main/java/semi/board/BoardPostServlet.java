package semi.board;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/BoardPostServlet")
@MultipartConfig
public class BoardPostServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user ="thirties";
		String pw = "3030";
	
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(url, user, pw);
			
			String btitle = request.getParameter("BOARD_TITLE");
			Part bfile = request.getPart("BOARD_FILE");
			String btext = request.getParameter("BOARD_TEXT");
			String bID = request.getParameter("user_name");
			
			//ȸ������ \insert
			
			String sql = "INSERT INTO BOARD(BOARD_TITLE,BOARD_FILE,BOARD_TEXT,ACCOUNT_ID) VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,btitle);
			preparedStatement.setBinaryStream(2, bfile.getInputStream(),(int)bfile.getSize());
			preparedStatement.setString(3,btext);
			preparedStatement.setString(4,bID);
		
			preparedStatement.executeUpdate();
		
			response.sendRedirect("BoardList.jsp");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("BoardPost.jsp");
			e.printStackTrace();
		}
		
	}

}
