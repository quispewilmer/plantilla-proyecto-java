package vista;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Product;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRegProd extends JInternalFrame {
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtCantidad;
	private JTextField txtPrecio;

	private JTextArea txtS;
	private JComboBox cboTipo;

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
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 506, 350);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(30, 48, 75, 14);
		getContentPane().add(label);

		txtCodigo = new JTextField();
		txtCodigo.setText("");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(109, 46, 86, 20);
		getContentPane().add(txtCodigo);

		JLabel label_1 = new JLabel("Product:");
		label_1.setBounds(30, 73, 75, 14);
		getContentPane().add(label_1);

		txtProducto = new JTextField();
		txtProducto.setText("");
		txtProducto.setColumns(10);
		txtProducto.setBounds(109, 71, 86, 20);
		getContentPane().add(txtProducto);

		JLabel label_2 = new JLabel("Tipo:");
		label_2.setBounds(30, 98, 53, 14);
		getContentPane().add(label_2);

		cboTipo = new JComboBox();
		cboTipo.setBounds(109, 95, 123, 20);
		cboTipo.setModel(new DefaultComboBoxModel(new String[] { "Seleccione tipo", "Pastillas", "Jarabe", "Otros" }));
		getContentPane().add(cboTipo);

		JLabel label_3 = new JLabel("Cantidad:");
		label_3.setBounds(30, 122, 86, 14);
		getContentPane().add(label_3);

		txtCantidad = new JTextField();
		txtCantidad.setText("");
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(107, 120, 53, 20);
		getContentPane().add(txtCantidad);

		JLabel label_4 = new JLabel("Precio:");
		label_4.setBounds(178, 122, 67, 14);
		getContentPane().add(label_4);

		txtPrecio = new JTextField();
		txtPrecio.setText("");
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(240, 120, 60, 20);
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

		txtS = new JTextArea();
		txtS.setText("");
		txtS.setBounds(30, 169, 434, 95);
		getContentPane().add(txtS);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(328, 123, 116, 34);
		getContentPane().add(btnEditar);

		JLabel lblMantenimientoDeProductos = new JLabel("Mantenimiento de Productos");
		lblMantenimientoDeProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMantenimientoDeProductos.setBounds(21, 13, 224, 20);
		getContentPane().add(lblMantenimientoDeProductos);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(191, 275, 109, 25);
		getContentPane().add(btnConsultar);

	}

	void ingresar() {
		String cod = null, prod = null;
		int cant = 0;
		double pre = 0;
		int tipo = 0;

		try {
			cod  = leerCodigo();
			prod = leerProducto();
			cant = leerCantidad();
			pre  = leerPrecio();
			tipo = leerTipo();			
			txtS.setText("prod\tCant\tPrecio\n");
			txtS.append(prod + "\t" + cant + "\t" + pre);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private String leerCodigo() throws Exception {
		String answer = null;
		if(txtCodigo.getText().length() != 0 && txtCodigo.getText().matches("i[0-9]{9}@cibertec.edu.pe")) {
			try {
				answer = txtCodigo.getText();
			} catch(Exception e) {
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
		if(txtProducto.getText().length() != 0) {
			try {
				answer = txtProducto.getText();
				answer = answer.substring(0, 1).toUpperCase() + answer.substring(1);
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe llenar el campo de producto");
			throw new Exception();
		}
		
		return answer;
	}
	
	int leerTipo() {
		return cboTipo.getSelectedIndex();
	}

	int leerCantidad() throws Exception {
		int answer = 0;
		if(txtCantidad.getText().length() != 0) {
			try {
				answer = Integer.parseInt(txtCantidad.getText());
			} catch(Exception e) {
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
		if(txtPrecio.getText().length() != 0) {
			try {
				answer = Double.parseDouble(txtPrecio.getText());
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Debe poner un precio válido");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe llenar el campo de precio");
			throw new Exception();
		}
		
		return answer;
	}
}
