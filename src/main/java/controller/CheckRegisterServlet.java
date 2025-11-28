package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Users;
import model.bo.UsersBO;

/**
 * Servlet implementation class CheckRegisterServlet
 */
@WebServlet("/CheckRegisterServlet")
public class CheckRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String fullname = request.getParameter("fullname");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		
		if (!password.equals(confirmPassword)) {
			request.setAttribute("errorMessage", "Passwords do not match.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			UsersBO usersBO = new UsersBO();
			if (usersBO.checkUserIsExist(username) != null) {
				request.setAttribute("errorMessage", "Username already exists.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				Users newUser = new Users();
				newUser.setUsername(username);
				newUser.setPassword(password);
				newUser.setFullname(fullname);
				newUser.setPhoneNumber(phoneNumber);
				newUser.setAddress(address);
				usersBO.register(newUser);
				request.setAttribute("successMessage", "Đăng ký thành công!!!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
		}

	}

}
