package footbal_team_package;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterFootballTeamServlet
 */
@WebServlet("/RegisterFootballTeamServlet")
public class RegisterFootballTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterFootballTeamServlet() {
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

		FootballTeam t = new FootballTeam(request.getParameter("name"), request.getParameter("nationality"), request.getParameter("stadium"));

		try {

			int saved = FootballTeamDAO.instance.save(t, userId);

			if (saved > 0) {
				request.setAttribute("teamNameCreated", "YES");

			} else {
				request.setAttribute("teamNameCreated", "NO");

			}

			// Forward to the football team actions page
			request.getRequestDispatcher("footballTeamActions.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
