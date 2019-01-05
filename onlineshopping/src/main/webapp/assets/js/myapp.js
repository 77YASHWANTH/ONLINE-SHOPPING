
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
	case 'Manage Proudcts':
		$('#manageProducts').addClass('active'); 
		break;

	default:
		if(menu=='home')
			break;
		$('#listProducts').addClass('active');
		$('a_'+menu).addClass('active'); // To know which category is Active
	
		break;
	} 
	
	// to get csrf token.
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if(token.length>0 && header.length>0){
		
		//ajax
		$(document).ajaxSend(function(e,xhr,options){
			xhr.setRequestHeader(header,token);
		});
		
	}
	
	
	//code for jquery Table 
	
	
	
	var $table = $('#productListTable');
	
	//this code will e executed when the tale is present 
	if($table.length){
	console.log('Inside the table!');
	
		var jsonUrl = '';
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else{
			jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
		}
		
		
		$table.DataTable({
			
			lengthMenu: [[3,5,10,-1],['3 Records','5 Records','10 Records','ALL']],
			pageLength:5,
			ajax:{
				url:jsonUrl, 
				dataSrc:''
			}, 
			columns:[
				{
					data:'code',
					mRender:function(data,type,row){
						return '<img src=" '+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg />';
					}
				},
				{
					data:'name'
				},
				{
					data:'brand'
				}, 
				{
					data:'unitPrice',
					mRender:function(data,type,row){ // this function using for conversion of money 
						return '&#8377;'+data
					}
						
				},
				{
					data:'quantity',
					mRender: function(data, type, row) {

								if (data < 1) {
									return '<span style="color:red">Out of Stock!</span>';
								}

								return data;

							}
				},
				{
					data:'id', 
					bSortable: false,
					mRender:function(data,type,row){ // this function using for conversion of money 
						var str = '';
						str += '<a href="'+window.contextRoot+ '/show/'+data+'/product class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
						
						if(row.quantity<1){
							str += '<a href="javascript:void(0)" class = "btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></a>';
							
						}
						else{
							str += '<a href="'+window.contextRoot+ '/show/'+data+'/product class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></a>';
							
						}
						
						
						return str;
					}
				
					
				}
			]
			
		});
		
	
	
	} 
	
	//dismissing the alert after 3 seconds 
	var $alert = $('.alert');
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow')
		},3000)
	}
	
	
//	$('.switch input[type="checkbox"]').on('change',function(){
//		
//		var checkbox = $(this);
//		var checked = checkbox.prop('checked');
//		var dMsg = (checked)? 'You want to activate the product?':
//		'You Want To Deactivate The Product?';
//		var value = checkbox.prop('value'); 
//		bootbox.confirm({
//			size:'medium',
//			title:'Product Activation and Deactivation',
//			message:dMsg,
//			callback:function(confirmed){
//				if(confirmed){
//					console.log(value);
//					bootbox.alert({
//						size:'medium',
//						title:'Information',
//						message:'You are going to operation on product' + value
//						});
//					}
//				else{
//					checkbox.prop('checked',!checked);
//				}
//				
//		
//
//			
//			
//			
//			
//		}
//			
//		});
/*validating the loginform*/
	
	// validating the product form element	
	// fetch the form element
	$loginForm = $('#loginForm');
	
	if($loginForm.length) {
		
		$loginForm.validate({			
				rules: {
					username: {
						required: true,
						email: true
						
					},
					password: {
						required: true
					}				
				},
				messages: {					
					username: {
						required: 'Please enter your email!',
						email: 'Please enter a valid email address!'
					},
					password: {
						required: 'Please enter your password!'
					}					
				},
				errorElement : "em",
				errorPlacement : function(error, element) {
					// Add the 'help-block' class to the error element
					error.addClass("help-block");
					
					// add the error label after the input element
					error.insertAfter(element);
				}	
			}
			);
		
		
		
	}
		
	
	




		
	
	});






		
	



		