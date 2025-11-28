package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Orders;
import model.bo.OrdersBO;

import java.io.IOException;
import java.util.List;

@WebServlet("/order-list")
public class OrderListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private OrdersBO ordersBO = new OrdersBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String keyword = request.getParameter("keyword");

        // Nếu không nhập keyword -> lấy tất cả
        List<Orders> list = ordersBO.searchOrders(keyword);

        request.setAttribute("orderList", list);
        request.setAttribute("keyword", keyword);
        request.getRequestDispatcher("order-list.jsp").forward(request, response);
    }
}
