package net.yash.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; // ensure the import for transactional is org.springframework.transaction.annotation.Transactional;


import net.yash.shoppingbackend.dao.CategoryDAO;
import net.yash.shoppingbackend.dto.Category;

  //categoryDAO is same name given in the PageController in onlineshopping or CategoryDAO object .
	//for using Repository we have to add spring dependencies 1.context framework. 2
@Repository("categoryDAO")
@Transactional 
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories = new ArrayList<>();

	@Autowired
	private SessionFactory sessionFactory; //here session created for adding category using the method add(Category category) given below
	
	static {
		Category category = new Category();
		
		Category category1 = new Category();

		Category category2 = new Category();

		//First 
		category1.setId(1);
		category1.setName("SAMSUNG");
		category1.setDescription("NEW SAMSUNG");
		category1.setImageUrl("pho.jpg"); 
		categories.add(category1);
		
		//Second
		category2.setId(2);
		category2.setName("REDMI");
		category2.setDescription("NEW REDMI");
		category2.setImageUrl("pho.jpg");
		categories.add(category2);
		
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


	@Override //abstract method from the CategoryDAO
	public Category get(int id) {
		//this method use for return the category based upon id which is called in page controller
		
		for(Category category : categories) {
			if(category.getId()==id) return category;
		}
		return null;
	}
	


	@Override  
	@Transactional
	//This method if for add category in database
	public boolean add(Category category) {
		
		try {
			//add category in database
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
		}

}
