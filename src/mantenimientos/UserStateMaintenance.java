package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.InterfazTipoEstado;
import model.UserState;
import model.UserType;
import utils.MySQLConexion8;

public class UserStateMaintenance implements InterfazTipoEstado {

	@Override
	public ArrayList<UserState> listUserState() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String SQL = "SELECT * FROM tb_estados";
		ArrayList<UserState> userStateList = null;
		UserState userState = null;

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);
			resultSet = preparedStatement.executeQuery();
			userStateList = new ArrayList<UserState>();

			while (resultSet.next()) {
				userState = new UserState();
				userState.setIdUserState(resultSet.getInt(1));
				userState.setUserStateDescription(resultSet.getString(2));
				userStateList.add(userState);
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

		return userStateList;
	}
}
