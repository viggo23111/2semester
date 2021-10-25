<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<h2>Get form</h2>
<form action="hello-servlet", method="get">
    <label for="fname">First name:</label><br>
    <input type="text" id="fname" name="fname" value="John"><br>
    <label for="lname">Last name:</label><br>
    <input type="text" id="lname" name="lname" value="Doe"><br><br>
    <input type="submit" value="Submit">
</form>

<h2>Post form</h2>
<form action="hello-servlet", method="post">
    <label for="fname">First name:</label><br>
    <input type="text" id="pfname" name="fname" value="John"><br>
    <label for="lname">Last name:</label><br>
    <input type="text" id="plname" name="lname" value="Doe"><br><br>
    <input type="submit" value="Submit">
</form>
<br/>

<a href="hello-servlet">Hello Servlet</a>
</body>
</html>