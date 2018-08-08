package lti.hola.webb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lti.hola.bean.ForgetBean;
import lti.hola.bean.LoginBean;
import lti.hola.bean.RegisterBean;
import lti.hola.service.UserService;
import lti.hola.service.UserServiceImpl;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Sessions declaration from request. If session id exists in request header
		// old session obj returned otherwise fresh session created
		HttpSession session = request.getSession();
		String referer = request.getHeader("referer");
		if (referer.contains("home.jsp")) {
			// Request coming from home for login authentication
			RegisterBean user = LoginController.authenticate(request);
			if (user != null) {
				// Login successful-keeping login user's details in sessions
				session.setAttribute("User", user);

				response.sendRedirect("profile.jsp");
			} else {
				// login failed and url rewriting
				response.sendRedirect("home.jsp?invalid=yes");
			}
		} else if (referer.contains("register.jsp")) {
			// Request coming for user registration
			if (RegisterController.register(request)) {
				response.sendRedirect("home.jsp");
			} else {
				response.sendRedirect("register.jsp");
			}
		} else if (referer.contains("forget.jsp")) {
			// Request coming for validating user for password change
			if (LoginController.forgetPassword(request)) {
				response.sendRedirect("change.jsp");
			} else {
				response.sendRedirect("forget.jsp?invalid=yes");
			}
		} else if (referer.contains("change.jsp")) {
			// Request coming for updating password
			if (LoginController.changePassword(request))
				response.sendRedirect("home.jsp");
			else
				response.sendRedirect("change.jsp");
		} else {
			// Requesting coming for logout - destroying session
			session.invalidate();
			response.sendRedirect("home.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Delegating call to doGet method
		doGet(request, response); // method chaining
	}

}
