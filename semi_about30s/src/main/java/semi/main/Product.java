package semi.main;

public class Product {
	private int productNo;
	private String accountId;
	private String productCategory;
	private String productTitle;
	private String productText;
	private int productPrice;
	
	public int getProductNo() {
		return productNo;
	}
	public String getAccountId() {
		return accountId;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public String getProductText() {
		return productText;
	}
	public int getProductPrice() {
		return productPrice;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public void setProductText(String productText) {
		this.productText = productText;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
}
