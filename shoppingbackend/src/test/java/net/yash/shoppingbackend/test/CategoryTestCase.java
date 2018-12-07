package net.yash.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.yash.shoppingbackend.dao.CategoryDAO;
import net.yash.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext(); 
		context.scan("net.yash.shoppingbackend");
		context.refresh(); 
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}

	@Test	
	public void testCRUDCategory() {
		
		try {
		//ADDING
		category = new Category();
		
		category.setName("REDMI");
		category.setDescription("NEW REDMI");
		category.setImageUrl("CAT_1.png");
		
		assertEquals("Category is added successfully",true,categoryDAO.add(category));
	
		category = new Category();
		
		category.setName("NOKIA");
		category.setDescription("NEW NOKIA");
		category.setImageUrl("CAT_2.png");
		
		assertEquals("Category is added successfully",true,categoryDAO.add(category));
	
		// UPDATE
		category = categoryDAO.get(2);
		category.setName("SAMSUNG");
		assertEquals("successfully updated in the single category",true,categoryDAO.update(category)); 
		
		//DELETING
		assertEquals("successfully Deleted in the single category",1,categoryDAO.list()); 
		
		//FETCHING THE LIST 
		assertEquals("successfully fetched the list of categories in the single category",1,categoryDAO.list().size()); 
		
		}
		catch(Exception ex) {
			ex.getStackTrace();
		}
	}
	
}
	
	
	
	/*@Test*
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("REDMI");
		category.setDescription("NEW REDMI");
		category.setImageUrl("CAT_1.png");
		
		assertEquals("Category is added successfully",true,categoryDAO.add(category));
		
		
	}
	
	
	@Test
	public void testGetCategory() {
		category = categoryDAO.get(66); 
		assertEquals("Category is Fetched successfully","REDMI",category.getName());
		
		
	}
	@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(66);
		category.setName("SAMSUNG");
		assertEquals("successfully updated in the single category",true,categoryDAO.update(category)); 
		
		
	}*/ 
	
	/*@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(66);
		assertEquals("successfully Deleted in the single category",true,categoryDAO.delete(category)); 
		
		
	}*/ 
	
	/*@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(66);
		assertEquals("successfully Deleted in the single category",1,categoryDAO.list()); 
		
		}  */  
//@Test
//public void testListCategory() {
//	assertEquals("successfully fetched the list of categories in the single category",3,categoryDAO.list().size()); 
//	} 
//}

	

	
	  
	
		

