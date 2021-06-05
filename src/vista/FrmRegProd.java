package vista;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Producto;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmRegProd extends JInternalFrame implements MouseListener {
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JComboBox cboTipo;
	private JTable tabla;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegProd frame = new FrmRegProd();
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
	public FrmRegProd() {
		setIconifiable(true);
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 506, 363);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(30, 48, 75, 14);
		getContentPane().add(label);

		txtCodigo = new JTextField();
		txtCodigo.setText("");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(88, 42, 86, 20);
		getContentPane().add(txtCodigo);

		JLabel label_1 = new JLabel("Producto:");
		label_1.setBounds(30, 73, 75, 14);
		getContentPane().add(label_1);

		txtProducto = new JTextField();
		txtProducto.setText("");
		txtProducto.setColumns(10);
		txtProducto.setBounds(88, 70, 86, 20);
		getContentPane().add(txtProducto);

		JLabel label_2 = new JLabel("Tipo:");
		label_2.setBounds(30, 98, 53, 14);
		getContentPane().add(label_2);

		cboTipo = new JComboBox();
		cboTipo.setBounds(88, 94, 123, 20);
		cboTipo.setModel(new DefaultComboBoxModel(new String[] { "Seleccione tipo", "Pastillas", "Jarabe", "Otros" }));
		getContentPane().add(cboTipo);

		JLabel label_3 = new JLabel("Cantidad:");
		label_3.setBounds(30, 122, 60, 14);
		getContentPane().add(label_3);

		txtCantidad = new JTextField();
		txtCantidad.setText("");
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(88, 119, 53, 20);
		getContentPane().add(txtCantidad);

		JLabel label_4 = new JLabel("Precio:");
		label_4.setBounds(178, 122, 46, 14);
		getContentPane().add(label_4);

		txtPrecio = new JTextField();
		txtPrecio.setText("");
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(220, 119, 60, 20);
		getContentPane().add(txtPrecio);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(328, 28, 116, 34);
		getContentPane().add(btnNuevo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
			}
		});
		btnGuardar.setBounds(328, 78, 116, 34);
		getContentPane().add(btnGuardar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(328, 123, 116, 34);
		getContentPane().add(btnEditar);

		JLabel lblMantenimientoDeProductos = new JLabel("Mantenimiento de Productos");
		lblMantenimientoDeProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMantenimientoDeProductos.setBounds(21, 13, 224, 20);
		getContentPane().add(lblMantenimientoDeProductos);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(191, 294, 109, 25);
		getContentPane().add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 164, 414, 120);
		getContentPane().add(scrollPane);
		
		Object[] columnas = {
			"Código",
			"Nombre",
			"Categoría",
			"Stock",
			"Precio"
		};
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(columnas);
		tabla = new JTable(modelo);
		tabla.addMouseListener(this);
		tabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tabla);

	}

	void ingresar() {
		String cod, prod;
		int cant;
		double pre;
		int tipo;

		cod  = leerCodigo();
		prod = leerProducto();
		cant = leerCantidad();
		pre  = leerPrecio();
		tipo = leerTipo();

	}

	private String leerCodigo() {
		return txtCodigo.getText();
	}

	String leerProducto() {
		return txtProducto.getText();
	}
	
	int leerTipo() {
		return cboTipo.getSelectedIndex();
	}

	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}

	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tabla) {
			mouseClickedTabla(e);
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
	protected void mouseClickedTabla(MouseEvent e) {
		int fila = tabla.getSelectedRow();
	}
}
