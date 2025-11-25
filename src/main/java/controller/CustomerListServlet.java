package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Users;
import model.bo.UsersBO;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class CustomerListServlet
 */
@WebServlet("/customer-list")
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsersBO usersBO = new UsersBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Users> list = usersBO.searchCustomers(keyword);
        request.setAttribute("customerList", list);
        request.setAttribute("keyword", keyword);
        request.getRequestDispatcher("customer-list.jsp").forward(request, response);
    }


}
