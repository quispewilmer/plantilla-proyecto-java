package interfaces;

import model.User;

public interface InterfazUsuario {
	public int add(User user);
	public int update(User user);
	public int delete(int code);
	public User search(int code);
}
