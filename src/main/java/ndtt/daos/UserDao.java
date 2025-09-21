package ndtt.daos;

import java.sql.Date;

import ndtt.models.UserModel;

public interface UserDao {
	
	UserModel findbyUserName(String username);

	
	
	void insert(UserDao user);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);



	String email();
	String username();
	String fullname();
	String Password();
	String avatar();
	int roleid();
	String phone();
	Date createddate();

}
