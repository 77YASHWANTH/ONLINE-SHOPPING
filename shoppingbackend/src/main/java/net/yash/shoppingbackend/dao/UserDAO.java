package net.yash.shoppingbackend.dao;

import java.util.List;

import net.yash.shoppingbackend.dto.Address;
import net.yash.shoppingbackend.dto.Cart;
import net.yash.shoppingbackend.dto.User;

public interface UserDAO {
	
		//add an user
	boolean addUser(User user);
	User getByEmail(String email);
	
	//add an addresses
	boolean addAddress(Address address);

	//add a cart
	boolean addCart(Cart cart);
		
		//update a cart 
	boolean updateCart(Cart cart);
	
	
	
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	
		
//		// adding and updating a new address
//		Address getAddress(int addressId);
//				boolean updateAddress(Address address);
		
	
	

}
