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
 * Servlet implementation class EditCustomerServlet
 */
@WebServlet("/edit-customer")
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsersBO usersBO = new UsersBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr == null) {
            response.sendRedirect("customer-list");
            return;
        }
        int id = Integer.parseInt(idStr);
        Users u = usersBO.getById(id);
        request.setAttribute("customer", u);
        request.getRequestDispatcher("edit-customer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone_number");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        int role = Integer.parseInt(request.getParameter("role"));

        Users u = new Users();
        u.setId(id);
        u.setFullname(fullname);
        u.setPhoneNumber(phone);
        u.setAddress(address);
        u.setPassword(password);
        u.setRole(role);

        usersBO.update(u);
        response.sendRedirect("customer-list");
    }

}
