package model.bo;

import model.bean.Users;
import model.dao.UsersDAO;

public class UsersBO {
	
	UsersDAO usersDAO = new UsersDAO();
	
	public Users login(String username, String password) {
		return usersDAO.login(username, password);
	}
	
	public Users checkUserIsExist(String username) {
		return usersDAO.checkUserIsExist(username);
	}
	
	public void register(Users user) {
		usersDAO.register(user);
	}

}
