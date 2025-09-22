package ndtt.daos;
import java.util.List;


import ndtt.models.CategoryModel;



public interface CategoryDao {
	void insert(CategoryModel category);
	void edit(CategoryModel category);
	void delete(int id);
	CategoryModel get(int id);
	CategoryModel get(String name);
	List<CategoryModel> getAll();
	List<CategoryModel> search(String keyword);
	String getname();
	String geticon();
	String getName();
	String getIcon();
}
