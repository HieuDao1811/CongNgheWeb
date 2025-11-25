package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.Users;

public class UsersDAO {
	public List<Users> searchCustomers(String keyword) {
        List<Users> list = new ArrayList<>();

        String sql =
            "SELECT * FROM users " +
            "WHERE (? IS NULL OR ? = '' " +
            "       OR fullname LIKE ? OR phone_number LIKE ? OR address LIKE ?) " +
            "ORDER BY id DESC";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String like = "%" + (keyword == null ? "" : keyword.trim()) + "%";

            ps.setString(1, keyword);
            ps.setString(2, keyword);
            ps.setString(3, like);
            ps.setString(4, like);
            ps.setString(5, like);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users u = new Users();
                u.setId(rs.getInt("id"));
                u.setFullname(rs.getString("fullname"));
                u.setPhoneNumber(rs.getString("phone_number"));
                u.setAddress(rs.getString("address"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getInt("role"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Users getById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Users u = new Users();
                u.setId(rs.getInt("id"));
                u.setFullname(rs.getString("fullname"));
                u.setPhoneNumber(rs.getString("phone_number"));
                u.setAddress(rs.getString("address"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getInt("role"));
                return u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(Users u) {
        String sql = "INSERT INTO users(fullname, phone_number, address, password, role) "
                   + "VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getFullname());
            ps.setString(2, u.getPhoneNumber());
            ps.setString(3, u.getAddress());
            ps.setString(4, u.getPassword());
            ps.setInt(5, u.getRole());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Users u) {
        String sql = "UPDATE users SET fullname=?, phone_number=?, address=?, password=?, role=? "
                   + "WHERE id=?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getFullname());
            ps.setString(2, u.getPhoneNumber());
            ps.setString(3, u.getAddress());
            ps.setString(4, u.getPassword());
            ps.setInt(5, u.getRole());
            ps.setInt(6, u.getId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
