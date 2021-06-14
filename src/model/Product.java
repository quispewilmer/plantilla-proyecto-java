package model;

public class Product {
	// atributos privados -> Tablas / GUI
	private String idProduct;
	private String productDescription;
	private int productQuantity;
	private double productPrice;
	private int productType;
	private boolean productState;
	
	public Product() {
		
	}

	public Product(String idProduct, String productDescription, int productQuantity, double productPrice,
			int productType, boolean productState) {
		this.idProduct = idProduct;
		this.productDescription = productDescription;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.productType = productType;
		this.productState = productState;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public boolean isProductState() {
		return productState;
	}

	public void setProductState(boolean productState) {
		this.productState = productState;
	}
}
