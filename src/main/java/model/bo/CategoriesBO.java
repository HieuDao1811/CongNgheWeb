package model.bo;

import java.util.List;

import model.bean.Categories;
import model.dao.CategoriesDAO;

public class CategoriesBO {

	public List<Categories> getAllCategories() {
		CategoriesDAO categoriesDAO = new CategoriesDAO();
		return categoriesDAO.getAllCategories();
	}

}
