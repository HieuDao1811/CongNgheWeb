package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.bean.Products;
import model.bo.ProductsBO;

@WebServlet("/edit-product")
public class EditProductServlet extends HttpServlet {
	private ProductsBO productsBO = new ProductsBO();
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        if (idStr == null) {
            response.sendRedirect("product-list"); // đổi path theo servlet list của bạn
            return;
        }

        int id = Integer.parseInt(idStr);
        Products product = productsBO.getProductById(id);

        if (product == null) {
            // Không tìm thấy sản phẩm -> quay lại list
            response.sendRedirect("product-list");
            return;
        }

        request.setAttribute("product", product);
        // nếu có danh sách category từ DB thì set thêm attribute categoryList
        request.getRequestDispatcher("edit-product.jsp").forward(request, response);
    }

    // Lưu thông tin sau khi sửa
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String thumbnail = request.getParameter("thumbnail");
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("category_id"));

        Products p = new Products();
        p.setId(id);
        p.setName(name);
        p.setPrice(price);
        p.setThumbnail(thumbnail);
        p.setDescription(description);
        p.setCategoryId(categoryId);

        productsBO.updateProduct(p);

        response.sendRedirect("admin-products"); 
    }

}
