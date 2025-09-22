package ndtt.services.impl;

import java.io.File;
import java.util.List;
import java.util.Locale.Category;

import ndtt.daos.CategoryDao;
import ndtt.daos.impl.CategoryDaoImpl;
import ndtt.services.CategoryService;
import ndtt.models.CategoryModel;

public class CategoryServiceImpl implements CategoryService {
	
	CategoryDao categoryDao = new CategoryDaoImpl();
	
	@Override
	public void insert(CategoryModel category) {
	categoryDao.insert(category);
	}
	
	@Override
	public void delete(int id) {
	categoryDao.delete(id);
	}
	
	@Override
	public CategoryModel get(int id) {
	return categoryDao.get(id);
	}
	
	@Override
	public void edit(CategoryModel newCategory) {
	CategoryModel oldCategory = categoryDao.get(newCategory.getId());
	oldCategory.setName(newCategory.getName());
	if (newCategory.getIcon() != null) {
	// XOA ANH CU DI
	String fileName = oldCategory.getIcon();
	final String dir = "E:\\upload";
	File file = new File(dir + "/category" + fileName);
	if (file.exists()) {
	file.delete();
	}
	oldCategory.setIcon(newCategory.getIcon());
	}
	categoryDao.edit(oldCategory);
	}

	@Override
	public CategoryModel get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}