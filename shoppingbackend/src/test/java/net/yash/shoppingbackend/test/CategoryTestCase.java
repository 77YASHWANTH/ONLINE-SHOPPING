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
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("REDMI");
		category.setDescription("NEW REDMI");
		category.setImageUrl("CAT_1.png");
		
		assertEquals("Category is added successfully",true,categoryDAO.add(category));
		
		
	}

}
