<%-- 
    Document   : customerForm
    Created on : Feb 3, 2021, 8:42:20 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create your fantastic customer</h1>
        
    <c:if test="${customerToEdit==null}">
        <c:url value="/customer/create" var="link"/>
    </c:if>
    <c:if test="${customerToEdit!=null}">
        <c:url  value="/customer/update" var="link"/>
    </c:if>
    <form action="${link}" method="POST">
        <label for="ccode">Code:</label>
        <input id="ccode" type="number" name="ccode" value="${customerToEdit.ccode}" readonly/>
        <br/>
        <label for="cname">Name:</label>
        <input id="cname" type="text" name="cname" value="${customerToEdit.cname}"/>
        <br/>
        <input type="submit" value="Submit"/>
    </form>
</body>
</html>
