package footbal_team_package;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateFootballTeamServlet
 */
@WebServlet("/UpdateFootballTeamServlet")
public class UpdateFootballTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateFootballTeamServlet() {
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

		String idToUpdate = request.getParameter("id");
		String nameToUpdate = request.getParameter("name");
		String nationalityToUpdate = request.getParameter("nationality");
		String stadiumToUpdate = request.getParameter("stadium");

		int teamId = Integer.parseInt(idToUpdate);

		FootballTeam updateT = new FootballTeam(nameToUpdate, nationalityToUpdate, stadiumToUpdate);

		try {

			int updated = FootballTeamDAO.instance.update(teamId, updateT, userId);

			if (updated > 0) {
				request.setAttribute("teamNameUpdated", "YES");

			} else {
				request.setAttribute("teamNameUpdated", "NO");

			}

			// Forward to the team actions page
			request.getRequestDispatcher("footballTeamActions.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
