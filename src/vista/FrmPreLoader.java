package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloCargador;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class FrmPreLoader extends JFrame implements WindowListener, WindowStateListener, PropertyChangeListener {

	private JPanel contentPane;
	public static JProgressBar prbCarga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPreLoader frame = new FrmPreLoader();
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
	public FrmPreLoader() {
		addWindowStateListener(this);
		addWindowListener(this);
		setTitle("Cargando...");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 347, 111);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.addPropertyChangeListener(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		prbCarga = new JProgressBar();
		prbCarga.setBounds(10, 43, 313, 19);
		contentPane.add(prbCarga);
		
		JLabel lblMensajes = new JLabel("El sistema est\u00E1 cargando, espere unos segundos");
		lblMensajes.setForeground(Color.BLUE);
		lblMensajes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajes.setBounds(10, 17, 325, 14);
		contentPane.add(lblMensajes);
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
		HiloCargador hc = new HiloCargador(this);
		hc.start();
	}
	public void windowStateChanged(WindowEvent arg0) {
		if (arg0.getSource() == this) {
			windowStateChangedThis(arg0);
		}
	}
	protected void windowStateChangedThis(WindowEvent arg0) {
	}
	public void propertyChange(PropertyChangeEvent arg0) {
		if (arg0.getSource() == contentPane) {
			propertyChangeContentPane(arg0);
		}
	}
	protected void propertyChangeContentPane(PropertyChangeEvent arg0) {
	}
}
