package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bo.ProductsBO;

import java.io.IOException;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/delete-product")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductsBO productsBO = new ProductsBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                productsBO.deleteProduct(id);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        // Xóa xong quay về list
        response.sendRedirect("admin-products");
    }

}
