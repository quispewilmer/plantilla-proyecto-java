package vista;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mantenimientos.CategoryMaintenance;
import mantenimientos.ProductMaintenance;
import model.Category;
import model.Product;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.WindowEvent;

public class FrmRegProd extends JFrame implements ActionListener, WindowListener {
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JComboBox cboTipo;
	private JTable table;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnGuardar;
	private DefaultTableModel dtm;

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
		addWindowListener(this);
		setResizable(true);
		setBounds(100, 100, 544, 350);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 23, 0, 53, 54, 60, 136, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 20, 20, 20, 20, 23, 161, 25, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);

		JLabel lblMantenimientoDeProductos = new JLabel("Mantenimiento de Productos");
		lblMantenimientoDeProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMantenimientoDeProductos = new GridBagConstraints();
		gbc_lblMantenimientoDeProductos.anchor = GridBagConstraints.WEST;
		gbc_lblMantenimientoDeProductos.fill = GridBagConstraints.VERTICAL;
		gbc_lblMantenimientoDeProductos.insets = new Insets(0, 0, 5, 5);
		gbc_lblMantenimientoDeProductos.gridwidth = 4;
		gbc_lblMantenimientoDeProductos.gridx = 1;
		gbc_lblMantenimientoDeProductos.gridy = 0;
		getContentPane().add(lblMantenimientoDeProductos, gbc_lblMantenimientoDeProductos);

		JLabel label = new JLabel("C\u00F3digo:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.HORIZONTAL;
		gbc_label.anchor = GridBagConstraints.NORTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		getContentPane().add(label, gbc_label);

		txtCodigo = new JTextField();
		txtCodigo.setText("");
		txtCodigo.setColumns(10);
		GridBagConstraints gbc_txtCodigo = new GridBagConstraints();
		gbc_txtCodigo.fill = GridBagConstraints.BOTH;
		gbc_txtCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodigo.gridwidth = 3;
		gbc_txtCodigo.gridx = 2;
		gbc_txtCodigo.gridy = 1;
		getContentPane().add(txtCodigo, gbc_txtCodigo);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNuevo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevo.gridx = 5;
		gbc_btnNuevo.gridy = 1;
		getContentPane().add(btnNuevo, gbc_btnNuevo);

		JLabel label_1 = new JLabel("Product:");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_1.anchor = GridBagConstraints.NORTH;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 2;
		getContentPane().add(label_1, gbc_label_1);

		txtProducto = new JTextField();
		txtProducto.setText("");
		txtProducto.setColumns(10);
		GridBagConstraints gbc_txtProducto = new GridBagConstraints();
		gbc_txtProducto.fill = GridBagConstraints.BOTH;
		gbc_txtProducto.insets = new Insets(0, 0, 5, 5);
		gbc_txtProducto.gridwidth = 3;
		gbc_txtProducto.gridx = 2;
		gbc_txtProducto.gridy = 2;
		getContentPane().add(txtProducto, gbc_txtProducto);
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 5;
		gbc_btnGuardar.gridy = 2;
		getContentPane().add(btnGuardar, gbc_btnGuardar);

		JLabel label_2 = new JLabel("Tipo:");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_2.anchor = GridBagConstraints.NORTH;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 3;
		getContentPane().add(label_2, gbc_label_2);

		cboTipo = new JComboBox();
		GridBagConstraints gbc_cboTipo = new GridBagConstraints();
		gbc_cboTipo.fill = GridBagConstraints.BOTH;
		gbc_cboTipo.insets = new Insets(0, 0, 5, 5);
		gbc_cboTipo.gridwidth = 3;
		gbc_cboTipo.gridx = 2;
		gbc_cboTipo.gridy = 3;
		getContentPane().add(cboTipo, gbc_cboTipo);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEditar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditar.gridx = 5;
		gbc_btnEditar.gridy = 3;
		getContentPane().add(btnEditar, gbc_btnEditar);

		JLabel label_3 = new JLabel("Cantidad:");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 4;
		getContentPane().add(label_3, gbc_label_3);

		txtCantidad = new JTextField();
		txtCantidad.setText("");
		txtCantidad.setColumns(10);
		GridBagConstraints gbc_txtCantidad = new GridBagConstraints();
		gbc_txtCantidad.anchor = GridBagConstraints.NORTH;
		gbc_txtCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_txtCantidad.gridx = 2;
		gbc_txtCantidad.gridy = 4;
		getContentPane().add(txtCantidad, gbc_txtCantidad);

		JLabel label_4 = new JLabel("Precio:");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 3;
		gbc_label_4.gridy = 4;
		getContentPane().add(label_4, gbc_label_4);

		txtPrecio = new JTextField();
		txtPrecio.setText("");
		txtPrecio.setColumns(10);
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.anchor = GridBagConstraints.NORTH;
		gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecio.gridx = 4;
		gbc_txtPrecio.gridy = 4;
		getContentPane().add(txtPrecio, gbc_txtPrecio);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		getContentPane().add(scrollPane, gbc_scrollPane);

		Object[] columns = {
				"Código",
				"Nombre",
				"Stock",
				"Precio",
				"Tipo",
				"Estado"
		};
		dtm = new DefaultTableModel();
		dtm.setColumnIdentifiers(columns);
		table = new JTable(dtm);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

		JButton btnConsultar = new JButton("Consultar");
		GridBagConstraints gbc_btnConsultar = new GridBagConstraints();
		gbc_btnConsultar.anchor = GridBagConstraints.NORTH;
		gbc_btnConsultar.insets = new Insets(0, 0, 0, 5);
		gbc_btnConsultar.gridwidth = 5;
		gbc_btnConsultar.gridx = 1;
		gbc_btnConsultar.gridy = 6;
		getContentPane().add(btnConsultar, gbc_btnConsultar);

	}

	private String leerCodigo() throws Exception {
		String answer = null;
		if (txtCodigo.getText().length() != 0 && txtCodigo.getText().matches("i[0-9]{9}@cibertec.edu.pe")) {
			try {
				answer = txtCodigo.getText();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe llenar correctamente el campo de código");
			throw new Exception();
		}

		return answer;
	}

	private String leerProducto() throws Exception {
		String answer = null;
		if (txtProducto.getText().length() != 0) {
			try {
				answer = txtProducto.getText();
				answer = answer.substring(0, 1).toUpperCase() + answer.substring(1);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe llenar el campo de producto");
			throw new Exception();
		}

		return answer;
	}

	int leerTipo() {
		return Integer.parseInt(cboTipo.getSelectedItem().toString().split(" - ")[0]);
	}

	int leerCantidad() throws Exception {
		int answer = 0;
		if (txtCantidad.getText().length() != 0) {
			try {
				answer = Integer.parseInt(txtCantidad.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Debe poner una cantidad válida");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe llenar el campo de cantidad");
			throw new Exception();
		}

		return 0;
	}

	double leerPrecio() throws Exception {
		double answer = 0;
		if (txtPrecio.getText().length() != 0) {
			try {
				answer = Double.parseDouble(txtPrecio.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Debe poner un precio válido");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe llenar el campo de precio");
			throw new Exception();
		}

		return answer;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(arg0);
		}
		if (arg0.getSource() == btnEditar) {
			actionPerformedBtnEditar(arg0);
		}
		if (arg0.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(arg0);
		}
	}

	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		registerProduct();
	}

	protected void actionPerformedBtnEditar(ActionEvent arg0) {
		editProduct();
	}
	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		saveProduct();
	}
	
	public void registerProduct() {
		clearTxts();
	}
	
	public void editProduct() {
		int quantity = 0;
		ProductMaintenance productMaintenance = new ProductMaintenance();
		try {
			quantity = productMaintenance.update(new Product(leerCodigo(), leerProducto(), leerCantidad(), leerPrecio(), leerTipo(), true));
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error: " + e.getMessage());
		}
		
		if (quantity > 0) {
			JOptionPane.showMessageDialog(null, "Producto actualizado correctamente.");
			clearTxts();
		} else {
			JOptionPane.showMessageDialog(null, "Producto no ha sido actualizado.");
		}
	}
	
	public void saveProduct() {
		int quantity = 0;
		ProductMaintenance productMaintenance = new ProductMaintenance();
		try {
			quantity = productMaintenance.add(new Product(leerCodigo(), leerProducto(), leerCantidad(), leerPrecio(), leerTipo(), true));
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error: " + e.getMessage());
		}
		
		if (quantity > 0) {
			JOptionPane.showMessageDialog(null, "Producto registrado correctamente.");
			clearTxts();
		} else {
			JOptionPane.showMessageDialog(null, "Producto no ha sido registrado.");
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
		listProducts();
		listCategoriesOnCbo();
	}
	
	public void listProducts() {
		ProductMaintenance productMaintenance = new ProductMaintenance();
		ArrayList<Product> productsList = productMaintenance.listProducts();
		
		for(Product product : productsList) {
			Object[] productItem = {
				product.getIdProduct(),
				product.getProductDescription(),
				product.getProductQuantity(),
				product.getProductPrice(),
				product.getProductType(),
				product.isProductState()
			};
			dtm.addRow(productItem);
		}
	}
	
	public void clearTxts() {
		txtCodigo.setText("");
		txtProducto.setText("");
		cboTipo.setSelectedIndex(1);
		txtCantidad.setText("");
		txtPrecio.setText("");
	}
	
	public void listCategoriesOnCbo() {
		CategoryMaintenance categoryMaintenance = new CategoryMaintenance();
		ArrayList<Category> categoriesList = categoryMaintenance.listCategories();
		
		for(Category category : categoriesList) {
			cboTipo.addItem(category.getIdCategory() + " - " + category.getCategoryDescription());
		}
	}
}
