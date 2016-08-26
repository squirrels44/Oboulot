<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
R�sultats de la recherche pr�c�dente.

</div>
<div>
<c:forEach items="${trajets.values().iterator()}" var="trajet">
	<c:if test="${trajetValable(trajet,trajetRecherche)}">
		<div>${trajet.getChauffeur()} par de ${trajet.getPointDeDepart()} pour aller � ${trajet.getPointDArrivee()}</div>
		<div>Il part le ${trajet.getDate()} � ${trajet.getHeureDArrivee()} </div>
	
		<c:if test="${sessionScope.connectedUser!=null }">
			<form  method="POST" action="formRechercheTrajet">
			<input type="submit" name="submit" value="Selectionner"
				class=" form-control btn btn-primary" />
			</form>
		</c:if>
		<c:if test="${sessionScope.connectedUser==null }">
		<div>Pour s�lectionner ce trajet veuillez vous connecter.
		</div>
		</c:if>
	</c:if>
</c:forEach>


</div>