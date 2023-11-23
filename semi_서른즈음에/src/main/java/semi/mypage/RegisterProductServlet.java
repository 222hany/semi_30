package semi.mypage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
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


@WebServlet("/RegisterProduct")
@MultipartConfig
public class RegisterProductServlet extends HttpServlet {
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "THIRTIES";
		String password = "3030";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
			
			request.setCharacterEncoding("UTF-8");
			String productTitle = request.getParameter("product_title");
			String productText = request.getParameter("product_text");
			String productPrice = request.getParameter("product_price");
			String productCategory = request.getParameter("product_category");
			String productComment = request.getParameter("product_comment");
			Part productFile = request.getPart("product_file");
			String accountId = request.getParameter("account_id");
			
			String sql = "INSERT INTO PRODUCTS (PRODUCT_TITLE, PRODUCT_TEXT, PRODUCT_PRICE, PRODUCT_CATEGORY, PRODUCT_COMMENT, PRODUCT_FILE, ACCOUNT_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productTitle);
			preparedStatement.setString(2, productText);
			preparedStatement.setString(3, productPrice);
			preparedStatement.setString(4, productCategory);
			preparedStatement.setString(5, productComment);
			preparedStatement.setBinaryStream(6, productFile.getInputStream(), (int) productFile.getSize());
			preparedStatement.setString(7, accountId);
			
			preparedStatement.executeUpdate();
			
			request.getSession().setAttribute("PRODUCT_TITLE", productTitle);
			request.getSession().setAttribute("PRODUCT_TEXT", productText);
			request.getSession().setAttribute("PRODUCT_PRICE", productPrice);
			request.getSession().setAttribute("PRODUCT_CATEGORY", productCategory);
			request.getSession().setAttribute("PRODUCT_COMMENT", productComment);
			request.getSession().setAttribute("PRODUCT_FILE", productFile);
			request.getSession().setAttribute("ACCOUNT_ID", accountId);
			
			response.sendRedirect("productRetrieve.jsp");
		} catch (SQLException e) {
			response.sendRedirect("productRegisterError.jsp");
			e.printStackTrace();
		}
	}
}