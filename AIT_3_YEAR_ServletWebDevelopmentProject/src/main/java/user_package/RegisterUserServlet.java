package user_package;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServelet
 */
@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create a new User object from form data
		User user = new User(request.getParameter("name"), request.getParameter("email"), request.getParameter("password"));

		try {
			int userId = UserDAO.instance.save(user); // Retrieve the generated user ID

			if (userId > 0) {
				// Set userId in the session to maintain the logged-in user context
				request.getSession().setAttribute("userId", userId);
				request.setAttribute("userNameCreated", "YES");
			} else {
				request.setAttribute("userNameCreated", "NO");
			}

			// Forward the request after setting the attribute
			request.getRequestDispatcher("userActions.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
