package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.InterfazVenta;
import model.TicketDetails;
import model.TicketHeader;
import utils.MySQLConexion8;

public class SellMaintenance implements InterfazVenta {

	@Override
	public String generateTicketNumber() {
		String code = "B0001";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String SQL = "SELECT substring(max(num_bol), 2) FROM tb_cab_boleta";

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				code = String.format("B%04d", resultSet.getInt(1) + 1);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al conectar.");
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Hubo un error al cerrar la conexión.");
			}
		}
		return code ;
	}

	@Override
	public int doSell(TicketHeader ticketHeader, ArrayList<TicketDetails> ticketDetails) {
		int rs = 0;
		
		Connection connection = null;
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;

		try {
			final String SQL1 = "INSERT INTO tb_cab_boleta VALUES (?, ?, ?, ?, ?)";
			final String SQL2 = "INSERT INTO tb_det_boleta VALUES (?, ?, ?, ?, ?)";
			final String SQL3 = "UPDATE tb_productos SET stock = stock - ? WHERE idprod = ?";
			connection = MySQLConexion8.getConexion();
			
			connection.setAutoCommit(false);
			preparedStatement1 = connection.prepareStatement(SQL1);
			preparedStatement1.setString(1, ticketHeader.getIdTicketHeader());
			preparedStatement1.setString(2, ticketHeader.getTicketHeaderDate());
			preparedStatement1.setInt(3, ticketHeader.getIdUser());
			preparedStatement1.setInt(4, ticketHeader.getIdSeller());
			preparedStatement1.setDouble(5, ticketHeader.getTicketHeaderTotals());
			rs = preparedStatement1.executeUpdate();			
			
			for(TicketDetails ticketDetailsItem : ticketDetails) {
				preparedStatement2 = connection.prepareStatement(SQL2);
				preparedStatement2.setString(1, ticketHeader.getIdTicketHeader());
				preparedStatement2.setString(2, ticketDetailsItem.getIdProduct());
				preparedStatement2.setInt(3, ticketDetailsItem.getQuantity());
				preparedStatement2.setDouble(4, ticketDetailsItem.getSellPrice());
				preparedStatement2.setDouble(5, ticketDetailsItem.getImportTicketDetails());
				
				rs += preparedStatement2.executeUpdate();
				
				preparedStatement3 = connection.prepareStatement(SQL3);
				preparedStatement3.setInt(1, ticketDetailsItem.getQuantity());
				preparedStatement3.setString(2, ticketDetailsItem.getIdProduct());
				
				rs += preparedStatement3.executeUpdate();
			}
			
			connection.commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al realizar venta.");
			rs = 0;
			try {
				connection.rollback();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Error al deshacer venta: " + e1.getMessage());
			}
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Hubo un error al cerrar la conexión.");
			}
		}
		
		return rs ;
	}
	
}
