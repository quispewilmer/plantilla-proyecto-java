package interfaces;

import java.util.ArrayList;

import model.TicketDetails;
import model.TicketHeader;

public interface InterfazVenta {
	public String generateTicketNumber();
	public int doSell(TicketHeader ticketHeader, ArrayList<TicketDetails> ticketDetails);
}
