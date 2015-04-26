<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 4/26/15
  Time: 2:14 AM
--%>

<%@ page import="museetoulouse.Adresse" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
    <style type="text/css" media="screen">
    #status {
        background-color: #eee;
        border: .2em solid #fff;
        margin: 2em 2em 1em;
        padding: 1em;
        width: 12em;
        float: left;
        -moz-box-shadow: 0px 0px 1.25em #ccc;
        -webkit-box-shadow: 0px 0px 1.25em #ccc;
        box-shadow: 0px 0px 1.25em #ccc;
        -moz-border-radius: 0.6em;
        -webkit-border-radius: 0.6em;
        border-radius: 0.6em;
    }

    .ie6 #status {
        display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
    }

    #status ul {
        font-size: 0.9em;
        list-style-type: none;
        margin-bottom: 0.6em;
        padding: 0;
    }

    #status li {
        line-height: 1.3;
    }

    #status h1 {
        text-transform: uppercase;
        font-size: 1.1em;
        margin: 0 0 0.3em;
    }

    #page-body {
        margin: 2em 1em 1.25em 18em;
    }

    h2 {
        margin-top: 1em;
        margin-bottom: 0.3em;
        font-size: 1em;
    }

    p {
        line-height: 1.5;
        margin: 0.25em 0;
    }

    #controller-list ul {
        list-style-position: inside;
    }

    #controller-list li {
        line-height: 1.3;
        list-style-position: inside;
        margin: 0.25em 0;
    }

    @media screen and (max-width: 480px) {
        #status {
            display: none;
        }

        #page-body {
            margin: 0 1em 1em;
        }

        #page-body h1 {
            margin-top: 0;
        }
    }
    </style>
</head>

<body>
<g:form id="rechercheForm" url="[action: 'recherche']">
    <label>Nom du musée: </label>
    <g:textField name="nomMusee"/><br/>




    <label>Nom de la rue: </label>
    <g:textField name="nomRue"/><br/>

    <label>Code postal: </label>
    <g:select name="codePostal"
              noSelection="${['':'    ']}"
              from="${Adresse.list().codePostal.unique()}" />



    <g:actionSubmit value="Rechercher" action="recherche"/>
</g:form>

<table>
    <thead>
    <tr>

        <th><g:message code="musee.nom.label" default="Nom" /></th>

        <th><g:message code="musee.telephone.label" default="Téléphone" /></th>

        <th><g:message code="musee.adresse.label" default="Adresse" /></th>

        <th><g:message code="musee.accesMetro.label" default="Métro" /></th>

        <th><g:message code="musee.accesBus.label" default="Bus" /></th>

        <th><g:message code="musee.horairesOuverture.label" default="Horaires" /></th>

        <th><g:message code="musee.gestionnaire.label" default="Gestionnaire" /></th>

        <th></th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${museeInstanceList}" status="i" var="museeInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td>${fieldValue(bean: museeInstance, field: "nom")}</td>

            <td>${fieldValue(bean: museeInstance, field: "telephone")}</td>

            <td>${fieldValue(bean: museeInstance, field: "adresse")}</td>

            <td>${fieldValue(bean: museeInstance, field: "accesMetro")}</td>

            <td>${fieldValue(bean: museeInstance, field: "accesBus")}</td>

            <td>${fieldValue(bean: museeInstance, field: "horairesOuverture")}</td>

            <td>${fieldValue(bean: museeInstance, field: "gestionnaire")}</td>


        </tr>
    </g:each>
    </tbody>
</table>
<div class="pagination">
    <g:paginate total="${museeInstanceCount ?: 0}"  controller="principale" action="recherche"  params="${params}"/>
</div>
</body>
</html>