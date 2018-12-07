
// this function will say that which page is actively open by highligthing the menu .
$(function(){
	switch(menu){ // this menu is from page.jsp 
	case 'ABOUT':		// this 'ABOUT is from title given in model view locater in pageController.
		$('#about').addClass('active');
		break;
	case 'CONTACT':
		$('#contact').addClass('active');
		break;
	case 'PRODUCTS':
		$('#listProducts').addClass('active');
		break;
	case 'SERVICES':
		$('#services').addClass('active'); 
		break;
	default:
		if(menu=='home')
			break;
		$('#home').addClass('active');
		$('a_'+menu).addClass('active'); // To know which category is Active
	
		break;
	}
	
});