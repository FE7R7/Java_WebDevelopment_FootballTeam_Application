package user_package;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UpdateUserServlet() {

		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		Integer userId = (Integer) session.getAttribute("userId");

		if (userId == null) {

			// Redirect to login page if user is not logged in
			response.sendRedirect("login.jsp");
			return;
		}

		String nameToUpdate = request.getParameter("name");
		String emailToUpdate = request.getParameter("email");
		String passwordToUpdate = request.getParameter("password");

		User updateUser = new User(nameToUpdate, emailToUpdate, passwordToUpdate);
		updateUser.setId(userId);

		try {

			int updated = UserDAO.instance.update(userId, updateUser);

			if (updated > 0) {
				request.setAttribute("updateStatus", "success");

			} else {
				request.setAttribute("updateStatus", "failed");

			}

			request.getRequestDispatcher("userActions.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("updateStatus", "error");
			request.getRequestDispatcher("userActions.jsp").forward(request, response);
		}
	}
}
