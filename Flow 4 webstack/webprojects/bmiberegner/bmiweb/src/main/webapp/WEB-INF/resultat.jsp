<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <h1 class="text-center">Resultat</h1>
        <table class="table table-striped">
            <tr>
                <td>Højde</td>
                <td>${requestScope.height} cm</td>
            </tr>
            <tr>
                <td>Vægt</td>
                <td>${requestScope.weight} kg</td>
            </tr>
            <tr>
                <td>BMI</td>
                <td>${requestScope.bmi}</td>
            </tr>
            <tr>
                <td>Kategori</td>
                <td>${requestScope.kategori}</td>
            </tr>
        </table>
        <p>${requestScope.gender}</p>
        <p>${requestScope.sport}</p>
        <p>
            <c:forEach var="infoitem" items="${requestScope.infos}">id: ${infoitem}
            </c:forEach>
        </p>
        <div class="text-center">
            <a href="FrontController?target=redirect&destination=index">Til forsiden</a>
        </div>
    </div>
    <div class="col-md-4"></div>
</div>
<%@include file="../includes/footer.inc"%>