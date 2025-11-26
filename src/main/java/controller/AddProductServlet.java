package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Products;
import model.bo.ProductsBO;

import java.io.IOException;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductsBO productsBO = new ProductsBO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String priceStr = request.getParameter("price");
        String thumbnail = request.getParameter("thumbnail");
        String description = request.getParameter("description");
        String categoryIdStr = request.getParameter("category_id");

        float price = 0;
        int categoryId = 0;
        try {
            price = Float.parseFloat(priceStr);
            categoryId = Integer.parseInt(categoryIdStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Products p = new Products();
        p.setName(name);
        p.setPrice(price);
        p.setThumbnail(thumbnail);
        p.setDescription(description);
        p.setCategoryId(categoryId);

        productsBO.addProduct(p);

        // Thêm xong quay lại trang danh sách
        response.sendRedirect("admin-products"); // đổi theo servlet list của bạn
    }

    // Nếu muốn vào add-product.jsp bằng GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("add-product.jsp").forward(request, response);
    }

}
