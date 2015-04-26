<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 4/27/15
  Time: 12:33 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Bienvenu à Toulouse</title>
    <r:require modules="bootstrap"/>
    <style type="text/css" media="screen">
.info, .success, .warning, .error, .validation {
    border: 1px solid;
    margin: 10px 0px;
    padding:15px 10px 15px 50px;
    background-repeat: no-repeat;
    background-position: 10px center;
}

.success {
    color: #4F8A10;
    background-color: #DFF2BF;
    background-image:url('success.png');
}
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
<br/><br/><br/>
<div class="success">
<div ><h3>Demande accepter, voici le code de votre reservation : ${retourCreation}</h3>
</div>

</div>
<br/><br/><br/>
</body>
</html>