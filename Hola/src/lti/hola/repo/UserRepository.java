package lti.hola.repo;

import lti.hola.bean.ForgetBean;
import lti.hola.bean.LoginBean;
import lti.hola.bean.RegisterBean;

public interface UserRepository {
	RegisterBean authenticate(LoginBean login);

	boolean validate(ForgetBean forget);

	boolean persist(RegisterBean register);

	boolean changePassword(LoginBean login);
}
