package lti.hola.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.catalina.User;

import lti.hola.bean.ForgetBean;
import lti.hola.bean.LoginBean;
import lti.hola.bean.RegisterBean;
import lti.hola.repo.UserRepository;
/**
 * 
 * Repository interface for variety of databases
 * @author Viral Savla,Dhrumil Shah
 * verion 1.0
 *
 */

public class UserRepositoryImpl implements UserRepository {
	private Connection getConnection() throws SQLException {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			Connection con = ds.getConnection();
			return con;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RegisterBean authenticate(LoginBean login) {
		String sql = "select * from users where email=? and password=?";
		Connection con = null;
		RegisterBean user = null;

		try {

			con = getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, login.getEmail());
			stmt.setString(2, login.getpassword());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new RegisterBean();
				user.setName(rs.getString(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setGender(rs.getString(5));
				user.setCity(rs.getString(6));
				user.setMovie(rs.getString(7));
				user.setPhoto(rs.getString(8));

			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public boolean validate(ForgetBean forget) {
		String sql = "select * from users where email=? and movie=?";
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, forget.getEmail());
			stmt.setString(2, forget.getmovie());
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean persist(RegisterBean register) {
		String sql = "insert into users values(?,?,?,?,?,?,?,?)";
		Connection con = null;

		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, register.getName());
			stmt.setString(2, register.getEmail());
			stmt.setString(3, register.getPassword());
			stmt.setInt(4, register.getAge());
			stmt.setString(5, register.getGender());
			stmt.setString(6, register.getCity());
			stmt.setString(7, register.getMovie());
			stmt.setString(8, register.getPhoto());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public boolean changePassword(LoginBean login) {
		String sql = "update users set password=? where email=?";
		Connection con = null;

		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, login.getpassword());
			stmt.setString(2, login.getEmail());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
