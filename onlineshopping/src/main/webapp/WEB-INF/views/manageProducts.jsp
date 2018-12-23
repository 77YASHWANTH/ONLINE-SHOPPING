<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">

	
	<div class="row">

		<c:if test="${not empty message}">	
		<div class="row">			
			<div class="col-xs-12 ">			
				<div class="alert alert-success alert-dismissible">
				
					<button type="button" class="close" data-dismiss="alert">&times;</button>
				
					${message}
				</div>				
			</div>
		</div>
	</c:if>
		


		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product Management</h4>

				</div>

				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products" method="POST" enctype="multipart/form-data">
						
						<div class="form-group">
							<label class="control-label col-md-4">Enter The Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" class="form-control"
									placeholder="Product Name" />
								<sf:errors path="name" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Enter The Brand:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" class="form-control"
									placeholder="Brand Name" /> 
								<sf:errors path="brand" cssClass="help-block" element="em"/>	
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Description</label>
							<div class="col-md-8">
								<sf:textarea path="description" class="form-control"
									placeholder="Enter your description here!" /> 
								<sf:errors path="description" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Unit Price</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" class="form-control"
									placeholder="Enter Unit Price" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Quantity Available:</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" class="form-control"
									placeholder="Enter Quantity" />
								<sf:errors path="quantity" cssClass="help-block" element="em"/> 
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Upload a file</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" class="form-control"/>
								<sf:errors path="file" cssClass="help-block" element="em"/> 
							</div>
						</div>

						
						
						
						

						<div class="form-group">
							<label class="control-label col-md-4">Category</label>
							<div class="col-md-8">
								<sf:select path="categoryId" id="categoryId" items="${categories}" itemLabel="name" itemValue="id" class="form-control"/>
									
								</div>
							
						</div>


					
						<div class="form-group">
							
							<div class="col-md-offset-4 col-md-8">
									<sf:hidden path="id"/>
									<sf:hidden path="code"/>
									<sf:hidden path="supplierId"/>
									<sf:hidden path="active"/>			
									<sf:hidden path="purchases"/>
									<sf:hidden path="views"/>	
							<input type="submit" name="submit" value="SUBMIT" class="btn btn-primary"/>
																											
							</div>
						</div>						
										
					</sf:form>

				</div>

			</div>

		</div>

	</div>

			
		</div>
	
	
	