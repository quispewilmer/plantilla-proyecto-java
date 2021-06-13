package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.InterfazTipoUsuario;
import model.User;
import model.UserType;
import utils.MySQLConexion8;

public class UserTypeMaintenance implements InterfazTipoUsuario {

	@Override
	public ArrayList<UserType> listUserType() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String SQL = "SELECT * FROM tb_tipos";
		ArrayList<UserType> userTypeList = null;
		UserType userType = null;

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);
			resultSet = preparedStatement.executeQuery();
			userTypeList = new ArrayList<UserType>();

			while (resultSet.next()) {
				userType = new UserType();
				userType.setIdUserType(resultSet.getInt(1));
				userType.setUserTypeDescription(resultSet.getString(2));
				userTypeList.add(userType);
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

		return userTypeList;
	}

	@Override
	public UserType searchUserType(int code) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String SQL = "SELECT * FROM tb_tipos WHERE id_tipo = ?";
		UserType userType = null;

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, code);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				userType = new UserType();
				userType.setUserTypeDescription(resultSet.getString(2));
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

		return userType;
	}

}
