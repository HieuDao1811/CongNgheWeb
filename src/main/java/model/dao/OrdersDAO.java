package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> customer

import model.bean.Orders;

public class OrdersDAO {
<<<<<<< HEAD
	public List<Orders> searchOrders(String keyword) {
        List<Orders> list = new ArrayList<>();

        String sql =
            "SELECT * FROM orders " +
            "WHERE (? IS NULL OR ? = '' " +
            "   OR fullname LIKE ? OR phone_number LIKE ? OR status LIKE ? OR id LIKE ?) " +
            "ORDER BY id DESC";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String like = "%" + (keyword == null ? "" : keyword.trim()) + "%";

            ps.setString(1, keyword);
            ps.setString(2, keyword);
            ps.setString(3, like);
            ps.setString(4, like);
            ps.setString(5, like);
            ps.setString(6, like);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orders o = new Orders();
                o.setId(rs.getInt("id"));
                o.setUserId(rs.getInt("user_id"));
                o.setFullname(rs.getString("fullname"));
                o.setEmail(rs.getString("email"));
                o.setPhoneNumber(rs.getString("phone_number"));
                o.setAddress(rs.getString("address"));
                o.setNote(rs.getString("note"));
                o.setOrderDate(rs.getTimestamp("order_date"));
                o.setStatus(rs.getString("status"));
                o.setTotalMoney(rs.getFloat("total_money"));
                list.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Orders getById(int id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Orders o = new Orders();
                o.setId(rs.getInt("id"));
                o.setUserId(rs.getInt("user_id"));
                o.setFullname(rs.getString("fullname"));
                o.setEmail(rs.getString("email"));
                o.setPhoneNumber(rs.getString("phone_number"));
                o.setAddress(rs.getString("address"));
                o.setNote(rs.getString("note"));
                o.setOrderDate(rs.getTimestamp("order_date"));
                o.setStatus(rs.getString("status"));
                o.setTotalMoney(rs.getFloat("total_money"));
                return o;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(Orders o) {
        String sql = "INSERT INTO orders(user_id, fullname, email, phone_number, address, note, status, total_money) "
                   + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, o.getUserId());
            ps.setString(2, o.getFullname());
            ps.setString(3, o.getEmail());
            ps.setString(4, o.getPhoneNumber());
            ps.setString(5, o.getAddress());
            ps.setString(6, o.getNote());
            ps.setString(7, o.getStatus());
            ps.setFloat(8, o.getTotalMoney());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Orders o) {
        String sql = "UPDATE orders SET user_id=?, fullname=?, email=?, phone_number=?, "
                   + "address=?, note=?, status=?, total_money=? WHERE id=?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, o.getUserId());
            ps.setString(2, o.getFullname());
            ps.setString(3, o.getEmail());
            ps.setString(4, o.getPhoneNumber());
            ps.setString(5, o.getAddress());
            ps.setString(6, o.getNote());
            ps.setString(7, o.getStatus());
            ps.setFloat(8, o.getTotalMoney());
            ps.setInt(9, o.getId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
=======

	public int insertOrder(Orders order) {
		String sql = "INSERT INTO orders(user_id, fullname, email, phone_number, address, note, order_date, status, total_money) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = new JDBCUtil().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, order.getUserId());
			ps.setString(2, order.getFullname());
			ps.setString(3, order.getEmail());
			ps.setString(4, order.getPhoneNumber());
			ps.setString(5, order.getAddress());
			ps.setString(6, order.getNote());
			ps.setTimestamp(7, order.getOrderDate());
			ps.setString(8, order.getStatus());
			ps.setFloat(9, order.getTotalMoney());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Orders getOrderById(int orderId) {
		String sql = "SELECT * FROM orders WHERE id = ?";
		try (Connection conn = new JDBCUtil().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Orders order = new Orders();
				order.setId(rs.getInt("id"));
				order.setUserId(rs.getInt("user_id"));
				order.setFullname(rs.getString("fullname"));
				order.setEmail(rs.getString("email"));
				order.setPhoneNumber(rs.getString("phone_number"));
				order.setAddress(rs.getString("address"));
				order.setNote(rs.getString("note"));
				order.setOrderDate(rs.getTimestamp("order_date"));
				order.setStatus(rs.getString("status"));
				order.setTotalMoney(rs.getFloat("total_money"));
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

>>>>>>> customer
}
