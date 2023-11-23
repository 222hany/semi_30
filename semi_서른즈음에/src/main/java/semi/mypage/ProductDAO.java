package semi.mypage;


import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public void addProduct() {
		
	}
	
	public List<ProductVO> getAllProducts(int pageNumber, int pageSize) {
		List<ProductVO> products = new ArrayList<>();
		int start = PaginationUtil.paginationStart(pageNumber, pageSize);
		int end = PaginationUtil.paginationEnd(pageNumber, pageSize);
		
		try {
			conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "SELECT * FROM (SELECT p.*, ROWNUM AS rnum FROM (SELECT * FROM PRODUCTS ORDER BY PRODUCT_NO) p WHERE ROWNUM <= ?) WHERE rnum >= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, end);
			ps.setInt(2, start);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ProductVO productVo = new ProductVO();
				productVo.setProductNo(rs.getInt("PRODUCT_NO"));
				productVo.setProductTitle(rs.getString("PRODUCT_TITLE"));
				productVo.setProductText(rs.getString("PRODUCT_TEXT"));
				productVo.setProductPrice(rs.getInt("PRODUCT_PRICE"));
				productVo.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
				productVo.setProductComment(rs.getString("PRODUCT_COMMENT"));
				productVo.setAccountId(rs.getString("ACCOUNT_ID"));
				
				Blob blob = rs.getBlob("PRODUCT_FILE");
				byte[] imageBytes = blob.getBytes(1, (int) blob.length());
				
				String imageBase64 = java.util.Base64.getEncoder().encodeToString(imageBytes);
                String imageUrl = "data:image/jpeg;base64, " + imageBase64;
                productVo.setProductFile(imageUrl);
				
				products.add(productVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public int getTotalProducts() {
		int totalProducts = 0;
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
			String sql = "SELECT COUNT(*) AS TOTAL FROM PRODUCTS";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				totalProducts = rs.getInt("TOTAL");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalProducts;
	}
	
	public ProductVO getProductByNo(int productId) {
		ProductVO productVo = null;
		// select로 한개만 가져오는 쿼리 작성
		try {
			conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "SELECT * FROM PRODUCTS WHERE PRODUCT_NO = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, productId);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				productVo = new ProductVO();
				productVo.setProductNo(rs.getInt("PRODUCT_NO"));
				productVo.setProductTitle(rs.getString("PRODUCT_TITLE"));
				productVo.setProductText(rs.getString("PRODUCT_TEXT"));
				productVo.setProductPrice(rs.getInt("PRODUCT_PRICE"));
				productVo.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
				productVo.setProductComment(rs.getString("PRODUCT_COMMENT"));
				productVo.setAccountId(rs.getString("ACCOUNT_ID"));
				
				Blob blob = rs.getBlob("PRODUCT_FILE");
				byte[] imageBytes = blob.getBytes(1, (int) blob.length());
				
				String imageBase64 = java.util.Base64.getEncoder().encodeToString(imageBytes);
                String imageUrl = "data:image/jpeg;base64, " + imageBase64;
                productVo.setProductFile(imageUrl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productVo;
	}
	
	public void updateProduct() {
		
	}
	
	public void deleteProduct(int productId) {
		
		try {
			conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
			String deleteQuery = "DELETE FROM PRODUCTS WHERE PRODUCT_NO = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, productId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ProductVO> getSearchProducts(String word, int pageNumber, int pageSize) {
		List<ProductVO> products = new ArrayList<>();
		int start = PaginationUtil.paginationStart(pageNumber, pageSize);
		int end = PaginationUtil.paginationEnd(pageNumber, pageSize);
		try {
			conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String searchQuery = "SELECT * FROM PRODUCTS WHERE PRODUCT_TITLE LIKE '%?%'";
			PreparedStatement ps = conn.prepareStatement(searchQuery);
			ps.setString(1, word);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productTitle = rs.getString("PRODUCT_TITLE");
				String productText = rs.getString("PRODUCT_TEXT");
				int productPrice = rs.getInt("PRODUCT_PRICE");
				String productCategory = rs.getString("PRODUCT_CATEGORY");
				String productComment = rs.getString("PRODUCT_COMMENT");
				String productFile = rs.getString("PRODUCT_FILE");
				String accountId = rs.getString("ACCOUNT_ID");
				
				ProductVO productVo = new ProductVO();
				Blob blob = rs.getBlob("PRODUCT_FILE");
				byte[] imageBytes = blob.getBytes(1, (int) blob.length());
				
				String imageBase64 = java.util.Base64.getEncoder().encodeToString(imageBytes);
                String imageUrl = "data:image/jpeg;base64, " + imageBase64;
                productVo.setProductFile(imageUrl);
				
				products.add(productVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
}