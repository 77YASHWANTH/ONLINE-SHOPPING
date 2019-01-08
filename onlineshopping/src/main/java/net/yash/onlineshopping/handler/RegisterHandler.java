package net.yash.onlineshopping.handler;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import net.yash.onlineshopping.model.RegisterModel;
import net.yash.shoppingbackend.dao.UserDAO;
import net.yash.shoppingbackend.dto.Address;
import net.yash.shoppingbackend.dto.Cart;
import net.yash.shoppingbackend.dto.User;

@Component
public class RegisterHandler implements Serializable {

	@Autowired
	private UserDAO userDAO;
	
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder; //by using the bean declared in spring-security.xml we can use this class


	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
	 registerModel.setUser(user);
	} 
	public void addBilling(RegisterModel registerModel, Address billing) {
	  registerModel.setBilling(billing);
	 }
	
	 public String saveAll(RegisterModel model) {
		 String transitionValue = "success";
		 //fetching the user
		 User user = model.getUser();
		 if(user.getRole().equals("USER")) {
		// create a new cart
			 Cart cart = new Cart();
			 cart.setUser(user);
			 user.setCart(cart);
  	}  
		 
//		 // encode the password
//		 user.setPassword(passwordEncoder.encode(user.getPassword()));
//		 
		 //save the user
		 userDAO.addUser(user);
		 
		 //get the address 
		 Address billing = model.getBilling();
		 billing.setId(user.getId()); 
		 billing.setBilling(true);
		 
		 //save the address
		 userDAO.addAddress(billing);
		 
		 return transitionValue;
	 }
	 
	 
	 public String validateUser(User user, MessageContext error) {
	  String transitionValue = "success";
	   if(!user.getPassword().equals(user.getConfirmPassword())) {
	    error
	    .addMessage(new MessageBuilder()
	    		.error().source("confirmPassword")
	    		.defaultText("Password does not match confirm password!").build());
	    transitionValue = "failure";    
	   }  
	   //unique email id
	   if(userDAO.getByEmail(user.getEmail())!=null) {
	    error.addMessage(new MessageBuilder()
	    		.error()
	    		.source(
	      "email")
	    		.defaultText("Email address is already taken!")
	    		.build());
	    transitionValue = "failure";
	   }
	  return transitionValue;
	 }
	 

	
	
	
// @Autowired
// private PasswordEncoder passwordEncoder;
//	
//	
// @Autowired
// private UserDAO userDAO;
// public RegisterModel init() { 
//  return new RegisterModel();
// } 
// public void addUser(RegisterModel registerModel, User user) {
//  registerModel.setUser(user);
// } 
// public void addBilling(RegisterModel registerModel, Address billing) {
//  registerModel.setBilling(billing);
// }
//
// public String validateUser(User user, MessageContext error) {
//  String transitionValue = "success";
//   if(!user.getPassword().equals(user.getConfirmPassword())) {
//    error.addMessage(new MessageBuilder().error().source(
//      "confirmPassword").defaultText("Password does not match confirm password!").build());
//    transitionValue = "failure";    
//   }  
//   if(userDAO.getByEmail(user.getEmail())!=null) {
//    error.addMessage(new MessageBuilder().error().source(
//      "email").defaultText("Email address is already taken!").build());
//    transitionValue = "failure";
//   }
//  return transitionValue;
// }
// 
// public String saveAll(RegisterModel registerModel) {
//  String transitionValue = "success";
//  User user = registerModel.getUser();
//  if(user.getRole().equals("USER")) {
//   // create a new cart
//   Cart cart = new Cart();
//   cart.setUser(user);
//   user.setCart(cart);
//  }
//   
// /* // encode the password
//  user.setPassword(passwordEncoder.encode(user.getPassword()));
//  
//  // save the user
//  userDAO.add(user);
//  // save the billing address
//  Address billing = registerModel.getBilling();
//  billing.setUserId(user.getId());
//  billing.setBilling(true);  
//  userDAO.addAddress(billing);
//  return transitionValue ;
// } */ 
 }

