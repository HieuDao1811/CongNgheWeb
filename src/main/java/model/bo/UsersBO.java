package model.bo;

<<<<<<< HEAD
import java.util.List;
=======
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
>>>>>>> customer

import model.bean.Users;
import model.dao.UsersDAO;

public class UsersBO {
	private UsersDAO usersDAO = new UsersDAO();

    public List<Users> searchCustomers(String keyword) {
        return usersDAO.searchCustomers(keyword);
    }

    public Users getById(int id) {
        return usersDAO.getById(id);
    }

    public boolean insert(Users u) {
        return usersDAO.insert(u);
    }

    public boolean update(Users u) {
        return usersDAO.update(u);
    }

    public boolean delete(int id) {
        return usersDAO.delete(id);
    }
}
