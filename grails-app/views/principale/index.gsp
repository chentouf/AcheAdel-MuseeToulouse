<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 4/26/15
  Time: 2:14 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="museetoulouse.Adresse" contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="main"/>
    <title>Bienvenu à Toulouse</title>
    <r:require modules="bootstrap"/>
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
    .container {
        position: relative;
    }
    nav {
        position: absolute;
        left: 0px;
        width: 200px;
    }
    section {
        /* position is static by default */
        margin-left: 200px;
    }
    footer {
        position: fixed;
        bottom: 0;
        left: 0;
        height: 70px;
        background-color: white;
        width: 100%;
    }
    body {
        margin-bottom: 120px;
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
<g:if test="${listeMussesPreferes.size() > 0}">

    <fieldset>
    <div class="fieldcontain" style="background: #E4D8FA">
        <table>
            <thead>
            <th>Mes préférés</th>
            <th>Supprimer</th>
            </thead>
            <tbody>

                        <g:each in="${listeMussesPreferes}" status="i" var="mP">
                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td><li>${mP.key} </li></td>
                            <td><a href="${createLink(controller: "principale",action: "supprimerMusee",params: [id:mP.value])}">DEL</a>
                            </td>
                            </tr>
                        </g:each>
            </tr>
            <td>

                <a href="${createLink(controller: "demandeVisite",action: "index")}">Effectuer une demande de visite</a>
            </td>
            </tbody>
        </table>


    </div>
    </fieldset>
</g:if>



<g:form  url="[action: 'recherche']">

    <fieldset class="form">
        <div class="fieldcontain" style = "margin-left: auto">
            <label>Nom du musée: </label>

    <g:textField name="nomMusee"/><br/>


    <label>Nom de la rue: </label>

    <g:textField name="nomRue"/>
    <br/>
    <label>Code postal: </label>
    <g:select name="codePostal"
              noSelection="${['':'    ']}"
              from="${Adresse.list().codePostal.unique()}" />

    <g:actionSubmit value="Rechercher"  action="recherche"/>
        </div>
    </fieldset>

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

        <th><g:message code="Favoris" default="Favoris" /></th>

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

            <g:if test="${!session.listeMusee.containsValue(new Integer(museeInstance.id.intValue()))}">
                <td><a   href="${createLink(controller: "principale",action: "ajouterMuseesPreferes",params: [id:fieldValue(bean: museeInstance, field: "id")])}"> ADD</a></td>
            </g:if>
        </tr>
    </g:each>
    </tbody>
</table>



<div class="pagination">
    <g:paginate total="${museeInstanceCount ?: 0}"  controller="principale" action="recherche"  params="${params}"/>
</div>
</body>
</html>