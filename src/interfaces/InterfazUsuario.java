package interfaces;

import java.util.ArrayList;

import model.User;

public interface InterfazUsuario {
	public int add(User user);
	public int update(User user);
	public int delete(int code);
	public User search(int code);
	public ArrayList<User> getUsers();
	public ArrayList<User> getUsersByType(int idType);
}
