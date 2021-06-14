package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import mantenimientos.SellMaintenance;
import model.TicketDetails;
import model.TicketHeader;

import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class FrmBoleta extends JFrame implements ActionListener {

	private JPanel contentPane;

	public static JTextField txtCodCliente;
	public static JTextField txtNomCompletoCliente;

	private JTextArea txtSalida;
	private JTextField txtFechaActual;
	private JButton btnNuevo;
	private JButton btnFinalizar;
	private JTextField txtTotal;
	private JTextField txtNumBoleta;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblProducto;
	public static JTextField txtCodProducto;
	public static JTextField txtDesProducto;
	public static JTextField txtPreProducto;
	public static JTextField txtStockProducto;
	private JTextField txtCantidadAComprar;
	private JButton btnAgregar;
	private JLabel lblCantidad;
	private JButton btnConsultarProducto;
	private JButton btnConsultarCliente;
	double total = 0;
	ArrayList<TicketDetails> cart = new ArrayList<TicketDetails>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBoleta frame = new FrmBoleta();
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
	public FrmBoleta() {
		setTitle("Boleta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 460);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 92, 144, 38, 156, 89, 0 };
		gbl_contentPane.rowHeights = new int[] { 105, 96, 114, 36, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 43, 0, 56, 0 };
		gbl_panel_1.rowHeights = new int[] { 37, 20, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblCliente = new JLabel("Cliente:");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 0;
		panel_1.add(lblCliente, gbc_lblCliente);

		txtCodCliente = new JTextField();
		txtCodCliente.setEditable(false);
		GridBagConstraints gbc_txtCodCliente = new GridBagConstraints();
		gbc_txtCodCliente.anchor = GridBagConstraints.SOUTHEAST;
		gbc_txtCodCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodCliente.gridx = 1;
		gbc_txtCodCliente.gridy = 0;
		panel_1.add(txtCodCliente, gbc_txtCodCliente);
		txtCodCliente.setColumns(10);

		btnConsultarCliente = new JButton("");
		btnConsultarCliente.addActionListener(this);
		GridBagConstraints gbc_btnConsultarCliente = new GridBagConstraints();
		gbc_btnConsultarCliente.anchor = GridBagConstraints.WEST;
		gbc_btnConsultarCliente.fill = GridBagConstraints.VERTICAL;
		gbc_btnConsultarCliente.insets = new Insets(0, 0, 5, 0);
		gbc_btnConsultarCliente.gridx = 2;
		gbc_btnConsultarCliente.gridy = 0;
		panel_1.add(btnConsultarCliente, gbc_btnConsultarCliente);
		btnConsultarCliente.setBorder(null);
		btnConsultarCliente.setBorderPainted(false);
		btnConsultarCliente.setContentAreaFilled(false);
		btnConsultarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultarCliente.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/busca.png")));

		txtNomCompletoCliente = new JTextField();
		txtNomCompletoCliente.setEditable(false);
		GridBagConstraints gbc_txtNomCompletoCliente = new GridBagConstraints();
		gbc_txtNomCompletoCliente.fill = GridBagConstraints.BOTH;
		gbc_txtNomCompletoCliente.gridwidth = 3;
		gbc_txtNomCompletoCliente.gridx = 0;
		gbc_txtNomCompletoCliente.gridy = 1;
		panel_1.add(txtNomCompletoCliente, gbc_txtNomCompletoCliente);
		txtNomCompletoCliente.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 48, 162, 0 };
		gbl_panel.rowHeights = new int[] { 20, 20, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNm = new JLabel("N\u00FAm");
		GridBagConstraints gbc_lblNm = new GridBagConstraints();
		gbc_lblNm.anchor = GridBagConstraints.WEST;
		gbc_lblNm.insets = new Insets(0, 0, 5, 5);
		gbc_lblNm.gridx = 0;
		gbc_lblNm.gridy = 0;
		panel.add(lblNm, gbc_lblNm);

		txtNumBoleta = new JTextField();
		txtNumBoleta.setEditable(false);
		txtNumBoleta.setText("B0000");
		txtNumBoleta.setColumns(10);
		GridBagConstraints gbc_txtNumBoleta = new GridBagConstraints();
		gbc_txtNumBoleta.fill = GridBagConstraints.BOTH;
		gbc_txtNumBoleta.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumBoleta.gridx = 1;
		gbc_txtNumBoleta.gridy = 0;
		panel.add(txtNumBoleta, gbc_txtNumBoleta);

		JLabel lblFecha_1 = new JLabel("Fecha:");
		GridBagConstraints gbc_lblFecha_1 = new GridBagConstraints();
		gbc_lblFecha_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFecha_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblFecha_1.gridx = 0;
		gbc_lblFecha_1.gridy = 1;
		panel.add(lblFecha_1, gbc_lblFecha_1);

		txtFechaActual = new JTextField();
		txtFechaActual.setEditable(false);
		txtFechaActual.setText("A\u00F1o/Mes/D\u00EDa");
		GridBagConstraints gbc_txtFechaActual = new GridBagConstraints();
		gbc_txtFechaActual.anchor = GridBagConstraints.WEST;
		gbc_txtFechaActual.fill = GridBagConstraints.VERTICAL;
		gbc_txtFechaActual.gridx = 1;
		gbc_txtFechaActual.gridy = 1;
		panel.add(txtFechaActual, gbc_txtFechaActual);
		txtFechaActual.setColumns(10);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Producto",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridwidth = 5;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 70, 86, 37, 148, 70, 70, 0 };
		gbl_panel_2.rowHeights = new int[] { 37, 37, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		lblProducto = new JLabel("Producto:");
		GridBagConstraints gbc_lblProducto = new GridBagConstraints();
		gbc_lblProducto.anchor = GridBagConstraints.SOUTH;
		gbc_lblProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProducto.gridx = 0;
		gbc_lblProducto.gridy = 0;
		panel_2.add(lblProducto, gbc_lblProducto);

		txtCodProducto = new JTextField();
		txtCodProducto.setEditable(false);
		txtCodProducto.setText("P0001");
		txtCodProducto.setColumns(10);
		GridBagConstraints gbc_txtCodProducto = new GridBagConstraints();
		gbc_txtCodProducto.anchor = GridBagConstraints.SOUTH;
		gbc_txtCodProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodProducto.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodProducto.gridx = 1;
		gbc_txtCodProducto.gridy = 0;
		panel_2.add(txtCodProducto, gbc_txtCodProducto);

		btnConsultarProducto = new JButton("");
		btnConsultarProducto.addActionListener(this);
		btnConsultarProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultarProducto.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/busca.png")));
		btnConsultarProducto.setContentAreaFilled(false);
		btnConsultarProducto.setBorderPainted(false);
		btnConsultarProducto.setBorder(null);
		GridBagConstraints gbc_btnConsultarProducto = new GridBagConstraints();
		gbc_btnConsultarProducto.fill = GridBagConstraints.BOTH;
		gbc_btnConsultarProducto.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsultarProducto.gridx = 2;
		gbc_btnConsultarProducto.gridy = 0;
		panel_2.add(btnConsultarProducto, gbc_btnConsultarProducto);

		txtDesProducto = new JTextField();
		txtDesProducto.setEditable(false);
		txtDesProducto.setText("Panadol cj 10");
		txtDesProducto.setColumns(10);
		GridBagConstraints gbc_txtDesProducto = new GridBagConstraints();
		gbc_txtDesProducto.anchor = GridBagConstraints.SOUTH;
		gbc_txtDesProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDesProducto.insets = new Insets(0, 0, 5, 5);
		gbc_txtDesProducto.gridx = 3;
		gbc_txtDesProducto.gridy = 0;
		panel_2.add(txtDesProducto, gbc_txtDesProducto);

		txtPreProducto = new JTextField();
		txtPreProducto.setEditable(false);
		txtPreProducto.setText("1.85");
		txtPreProducto.setColumns(10);
		GridBagConstraints gbc_txtPreProducto = new GridBagConstraints();
		gbc_txtPreProducto.anchor = GridBagConstraints.SOUTH;
		gbc_txtPreProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPreProducto.insets = new Insets(0, 0, 5, 5);
		gbc_txtPreProducto.gridx = 4;
		gbc_txtPreProducto.gridy = 0;
		panel_2.add(txtPreProducto, gbc_txtPreProducto);

		txtStockProducto = new JTextField();
		txtStockProducto.setEditable(false);
		txtStockProducto.setText("20");
		txtStockProducto.setColumns(10);
		GridBagConstraints gbc_txtStockProducto = new GridBagConstraints();
		gbc_txtStockProducto.anchor = GridBagConstraints.SOUTH;
		gbc_txtStockProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStockProducto.insets = new Insets(0, 0, 5, 0);
		gbc_txtStockProducto.gridx = 5;
		gbc_txtStockProducto.gridy = 0;
		panel_2.add(txtStockProducto, gbc_txtStockProducto);

		lblCantidad = new JLabel("Cantidad:");
		GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
		gbc_lblCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCantidad.insets = new Insets(0, 0, 0, 5);
		gbc_lblCantidad.gridx = 0;
		gbc_lblCantidad.gridy = 1;
		panel_2.add(lblCantidad, gbc_lblCantidad);

		txtCantidadAComprar = new JTextField();
		txtCantidadAComprar.setColumns(10);
		GridBagConstraints gbc_txtCantidadAComprar = new GridBagConstraints();
		gbc_txtCantidadAComprar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCantidadAComprar.insets = new Insets(0, 0, 0, 5);
		gbc_txtCantidadAComprar.gridx = 1;
		gbc_txtCantidadAComprar.gridy = 1;
		panel_2.add(txtCantidadAComprar, gbc_txtCantidadAComprar);

		btnAgregar = new JButton("");
		btnAgregar.addActionListener(this);
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setRolloverIcon(new ImageIcon(FrmBoleta.class.getResource("/img/cartph.png")));
		btnAgregar.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/cartp.png")));
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setBorderPainted(false);
		btnAgregar.setBorder(null);
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.fill = GridBagConstraints.BOTH;
		gbc_btnAgregar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAgregar.gridx = 2;
		gbc_btnAgregar.gridy = 1;
		panel_2.add(btnAgregar, gbc_btnAgregar);

		JLabel lblAgregarProducto = new JLabel("Agregar producto ");
		GridBagConstraints gbc_lblAgregarProducto = new GridBagConstraints();
		gbc_lblAgregarProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAgregarProducto.insets = new Insets(0, 0, 0, 5);
		gbc_lblAgregarProducto.gridx = 3;
		gbc_lblAgregarProducto.gridy = 1;
		panel_2.add(lblAgregarProducto, gbc_lblAgregarProducto);

		txtSalida = new JTextArea();
		GridBagConstraints gbc_txtSalida = new GridBagConstraints();
		gbc_txtSalida.fill = GridBagConstraints.BOTH;
		gbc_txtSalida.insets = new Insets(0, 0, 5, 0);
		gbc_txtSalida.gridwidth = 5;
		gbc_txtSalida.gridx = 0;
		gbc_txtSalida.gridy = 2;
		contentPane.add(txtSalida, gbc_txtSalida);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.anchor = GridBagConstraints.SOUTH;
		gbc_btnNuevo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNuevo.insets = new Insets(0, 0, 0, 5);
		gbc_btnNuevo.gridx = 0;
		gbc_btnNuevo.gridy = 3;
		contentPane.add(btnNuevo, gbc_btnNuevo);

		btnFinalizar = new JButton("Finalizar Compra");
		btnFinalizar.addActionListener(this);
		GridBagConstraints gbc_btnFinalizar = new GridBagConstraints();
		gbc_btnFinalizar.anchor = GridBagConstraints.SOUTH;
		gbc_btnFinalizar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFinalizar.insets = new Insets(0, 0, 0, 5);
		gbc_btnFinalizar.gridx = 1;
		gbc_btnFinalizar.gridy = 3;
		contentPane.add(btnFinalizar, gbc_btnFinalizar);

		JLabel lblTotal = new JLabel("Total");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotal.gridx = 3;
		gbc_lblTotal.gridy = 3;
		contentPane.add(lblTotal, gbc_lblTotal);

		txtTotal = new JTextField();
		GridBagConstraints gbc_txtTotal = new GridBagConstraints();
		gbc_txtTotal.anchor = GridBagConstraints.NORTH;
		gbc_txtTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotal.gridx = 4;
		gbc_txtTotal.gridy = 3;
		contentPane.add(txtTotal, gbc_txtTotal);
		txtTotal.setColumns(10);

	}

	private int obtenerCodVendedor() {
		return Logueo.newUser.getCode();
	}

	private int leerCodCliente() {
		// TODO Auto-generated method stub
		return Integer.parseInt(txtCodCliente.getText());
	}

	private String obtenerNumBoleta() {
		return new SellMaintenance().generateTicketNumber();
	}

	private String obtenerFecha() {
		// Obtener la fecha del sistema
		return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	}

	private int leerCantidad() {
		// TODO Auto-generated method stub
		System.out.println(txtCantidadAComprar.getText());
		return Integer.parseInt(txtCantidadAComprar.getText());
	}

	private int leerStock() {
		// TODO Auto-generated method stub
		return Integer.parseInt(txtStockProducto.getText());
	}

	private double leerPrecio() {
		// TODO Auto-generated method stub
		return Double.parseDouble(txtPreProducto.getText());
	}

	private String leerNomProd() {
		// TODO Auto-generated method stub
		return txtDesProducto.getText();
	}

	private String leerCodProd() {
		// TODO Auto-generated method stub
		return txtCodProducto.getText();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(arg0);
		}
		if (arg0.getSource() == btnFinalizar) {
			actionPerformedBtnFinalizar(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
		if (arg0.getSource() == btnConsultarProducto) {
			actionPerformedBtnConsultarProducto(arg0);
		}
		if (arg0.getSource() == btnConsultarCliente) {
			actionPerformedBtnConsultarCliente(arg0);
		}
	}

	protected void actionPerformedBtnConsultarCliente(ActionEvent arg0) {
		DlgCliente c = new DlgCliente();
		c.setVisible(true);
	}

	protected void actionPerformedBtnConsultarProducto(ActionEvent arg0) {
		DlgProducto p = new DlgProducto();
		p.setVisible(true);
	}

	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		addProduct();
	}

	public void addProduct() {
		String productCode, productName;
		int productQuantity, productStock;
		double productPrice, productImport;

		productCode = leerCodProd();
		productName = leerNomProd();
		productQuantity = leerCantidad();
		productPrice = leerPrecio();
		productStock = leerStock();

		if (productQuantity > productStock) {
			JOptionPane.showMessageDialog(null, "Error, cantidad no disponible.");
			return;
		}

		productImport = productQuantity * productPrice;
		total += productImport;

		txtSalida.append(productCode + "\t" + productName + "\t" + productQuantity + "\t" + productPrice + "\t"
				+ String.valueOf(productImport + "\t"));
		txtTotal.setText(String.valueOf(total));
		cart.add(new TicketDetails(null, productCode, productQuantity, productPrice, productImport));
	}

	protected void actionPerformedBtnFinalizar(ActionEvent arg0) {
		finalizePurchase();
	}

	public void finalizePurchase() {
		String idTicket;
		String ticketDate;
		int idClient;
		int idSeller;
		double ticketTotals;

		idTicket = obtenerNumBoleta();
		ticketDate = obtenerFecha();
		idClient = leerCodCliente();
		idSeller = obtenerCodVendedor();
		ticketTotals = total;

		TicketHeader ticketHeader = new TicketHeader(idTicket, ticketDate, idClient, idSeller, ticketTotals);
		int result = new SellMaintenance().doSell(ticketHeader, cart);

		if (result == 0) {
			JOptionPane.showMessageDialog(null, "Error en la transacción");
		} else {
			txtNumBoleta.setText(idTicket);
			JOptionPane.showMessageDialog(null, "Transacción OK");
			clearTicket();
		}
	}
	
	public void clearTicket() {
		txtCantidadAComprar.setText("");
		txtCodCliente.setText("");
		txtCodProducto.setText("");
		txtDesProducto.setText("");
		txtFechaActual.setText("");
		txtNomCompletoCliente.setText("");
		txtNumBoleta.setText("");
		txtPreProducto.setText("");
		txtSalida.setText("");
		txtStockProducto.setText("");
		txtTotal.setText("");
		total = 0;
		cart = new ArrayList<TicketDetails>();
	}
	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		clearTicket();
	}
}
