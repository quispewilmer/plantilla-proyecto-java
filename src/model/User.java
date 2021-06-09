package model;

public class User {
	private int code;
	private String name;
	private String lastName;
	private String user;
	private String key;
	private String birthday;
	private int type;
	private int state;

	public User() {

	}

	public User(int code, String name, String lastName, String user, String key, String birthday, int type, int state) {
		this.code = code;
		this.name = name;
		this.lastName = lastName;
		this.user = user;
		this.key = key;
		this.birthday = birthday;
		this.type = type;
		this.state = state;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
