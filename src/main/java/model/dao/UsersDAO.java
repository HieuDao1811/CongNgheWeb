package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.bean.Users;

public class UsersDAO {

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
