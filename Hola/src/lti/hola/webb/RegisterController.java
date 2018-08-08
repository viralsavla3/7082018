package lti.hola.webb;
/**
 * Used to register entries into database
 * @author Viral Savla,Dhrumil Shah
 * verion 1.0
 */

import javax.servlet.http.HttpServletRequest;

import lti.hola.bean.RegisterBean;
import lti.hola.service.UserService;
import lti.hola.service.UserServiceImpl;

public class RegisterController {

	public static boolean register(HttpServletRequest request) {
		UserService service = new UserServiceImpl();
		
		RegisterBean register = new RegisterBean();
		register.setName(request.getParameter("name"));
		register.setEmail(request.getParameter("email"));
		register.setPassword(request.getParameter("password"));
		register.setAge(Integer.parseInt(request.getParameter("age")));
		register.setGender(request.getParameter("gender"));
		register.setCity(request.getParameter("city"));
		register.setMovie(request.getParameter("movie"));
		register.setPhoto(request.getParameter("photo"));
		
		
		
		return service.persist(register);
	}

}
