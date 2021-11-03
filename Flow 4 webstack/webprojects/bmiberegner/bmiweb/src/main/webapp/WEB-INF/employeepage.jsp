<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee home page</title>
</head>
<body>

<div class="alert-success text-center">
<h3>Logget på som:  ${sessionScope.email} </h3>
</div>

<h3>Her kan du gøre følgende: </h3>
<ul>
    <li><a href="FrontController?target=redirect&destination=categories">Rette kategorier</a></li>
    <li><a href="FrontController?target=redirect&destination=index">Til forsiden</a></li>
</ul>
<%@include file="../includes/footer.inc" %>
