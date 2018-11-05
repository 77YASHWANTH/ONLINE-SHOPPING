package net.yash.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.yash.shoppingbackend.dao.CategoryDAO;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO; //CategoryDAO interface from shoppingbackend..DAO package.
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","HOME");
		
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
	
	@RequestMapping(value = {"/viewproduct"})
	public ModelAndView viewproduct(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","VIEW PRODUCT");
		mv.addObject("userClickViewProduct",true);
		return mv;
	} 
	

/*	//Request param  .... onlineshopping/test?greeting=process is success
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting",required=false)String greeting){
		if(greeting==null) {
			greeting = "Page Is Under The Construction";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",greeting); 
		return mv;
	}
	
	
	//PathVariable ..... onlineshopping/test/what ever u type here it will passed as greeting to the pagecontroller

	@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting")String greeting){
		if(greeting==null) {
			greeting = "Page Is Under The Construction";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",greeting); 
		return mv;
	}*/
}

