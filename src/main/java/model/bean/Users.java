package model.bean;

public class Users {
	private int id;
	private String username;
	private String fullname;
	private String phoneNumber;
	private String address;
	private String password;
	private int role;

	public Users() {
	}

	public Users(int id, String username, String fullname, String phoneNumber, String address, String password,
			int role) {
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
