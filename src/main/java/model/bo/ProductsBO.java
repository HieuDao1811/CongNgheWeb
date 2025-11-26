package model.bo;

import java.util.List;
import model.bean.Products;
import model.dao.ProductsDAO;

public class ProductsBO {
    
    private ProductsDAO productsDAO = new ProductsDAO();

    public List<Products> getAllProducts() {
        return productsDAO.getAllProducts();
    }
    
    public Products getProductById(int id) {
    	return productsDAO.getProductById(id);
    }
    
    public boolean updateProduct(Products p) {
    	return productsDAO.updateProduct(p);
    }
    
    public boolean deleteProduct(int id) {
    	return productsDAO.deleteProduct(id);
    }
    
    public boolean addProduct(Products p) {
        return productsDAO.addProduct(p);
    }
}
