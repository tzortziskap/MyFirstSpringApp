<%-- 
    Document   : familyList
    Created on : Feb 3, 2021, 8:04:43 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Family</title>
    </head>
    <body>
        <h1>This is my List of family</h1>
        <div>
            <h3>Family</h3>
            <p>
                ${message}
            </p>
          
            <table border="1">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Relationship</th>
                        <th>Date of Birth</th>
                    </tr>
                </thead>
                <c:forEach items="${listOfFamily}" var = "family">
                    <tr>
                        <td>${family.fid}</td>
                        <td>${family.fname}</td>
                        <td>${family.frelationship}</td>
                        <td>${family.dob}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>