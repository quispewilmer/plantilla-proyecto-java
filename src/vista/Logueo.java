package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.event.ChangeListener;

import hilos.HiloContador;
import mantenimientos.UserMaintenance;
import model.User;

import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class Logueo extends JFrame implements ActionListener, WindowListener {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	public static Logueo frame;
	private JButton btnAceptar;
	public static JLabel lblTiempo;
	public static User newUser = new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Logueo();
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
	public Logueo() {
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Logueo.class.getResource("/img/avatar.png")));
		setTitle("CIBERFARMA - Acceso al Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(114, 36, 96, 20);
		contentPane.add(lblUsuario);

		JLabel lblClave = new JLabel("Contrase\u00F1a:");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClave.setBounds(114, 83, 96, 20);
		contentPane.add(lblClave);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(205, 36, 103, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtClave = new JPasswordField();
		txtClave.setBounds(205, 84, 103, 20);
		contentPane.add(txtClave);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(114, 116, 89, 23);
		contentPane.add(btnAceptar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(226, 116, 89, 23);
		contentPane.add(btnSalir);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Logueo.class.getResource("/img/avatar.png")));
		lblFondo.setBounds(0, 11, 127, 184);
		contentPane.add(lblFondo);

		lblTiempo = new JLabel("10s");
		lblTiempo.setBounds(307, 11, 46, 14);
		contentPane.add(lblTiempo);

		JLabel lblMensaje = new JLabel("Esta ventana se cerrar\u00E1 en ");
		lblMensaje.setHorizontalTextPosition(SwingConstants.LEFT);
		lblMensaje.setBounds(114, 11, 194, 14);
		contentPane.add(lblMensaje);

		setLocationRelativeTo(null);
	} // fin del constructor de la clase

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}
	
	private String leerUsuario() throws Exception {
		String answer = null;
		
		if(txtUsuario.getText().length() != 0
			&&
		txtUsuario.getText().matches("i[0-9]{9}@cibertec.edu.pe")
		) {
			try {
				answer = txtUsuario.getText();
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Introduzca correctamente el usuario");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, introduzca el usuario");
			throw new Exception();
		}
		
		return answer;
	}
	
	@SuppressWarnings("deprecation")
	private String leerClave() throws Exception {
		String answer = null;
		
		if(String.valueOf(txtClave.getPassword()).length() != 0) {
			try {
				answer = String.valueOf(txtClave.getPassword());
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Introduzca correctamente el usuario");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, introduzca la clave");
			throw new Exception();
		}
		
		return answer;
	}
	
 	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
 		validateAccess();
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
		HiloContador hc = new HiloContador(this);
		hc.start();
	}
	
	public void validateAccess() {
		String user, password;
		
		user = readUser();
		password = readPassword();
	
		newUser = new UserMaintenance().validateAccess(user, password);
		
		if(newUser == null) {
			JOptionPane.showMessageDialog(null, "Usuario o clave incorrecto.");
		} else {
			FrmPreLoader frmPreLoader = new FrmPreLoader();
			frmPreLoader.setVisible(true);
			this.dispose();
		}
	}

	private String readPassword() {
		return String.valueOf(txtClave.getPassword());
	}

	private String readUser() {
		return txtUsuario.getText();
	}
}
