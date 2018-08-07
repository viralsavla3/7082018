package lti.hola.webb;


import javax.servlet.http.HttpServletRequest;

import lti.hola.bean.ForgetBean;
import lti.hola.bean.LoginBean;
import lti.hola.bean.RegisterBean;
import lti.hola.service.UserService;
import lti.hola.service.UserServiceImpl;

public class LoginController {

	public static RegisterBean authenticate(HttpServletRequest request) {
		UserService service = new UserServiceImpl();

		// Instantiating LoginBean to hold login credentials
		LoginBean login = new LoginBean();
		// Reading request parameters and storing in login bean object
		login.setEmail(request.getParameter("email"));
		login.setpassword(request.getParameter("password"));
		// Passing LoginBean to service method
		RegisterBean user = service.authenticate(login);
		return user;
	}

	public static boolean forgetPassword(HttpServletRequest request) {
		UserService service = new UserServiceImpl();

		ForgetBean forget = new ForgetBean();
		forget.setEmail(request.getParameter("email"));
		forget.setmovie(request.getParameter("movie"));

		return service.validate(forget);
	}

	public static boolean changePassword(HttpServletRequest request) {
		UserService service = new UserServiceImpl();
		LoginBean change = new LoginBean();
		
		// Reading request parameters and storing in login bean object
		change.setEmail(request.getParameter("email"));
		change.setpassword(request.getParameter("password"));

		return service.changePassword(change);
	}

}
