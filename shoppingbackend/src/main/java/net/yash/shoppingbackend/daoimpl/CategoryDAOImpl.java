package net.yash.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; // ensure the import for transactional is org.springframework.transaction.annotation.Transactional;

import net.yash.shoppingbackend.dao.CategoryDAO;
import net.yash.shoppingbackend.dto.Category;

  //categoryDAO is same name given in the PageController in onlineshopping or CategoryDAO object .
	//for using Repository we have to add spring dependencies 1.context framework. 2
@Repository("categoryDAO")
@Transactional // every method has to run on transctional which is handled by spring framework.
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories = new ArrayList<>();

	@Autowired
	private SessionFactory sessionFactory; //here session created for adding category using the method add(Category category) given below
	

	
	//Fetch List
	@Override 
	public List<Category> list() {
		//return null;
		
		String selectActiveCategory = "FROM Category WHERE active = :active";//Hql query ,category is an entity
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory); //Hql query getting the session and selecting active category.
		
		query.setParameter("active", true);
		return query.getResultList();
	}


	//Getting Single Category based on Methods
	@Override //abstract method from the CategoryDAO
	public Category get(int id) {
		//this method use for return the category based upon id which is called in page controller
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
	


	@Override  
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


	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		try {
			//add category in database
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
}


	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub 
		category.setActive(false);
		try {
			//add category in database
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
			}

}
