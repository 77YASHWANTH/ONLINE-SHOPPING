package net.yash.shoppingbackend.dao;

import java.util.List;

import net.yash.shoppingbackend.dto.Cart;
import net.yash.shoppingbackend.dto.CartLine;

public interface CartLineDAO {

	public CartLine get(int id);	
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);

	// fetch the CartLine based on cartId and productId
	public CartLine getByCartAndProduct(int cartId, int productId);		
	
	// list of available cartLine
	public List<CartLine> listAvailable(int cartId);
		
	
	// updating the cart
	boolean updateCart(Cart cart);
	
	
	// adding order details
	//boolean addOrderDetail(OrderDetail orderDetail);

}
