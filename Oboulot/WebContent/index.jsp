<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Oboulo Covoiturage</title>
<meta charset="utf-8">
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="css/plugins/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">Accueil</a>
			</div>
			<ul class="nav navbar-right top-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-bell"></i> <b
						class="caret"></b></a>
					<ul class="dropdown-menu alert-dropdown">
						<li><a href="#">Jean vous accepte lundi <span
								class="label label-success">-</span></a></li>
						<li><a href="#">Jean vous accepte mardi <span
								class="label label-success">-</span></a></li>
						<li><a href="#">Jean décline pour jeudi <span
								class="label label-danger">-</span></a></li>
						<li><a href="#">Nouvelle demande <span
								class="label label-info">-</span></a></li>
						<li><a href="#">Nouvelle demande <span
								class="label label-info">-</span></a></li>
						<li><a href="#">Nouvelle demande <span
								class="label label-info">-</span></a></li>
						<li class="divider"></li>
						<li><a href="#">View All</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a></li>
						<li><a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="#"><i class="fa fa-fw fa-power-off"></i> Log
								Out</a></li>
					</ul></li>
			</ul>
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="index.jsp" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-search"></i>Rechercher<i class="fa fa-fw fa-caret-down"></i></a>
						<div id="Rechercher" class="collapse">
							<c:import url="/WEB-INF/trajet/recherche.jsp"></c:import></div></li>
					<li><a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-road"></i>Proposer<i class="fa fa-fw fa-caret-down"></i></a>
						<div id="Proposer" class="collapse">
							<c:import url="/WEB-INF/trajet/propose.jsp"></c:import></div></li>
				</ul>
			</div>
		</nav>
		<div id="page-wrapper">
			<c:import url="/WEB-INF/carte/carte.jsp"></c:import>
		</div>
	</div>

	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script src="js/plugins/morris/raphael.min.js"></script>
	<script src="js/plugins/morris/morris.min.js"></script>
	<script src="js/plugins/morris/morris-data.js"></script>

</body>
</html>