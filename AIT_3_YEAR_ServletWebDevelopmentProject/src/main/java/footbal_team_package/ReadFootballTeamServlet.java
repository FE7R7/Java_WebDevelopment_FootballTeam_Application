package footbal_team_package;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReadFootballTeamServlet
 */
@WebServlet("/ReadFootballTeamServlet")
public class ReadFootballTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadFootballTeamServlet() {
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

		HttpSession session = request.getSession();

		Integer userId = (Integer) session.getAttribute("userId");

		if (userId == null) {

			response.sendRedirect("indexLogin.jsp"); // Redirect to login if not logged in
			return;

		}

		String idToRead = request.getParameter("id");
		int numberId = Integer.parseInt(idToRead);

		try {

			FootballTeam readTeam = FootballTeamDAO.instance.search(numberId, userId);

			if (readTeam != null) {
				request.setAttribute("teamReadAfterSearch", readTeam);

			} else {
				request.setAttribute("teamReadError", "Team not found or you do not have permission to view it.");

			}

			request.getRequestDispatcher("footballTeamActions.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
