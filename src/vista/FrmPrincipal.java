package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnSistema;
	private JMenu mnMantenimientos;
	private JMenu mnReportes;
	private JMenuItem mntmSalir;
	private JMenuItem mntmClientes;
	private JMenuItem mntmProductos;
	private JDesktopPane contenedor;
	private JMenuItem mntmProductos_1;
	private JMenuItem mntmVentas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/cerrar.png")));
		mntmSalir.addActionListener(this);
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnSistema.add(mntmSalir);
		
		mnMantenimientos = new JMenu("Mantenimientos");
		mnMantenimientos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/abrir2.png")));
		menuBar.add(mnMantenimientos);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/nuevo.png")));
		mntmClientes.addActionListener(this);
		mntmClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnMantenimientos.add(mntmClientes);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/abrir.png")));
		mntmProductos.addActionListener(this);
		mntmProductos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK | InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnMantenimientos.add(mntmProductos);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/busca.png")));
		menuBar.add(mnReportes);
		
		mntmProductos_1 = new JMenuItem("Productos");
		mntmProductos_1.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/abrir2.png")));
		mntmProductos_1.addActionListener(this);
		mntmProductos_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnReportes.add(mntmProductos_1);
		
		mntmVentas = new JMenuItem("Ventas");
		mntmVentas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/busca.png")));
		mntmVentas.addActionListener(this);
		mntmVentas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnReportes.add(mntmVentas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contenedor = new JDesktopPane();
		contentPane.add(contenedor, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmVentas) {
			actionPerformedMntmVentas(arg0);
		}
		if (arg0.getSource() == mntmProductos) {
			actionPerformedMntmProductos(arg0);
		}
		if (arg0.getSource() == mntmProductos_1) {
			actionPerformedMntmProductos_1(arg0);
		}
		if (arg0.getSource() == mntmClientes) {
			actionPerformedMntmClientes(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		System.exit(1);
	}
	protected void actionPerformedMntmClientes(ActionEvent arg0) {
		
	}
	protected void actionPerformedMntmProductos_1(ActionEvent arg0) {
		
	}
	protected void actionPerformedMntmProductos(ActionEvent arg0) {
		FrmRegProd frp = new FrmRegProd();
		contenedor.add(frp);
		frp.setVisible(true);
	}
	protected void actionPerformedMntmVentas(ActionEvent arg0) {
		FrmRptVtas frv = new FrmRptVtas();
		contenedor.add(frv);
		frv.setVisible(true);
	}
}
