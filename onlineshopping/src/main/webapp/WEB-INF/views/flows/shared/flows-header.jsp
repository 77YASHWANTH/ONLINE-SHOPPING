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

    <title>Lets Deal</title> 
    
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
		<%@include file="flows-navbar.jsp" %> 
	</div>
	</body>
		