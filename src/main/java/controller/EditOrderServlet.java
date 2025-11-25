package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Orders;
import model.bo.OrdersBO;

import java.io.IOException;

/**
 * Servlet implementation class EditOrderServlet
 */
@WebServlet("/edit-order")
public class EditOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OrdersBO ordersBO = new OrdersBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr == null) {
            response.sendRedirect("order-list");
            return;
        }
        int id = Integer.parseInt(idStr);
        Orders o = ordersBO.getById(id);
        request.setAttribute("order", o);
        request.getRequestDispatcher("edit-order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        int userId = Integer.parseInt(request.getParameter("user_id"));
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone_number");
        String address = request.getParameter("address");
        String note = request.getParameter("note");
        String status = request.getParameter("status");
        float totalMoney = Float.parseFloat(request.getParameter("total_money"));

        Orders o = new Orders();
        o.setId(id);
        o.setUserId(userId);
        o.setFullname(fullname);
        o.setEmail(email);
        o.setPhoneNumber(phone);
        o.setAddress(address);
        o.setNote(note);
        o.setStatus(status);
        o.setTotalMoney(totalMoney);

        ordersBO.update(o);
        response.sendRedirect("order-list");
    }

}
