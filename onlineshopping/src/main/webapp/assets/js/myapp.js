
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
	
	
	
	
	
});