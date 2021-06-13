package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.UserMaintenance;
import mantenimientos.UserTypeMaintenance;
import model.User;
import model.UserType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class FrmUserReportByType extends JFrame implements ActionListener, WindowListener {

	private JPanel contentPane;
	private JComboBox cboType;
	private JTable tblExit;

	DefaultTableModel tableModel = new DefaultTableModel();
	private JButton btnReporteConProcedure;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUserReportByType frame = new FrmUserReportByType();
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
	public FrmUserReportByType() {
		addWindowListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 46, 70, 81, 207, 0 };
		gbl_contentPane.rowHeights = new int[] { 26, 20, 141, 47, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblListadoDeUsuarios = new JLabel("Listado de Usuarios");
		GridBagConstraints gbc_lblListadoDeUsuarios = new GridBagConstraints();
		gbc_lblListadoDeUsuarios.anchor = GridBagConstraints.WEST;
		gbc_lblListadoDeUsuarios.fill = GridBagConstraints.VERTICAL;
		gbc_lblListadoDeUsuarios.insets = new Insets(0, 0, 5, 0);
		gbc_lblListadoDeUsuarios.gridwidth = 4;
		gbc_lblListadoDeUsuarios.gridx = 0;
		gbc_lblListadoDeUsuarios.gridy = 0;
		contentPane.add(lblListadoDeUsuarios, gbc_lblListadoDeUsuarios);

		JLabel lblTipo = new JLabel("Tipo:");
		GridBagConstraints gbc_lblTipo = new GridBagConstraints();
		gbc_lblTipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipo.gridx = 0;
		gbc_lblTipo.gridy = 1;
		contentPane.add(lblTipo, gbc_lblTipo);

		cboType = new JComboBox();
		GridBagConstraints gbc_cboType = new GridBagConstraints();
		gbc_cboType.fill = GridBagConstraints.BOTH;
		gbc_cboType.insets = new Insets(0, 0, 5, 5);
		gbc_cboType.gridwidth = 2;
		gbc_cboType.gridx = 1;
		gbc_cboType.gridy = 1;
		contentPane.add(cboType, gbc_cboType);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridwidth = 4;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 2;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);

		tblExit = new JTable();
		// Asociar el model y la tabla
		tblExit.setModel(tableModel);
		tblExit.getTableHeader().setBackground(new Color(32, 136, 203));
		scrollPane_1.setViewportView(tblExit);

		JButton btnReporte = new JButton("Reporte");
		GridBagConstraints gbc_btnReporte = new GridBagConstraints();
		gbc_btnReporte.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnReporte.insets = new Insets(0, 0, 0, 5);
		gbc_btnReporte.gridwidth = 2;
		gbc_btnReporte.gridx = 0;
		gbc_btnReporte.gridy = 3;
		contentPane.add(btnReporte, gbc_btnReporte);

		btnReporteConProcedure = new JButton("Reporte con procedure");
		btnReporteConProcedure.addActionListener(this);
		GridBagConstraints gbc_btnReporteConProcedure = new GridBagConstraints();
		gbc_btnReporteConProcedure.anchor = GridBagConstraints.NORTH;
		gbc_btnReporteConProcedure.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReporteConProcedure.gridx = 3;
		gbc_btnReporteConProcedure.gridy = 3;
		contentPane.add(btnReporteConProcedure, gbc_btnReporteConProcedure);
		// Añadir los titulos de las columna
		tableModel.addColumn("Codigo");
		tableModel.addColumn("Nombre Completo");
		tableModel.addColumn("Tipo");

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnReporteConProcedure) {
			actionPerformedBtnReporteConProcedure(arg0);
		}
	}

	public int getTypeOfUser() {
		int answer = 0;

		try {
			answer = Integer.parseInt(cboType.getSelectedItem().toString().split(" - ")[0]);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
		}

		return answer;
	}

	protected void actionPerformedBtnReporteConProcedure(ActionEvent arg0) {
		clearTable();
		UserMaintenance userMaintenance = new UserMaintenance();
		ArrayList<User> usersListByType = userMaintenance.getUsersByType(getTypeOfUser());
		UserTypeMaintenance userTypeMaintenance = null;
		for (User user : usersListByType) {
			userTypeMaintenance = new UserTypeMaintenance();
			Object[] userItem = { user.getCode(), user.getName(),
					userTypeMaintenance.searchUserType(user.getType()).getUserTypeDescription() };
			tableModel.addRow(userItem);
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

	public void listUserTypesOnCbo() {
		UserTypeMaintenance userTypeMaintenance = new UserTypeMaintenance();
		ArrayList<UserType> listUserType = userTypeMaintenance.listUserType();
		for (UserType userType : listUserType) {
			cboType.addItem(userType.getIdUserType() + " - " + userType.getUserTypeDescription());
		}
	}

	protected void windowOpenedThis(WindowEvent e) {
		listUserTypesOnCbo();
	}

	public void clearTable() {
		tableModel.setRowCount(0);
	}
}
