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
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
      integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

</head>
<body>
<div class="alert alert-dark" role="alert">
    <h3 class="text-center ">Oversigt over sportskategorier </h3>
</div>

<form action="FrontController" method="post">
    <input type="hidden" name="target" value="manageCategory"/>
    <table class="table">
        <c:forEach var="sportItems" items="${applicationScope.sportList}">
            <tr>
                <td>${sportItems.name}</td>
                <td class="text-right">
                    <button type="submit" name="editbtn" value="${sportItems.sports_id}" class="btn btn-primary"><i
                            class="fa fa-edit"></i></button>
                    <button type="submit" name="removebtn" value="${sportItems.sports_id}" class="btn btn-danger"><i
                            class="fa fa-trash"></i></button>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
<button type="submit" name="editbtn" class="btn btn-link"><a href="FrontController?target=redirect&destination=index">Til
    forsiden</a></button>
<%@include file="../includes/footer.inc" %>
