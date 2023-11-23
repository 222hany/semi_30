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
		// 데이터베이스 연결
		Connection connection = null;
		try {
			Class.forName("oracle. jdbc.OracleDriver");// Class.forName("oracle.jdbc.driver.OracleDriver); 위와 같이 실행되나 위쪽이 개편된 문장이라 윗 문장을 쓰는 게 더 좋음.
			connection = DriverManager.getConnection(jdbcURL, userName, password);
			// SQL 쿼리
			String sql = "SELECT * FROM board_qna";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet =  ps.executeQuery();
			
			// 제품 목록을 저장할 장바구니같은 ArrayList 생성
			ArrayList<QnAVO> qnaList = new ArrayList<>();
			
			while(resultSet.next()) {
				int qnaNo = resultSet.getInt("qna_no");
				String accountID = resultSet.getString("account_id");
				String qnaTitle = resultSet.getString("qna_title");
				String qnaText = resultSet.getString("qna_text");
				Date qnaTime = resultSet.getDate("qna_time");
				int qnaHit = resultSet.getInt("qna_Hit");
				
				QnAVO qna = new QnAVO(qnaNo, accountID, qnaTitle, qnaText, qnaTime, qnaHit);
					// productList에 제품들을 하나씩 add해서 넣어줌
				qnaList.add(qna);			
			}
			
			// JSP 제품목록 페이지로 제품 목록을 전달하자 !
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
