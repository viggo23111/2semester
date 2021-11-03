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

<h3>Ret sportskategori </h3>

<form action="FrontController" method="post">
    <input type="hidden" name="target" value="manageCategory"/>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="sportId" value="${requestScope.sport.sports_id}">

    <div class="form-group">
        <label for="category">Ret teksten</label>
        <input type="text" class="form-control" id="category" name="category" value="${requestScope.sport.name}">
    </div>

    <button type="submit" name="updatebtn"  class="btn btn-primary">Opdater</button>

</form>

<ul>
    <li><a href="FrontController?target=redirect&destination=index">Til forsiden</a></li>
</ul>
<%@include file="../includes/footer.inc" %>
