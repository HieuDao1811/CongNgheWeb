package model.bo;

import java.util.List;

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
