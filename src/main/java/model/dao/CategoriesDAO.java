package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.Categories;
import model.bean.Products;

public class CategoriesDAO {

	public List<Categories> getAllCategories() {
		String sql = "SELECT * FROM categories";
		List<Categories> categories = new ArrayList<>();
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Categories category = new Categories();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

}
