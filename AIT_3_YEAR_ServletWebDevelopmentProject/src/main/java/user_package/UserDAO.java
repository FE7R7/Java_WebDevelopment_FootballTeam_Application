package user_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public enum UserDAO {

		instance;

	// Constructor
	private UserDAO() {

	}

	// --------------------------- Connecting ------------------------------ //

	public Connection getConnection() throws Exception {

		Class.forName("org.hsqldb.jdbcDriver");
		return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");

	}

// --------------------------- CREATE -> save() method ------------------------------ //

	public int save(User user) throws Exception {

		int userSaved;

		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement("INSERT INTO UserFootball (name, email, password) VALUES (?, ?, ?)")) {

			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());

			userSaved = ps.executeUpdate();

		}
		return userSaved;

	}

// --------------------------- READ -> search method() ------------------------------ //

	public User search(int id) throws Exception {

		User userReadUser = null;

		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT * FROM UserFootball WHERE id = ?")) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");

				userReadUser = new User(id, name, email, password);

			}

		}
		return userReadUser;

	}

// --------------------------- UPDATE -> update() method ------------------------------ //

	public int update(int id, User updateU) throws Exception {

		int rowsUpdated;

		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE UserFootball SET name = ?, email = ?, password = ? WHERE id = ?")) {

			ps.setString(1, updateU.getName());
			ps.setString(2, updateU.getEmail());
			ps.setString(3, updateU.getPassword());
			ps.setInt(4, id);

			rowsUpdated = ps.executeUpdate();

		}
		return rowsUpdated;
	}

// --------------------------- DELETE -> remove() method ------------------------------ //

	public boolean remove(int id) throws Exception {

		boolean result = false;

		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement("DELETE FROM UserFootball WHERE id = ?")) {

			ps.setInt(1, id);

			int del = ps.executeUpdate();

			if (del > 0) {
				result = true;

			}
		}
		return result;

	}

// --------------------------- checkLogin() method ------------------------------ //

	public int checkLoginAndGetId(String name, String password) throws Exception {

		int userId = -1; // Default set to -1, meaning "not found"

		try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement("SELECT id FROM UserFootball WHERE name = ? AND password = ?")) {

			stmt.setString(1, name);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				userId = rs.getInt("id");

			}

		}
		return userId;

	}
}
