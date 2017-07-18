<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page import="java.util.*"%>
<%
    request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Bootstrap 3</title>

<!-- Bootstrap -->
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/custom/css/sticky-footer-navbar.css" />" rel="stylesheet">
</head>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<tiles:insertAttribute name="header"/>
		</div>
	</nav>

	<div class="container theme-showcase" role="main">
		<tiles:insertAttribute name="content"/>
	</div>
	
	<footer class="footer">
      <div class="container">
      	<tiles:insertAttribute name="footer"/>
      </div>
    </footer>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	
	
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
	
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="<c:url value="/resources/bootstrap/js/ie10-viewport-bug-workaround.js"/>"></script>
</body>
</html>