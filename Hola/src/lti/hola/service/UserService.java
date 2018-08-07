package lti.hola.service;

import lti.hola.bean.ForgetBean;
import lti.hola.bean.LoginBean;
import lti.hola.bean.RegisterBean;

public interface UserService {

	RegisterBean authenticate(LoginBean login);

	boolean validate(ForgetBean forget);

	boolean persist(RegisterBean register);

	boolean changePassword(LoginBean login);
}
	