package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import mantenimientos.UserMaintenance;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FrmRegistro extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JDateChooser txtFecha;
	private JButton btnEliminar;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistro frame = new FrmRegistro();
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
	public FrmRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeUsuario = new JLabel("Registro de Usuario");
		lblRegistroDeUsuario.setBounds(28, 11, 224, 32);
		contentPane.add(lblRegistroDeUsuario);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(28, 65, 46, 14);
		contentPane.add(lblCdigo);
		
		JLabel lblAutogenerado = new JLabel("Autogenerado");
		lblAutogenerado.setBounds(192, 65, 92, 14);
		contentPane.add(lblAutogenerado);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(28, 94, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(28, 121, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(28, 146, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(28, 176, 46, 14);
		contentPane.add(lblClave);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(28, 206, 46, 14);
		contentPane.add(lblFecha);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(87, 91, 130, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(87, 118, 130, 20);
		contentPane.add(txtApellido);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(87, 146, 68, 20);
		contentPane.add(txtUsuario);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(87, 173, 71, 20);
		contentPane.add(txtClave);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarDatos();
			}
		});
		btnRegistrar.setBounds(302, 26, 89, 25);
		contentPane.add(btnRegistrar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(302, 89, 89, 25);
		contentPane.add(btnLimpiar);
		
		txtFecha = new JDateChooser();
		txtFecha.setDateFormatString("dd-MM-yyyy");
		txtFecha.setBounds(87, 200, 95, 20);
		contentPane.add(txtFecha);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(302, 60, 89, 25);
		contentPane.add(btnEliminar);
		
		textField = new JTextField();
		textField.setBounds(87, 63, 92, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(302, 116, 89, 25);
		contentPane.add(btnActualizar);
	}
	
	void registrarDatos(){
		// variables
		// entradas
		// procesos
		// salidas
		
		
	}
	
	public int obtenerCodigo() {
		return Integer.parseInt(textField.getText());
	}
	
	public String obtenerNombre() {
		return txtNombre.getText();
	}
	
	public String obtenerApellido() {
		return txtApellido.getText();
	}
	
	public String obtenerUsuario() {
		return txtUsuario.getText();
	}
	
	public String obtenerClave() {
		return txtClave.getPassword().toString();
	}
	
	public Date obtenerFNacim() {
		return txtFecha.getDate();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		int codigo = obtenerCodigo();
		UserMaintenance mu = new UserMaintenance();
	}
}
