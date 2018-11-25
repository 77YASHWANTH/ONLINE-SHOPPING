package net.yash.shoppingbackend.dao;

import net.yash.shoppingbackend.dto.Category; 

import java.util.List;

public interface CategoryDAO {
	
	boolean add(Category category); //
	
	List<Category> list(); 
	Category get(int id);

}
