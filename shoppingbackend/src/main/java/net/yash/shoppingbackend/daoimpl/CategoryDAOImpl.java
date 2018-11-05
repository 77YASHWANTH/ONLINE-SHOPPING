package net.yash.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.yash.shoppingbackend.dao.CategoryDAO;
import net.yash.shoppingbackend.dto.Category;

  //categoryDAO is same name given in the PageController in onlineshopping or CategoryDAO object .
	//for using Repository we have to add spring dependencies 1.context framework. 2
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();
		
		//First 
		category.setId(1);
		category.setName("OPPO");
		category.setDescription("NEW OPPO");
		category.setImageUrl("pho.jpg"); 
		categories.add(category);
		
		//Second
		category.setId(2);
		category.setName("REDMI");
		category.setDescription("NEW REDMI");
		category.setImageUrl("pho.jpg");
		categories.add(category);
		
		//Third
		category.setId(3);
		category.setName("NOKIA");
		category.setDescription("NEW NOKIA");
		category.setImageUrl("pho.jpg");
		categories.add(category);
		
				
				
		
	}
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}
