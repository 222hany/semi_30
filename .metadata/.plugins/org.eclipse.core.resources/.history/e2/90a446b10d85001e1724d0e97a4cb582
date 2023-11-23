package com.kh.semi;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername = "thirties";
	private static final String jdbcPassword = "3030";
	
	public ReviewDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<Review> getAllReviews(){
		List<Review> reviews = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "SELECT REVIEW_NO, REVIEW_TITLE, REVIEW_TEXT, REVIEW_TIME, ACCOUNT_ID, REVIEW_HIT FROM BOARD_REVIEW ORDER BY REVIEW_NO DESC";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()){
				int reviewNo = resultSet.getInt("REVIEW_NO");
				String reviewTitle = resultSet.getString("REVIEW_TITLE");
				String reviewText = resultSet.getString("REVIEW_TEXT");
				Timestamp reviewTime = resultSet.getTimestamp("REVIEW_TIME");
				String accountId = resultSet.getString("ACCOUNT_ID");
				int reviewHit = resultSet.getInt("REVIEW_HIT");
				
				Review review = new Review(reviewNo, reviewTitle, reviewText, reviewTime, accountId, reviewHit);
				reviews.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviews;
		
	}
	
	public Review getReviewNo(int reviewNos) {
		Review review = null;
		String selectSql = "SELECT * FROM BOARD_REVIEW WHERE REVIEW_NO = ?";
	
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			PreparedStatement ps = connection.prepareStatement(selectSql);
			ps.setInt(1, reviewNos);
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()) {
				int reviewNo = resultSet.getInt("REVIEW_NO");
				String reviewTitle = resultSet.getString("REVIEW_TITLE");
				String reviewText = resultSet.getString("REVIEW_TEXT");
				Timestamp reviewTime = resultSet.getTimestamp("REVIEW_TIME");
				String accountId = resultSet.getString("ACCOUNT_ID");
				int reviewHit = resultSet.getInt("REVIEW_HIT");
				reviewHit++;
				reviewHitUpdate(reviewHit, reviewNo);
				
				review = new Review (reviewNo, reviewTitle, reviewText, reviewTime, accountId, reviewHit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return review;
	}

	public int deleteReview(int reviewNo) {
		int result = 0;
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
			String sql = "DELETE FROM BOARD_REVIEW WHERE REVIEW_NO = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, reviewNo);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int reviewHitUpdate(int reviewHit, int reviewNo) {
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String SQL = "UPDATE BOARD_REVIEW SET REVIEW_HIT = ? WHERE REVIEW_NO = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, reviewHit);//물음표의 순서
			ps.setInt(2, reviewNo);
			return ps.executeUpdate();//insert,delete,update			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;//데이터베이스 오류
	}
}
