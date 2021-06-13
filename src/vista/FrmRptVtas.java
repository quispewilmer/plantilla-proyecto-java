package vista;

import java.awt.EventQueue;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.awt.event.MouseEvent;


public class FrmRptVtas extends JInternalFrame implements MouseListener {
	private JDateChooser txtFecha;
	private JTable tabla;
	DefaultTableModel modelo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRptVtas frame = new FrmRptVtas();
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
	public FrmRptVtas() {
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FrmUserReport de Ventas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 215, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblDel = new JLabel("Del:");
		lblDel.setBounds(20, 59, 39, 24);
		getContentPane().add(lblDel);
		
		JButton btnReporte = new JButton("FrmUserReport");
		btnReporte.setBounds(339, 60, 89, 23);
		getContentPane().add(btnReporte);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 418, 164);
		getContentPane().add(scrollPane);
		
		Object[] columnas = {
				"Fecha",
				"Nombre",
				"Cantidad"
		};
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(columnas);
		tabla = new JTable(modelo);
		tabla.addMouseListener(this);
		tabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tabla);
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(61, 64, 114, 19);
		getContentPane().add(txtFecha);

	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tabla) {
			mouseClickedTable(e);
		}
	}
	
	public String leerFecha() {
		return new SimpleDateFormat("yyyy-MM-dd").format(txtFecha.getDate());
	}
	
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTable(MouseEvent e) {
		int fila = tabla.getSelectedRow();
	}
}
