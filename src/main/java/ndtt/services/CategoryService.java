package ndtt.services;
import java.util.List;
import java.util.Locale.Category;

import ndtt.daos.CategoryDao;
import ndtt.models.CategoryModel;

public interface CategoryService {
	void insert(CategoryModel category);
	void edit(CategoryModel category);
	void delete(int id);
	CategoryModel get(int id);
	CategoryModel get(String name);
	List<Category> getAll();
	List<Category> search(String keyword);
}
