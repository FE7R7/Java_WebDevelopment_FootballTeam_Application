package footbal_team_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public enum FootballTeamDAO {

		instance;

	// Constructor
	private FootballTeamDAO() {
	}

// --------------------------- Connecting ------------------------------ //

	public Connection getConnection() throws Exception {

		Class.forName("org.hsqldb.jdbcDriver");
		return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");

	}

// --------------------------- CREATE -> save() method ------------------------------ //

	public int save(FootballTeam team, int userId) throws Exception {

		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("INSERT INTO TeamFootball (name, nationality, stadium, user_id) VALUES (?, ?, ?, ?)");

		ps.setString(1, team.getName());
		ps.setString(2, team.getNationality());
		ps.setString(3, team.getStadium());
		ps.setInt(4, userId);
		int teamSaved = ps.executeUpdate();

		return teamSaved;
	}

// --------------------------- READ -> search method() ------------------------------ //

	public FootballTeam search(int id, int userId) throws Exception {

		FootballTeam teamReadTeam = null;

		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM TeamFootball WHERE id = ? AND user_id = ?");

		ps.setInt(1, id);
		ps.setInt(2, userId);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			String name = rs.getString("name");
			String nationality = rs.getString("nationality");
			String stadium = rs.getString("stadium");

			teamReadTeam = new FootballTeam(name, nationality, stadium);

		}

		return teamReadTeam;
	}

// --------------------------- UPDATE -> update() method ------------------------------ //

	public int update(int id, FootballTeam updateT, int userId) throws Exception {

		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("UPDATE TeamFootball SET name = ?, nationality = ?, stadium = ? WHERE id = ? AND user_id = ?");

		ps.setString(1, updateT.getName());
		ps.setString(2, updateT.getNationality());
		ps.setString(3, updateT.getStadium());
		ps.setInt(4, id);
		ps.setInt(5, userId);

		int rowsUpdated = ps.executeUpdate();

		return rowsUpdated;
	}

// --------------------------- DELETE -> remove() method ------------------------------ //

	public boolean remove(int id, int userId) throws Exception {

		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("DELETE FROM TeamFootball WHERE id = ? AND user_id = ?");

		ps.setInt(1, id);
		ps.setInt(2, userId);

		int rowsDeleted = ps.executeUpdate();

		return rowsDeleted > 0;
	}

// --------------------------- READ ALL -> list method() ------------------------------ //

	public ArrayList<FootballTeam> list(int userId) throws Exception {

		ArrayList<FootballTeam> teamListReceived = new ArrayList<>();

		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT name, nationality, stadium FROM TeamFootball WHERE user_id = ?");
		ps.setInt(1, userId);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			String name = rs.getString("name");
			String nationality = rs.getString("nationality");
			String stadium = rs.getString("stadium");

			teamListReceived.add(new FootballTeam(name, nationality, stadium));

		}

		return teamListReceived;
	}
}
