package net.yash.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.yash.shoppingbackend.dao.UserDAO;
import net.yash.shoppingbackend.dto.Address;
import net.yash.shoppingbackend.dto.Cart;
import net.yash.shoppingbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.yash.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("UserDAO");
	}
	
	@Test
	public void testGetAddresses() {
		
		user = userDAO.getByEmail("hr@gmail.com"); 
		assertEquals("Failed to fetch the list of address and size doest not match!",2,userDAO.listShippingAddresses(user).size()); 
	
		assertEquals("Failed to fetch the list of address and size doest not match!","MUMBAI",userDAO.getBillingAddress(user).getCity()); 

		
	}
}
	
	
	/*@Test 
	public void tetAddAddress() {
		
				user = userDAO.getByEmail("hr@gmail.com");
		//we are also going to add the shipping address
				// add the shipping address
				address = new Address();
				address.setAddressLineOne("301/B Jadoo Society, Kishan Kanhaiya Nagar");
				address.setAddressLineTwo("Near Kudrat Store");
				address.setCity("Banglore");
				address.setState("Karnataka");
				address.setCountry("India");
				address.setPostalCode("400001");
				//set shipping to true
				address.setShipping(true);
				
				
				address.setUser(user); 
				
				assertEquals("Failed to add address!",true,userDAO.addAddress(address));
				
		
	}
} */
	
	
	/*@Test
	public void testAddAddress() {
		//add an user 
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("CUSTOMER");
		user.setEnabled(true);
		user.setPassword("12345");
				
		
		// add the user
		assertEquals("Failed to add the user!", true, userDAO.addUser(user));	
		
		
		//add the address 
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		address.setUser(user); 
		
		assertEquals("Failed to add address!",true,userDAO.addAddress(address));
		
		
		
		//we are also going to add the shipping address
		// add the shipping address
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		//set shipping to true
		address.setShipping(true);
		
		
		address.setUser(user); 
		
		assertEquals("Failed to add address!",true,userDAO.addAddress(address));
		
					
		
		
	}
} */
	
	/*@Test
	public void testAdd() {
		
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("CUSTOMER");
		user.setEnabled(true);
		user.setPassword("12345");
				
		
		
		if(user.getRole().equals("CUSTOMER")) {
		
		
		cart = new Cart();
		
		// linked the cart with the user
		cart.setUser(user);
		
		// attach cart with the user 
		user.setCart(cart);
		}	
		// add the user
		assertEquals("Failed to add the user!", true, userDAO.addUser(user));	
				
} 
}
*/
	
	
	/*@Test
	public void testUpdateCart() {
		// fetch the user y its email
		user = userDAO.getByEmail("hr@gmail.com");
		
		//get the cart from the user
		cart = user.getCart();
		
		cart.setGrandTotal(5555);
		cart.setCartLines(2);
		
		assertEquals("Failed to  UpdateCart",true,userDAO.updateCart(cart));
	}*/

	

	/*@Test
	public void testAdd() {
		
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("CUSTOMER");
		user.setEnabled(true);
		user.setPassword("12345");
				
		
		// add the user
		assertEquals("Failed to add the user!", true, userDAO.addUser(user));	
		
		
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		// linked the address with the user
		address.setId(user.getId());
						
		// add the address
		//assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));
					
		
		if(user.getRole().equals("CUSTOMER")) {
			
			
			cart = new Cart();
			
			// linked the cart with the user
			cart.setUser(user);
			
			
			// add the cart
			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
			
			
			// add the shipping address
			address = new Address();
			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
			address.setAddressLineTwo("Near Kudrat Store");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
			//set shipping to true
			address.setShipping(true);
			
			//link it with the user
			//address.setUserId(user.getId());
			
			assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		
			
			
			
			
			
			
		}
	} 
}/*
		
		
		
				
	/*	// add the shipping address
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setUser(user);
		assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		
	}
	
	*/

	// working for uni-directional
/*
	@Test
	public void testAddAddress() {
		user = userDAO.get(1);
		
		address = new Address();
		address.setAddressLineOne("301/B Jadoo Society, King Uncle Nagar");
		address.setAddressLineTwo("Near Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
				
		address.setUser(user);
		// add the address
		assertEquals("Failed to add the address!", true, userDAO.addAddress(address));	
	}
	
	@Test
	public void testUpdateCart() {
		user = userDAO.get(1);
		cart = user.getCart();
		cart.setGrandTotal(10000);
		cart.setCartLines(1);
		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));			
	} 
*/
	
	
	


