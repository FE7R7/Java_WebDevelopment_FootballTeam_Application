package user_package;

public class User {

	private int id;
	private String name;
	private String email;
	private String password;

	// Constructor for user without an assigned ID yet
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	// Constructor for user an assigned ID
	public User(int id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Email: " + email + ", Password: " + password + ", ID: " + id;
	}
}
