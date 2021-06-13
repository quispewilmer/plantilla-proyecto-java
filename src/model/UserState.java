package model;

public class UserState {
	private int idUserState;
	private String userStateDescription;
	
	public UserState() {
		
	}

	public UserState(int idUserState, String userStateDescription) {
		this.idUserState = idUserState;
		this.userStateDescription = userStateDescription;
	}

	public int getIdUserState() {
		return idUserState;
	}

	public void setIdUserState(int idUserState) {
		this.idUserState = idUserState;
	}

	public String getUserStateDescription() {
		return userStateDescription;
	}

	public void setUserStateDescription(String userStateDescription) {
		this.userStateDescription = userStateDescription;
	}
}
