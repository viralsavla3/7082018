package lti.hola.service;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import lti.hola.bean.ForgetBean;
import lti.hola.bean.LoginBean;
import lti.hola.bean.RegisterBean;
import lti.hola.repo.UserRepository;
import lti.hola.repo.UserRepositoryImpl;

public class UserServiceImpl implements UserService {
	private UserRepository repo;

	public UserServiceImpl() {
		repo = new UserRepositoryImpl();
	}

	@Override
	public RegisterBean authenticate(LoginBean login) {
		// Password Encoding
		Encoder encoder = Base64.getEncoder();
		String encoded = encoder.encodeToString(login.getpassword().getBytes());
		login.setpassword(encoded);
		
//		Decoder decoder = Base64.getDecoder();
//		String decoded  = new String(decoder.decode(encoded.getBytes()));
//		//System.out.println(decoded);
//		login.setpassword(decoded);;


		return repo.authenticate(login);

	}

	@Override
	public boolean validate(ForgetBean forget) {
		Encoder encoder = Base64.getEncoder();
		String encoded = encoder.encodeToString(forget.getmovie().getBytes());
//		Decoder decoder = Base64.getDecoder();
//		String decoded  = new String(decoder.decode(encoded.getBytes()));
		forget.setmovie(encoded);
		//forget.setmovie(decoded);
		return repo.validate(forget);
	}

	@Override
	public boolean persist(RegisterBean register) {
		Encoder encoder = Base64.getEncoder();
		String encoded = encoder.encodeToString(register.getPassword().getBytes());
		register.setPassword(encoded);
		
//		Decoder decoder = Base64.getDecoder();
//		String decoded  = new String(decoder.decode(encoded.getBytes()));	
//		register.setPassword(decoded);
//		
//		String encoded1 = encoder.encodeToString(register.getMovie().getBytes());
//		String decoded1  = new String(decoder.decode(encoded1.getBytes()));		
//		
//		register.setMovie(decoded);
		return repo.persist(register);
	}

	@Override
	public boolean changePassword(LoginBean login) {
		Encoder encoder = Base64.getEncoder();
		String encoded =encoder.encodeToString(login.getpassword().getBytes());
		login.setpassword(encoded);
//		Decoder decoder = Base64.getDecoder();
//		String decoded  = new String(decoder.decode(encoded.getBytes()));	
//		login.setpassword(decoded);
		
	return repo.changePassword(login);
	}

}
