package footbal_team_package;

public class FootballTeam {

	private int id;
	private String name;
	private String nationality;
	private String stadium;

	public FootballTeam(String name, String nationality, String stadium) {

		this.name = name;
		this.nationality = nationality;
		this.stadium = stadium;

	}

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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	@Override
	public String toString() {

		return "Name: " + name + " Nationality: " + nationality + "Stadium: " + stadium;
	}

}
