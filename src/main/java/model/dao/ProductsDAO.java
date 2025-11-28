package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.Products;

public class ProductsDAO {

    // Lấy tất cả sản phẩm (kèm tên category)
    public List<Products> getAllProducts() {
        List<Products> list = new ArrayList<>();

        String sql = "SELECT p.id, p.name, p.price, p.thumbnail, p.description, "
                   + "p.category_id, c.name AS category_name "
                   + "FROM products p "
                   + "LEFT JOIN categories c ON p.category_id = c.id";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Products p = new Products();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getFloat("price"));
                p.setThumbnail(rs.getString("thumbnail"));
                p.setDescription(rs.getString("description"));
                p.setCategoryId(rs.getInt("category_id"));
                p.setCategoryName(rs.getString("category_name"));

                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Lấy 1 sản phẩm theo id (int)
    public Products getProductById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Products p = new Products();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getFloat("price"));
                p.setThumbnail(rs.getString("thumbnail"));
                p.setDescription(rs.getString("description"));
                p.setCategoryId(rs.getInt("category_id"));
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cập nhật sản phẩm
    public boolean updateProduct(Products p) {
        String sql = "UPDATE products "
                   + "SET name = ?, price = ?, thumbnail = ?, description = ?, category_id = ? "
                   + "WHERE id = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setFloat(2, p.getPrice());
            ps.setString(3, p.getThumbnail());
            ps.setString(4, p.getDescription());
            ps.setInt(5, p.getCategoryId());
            ps.setInt(6, p.getId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa sản phẩm
    public boolean deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Thêm sản phẩm
    public boolean addProduct(Products p) {
        String sql = "INSERT INTO products(name, price, thumbnail, description, category_id) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setFloat(2, p.getPrice());
            ps.setString(3, p.getThumbnail());
            ps.setString(4, p.getDescription());
            ps.setInt(5, p.getCategoryId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy tất cả sản phẩm theo category_id
    public List<Products> getAllProductsByCategoryId(int id) {
        String sql = "SELECT * FROM products WHERE category_id = ?";
        List<Products> products = new ArrayList<>();

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Products product = new Products();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getFloat("price"));
                    product.setThumbnail(rs.getString("thumbnail"));
                    product.setDescription(rs.getString("description"));
                    product.setCategoryId(rs.getInt("category_id"));
                    products.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    // Lấy sản phẩm theo id (String)
    public Products getProductsById(String id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        Products product = null;

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    product = new Products();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getFloat("price"));
                    product.setThumbnail(rs.getString("thumbnail"));
                    product.setDescription(rs.getString("description"));
                    product.setCategoryId(rs.getInt("category_id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    // Tìm sản phẩm theo tên (LIKE)
    public List<Products> getProductsByName(String name) {
        String sql = "SELECT * FROM products WHERE name LIKE ?";
        List<Products> products = new ArrayList<>();

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Products product = new Products();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getFloat("price"));
                    product.setThumbnail(rs.getString("thumbnail"));
                    product.setDescription(rs.getString("description"));
                    product.setCategoryId(rs.getInt("category_id"));
                    products.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}
