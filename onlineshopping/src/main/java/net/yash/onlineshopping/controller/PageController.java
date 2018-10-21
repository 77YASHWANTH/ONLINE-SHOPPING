package net.yash.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","spring project is on process");
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

