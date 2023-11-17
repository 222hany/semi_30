package semi.main;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import semi.mypage.ProductVO;

public class ProductDAO {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername = "THIRTIES";
	private static final String jdbcPassword = "3030";
	Connection conn;
	
	public ProductDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<Product> searchList(String searchTitle) {
		List<Product> products = new ArrayList<Product>();
		
		try {
			conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			PreparedStatement ps;
			
			String search = "SELECT * FROM products";
			
			if((searchTitle != null && searchTitle.length() != 0)) {
				search += " WHERE product_title LIKE ?";
				ps = conn.prepareStatement(search);
				ps.setString(1, "%" + searchTitle + "%");
			}else {
				ps = conn.prepareStatement(search);
			}
			
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				Product product = new Product();
				product.setProductNo(resultSet.getInt("PRODUCT_NO"));
				product.setProductTitle(resultSet.getString("PRODUCT_TITLE"));
				product.setProductText(resultSet.getString("PRODUCT_TEXT"));
				product.setProductPrice(resultSet.getInt("PRODUCT_PRICE"));
				product.setProductCategory(resultSet.getString("PRODUCT_CATEGORY"));
				product.setProductComment(resultSet.getString("PRODUCT_COMMENT"));
				product.setAccountId(resultSet.getString("ACCOUNT_ID"));
				
				Blob blob = resultSet.getBlob("PRODUCT_FILE");
				byte[] imageBytes = blob.getBytes(1, (int) blob.length());
				
				String imageBase64 = java.util.Base64.getEncoder().encodeToString(imageBytes);
                String imageUrl = "data:image/jpeg;base64, " + imageBase64;
                product.setProductFile(imageUrl);
				
				products.add(product);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public List<Product> mainList() {
		List<Product> products = new ArrayList<Product>();
		try {
			conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

			String sql = "SELECT * FROM PRODUCTS WHERE ROWNUM <= 15 ORDER  BY PRODUCT_NO DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				Product product = new Product();
				
				product.setProductNo(resultSet.getInt("PRODUCT_NO"));
				product.setProductTitle(resultSet.getString("PRODUCT_TITLE"));
				product.setProductText(resultSet.getString("PRODUCT_TEXT"));
				product.setProductPrice(resultSet.getInt("PRODUCT_PRICE"));
				product.setProductCategory(resultSet.getString("PRODUCT_CATEGORY"));
				product.setProductComment(resultSet.getString("PRODUCT_COMMENT"));
				product.setAccountId(resultSet.getString("ACCOUNT_ID"));
				
				Blob blob = resultSet.getBlob("PRODUCT_FILE");
				byte[] imageBytes = blob.getBytes(1, (int) blob.length());
				
				String imageBase64 = java.util.Base64.getEncoder().encodeToString(imageBytes);
                String imageUrl = "data:image/jpeg;base64, " + imageBase64;
                product.setProductFile(imageUrl);
				
				products.add(product);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
}
