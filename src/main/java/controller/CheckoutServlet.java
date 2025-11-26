package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.OrderDetails;
import model.bean.Orders;
import model.bean.Users;
import model.dao.OrderDetailsDAO;
import model.dao.OrdersDAO;

import java.io.IOException;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CheckoutServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Kiểm tra đăng nhập
        Users user = (Users) request.getSession().getAttribute("currentUser");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        float price = Float.parseFloat(request.getParameter("price"));
        float totalMoney = price * quantity;

        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String note = request.getParameter("note");

        java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());

        Orders order = new Orders();
        order.setUserId(user.getId());
        order.setFullname(fullname);
        order.setEmail(email);
        order.setPhoneNumber(phone);
        order.setAddress(address);
        order.setNote(note);
        order.setOrderDate(now);
        order.setStatus("Pending");
        order.setTotalMoney(totalMoney);

        OrdersDAO ordersDAO = new OrdersDAO();

        int newOrderId = ordersDAO.insertOrder(order);
        order.setId(newOrderId);

        OrderDetails detail = new OrderDetails();
        detail.setOrderId(newOrderId);
        detail.setProductId(productId);
        detail.setPrice(price);
        detail.setNumberOfProducts(quantity);
        detail.setTotalMoney(totalMoney);
        detail.setColor("default");

        OrderDetailsDAO detailDAO = new OrderDetailsDAO();
        detailDAO.insertOrderDetail(detail);

        response.sendRedirect("success.jsp?orderId=" + newOrderId);
    }
}
