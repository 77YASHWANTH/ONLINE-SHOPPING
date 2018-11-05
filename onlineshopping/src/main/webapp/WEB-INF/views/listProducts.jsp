<div class="container">

		<!-- To divide page into two parts-->
		<div class="row">
		
			<!-- To display sidebars -->
			<div class="col-md-3">
				
					<%@include file="./shared/sidebar.jsp" %>
			
			</div>
			
			
			<!-- To display Products -->
			<div class="col-md-9">
				
				<!-- Added breadCrumb (home/category/)to grt like this -->
				<div class = "row">
					
					<div class="col-md-12">
							<c:if test="${userClickAllProducts == true }" >
									<ol class="breadcrumb">
										<li><a href="${contextRoot}/home">HOME</a></li>
										<li class="active">All Products</li>
									</ol>
							</c:if>
							
							<c:if test="${userClickCategoryProducts == true }">
									<ol class="breadcrumb">
										<li><a href="${contextRoot}/home">HOME</a></li>
										<li class="active">Category</li>
										<li class="active">${category.name}</li>
									</ol>
							</c:if>
						
						</div> 
				
				
				</div>
			
			
			
			</div>
		
		
		
		</div>





</div>