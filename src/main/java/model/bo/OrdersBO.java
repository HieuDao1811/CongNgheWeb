package model.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.Orders;
import model.dao.JDBCUtil;
import model.dao.OrdersDAO;

public class OrdersBO {
	private OrdersDAO ordersDAO = new OrdersDAO();

    public List<Orders> searchOrders(String keyword) {
        return ordersDAO.searchOrders(keyword);
    }

    public Orders getById(int id) {
        return ordersDAO.getById(id);
    }

    public boolean insert(Orders o) {
        return ordersDAO.insert(o);
    }

    public boolean update(Orders o) {
        return ordersDAO.update(o);
    }

    public boolean delete(int id) {
        return ordersDAO.delete(id);
    }
}
