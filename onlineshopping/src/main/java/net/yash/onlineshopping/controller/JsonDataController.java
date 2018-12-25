package net.yash.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.yash.shoppingbackend.dao.ProductDAO;
import net.yash.shoppingbackend.dto.Product;

@Controller 
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	//These Methods Are All From ProductDAOImpl
	
	
	
	@RequestMapping("/all/products") 
	@ResponseBody //by adding this annotation make this method asc json 
	public List<Product> getAllProducts(){
		return productDAO.listActiveProducts();
	} 
	
	@RequestMapping("/admin/all/products") 
	@ResponseBody //by adding this annotation make this method asc json 
	public List<Product> getAllProductsForAdmin(){
		return productDAO.list();
	} 
	
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody //by adding this annotation make this method asc json 
	public List<Product> getProductsByCategory(@PathVariable int id){
		
		return productDAO.listActiveProductsByCategory(id);
	}
	
	
}
