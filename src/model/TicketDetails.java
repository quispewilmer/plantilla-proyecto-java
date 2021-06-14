package model;

public class TicketDetails {
	private String idTicketDetails;
	private String idProduct;
	private int quantity;
	private double sellPrice;
	private double importTicketDetails;

	public TicketDetails() {
	}

	public TicketDetails(String idTicketDetails, String idProduct, int quantity, double sellPrice,
			double importTicketDetails) {
		this.idTicketDetails = idTicketDetails;
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.sellPrice = sellPrice;
		this.importTicketDetails = importTicketDetails;
	}

	public String getIdTicketDetails() {
		return idTicketDetails;
	}

	public void setIdTicketDetails(String idTicketDetails) {
		this.idTicketDetails = idTicketDetails;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public double getImportTicketDetails() {
		return importTicketDetails;
	}

	public void setImportTicketDetails(double importTicketDetails) {
		this.importTicketDetails = importTicketDetails;
	}

}
