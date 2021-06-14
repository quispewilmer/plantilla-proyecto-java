package model;

public class TicketHeader {
	private String idTicketHeader;
	private String ticketHeaderDate;
	private int idUser;
	private int idSeller;
	private double ticketHeaderTotals;
	
	public TicketHeader() {
		
	}

	public TicketHeader(String idTicketHeader, String ticketHeaderDate, int idUser, int idSeller,
			double ticketHeaderTotals) {
		this.idTicketHeader = idTicketHeader;
		this.ticketHeaderDate = ticketHeaderDate;
		this.idUser = idUser;
		this.idSeller = idSeller;
		this.ticketHeaderTotals = ticketHeaderTotals;
	}

	public String getIdTicketHeader() {
		return idTicketHeader;
	}

	public void setIdTicketHeader(String idTicketHeader) {
		this.idTicketHeader = idTicketHeader;
	}

	public String getTicketHeaderDate() {
		return ticketHeaderDate;
	}

	public void setTicketHeaderDate(String ticketHeaderDate) {
		this.ticketHeaderDate = ticketHeaderDate;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdSeller() {
		return idSeller;
	}

	public void setIdSeller(int idSeller) {
		this.idSeller = idSeller;
	}

	public double getTicketHeaderTotals() {
		return ticketHeaderTotals;
	}

	public void setTicketHeaderTotals(double ticketHeaderTotals) {
		this.ticketHeaderTotals = ticketHeaderTotals;
	}
}
