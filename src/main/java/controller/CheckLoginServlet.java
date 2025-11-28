package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Users;
import model.bo.UsersBO;

import java.io.IOException;

@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CheckLoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Nếu cần tiếng Việt:
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsersBO usersBO = new UsersBO();
        Users users = usersBO.login(username, password);   // trả về Users có cả field role

        if (users != null) {
            // Đăng nhập thành công
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", users);      // lưu toàn bộ user
            session.setAttribute("role", users.getRole());   // lưu riêng role cho dễ dùng

            int role = users.getRole();

            // Phân quyền
            if (role == 1) {
                // Admin
                // Nếu bạn có AdminIndexServlet thì dùng: response.sendRedirect("AdminIndexServlet");
                response.sendRedirect("admin_index.jsp");
            } else {
                // User bình thường
                response.sendRedirect("IndexServlet");
            }

        } else {
            // Sai tài khoản hoặc mật khẩu
            request.setAttribute("errorMessage", "Sai tên đăng nhập hoặc mật khẩu");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
