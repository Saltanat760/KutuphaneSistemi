package entity;

public class User {
	private String username;
	private String name;
	private String surname;
	private String email;
	private String authority;
	private String password;
	private int enabled;

	public User(String username, String name, String surname, String email, String authority, String password,
			int enabled) {
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.authority = authority;
		this.password = password;
		this.enabled = enabled;
	}

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", authority=" + authority + ", password=" + password + ", enabled=" + enabled + "]";
	}

}
