package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import mantenimientos.UserMaintenance;
import model.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRegister extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblRegistroDeUsuario;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblCdigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblUsuario;
	private JLabel lblClave;
	private JLabel lblFNacimiento;
	private JTextField txtCode;
	private JTextField txtName;
	private JTextField txtLastName;
	private JTextField txtUser;
	private JTextField txtKey;
	private JDateChooser dateBirthday;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegister frame = new FrmRegister();
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
	public FrmRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{253, 194, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblRegistroDeUsuario = new JLabel("Registro de Usuario");
		GridBagConstraints gbc_lblRegistroDeUsuario = new GridBagConstraints();
		gbc_lblRegistroDeUsuario.gridwidth = 2;
		gbc_lblRegistroDeUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegistroDeUsuario.gridx = 0;
		gbc_lblRegistroDeUsuario.gridy = 0;
		contentPane.add(lblRegistroDeUsuario, gbc_lblRegistroDeUsuario);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 21, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblCdigo = new JLabel("Código");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 0;
		panel.add(lblCdigo, gbc_lblCdigo);
		
		txtCode = new JTextField();
		GridBagConstraints gbc_txtCode = new GridBagConstraints();
		gbc_txtCode.insets = new Insets(0, 0, 5, 0);
		gbc_txtCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCode.gridx = 1;
		gbc_txtCode.gridy = 0;
		panel.add(txtCode, gbc_txtCode);
		txtCode.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		panel.add(lblNombre, gbc_lblNombre);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 1;
		panel.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 2;
		panel.add(lblApellido, gbc_lblApellido);
		
		txtLastName = new JTextField();
		GridBagConstraints gbc_txtLastName = new GridBagConstraints();
		gbc_txtLastName.insets = new Insets(0, 0, 5, 0);
		gbc_txtLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastName.gridx = 1;
		gbc_txtLastName.gridy = 2;
		panel.add(txtLastName, gbc_txtLastName);
		txtLastName.setColumns(10);
		
		lblUsuario = new JLabel("Usuario");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 3;
		panel.add(lblUsuario, gbc_lblUsuario);
		
		txtUser = new JTextField();
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.insets = new Insets(0, 0, 5, 0);
		gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUser.gridx = 1;
		gbc_txtUser.gridy = 3;
		panel.add(txtUser, gbc_txtUser);
		txtUser.setColumns(10);
		
		lblClave = new JLabel("Clave");
		GridBagConstraints gbc_lblClave = new GridBagConstraints();
		gbc_lblClave.anchor = GridBagConstraints.EAST;
		gbc_lblClave.insets = new Insets(0, 0, 5, 5);
		gbc_lblClave.gridx = 0;
		gbc_lblClave.gridy = 4;
		panel.add(lblClave, gbc_lblClave);
		
		txtKey = new JTextField();
		GridBagConstraints gbc_txtKey = new GridBagConstraints();
		gbc_txtKey.insets = new Insets(0, 0, 5, 0);
		gbc_txtKey.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKey.gridx = 1;
		gbc_txtKey.gridy = 4;
		panel.add(txtKey, gbc_txtKey);
		txtKey.setColumns(10);
		
		lblFNacimiento = new JLabel("F. Nacimiento");
		GridBagConstraints gbc_lblFNacimiento = new GridBagConstraints();
		gbc_lblFNacimiento.insets = new Insets(0, 0, 0, 5);
		gbc_lblFNacimiento.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblFNacimiento.gridx = 0;
		gbc_lblFNacimiento.gridy = 5;
		panel.add(lblFNacimiento, gbc_lblFNacimiento);
		
		dateBirthday = new JDateChooser();
		GridBagConstraints gbc_dateBirthday = new GridBagConstraints();
		gbc_dateBirthday.anchor = GridBagConstraints.NORTH;
		gbc_dateBirthday.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateBirthday.gridx = 1;
		gbc_dateBirthday.gridy = 5;
		panel.add(dateBirthday, gbc_dateBirthday);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAgregar.gridx = 0;
		gbc_btnAgregar.gridy = 0;
		panel_1.add(btnAgregar, gbc_btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminar.gridx = 0;
		gbc_btnEliminar.gridy = 1;
		panel_1.add(btnEliminar, gbc_btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnActualizar.insets = new Insets(0, 0, 5, 0);
		gbc_btnActualizar.gridx = 0;
		gbc_btnActualizar.gridy = 2;
		panel_1.add(btnActualizar, gbc_btnActualizar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscar.gridx = 0;
		gbc_btnBuscar.gridy = 3;
		panel_1.add(btnBuscar, gbc_btnBuscar);
	}

	public int getCodeOfUser() throws Exception {
		int answer = 0;
		if(txtCode.getText().length() != 0 && txtCode.getText().matches("[0-9]{5}")) {
			try {
				answer = Integer.parseInt(txtCode.getText());
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, digite un código con el formato: 0001.");
			throw new Exception();
		}
		return answer;
	}
	public String getNameOfUser() throws Exception {
		String answer = null;
		if(txtName.getText().length() != 0) {
			try {
				answer = txtName.getText();
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, digite un nombre.");
			throw new Exception();
		}
		return answer;
	}
	public String getLastNameOfUser() throws Exception {
		String answer = null;
		if(txtLastName.getText().length() != 0) {
			try {
				answer = txtLastName.getText();
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, digite un apellido.");
			throw new Exception();
		}
		return answer;
	}
	public String getUserOfUser() throws Exception {
		String answer = null;
		if(txtUser.getText().length() != 0 && txtUser.getText().matches("U[0-9]{3}")) {
			try {
				answer = txtUser.getText();
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, digite un usuario con el formato: U001.");
			throw new Exception();
		}
		return answer;
	}
	public String getKeyOfUser() throws Exception {
		String answer = null;
		if(txtKey.getText().length() != 0) {
			try {
				answer = txtKey.getText();
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, digite una clave.");
			throw new Exception();
		}
		return answer;
	}
	public String getBrithOfUser() throws Exception {
		String answer = null;
		if(new SimpleDateFormat("yyyy-MM-dd").format(dateBirthday.getDate()).length() != 0) {
			try {
				answer = new SimpleDateFormat("yyyy-MM-dd").format(dateBirthday.getDate());
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, digite una clave.");
			throw new Exception();
		}
		return answer;
	}
	
	public void addUser() {
		UserMaintenance mantenimientoU = new UserMaintenance();
		try {
			mantenimientoU.add(new User(
					getCodeOfUser(), getNameOfUser(),
					getLastNameOfUser(), getUserOfUser(),
					getKeyOfUser(), getBrithOfUser(),
					1, 2
					));			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error: " + e.getMessage());
		}
	}
	
	public void updateUser() {
		UserMaintenance mantenimientoU = new UserMaintenance();
		try {
			mantenimientoU.add(new User(
					getCodeOfUser(), getNameOfUser(),
					getLastNameOfUser(), getUserOfUser(),
					getKeyOfUser(), getBrithOfUser(),
					1, 2
					));
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error: " + e.getMessage());
		}
	}
	
	public void deleteUser() {
		UserMaintenance mantenimientoU = new UserMaintenance();
		try {
			mantenimientoU.delete(getCodeOfUser());			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error: " + e.getMessage());
		}
	}
	public void searchUser() {
		UserMaintenance mantenimientoU = new UserMaintenance();
		try {
			mantenimientoU.search(getCodeOfUser());			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error: " + e.getMessage());
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		addUser();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		deleteUser();
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		searchUser();
	}
	protected void actionPerformedBtnActualizar(ActionEvent arg0) {
		updateUser();
	}
}
