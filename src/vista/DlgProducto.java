package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.ProductMaintenance;
import mantenimientos.UserMaintenance;
import model.Product;
import model.User;

import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.WindowEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgProducto extends JDialog implements WindowListener, MouseListener {
	private JTable clientUsersTable;
	private DefaultTableModel dtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgProducto dialog = new DlgProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgProducto() {
		addWindowListener(this);
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 0;
			getContentPane().add(scrollPane, gbc_scrollPane);
			{
				Object[] mainColumns = { "Código", "Descripción", "Precio", "Stock" };
				dtm = new DefaultTableModel();
				dtm.setColumnIdentifiers(mainColumns);
				clientUsersTable = new JTable(dtm);
				clientUsersTable.addMouseListener(this);
				clientUsersTable.setFillsViewportHeight(true);
				clientUsersTable.getColumnModel().getColumn(0).setPreferredWidth(100);
				clientUsersTable.getColumnModel().getColumn(1).setPreferredWidth(300);
				scrollPane.setViewportView(clientUsersTable);
			}
		}
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
		if (e.getSource() == this) {
			windowOpenedThis(e);
		}
	}

	protected void windowOpenedThis(WindowEvent e) {
		listProducts();
	}

	public void listProducts() {
		ProductMaintenance productManagement = new ProductMaintenance();
		ArrayList<Product> productsList = productManagement.listProducts();

		for (Product product : productsList) {
			Object[] productItem = { product.getIdProduct(), product.getProductDescription(), product.getProductPrice(),
					product.getProductQuantity() };
			dtm.addRow(productItem);
		}
	}

	public void clearTable() {
		dtm.setRowCount(0);
	}

	public void getDataFromTable() {
		int row = clientUsersTable.getSelectedRow();
		FrmBoleta.txtCodProducto.setText(dtm.getValueAt(row, 0).toString());
		FrmBoleta.txtDesProducto.setText(dtm.getValueAt(row, 1).toString());
		FrmBoleta.txtPreProducto.setText(dtm.getValueAt(row, 2).toString());
		FrmBoleta.txtStockProducto.setText(dtm.getValueAt(row, 3).toString());
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == clientUsersTable) {
			mouseClickedClientUsersTable(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void mouseClickedClientUsersTable(MouseEvent e) {
		getDataFromTable();
	}
}
