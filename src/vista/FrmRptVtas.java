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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class FrmRptVtas extends JFrame implements MouseListener {
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
		setBounds(100, 100, 555, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{12, 0, 110, 114, 194, 0, 0};
		gridBagLayout.rowHeights = new int[]{37, 24, 164, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("FrmUserReport de Ventas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblDel = new JLabel("Del:");
		GridBagConstraints gbc_lblDel = new GridBagConstraints();
		gbc_lblDel.fill = GridBagConstraints.BOTH;
		gbc_lblDel.insets = new Insets(0, 0, 5, 5);
		gbc_lblDel.gridx = 1;
		gbc_lblDel.gridy = 1;
		getContentPane().add(lblDel, gbc_lblDel);
		
		txtFecha = new JDateChooser();
		GridBagConstraints gbc_txtFecha = new GridBagConstraints();
		gbc_txtFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFecha.anchor = GridBagConstraints.SOUTH;
		gbc_txtFecha.insets = new Insets(0, 0, 5, 5);
		gbc_txtFecha.gridx = 2;
		gbc_txtFecha.gridy = 1;
		getContentPane().add(txtFecha, gbc_txtFecha);
		
		JButton btnReporte = new JButton("FrmUserReport");
		GridBagConstraints gbc_btnReporte = new GridBagConstraints();
		gbc_btnReporte.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReporte.insets = new Insets(0, 0, 5, 5);
		gbc_btnReporte.gridx = 4;
		gbc_btnReporte.gridy = 1;
		getContentPane().add(btnReporte, gbc_btnReporte);
		
		Object[] columnas = {
				"Fecha",
				"Nombre",
				"Cantidad"
		};
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(columnas);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		getContentPane().add(scrollPane, gbc_scrollPane);
		tabla = new JTable(modelo);
		tabla.addMouseListener(this);
		tabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tabla);

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
