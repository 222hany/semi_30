package com.kh.semi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/SearchServlet")
@MultipartConfig
public class SearchServlet extends HttpServlet {
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
	            String rText = request.getParameter("REVIEW_TEXT");
	            String rId = request.getParameter("ACCOUNT_ID");
	            Timestamp rTime = ((ResultSet) request).getTimestamp("REVIEW_TIME");
			//리뷰 SELECT
	            String sql = "SELECT * FROM BOARD_REVIEW ACCOUNT_ID LIKE '%?%'";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, rTitle);
	            preparedStatement.setString(2, rText);
	            preparedStatement.setString(3, rId);
	            preparedStatement.setTimestamp(4, rTime);

	            ResultSet resultSet = preparedStatement.executeQuery();
	           
	            request.getSession().setAttribute("REVIEW_TITLE", rTitle);
	            request.getSession().setAttribute("REVIEW_TEXT", rText);
	            request.getSession().setAttribute("ACCOUNT_ID", rId);
	            request.getSession().setAttribute("REVIEW_TIME", rTime);
	            

	            response.sendRedirect("reviewDetail.jsp");
		} catch (SQLException e) {

			response.sendRedirect("reviewList.jsp");
			e.printStackTrace();
		}
	}
}