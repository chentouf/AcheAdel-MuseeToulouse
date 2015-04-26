
<%@ page import="museetoulouse.DemandeVisite" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'demandeVisite.label', default: 'DemandeVisite')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
<body>

<g:form id="demandeForm" url="[action: 'demande']" >
    <label>Date de début :</label>
    <g:datePicker name="dateDebutPeriode" value="${new Date()}" precision="day" relativeYears="[0..1]"></g:datePicker><br/>
    <label>Date de fin :</label>
    <g:datePicker name="dateFinPeriode" value="${new Date()}" precision="day" relativeYears="[0..1]"></g:datePicker><br/>
    <label>Nombre de personne(s) :</label>
    <g:field type="number" name="nbPersonnes" min="1" max="6" required="true" />
    <g:actionSubmit value="Effuctuer la demande" action="demande"/>
</g:form>
<div>
<table id="museesFavoris">

    <thead>
        <h3>Mes Musée(s) :</h3>
    </thead>
    <tbody>
    <g:each in="${listeMussesPreferes}" status="i" var="mP">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td>${mP.key}</td>
        </tr>
    </g:each>
    </tbody>
</table>
</div>

</body>
</html>
