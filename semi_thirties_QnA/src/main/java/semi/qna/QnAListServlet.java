package semi.qna;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/QnAListServlet")
public class QnAListServlet extends HttpServlet {
	// JDBC불러오기
	String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String userName = "thirties";
	String password = "3030";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection connection = null;
		try {
			Class.forName("oracle. jdbc.OracleDriver");
			connection = DriverManager.getConnection(jdbcURL, userName, password);
			String sql = "SELECT * FROM board_qna";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet =  ps.executeQuery();
			
			ArrayList<QnAVO> qnaList = new ArrayList<>();
			
			while(resultSet.next()) {
				int qnaNo = resultSet.getInt("qna_no");
				String accountID = resultSet.getString("account_id");
				String qnaTitle = resultSet.getString("qna_title");
				String qnaText = resultSet.getString("qna_text");
				Date qnaTime = resultSet.getDate("qna_time");
				int qnaHit = resultSet.getInt("qna_Hit");
				
				QnAVO qna = new QnAVO(qnaNo, accountID, qnaTitle, qnaText, qnaTime, qnaHit);

				qnaList.add(qna);			
			}

			request.setAttribute("qnaList", qnaList);
			request.getRequestDispatcher("/QnAList.jsp").forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}

