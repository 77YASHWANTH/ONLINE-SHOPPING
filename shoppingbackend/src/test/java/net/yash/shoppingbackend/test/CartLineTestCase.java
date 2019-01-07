package net.yash.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.yash.shoppingbackend.dao.CartLineDAO;
import net.yash.shoppingbackend.dao.ProductDAO;
import net.yash.shoppingbackend.dao.UserDAO;
import net.yash.shoppingbackend.dto.Cart;
import net.yash.shoppingbackend.dto.CartLine;
import net.yash.shoppingbackend.dto.Product;
import net.yash.shoppingbackend.dto.User;

public class CartLineTestCase {

	

	private static AnnotationConfigApplicationContext context;
	
	
	private static CartLineDAO cartLineDAO;
	private static ProductDAO productDAO;
	private static UserDAO userDAO;
	
	
	private CartLine cartLine = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.yash.shoppingbackend");
		context.refresh();
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
		productDAO = (ProductDAO)context.getBean("productDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	
	@Test
	public void testAddCartLine() {
		
		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("kn@gmail.com");		
		
		//fetch the cart
		Cart cart = user.getCart();
		
		// fetch the product 
		Product product = productDAO.get(1);
		
		// Create a new CartLine
		cartLine = new CartLine();
		
		//Buying price
		cartLine.setBuyingPrice(product.getUnitPrice()); 
		
		//product Count
		cartLine.setProductCount(cartLine.getProductCount()+1);
		
		//Total
		cartLine.setTotal(product.getUnitPrice() * cartLine.getProductCount());
		
		//Is Available.
		cartLine.setAvailable(true);
		
		//getting CartId
		cartLine.setCartId(cart.getId());
		
		//setting Product
		cartLine.setProduct(product);
				
		//double oldTotal = cartLine.getTotal();		
		
		
		
		assertEquals("Failed to add the CartLine!",true, cartLineDAO.add(cartLine));
		
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal()));
		cart.setCartLines(cart.getCartLines() + 1);
		
		assertEquals("Failed to update the cart!",true, userDAO.updateCart(cart));
		
	}
	
	
	/*
	@Test
	public void testUpdateCartLine() {

		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("absr@gmail.com");		
		Cart cart = user.getCart();
				
		cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), 2);
		
		cartLine.setProductCount(cartLine.getProductCount() + 1);
				
		double oldTotal = cartLine.getTotal();
				
		cartLine.setTotal(cartLine.getProduct().getUnitPrice() * cartLine.getProductCount());
		
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		
		assertEquals("Failed to update the CartLine!",true, cartLineDAO.update(cartLine));	

		
	} */
	
	
	
}