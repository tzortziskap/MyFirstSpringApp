<%-- 
    Document   : salesmanList
    Created on : Feb 3, 2021, 8:04:43 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salesmen</title>
    </head>
    <body>
        <h1>This is my List of salesmans</h1>
        <div>
            <h3>Salesmen</h3>
            <p>
                ${message}
            </p>
            <a href="${pageContext.request.contextPath}/salesman/create">Add salesman</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <c:forEach items="${listOfSalesmans}" var = "salesman">
                    <tr>
                        <td>${salesman.scode}</td>
                        <td>${salesman.sname}</td>
                        <td>      
                            <a href="${pageContext.request.contextPath}/salesman/update/${salesman.scode}">Update</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/salesman/delete?id=${salesman.scode}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
