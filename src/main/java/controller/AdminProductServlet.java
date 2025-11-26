package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Products;
import model.bo.ProductsBO;

@WebServlet("/admin-products")
public class AdminProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductsBO productsBO = new ProductsBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Products> list = productsBO.getAllProducts();

        request.setAttribute("productList", list); 	

        request.getRequestDispatcher("product-list.jsp").forward(request, response);
    }
}
