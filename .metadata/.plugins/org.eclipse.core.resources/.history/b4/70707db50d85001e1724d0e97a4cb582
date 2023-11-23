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

@WebServlet("/ReviewPostServlet")
@MultipartConfig
public class ReviewPostServlet extends HttpServlet {
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
	            String rTitle = request.getParameter("REVIEW_TITLE");
	            Part rFile = request.getPart("REVIEW_FILE");
	            String rText = request.getParameter("REVIEW_TEXT");
	            String rId = request.getParameter("ACCOUNT_ID");
			//리뷰 INSERT
	            String sql = "INSERT INTO BOARD_REVIEW(REVIEW_TITLE, REVIEW_FILE, REVIEW_TEXT, ACCOUNT_ID) VALUES (?, ?, ?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, rTitle);
	            preparedStatement.setBinaryStream(2, rFile.getInputStream(),(int) rFile.getSize());
	            preparedStatement.setString(3, rText);
	            preparedStatement.setString(4, rId);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            response.sendRedirect("reviewList.jsp");
		} catch (SQLException e) {

			response.sendRedirect("reviewPost.jsp");
			e.printStackTrace();
		}
	}
}