package footbal_team_package;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RemoveFootballTeamServlet
 */
@WebServlet("/RemoveFootballTeamServlet")
public class RemoveFootballTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveFootballTeamServlet() {
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

		String idToRemove = request.getParameter("id");

		int teamId = Integer.parseInt(idToRemove);

		try {

			boolean removed = FootballTeamDAO.instance.remove(teamId, userId);

			if (removed) {
				request.setAttribute("teamNameDeleted", "YES");

			} else {
				request.setAttribute("teamNameDeleted", "NO");

			}

			request.getRequestDispatcher("footballTeamActions.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
