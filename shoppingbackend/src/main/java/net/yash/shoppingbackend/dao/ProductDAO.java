package net.yash.shoppingbackend.dao;

import java.util.List;

import net.yash.shoppingbackend.dto.Product;

public interface ProductDAO {

	Product get(int productId);
	List<Product> list();	
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);

	//List<Product> getProductsByParam(String param, int count);	
	
	
	// business methods
	List<Product> listActiveProducts();	
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
}


/*package net.yash.shoppingbackend.dao;

import java.util.List;

import net.yash.shoppingbackend.dto.Product;

public interface ProductDAO {
	
	Object listActiveProducts = null;
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//Business Methods 
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	

}*/
