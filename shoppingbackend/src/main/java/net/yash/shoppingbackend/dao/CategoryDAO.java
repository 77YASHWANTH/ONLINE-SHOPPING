package net.yash.shoppingbackend.dao;

import net.yash.shoppingbackend.dto.Category; 

import java.util.List;

public interface CategoryDAO {
	
	Category get(int id);
	
	List<Category> list(); 
	//CRUD OPERATIONS
	boolean add(Category category);
	
	boolean update(Category category);
	
	boolean delete(Category category);
	
}
