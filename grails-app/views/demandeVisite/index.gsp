
<%@ page import="museetoulouse.DemandeVisite" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'demandeVisite.label', default: 'DemandeVisite')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
        <style>
        .info, .success, .warning, .error, .validation {
            border: 1px solid;
            margin: 10px 0px;
            padding:15px 10px 15px 50px;
            background-repeat: no-repeat;
            background-position: 10px center;
        }
        .error {
            color: #D8000C;
            background-color: #FFBABA;
            background-image: url('error.png');
        }
        .button {
            border : 0px;
            -moz-border-radius:7px;
            -webkit-border-radius:7px;
            border-radius:7px;
        }
        </style>
	</head>
<body>

<div>
    <fieldset>
<g:form url="[action: 'demande']" >
    <label>Date de début :</label>
    <g:datePicker name="dateDebutPeriode" value="${new Date()}" precision="day" relativeYears="[0..1]"></g:datePicker><br/>
    <label>Date de fin :</label>
    <g:datePicker name="dateFinPeriode" value="${new Date()}" precision="day" relativeYears="[0..1]"></g:datePicker><br/>
    <label>Nombre de personne(s) :</label>
    <g:field type="number" name="nbPersonnes" min="1" max="6" required="true" />
    <g:actionSubmit value="Effectuer la demande" action="creationDemande"/>
</g:form>
    </div>
    </fieldset>
    <fieldset >
        <g:hasErrors bean="${retourCreation}">
            <div class="error">
                <g:renderErrors bean="${retourCreation}" as="list"  />
            </div>
        </g:hasErrors>
        </fieldset>
<table>

    <thead>
    <th>Mes préférés</th>
    <th>Supprimer</th>
    </thead>
    <tbody>

    <g:each in="${listeMussesPreferes}" status="i" var="mP">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td>
                <li>${mP.key}</li>
                <td><a  href="${createLink(controller: "principale",action: "supprimerMusee",params: [id:mP.value])}">DEL</a></td>
            </td>
        </tr>
    </g:each>

    </tbody>
</table>
</div>

</body>
</html>
