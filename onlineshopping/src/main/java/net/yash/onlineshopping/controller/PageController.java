package net.yash.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.yash.onlineshopping.exception.ProductNotFoundException;
import net.yash.shoppingbackend.dao.CategoryDAO;
import net.yash.shoppingbackend.dao.ProductDAO;
import net.yash.shoppingbackend.dto.Category;
import net.yash.shoppingbackend.dto.Product;



@Controller
public class PageController {
	
	//this is for logger class
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO; //CategoryDAO interface from shoppingbackend..DAO package. 
	
	
	@Autowired
	private ProductDAO productDAO; //ProductDAO interface from shoppingbackend..DAO package. 
	
	
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","HOME"); 
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		//Passing the list of categories
		mv.addObject("categories", categoryDAO.list()); // categories is an arraylist used in CategoryDAOimpl 
														//to return list of category objects	
														//categoryDAO.list() method;
		
		mv.addObject("userClickHome",true);
		return mv;
	} 
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","ABOUT");
		mv.addObject("userClickAbout",true);
		return mv;
	} 
	
	@RequestMapping(value = {"/services"})
	public ModelAndView services(){
	
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","SERVICES");
		mv.addObject("userClickServices",true);
		return mv;
	} 
	
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","CONTACT");
		mv.addObject("userClickContact",true);
		return mv;
	} 
	
		/* 
	 * Methods to load all the products and based on category.
	 */
	
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts(){
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title","All Products");
		
		//Passing the list of categories
		mv.addObject("categories", categoryDAO.list()); // categories is an arraylist used in CategoryDAOimpl 
														//to return list of category objects	
														//categoryDAO.list() method;
		
		mv.addObject("userClickAllProducts",true);
		return mv;
	} 
	
	
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id")int id){
		
		ModelAndView mv = new ModelAndView("page");
		//categoryDAO to fetch a single category 
		Category category = null; 
		category = categoryDAO.get(id);
		
		//to get Category Name.
		mv.addObject("title",category.getName());
		
		//Passing the list of categories
		mv.addObject("categories", categoryDAO.list()); // categories is an arraylist used in CategoryDAOimpl 
														//to return list of category objects	
									
		System.out.println(categoryDAO.list());//categoryDAO.list() method;
		mv.addObject("category",category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;
	}   
	
	// viewing Single Product
	
	@RequestMapping(value = "/show/{id}/product") 
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product == null)throw new ProductNotFoundException(); 
		
		// update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		//---------------------------
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		
		
		return mv;
		
	}
	//Having Similar Mapping To Our Flow ID
		@RequestMapping(value = {"/register"})
		public ModelAndView register(){
			
			ModelAndView mv = new ModelAndView("page");
			mv.addObject("title","ABOUT US");
			return mv;
		}  
		
		/* Login */
		@RequestMapping(value = "/login")
		public ModelAndView login(@RequestParam(name="error",required=false)String error){
			
			ModelAndView mv = new ModelAndView("login");
			
			if(error!=null) {
				mv.addObject("message","INVALID USER NAME AND PASSWORD ");
			}
//			if(logout!=null) {
//				mv.addObject("logout","User has Successfully logged out!");
//			}
//			
			mv.addObject("title","login");
			
			return mv;
			} 
		
		//Access denied Page
		@RequestMapping(value = "/access-denied")
		public ModelAndView accessDenied(){
			
			ModelAndView mv = new ModelAndView("error");
			
			mv.addObject("title","Access Denied");
			mv.addObject("errorTitle","Access Denied");
			mv.addObject("errorDescription","Access Denied");
			
			return mv;
			} 
		
//		//Logout
//		@RequestMapping(value = "/perform-logout")
//		public String logout(HttpServletRequest request,HttpServletResponse response){
//			//fetch the authentication  
//			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//			
//			if(auth!=null) {
//				new SecurityContextLogoutHandler().logout(request,response,auth);
//			} 
//			
//			return "redirect:/login?logout";
//		
//		
//		} 

		

	
}

