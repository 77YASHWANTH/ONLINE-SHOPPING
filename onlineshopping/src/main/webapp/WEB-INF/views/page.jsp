<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    	<meta name="description" content="">
    	<meta name="author" content="">

    	<title>ONLINE SHOPPING ${title}</title>

    	<!-- Bootstrap core CSS -->
    	<link href="${css}/bootstrap.min.css" rel="stylesheet">

    	<!-- Custom styles for this template -->
    	<link href="${css}/myapp.css" rel="stylesheet">

  
</head>
<body>
		

    <!-- Navigation -->
   
   <%@ include file="./shared/navigation.jsp" %>
   
   <!-- home content -->
    <c:if test="${userClickHome == true}">
 	<%@ include file="home.jsp" %> 
    </c:if>
    
    
    <!-- WHEN ABOUT IS CLICKED -->
     <c:if test="${userClickAbout == true}">
 	<%@ include file="about.jsp" %> 
    </c:if>
    
     <!-- WHEN SERVICES IS CLICKED -->
     <c:if test="${userClickServices == true}">
 	<%@ include file="services.jsp" %> 
    </c:if>
    
     <!-- WHEN CONTACT IS CLICKED -->
     <c:if test="${userClickContact == true}">
 	<%@ include file="about.jsp" %> 
    </c:if>
    
    
    
    
    <!-- Footer -->
   		<%@ include file="./shared/footer.jsp" %>
   		
   		
   		
    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.min.js"></script>

  
</body>
</html>