package ndtt.daos.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ndtt.configs.DBConnect;
import ndtt.daos.UserDao;
import ndtt.models.UserModel;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public void insert(UserDao user) {
	    String sql = "INSERT INTO [User](email, username, fullname, password, avatar, roleid, phone, createddate) "
	               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


	try {
	conn = new DBConnect().getConnection();
	ps = conn.prepareStatement(sql);
	ps.setString(1, user.email());
	ps.setString(2, user.username());
	ps.setString(3, user.fullname());
	ps.setString(4, user.Password());
	ps.setString(5, user.avatar());
	ps.setInt(6,user.roleid());
	ps.setString(7,user.phone());
	ps.setDate(8, user.createddate());
	ps.executeUpdate();
	} catch (Exception e) {e.printStackTrace();}
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from [user] where email = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from [User] where username = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public UserModel findbyUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String email() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String username() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fullname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Password() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String avatar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int roleid() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String phone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date createddate() {
		// TODO Auto-generated method stub
		return null;
	}
}
