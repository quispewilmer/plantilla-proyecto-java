package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.UserMaintenance;
import mantenimientos.UserTypeMaintenance;
import model.User;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class FrmUserReport extends JFrame implements ActionListener, WindowListener {

	private JPanel contentPane;
	private JTable usersTable;
	private JButton btnReporte;
	DefaultTableModel dtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUserReport frame = new FrmUserReport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmUserReport() {
		addWindowListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 414, 0 };
		gbl_contentPane.rowHeights = new int[] { 26, 176, 23, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblListadoDeUsuarios = new JLabel("Listado de Usuarios");
		GridBagConstraints gbc_lblListadoDeUsuarios = new GridBagConstraints();
		gbc_lblListadoDeUsuarios.fill = GridBagConstraints.BOTH;
		gbc_lblListadoDeUsuarios.insets = new Insets(0, 0, 5, 0);
		gbc_lblListadoDeUsuarios.gridx = 0;
		gbc_lblListadoDeUsuarios.gridy = 0;
		contentPane.add(lblListadoDeUsuarios, gbc_lblListadoDeUsuarios);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		Object[] columns = {
				"Id",
				"Nombre",
				"Apellidos",
				"Usuario",
				"F. Nacim",
				"Tipo",
				"Estado"
		};
		dtm = new DefaultTableModel();
		dtm.setColumnIdentifiers(columns);

		usersTable = new JTable(dtm);
		usersTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(usersTable);

		btnReporte = new JButton("FrmUserReport");
		btnReporte.addActionListener(this);

		GridBagConstraints gbc_btnReporte = new GridBagConstraints();
		gbc_btnReporte.fill = GridBagConstraints.VERTICAL;
		gbc_btnReporte.gridx = 0;
		gbc_btnReporte.gridy = 2;
		contentPane.add(btnReporte, gbc_btnReporte);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnReporte) {
			actionPerformedBtnReporte(arg0);
		}
	}

	protected void actionPerformedBtnReporte(ActionEvent arg0) {
		listUsers();
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
		
	}
	
	public void listUsers() {
		clearTable();
		UserMaintenance userMaintenance = new UserMaintenance();
		ArrayList<User> listOfUsers = userMaintenance.getUsers();
		UserTypeMaintenance userTypeMaintenance = null;
		for(User user : listOfUsers) {
			userTypeMaintenance = new UserTypeMaintenance();
			Object[] userInfo = {
				user.getCode(),
				user.getName(),
				user.getLastName(),
				user.getUser(),
				user.getBirthday(),
				userTypeMaintenance.searchUserType(user.getType()).getUserTypeDescription(),
				user.getState()
			};
			dtm.addRow(userInfo);
		}
	}
	
	public void clearTable() {
		dtm.setRowCount(0);
	}
}
