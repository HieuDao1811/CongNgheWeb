package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Users;
import model.bo.UsersBO;

import java.io.IOException;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/add-customer")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsersBO usersBO = new UsersBO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone_number");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        int role = Integer.parseInt(request.getParameter("role")); // 0=user,1=admin

        Users u = new Users();
        u.setFullname(fullname);
        u.setPhoneNumber(phone);
        u.setAddress(address);
        u.setPassword(password);
        u.setRole(role);

        usersBO.insert(u);
        response.sendRedirect("customer-list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("add-customer.jsp").forward(req, resp);
    }

}
