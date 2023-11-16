package semi.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private PreparedStatement ps;
    private Connection con;
	public ProductDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List listproducts(Product product) {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
		String jdbcUsername = "thirties";
		String jdbcPassword = "3030";
		
		List<Product> products = new ArrayList<Product>();
		String searchTitle = product.getProductTitle();
		try {
			con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

			String search = "SELECT * FROM products";
			
			if((searchTitle != null && searchTitle.length() != 0)) {
				search += " WHERE product_title LIKE ?";
				ps = con.prepareStatement(search);
				ps.setString(1, "%" + searchTitle + "%");
			}else {
				ps = con.prepareStatement(search);
			}
			
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				int productNo = resultSet.getInt("product_no");
				String accountId = resultSet.getString("account_id");
				String productCategory = resultSet.getString("product_category");
				String productTitle = resultSet.getString("product_title");
				String productText = resultSet.getString("product_text");
				int productPrice = resultSet.getInt("product_price");
				
				Product product1 = new Product();
				
				product1.setProductNo(productNo);
				product1.setAccountId(accountId);
				product1.setProductCategory(productCategory);
				product1.setProductTitle(productTitle);
				product1.setProductText(productText);
				product1.setProductPrice(productPrice);
				
				products.add(product1);
			}
			resultSet.close();
			ps.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public List mainList(Product product) {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
		String jdbcUsername = "thirties";
		String jdbcPassword = "3030";
		
		List<Product> products = new ArrayList<Product>();
		try {
			con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

			String search = "SELECT * FROM PRODUCTS WHERE ROWNUM <= 3 ORDER  BY PRODUCT_NO DESC";
			ps = con.prepareStatement(search);
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				int productNo = resultSet.getInt("product_no");
				String accountId = resultSet.getString("account_id");
				String productCategory = resultSet.getString("product_category");
				String productTitle = resultSet.getString("product_title");
				String productText = resultSet.getString("product_text");
				int productPrice = resultSet.getInt("product_price");
				
				Product product1 = new Product();
				
				product1.setProductNo(productNo);
				product1.setAccountId(accountId);
				product1.setProductCategory(productCategory);
				product1.setProductTitle(productTitle);
				product1.setProductText(productText);
				product1.setProductPrice(productPrice);
				
				products.add(product1);
			}
			resultSet.close();
			ps.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
}
