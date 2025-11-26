package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.bean.OrderDetails;

public class OrderDetailsDAO {

	public void insertOrderDetail(OrderDetails detail) {
		String sql = "INSERT INTO order_details(order_id, product_id, price, number_of_products, total_money, color) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection conn = new JDBCUtil().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, detail.getOrderId());
			ps.setInt(2, detail.getProductId());
			ps.setFloat(3, detail.getPrice());
			ps.setInt(4, detail.getNumberOfProducts());
			ps.setFloat(5, detail.getTotalMoney());
			ps.setString(6, detail.getColor());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
