package footbal_team_package;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListAllFootballTeamServlet
 */
@WebServlet("/ListAllFootballTeamServlet")
public class ListAllFootballTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListAllFootballTeamServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<FootballTeam> listOfTeams = new ArrayList<>();

		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");

		if (userId == null) {

			response.sendRedirect("userLogin.jsp");
			return;
		}

		try {

			listOfTeams = FootballTeamDAO.instance.list(userId);

			request.setAttribute("newTeamList", listOfTeams);

			request.getRequestDispatcher("listAllFootballTeams.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
