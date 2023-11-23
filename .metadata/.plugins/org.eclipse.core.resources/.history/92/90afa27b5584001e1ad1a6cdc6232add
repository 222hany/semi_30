package com.kh.semi;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername = "thirties";
	private static final String jdbcPassword = "3030";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = null;
		
		//데이터 베이스 연결
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection(jdbcURL,jdbcUsername, jdbcPassword);
			//SQL 쿼리
			String sql = "SELECT REVIEW_NO, REVIEW_TITLE, REVIEW_TEXT, REVIEW_TIME, ACCOUNT_ID, REVIEW_HIT FROM BOARD_REVIEW";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			
			//게시글 목록을 저장할 장바구니 같은 ArrayList 생성.
			ArrayList<Review> reviewList = new ArrayList<>();
			
			while(resultSet.next()) {
				int reviewNo = resultSet.getInt("REVIEW_NO");
				String reviewTitle = resultSet.getString("REVIEW_TITLE");
				String reviewText = resultSet.getString("REVIEW_TEXT");
				Timestamp reviewTime = resultSet.getTimestamp("REVIEW_TIME");
				String accountId = resultSet.getString("ACCOUNT_ID");
				int reviewHit = resultSet.getInt("REVIEW_HIT");
				
				Review review = new Review(reviewNo, reviewTitle, reviewText, reviewTime, accountId, reviewHit);

				reviewList.add(review);
			}
			
			request.setAttribute("reviewList", reviewList);
			request.getRequestDispatcher("/reviewList.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}