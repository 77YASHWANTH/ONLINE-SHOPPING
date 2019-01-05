<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ESHOP</title> 
    
    <script>
    	window.menu = '${title}'; 
    	
    	window.contextRoot = '${contextRoot}'
    		
	</script>
   
    <!-- Bootstrap Core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
   <!--   Simplex Theme //this has should be completed // video-part 02-8
	<link href="${css}/bootstrap-simplex-theme.css" rel="stylesheet">
	-->  
	
	
	<!-- Bootstrap DataTables -->
	<link href="${css}/dataTables.bootstrap.css" rel = "stylesheet">
    
    <script type="text/javascript" href="https://cdn.datatables.net/plug-ins/1.10.19/api/average().js"></script>
    
    <!-- Custom CSS -->
	<link href="${css}/myapp.css" rel="stylesheet"> 

	<link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"  rel = "stylesheet"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>



<body>
	<div class="wrapper">
	
	
	    <!-- Navigation -->
	    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	    	<div class="container">
	    		<!-- brand and toggle get grouped for better mobile --> 
	    		<div class="navbar-header">
	    			<a class="nav-brand" href="${contextRoot}/home">LETS DEAL</a>
	    		</div>
	    	
	    	</div>
	    
	    
	    </nav>
	    	
	    <!-- Page Content -->
	    	
<div class="content">
	
	<div  class="container">    
		<!-- login details is wrong this will execute -->
		<c:if test="${not empty message}">
			<div class="row">
     
     			<div class="col-md-offset-3 col-md-6">
    				
    				<div class="alert alert-danger">
    					${message}
    				</div>
    				
			</div> 
		</div>
			
		</c:if>
	
		
	<div class="row">
     
     <div class="col-md-offset-3 col-md-6">
      
      <div class="panel panel-primary">
       
       <div class="panel-heading">
        <h4>Login</h4>
       </div>
       
       <div class="panel-body">
        <form action="${contextRoot}/login" method="POST" class="form-horizontal"
         id="loginForm"
        >
         <div class="form-group">
          <label for="username" class="col-md-4 control-label">Email: </label>
          <div class="col-md-8">
           <input type="text" name="username" id="username" class="form-control"/>
          </div>
         </div>
       
		 <div class="form-group">
          <label for="password" class="col-md-4 control-label">Password: </label>
          <div class="col-md-8">
           <input type="password" name="password" id="password" class="form-control"/>
          </div>
         </div>
        
         <div class="form-group">
          <div class="col-md-offset-4 col-md-8">
           <input type="submit" value="Login" class="btn btn-primary"/>
          	<input type="hidden" name="${_csrf.parameterName}" value = "${_csrf.token}"/>
          </div>
         </div>
        </form>
       
       </div>
       <div class="panel-footer">
       	<div class="text-right">
       		New User - <a href="${contextRoot}/register">Register Here</a>
       	</div>
       </div>
      
      </div> 
    
     </div>
   
	</div> 
</div>
	       <!-- /.container -->
		
		<!-- Footer -->
		<%@include file="./shared/footer.jsp" %>
	       
	    
	    <!-- jQuery -->
	    <script src="${js}/jquery.js"></script>
	
	    <!-- Bootstrap Core JavaScript -->
	    <script src="${js}/bootstrap.min.js"></script> 
	    
	  
		<!-- DataTable Bootstrap Script-->
	    <script src="${js}/dataTables.bootstrap.js"></script>
		
	    
	      
	    <!-- self code(MyAPP.js) -->
		<script src="${js}/myapp.js"></script>
		
	</div>
</body>

</html>
