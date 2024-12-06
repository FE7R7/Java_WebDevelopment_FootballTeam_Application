package user_package;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RemoveUserServlet")
public class RemoveUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RemoveUserServlet() {

		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		Integer userId = (Integer) session.getAttribute("userId");

		if (userId == null) {

			response.sendRedirect("login.jsp");
			return;
		}

		try {

			boolean removed = UserDAO.instance.remove(userId);

			if (removed) {

				// Invalidate the session and redirect to logout or login page
				session.invalidate();
				response.sendRedirect("logout.jsp");

			} else {

				request.setAttribute("userNameDeleted", "NO");
				request.getRequestDispatcher("userActions.jsp").forward(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("userNameDeleted", "error");
			request.getRequestDispatcher("userActions.jsp").forward(request, response);
		}
	}
}
