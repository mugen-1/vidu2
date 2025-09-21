package ndtt.services.impl;

import ndtt.daos.UserDao;
import ndtt.daos.impl.UserDaoImpl;
import ndtt.models.UserModel;
import ndtt.services.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();

	@Override
	public UserModel findbyUserName(String username) {
	
		return userDao.findbyUserName(username);
	}

	@Override
	public UserModel login(String username, String password) {

		UserModel user = this.findbyUserName(username);
		
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public void insert(UserService user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
