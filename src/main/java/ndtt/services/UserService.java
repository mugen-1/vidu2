package ndtt.services;

import ndtt.models.UserModel;

public interface UserService {

	UserModel login(String username, String password);

	UserModel findbyUserName(String username);

	void insert(UserService user);

	boolean register(String email, String password, String username, String fullname, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
	
	
}
