package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.InterfazProducto;
import model.Product;
import model.User;
import utils.MySQLConexion8;

public class ProductMaintenance implements InterfazProducto {

	@Override
	public int add(Product product) {
		int rs = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		final String SQL = "INSERT INTO tb_productos VALUES (?, ?, ?, ?, ?, ?)";

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, product.getIdProduct());
			preparedStatement.setString(2, product.getProductDescription());
			preparedStatement.setInt(3, product.getProductQuantity());
			preparedStatement.setDouble(4, product.getProductPrice());
			preparedStatement.setInt(5, product.getProductType());
			preparedStatement.setBoolean(6, product.isProductState());

			rs = preparedStatement.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al conectar.");
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Hubo un error al cerrar la conexión.");
			}
		}
		return rs;
	}

	@Override
	public int update(Product product) {
		int rs = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		final String SQL = "UPDATE tb_productos SET descripcion = ?, stock = ?, precio = ?, idstock = ?, estado = ? WHERE idprod = ?";

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, product.getProductDescription());
			preparedStatement.setInt(2, product.getProductQuantity());
			preparedStatement.setDouble(3, product.getProductPrice());
			preparedStatement.setInt(4, product.getProductType());
			preparedStatement.setBoolean(5, product.isProductState());
			preparedStatement.setString(6, product.getIdProduct());

			rs = preparedStatement.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al conectar.");
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Hubo un error al cerrar la conexión.");
			}
		}
		return rs;
	}

	@Override
	public int delete(int code) {
		int rs = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		final String SQL = "DELETE FROM tb_productos WHERE idprod = ?";

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, code);

			rs = preparedStatement.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al conectar.");
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Hubo un error al cerrar la conexión.");
			}
		}
		return rs;
	}

	@Override
	public Product search(int code) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String SQL = "SELECT * FROM tb_productos WHERE codigo = ?";
		Product product = null;

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, code);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				product = new Product(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3),
						resultSet.getDouble(4), resultSet.getInt(5), resultSet.getBoolean(6));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al conectar.");
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Hubo un error al cerrar la conexión.");
			}
		}
		return product;
	}

	@Override
	public ArrayList<Product> listProducts() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String SQL = "SELECT * FROM tb_productos";
		ArrayList<Product> productsList = null;
		Product product = null;

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);
			resultSet = preparedStatement.executeQuery();
			productsList = new ArrayList<Product>();

			while (resultSet.next()) {
				product = new Product();
				product.setIdProduct(resultSet.getString(1));
				product.setProductDescription(resultSet.getString(2));
				product.setProductQuantity(resultSet.getInt(3));
				product.setProductPrice(resultSet.getDouble(4));
				product.setProductType(resultSet.getInt(5));
				product.setProductState(resultSet.getBoolean(6));
				productsList.add(product);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al conectar.");
			System.out.println(e.getMessage() + e.getLocalizedMessage() + e.getCause() + e.getStackTrace());
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Hubo un error al cerrar la conexión.");
			}
		}

		return productsList;
	}

}
