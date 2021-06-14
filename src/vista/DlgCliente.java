package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.UserMaintenance;
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

public class DlgCliente extends JDialog implements WindowListener, MouseListener {
	private JTable clientUsersTable;
	private DefaultTableModel dtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCliente dialog = new DlgCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCliente() {
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
				Object[] mainColumns = { "Código", "Nombre del cliente" };
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
		listClients();
	}

	public void listClients() {
		UserMaintenance userManagement = new UserMaintenance();
		ArrayList<User> usersList = userManagement.getUsersByType(2);

		for (User userClient : usersList) {
			Object[] userItem = { userClient.getCode(), userClient.getName() };
			dtm.addRow(userItem);
		}
	}

	public void clearTable() {
		dtm.setRowCount(0);
	}

	public void getDataFromTable() {
		int row = clientUsersTable.getSelectedRow();
		FrmBoleta.txtCodCliente.setText(dtm.getValueAt(row, 0).toString());
		FrmBoleta.txtNomCompletoCliente.setText(dtm.getValueAt(row, 1).toString());
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
