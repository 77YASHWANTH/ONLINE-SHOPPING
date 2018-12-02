/*package net.yash.shoppingbackend.test;

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
	*/
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
	
	/*public void testListCategory() {
		assertEquals("successfully fetched the list of categories in the single category",1,categoryDAO.delete(category)); 
		
		}  
	
	
}
*/