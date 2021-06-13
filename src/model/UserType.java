package model;

public class UserType {
	private int idUserType;
	private String UserTypeDescription;
	
	public UserType(int idUserType, String userTypeDescription) {
		this.idUserType = idUserType;
		this.UserTypeDescription = userTypeDescription;
	}

	public UserType() {
		
	}

	public int getIdUserType() {
		return idUserType;
	}

	public void setIdUserType(int idUserType) {
		this.idUserType = idUserType;
	}

	public String getUserTypeDescription() {
		return UserTypeDescription;
	}

	public void setUserTypeDescription(String userTypeDescription) {
		UserTypeDescription = userTypeDescription;
	}
}
