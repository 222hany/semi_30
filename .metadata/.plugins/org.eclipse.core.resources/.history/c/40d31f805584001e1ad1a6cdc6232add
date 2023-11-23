package com.kh.semi;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/ReviewUpdateServlet")
@MultipartConfig
public class ReviewUpdateServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// JDBC 불러오기
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUsername = "thirties";
		String jdbcPassword = "3030";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	            
			String reviewTitle = request.getParameter("REVIEW_TITLE");
            String reviewText = request.getParameter("REVIEW_TEXT");
            int reviewNo = Integer.parseInt(request.getParameter("REVIEW_NO"));

            
			//리뷰 UPDATE
            String updateSql = "UPDATE BOARD_REVIEW SET REVIEW_TITLE = ?, REVIEW_TEXT = ? WHERE REVIEW_NO = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setString(1, reviewTitle);
            preparedStatement.setString(2, reviewText);
            preparedStatement.setInt(3, reviewNo);

            preparedStatement.executeUpdate();

            response.sendRedirect("reviewList.jsp");
		} catch (SQLException e) {

			response.sendRedirect("review-error.jsp");
			e.printStackTrace();
		}
	}
}