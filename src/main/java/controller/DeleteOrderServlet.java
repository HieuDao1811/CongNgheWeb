package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bo.OrdersBO;

import java.io.IOException;

/**
 * Servlet implementation class DeleteOrderServlet
 */
@WebServlet("/delete-order")
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OrdersBO ordersBO = new OrdersBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            ordersBO.delete(id);
        }
        response.sendRedirect("order-list");
    }

}
