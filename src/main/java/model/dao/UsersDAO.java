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
                u.setUsername(rs.getString("username"));
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
    public Users login(String username, String password) {
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Users user = new Users();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setFullname(rs.getString("fullname"));
					user.setPhoneNumber(rs.getString("phone_number"));
					user.setAddress(rs.getString("address"));
					user.setPassword(rs.getString("password"));
					user.setRole(rs.getInt("role"));
					return user;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Users checkUserIsExist(String username) {
		String sql = "SELECT * FROM users WHERE username = ?";
		try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Users user = new Users();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setFullname(rs.getString("fullname"));
					user.setPhoneNumber(rs.getString("phone_number"));
					user.setAddress(rs.getString("address"));
					user.setPassword(rs.getString("password"));
					user.setRole(rs.getInt("role"));
					return user;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void register(Users user) {
		String sql = "INSERT INTO users (username, fullname, phone_number, address, password, role) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getFullname());
			pstmt.setString(3, user.getPhoneNumber());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getPassword());
			pstmt.setInt(6, user.getRole());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

