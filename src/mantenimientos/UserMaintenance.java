package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.InterfazUsuario;
import model.User;
import utils.MySQLConexion8;

public class UserMaintenance implements InterfazUsuario {

	@Override
	public int add(User user) {
		int rs = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		final String SQL = "INSERT INTO tb_usuarios VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, user.getCode());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getUser());
			preparedStatement.setString(5, user.getKey());
			preparedStatement.setString(6, user.getBirthday());
			preparedStatement.setInt(7, user.getType());
			preparedStatement.setInt(8, user.getState());

			rs = preparedStatement.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al conectar.");
			System.out.println(e.getCause() + e.getLocalizedMessage());
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
	public int update(User user) {
		int rs = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		final String SQL = "UPDATE tb_usuarios SET nombre = ?, apellido = ?, usuario = ?, clave = ?, fnacim = ?, tipo = ?, estado = ? WHERE codigo = ?";

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUser());
			preparedStatement.setString(4, user.getKey());
			preparedStatement.setString(5, user.getBirthday());
			preparedStatement.setInt(6, user.getType());
			preparedStatement.setInt(7, user.getState());
			preparedStatement.setInt(8, user.getCode());

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
		final String SQL = "DELETE FROM tb_usuarios WHERE codigo = ?";

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, code);

			rs = preparedStatement.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al conectar.");
			System.out.println(e.getLocalizedMessage() + e.getCause());
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
	public User search(int code) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String SQL = "SELECT * FROM tb_usuarios WHERE codigo = ?";
		User user = null;

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, code);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7),
						resultSet.getInt(8));
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
		return user;
	}

	@Override
	public ArrayList<User> getUsers() {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String SQL = "SELECT codigo, nombre, apellido, usuario, fnacim, tipo, estado FROM tb_usuarios";
		ArrayList<User> usersList = null;
		User user = null;

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);
			resultSet = preparedStatement.executeQuery();
			usersList = new ArrayList<User>();

			while (resultSet.next()) {
				user = new User();
				user.setCode(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setLastName(resultSet.getString(3));
				user.setUser(resultSet.getString(4));
				user.setBirthday(resultSet.getString(5));
				user.setType(resultSet.getInt(6));
				user.setState(resultSet.getInt(7));
				usersList.add(user);
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

		return usersList;
	}

	@Override
	public ArrayList<User> getUsersByType(int idType) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String SQL = "{CALL usp_listarUsuariosPorTipo(?)}";
		ArrayList<User> usersList = null;
		User user = null;

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, idType);
			resultSet = preparedStatement.executeQuery();
			usersList = new ArrayList<User>();

			while (resultSet.next()) {
				user = new User();
				user.setCode(resultSet.getInt(1));
				user.setName(resultSet.getString(2) + ", " + resultSet.getString(3));
				user.setType(resultSet.getInt(7));
				usersList.add(user);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al conectar.");
			System.out.println(e.getMessage() + e.getLocalizedMessage() + e.getCause());
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Hubo un error al cerrar la conexión.");
			}
		}

		return usersList;
	}

	@Override
	public User validateAccess(String user, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String SQL = "{CALL usp_validarUsuario(?, ?)}";
		User userS = null;

		try {
			connection = MySQLConexion8.getConexion();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, password);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				userS = new User();
				userS.setCode(resultSet.getInt(1));
				userS.setName(resultSet.getString(2));
				userS.setUser(resultSet.getString(4));
				userS.setKey(resultSet.getString(5));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al conectar.");
			System.out.println(e.getMessage() + e.getLocalizedMessage() + e.getCause());
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Hubo un error al cerrar la conexión.");
			}
		}
		return userS;
	}

}
