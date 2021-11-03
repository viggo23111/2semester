<%@ page import="FunctionLayer.Toppings" %>
<%@ page import="Util.Initializer" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="includes/header.inc" %>

<%!
    @Override
    public void jspInit() {
        //Kode til initialisering. Fe.eks. befolke datastrukter, lister etc

    }
%>
<%
    if(request.getServletContext().getAttribute("sportList") == null) {
        request.getServletContext().setAttribute("sportList", Initializer.getSportList());
    }
    if(request.getServletContext().getAttribute("infoList") == null) {
        request.getServletContext().setAttribute("infoList", Initializer.getInfoList());
    }
%>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <p class="text-center"><a href="FrontController?target=redirect&destination=login">Log ind som admin</a></p>
        <h1 class="text-center">BMI beregner</h1>
        <form action="FrontController" method="post">
            <input type="hidden" name="target" value="resultat">
            <div class="form-group">
                <label for="height">Indtast din højde i centimeter</label>
                <input type="text" class="form-control" id="height" name="height">
            </div>
            <div class="form-group">
                <label for="weight">Indtast din vægt i kg:</label>
                <input type="text" class="form-control" id="weight" name="weight">
            </div>

            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="kvinde">
                <label class="form-check-label" for="inlineRadio1">Kvinde</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="mand" checked>
                <label class="form-check-label" for="inlineRadio2">Mand</label>
            </div>

            <div class="form-group">
                <label for="sport">Vælg din primære idræt</label>
                <select class="form-control" name="sport" id="sport">
                    <c:forEach var="sportsItem" items="${applicationScope.sportList}">
                        <option value="${sportsItem.sports_id}">${sportsItem.name}</option>
                    </c:forEach>
                </select>
            </div>

            <c:forEach var="infoItem" items="${applicationScope.infoList}">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="info" value="${infoItem.info_id}" id="flexCheckDefault${infoItem.info_id}">
                <label class="form-check-label" for="flexCheckDefault${infoItem.info_id}">
                    ${infoItem.name}
                </label>
            </div>
            </c:forEach>

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Beregn din BMI</button>
            </div>
        </form>

        <h3>${requestScope.message}</h3>

    </div>
    <div class="col-md-4"></div>
</div>
<%@include file="includes/footer.inc" %>