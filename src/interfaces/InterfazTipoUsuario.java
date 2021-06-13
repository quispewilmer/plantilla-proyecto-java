package interfaces;

import java.util.ArrayList;

import model.UserType;

public interface InterfazTipoUsuario {
	public ArrayList<UserType> listUserType();
	public UserType searchUserType(int code);
}
