<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				
				<%-- <c:if ${connecté}> élément de liste suivant </c:if> --%>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-bell"></i> <b
						class="caret"></b></a>
					<ul class="dropdown-menu alert-dropdown">
						<%-- <c:foreach ${Profile.notification} > </c:foreach>--%>
						
						<li><a href="#">Jean ok lundi <span
								class="label label-success">o</span></a></li>
						<li><a href="#">Jean ok mardi <span
								class="label label-success">o</span></a></li>
						<li><a href="#">Jean pas ok jeudi <span
								class="label label-danger">x</span></a></li>
						<li><a href="#">Nouvelle demande <span
								class="label label-info">i</span></a></li>
						<li><a href="#">Nouvelle demande <span
								class="label label-info">i</span></a></li>
						<li><a href="#">Nouvelle demande <span
								class="label label-info">i</span></a></li>
						<li class="divider"></li>
						<li><a href="#">View All</a></li>
					</ul></li>
					
				<%-- <c:if ${connecté}> élément de liste suivant </c:if> --%>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> John Smith<%-- ${profile.name} --%> <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#" data-toggle="modal" data-target="#profil"><i class="fa fa-fw fa-user"></i> Profil</a></li>
						<li><a href="#" data-toggle="modal" data-target="#parametres"><i class="fa fa-fw fa-gear"></i> Paramètres</a>
						</li>
						<li class="divider"></li>
						<li><a href="#"><i class="fa fa-fw fa-power-off"></i> Se déconnecter </a></li>
					</ul></li>
					
				<%-- <c:if ${!connecté}> élément de liste suivant </c:if> --%>
				<li class="dropdown"><a href="#" 
					data-toggle="modal" data-target="#connecter">Se connecter</a>
				</li>
				
				<%-- <c:if ${!connecté}> élément de liste suivant </c:if> --%>
				<li class="dropdown"><a href="#"
					data-toggle="modal" data-target="#inscrire">S'inscrire</a>
				</li>
				
			</ul>
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="index.jsp" data-toggle="collapse" data-target="#Rechercher"><i class="fa fa-fw fa-search"></i>Rechercher<i class="fa fa-fw fa-caret-down"></i></a>
						<div id="Rechercher" class="collapse">
							<%-- <c:import url="/WEB-INF/trajet/recherche.jsp"></c:import> --%>
						</div>
					</li>
					<li><a href="javascript:;" data-toggle="collapse" data-target="#Proposer"><i class="fa fa-fw fa-road"></i>Proposer<i class="fa fa-fw fa-caret-down"></i></a>
						<div id="Proposer" class="collapse">
							<c:import url="/WEB-INF/trajet/formulaireProposerTrajet.jsp"></c:import>
						</div>
					</li>
				</ul>
			</div>
		</nav>
		<div id="page-wrapper">
			<%-- <c:import url="/carte/carte.jsp"></c:import> --%>
		</div>
	</div>

	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script src="js/plugins/morris/raphael.min.js"></script>
	<script src="js/plugins/morris/morris.min.js"></script>
	<script src="js/plugins/morris/morris-data.js"></script>

<div class="modal fade" id="inscrire" role="dialog">
	<div class="modal-dialog">
      	<div class="modal-content">
     		<div class="modal-body">
        		<button type="button" class="close" data-dismiss="modal">&times;</button>
          		<a href="#"><c:import url="/WEB-INF/compte/formulaireInscription.jsp"></c:import></a>
        	</div>
      	</div>
    </div>
</div>
<div class="modal fade" id="connecter" role="dialog">
	<div class="modal-dialog">
      	<div class="modal-content">
     		<div class="modal-body">
        		<button type="button" class="close" data-dismiss="modal">&times;</button>
          		<a href="#"><c:import url="/WEB-INF/compte/formulaireConnexion.jsp"></c:import></a>
        	</div>
      	</div>
    </div>
</div>
<div class="modal fade" id="profil" role="dialog">
	<div class="modal-dialog">
      	<div class="modal-content">
     		<div class="modal-body">
        		<button type="button" class="close" data-dismiss="modal">&times;</button>
          		Mon profil
        	</div>
      	</div>
    </div>
</div>
<div class="modal fade" id="parametres" role="dialog">
	<div class="modal-dialog">
      	<div class="modal-content">
     		<div class="modal-body">
        		<button type="button" class="close" data-dismiss="modal">&times;</button>
          		Paramètres d'application<br>
          		-<br>
          		-<br>
        	</div>
      	</div>
    </div>
</div>


</body>
</html>