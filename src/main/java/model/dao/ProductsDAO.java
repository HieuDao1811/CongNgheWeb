package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.Products;

public class ProductsDAO {

	public List<Products> getAllProducts() {
		String sql = "SELECT * FROM products";
		List<Products> products = new ArrayList<>();
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Products product = new Products();
				product = new Products();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getFloat("price"));
				product.setThumbnail(rs.getString("thumbnail"));
				product.setDescription(rs.getString("description"));
				product.setCategoryId(rs.getInt("category_id"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Products> getAllProductsByCategoryId(int id) {
		String sql = "SELECT * FROM products WHERE category_id = " + id;
		List<Products> products = new ArrayList<>();
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Products product = new Products();
				product = new Products();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getFloat("price"));
				product.setThumbnail(rs.getString("thumbnail"));
				product.setDescription(rs.getString("description"));
				product.setCategoryId(rs.getInt("category_id"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public Products getProductsById(String id) {
		String sql = "SELECT * FROM products WHERE id = " + id;
		Products product = new Products();
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				product = new Products();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getFloat("price"));
				product.setThumbnail(rs.getString("thumbnail"));
				product.setDescription(rs.getString("description"));
				product.setCategoryId(rs.getInt("category_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public List<Products> getProductsByName(String name) {
		String sql = "SELECT * FROM products WHERE name LIKE '%" + name + "%'";
		List<Products> products = new ArrayList<>();
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Products product = new Products();
				product = new Products();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getFloat("price"));
				product.setThumbnail(rs.getString("thumbnail"));
				product.setDescription(rs.getString("description"));
				product.setCategoryId(rs.getInt("category_id"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

}
