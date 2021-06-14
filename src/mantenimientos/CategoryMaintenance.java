package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.InterfazCategoria;
import model.Category;
import utils.MySQLConexion8;

public class CategoryMaintenance implements InterfazCategoria {

	@Override
	public ArrayList<Category> listCategories() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String SQL = "SELECT * FROM tb_categorias";
		ArrayList<Category> categoryList = null;
		Category category = null;

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);
			resultSet = preparedStatement.executeQuery();
			categoryList = new ArrayList<Category>();

			while (resultSet.next()) {
				category = new Category();
				category.setIdCategory(resultSet.getInt(1));
				category.setCategoryDescription(resultSet.getString(2));
				categoryList.add(category);
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

		return categoryList;
	}

}
