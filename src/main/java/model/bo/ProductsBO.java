package model.bo;

import java.util.List;

import model.bean.Products;
import model.dao.ProductsDAO;

public class ProductsBO {

	ProductsDAO productsDAO = new ProductsDAO();

	public List<Products> getAllProducts() {
		return productsDAO.getAllProducts();
	}

	public List<Products> getAllProductsByCategoryId(int id) {
		return productsDAO.getAllProductsByCategoryId(id);
	}

	public Products getProductsById(String id) {
		return productsDAO.getProductsById(id);
	}

	public List<Products> searchProductsByName(String name) {
		return productsDAO.getProductsByName(name);
	}

}
