package ndtt.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import ndtt.configs.DBConnect;
import ndtt.daos.CategoryDao;
import ndtt.models.CategoryModel;


public class CategoryDaoImpl extends DBConnect implements CategoryDao {

	
	@Override
	public void insert(CategoryModel category) {
	String sql = "INSERT INTO category(cate_name,icons) VALUES (?,?)";
	try {
	Connection con = super.getConnection();
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, category.getName());
	ps.setString(2, category.getIcon());
	ps.executeUpdate();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	
	@Override
	public void edit(CategoryModel category) {
	    String sql = "UPDATE category SET cate_name = ?, icons=? WHERE cate_id = ?";
	    try {
	        Connection con = super.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, category.getName());
	        ps.setString(2, category.getIcon());
	        ps.setInt(3, category.getId());
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	@Override
	public void delete(int id) {
	String sql = "DELETE FROM category WHERE cate_id = ?";
	try {
	Connection con = super.getConnection();
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1, id);
	ps.executeUpdate();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	
	@Override
	public CategoryModel get(int id) {
	String sql = "SELECT * FROM category WHERE cate_id = ? ";
	try {
	Connection con = super.getConnection();
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	CategoryModel category = new CategoryModel();
	category.setId(rs.getInt("cate_id"));
	category.setName(rs.getString("cate_name"));
	category.setIcon(rs.getString("icons"));
	return category;
	}} catch (Exception e) {
	e.printStackTrace();}
	return null;
	}


	@Override
	public CategoryModel get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String geticon() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIcon() {
		// TODO Auto-generated method stub
		return null;
	}
}
