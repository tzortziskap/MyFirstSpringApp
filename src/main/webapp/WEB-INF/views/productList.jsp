<%-- 
    Document   : productList
    Created on : Feb 3, 2021, 8:04:43 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>
        <h1>This is my List of products</h1>
        <div>
            <h3>Products</h3>
            <p>
                ${message}
            </p>
            <a href="${pageContext.request.contextPath}/product/create">Add product</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <c:forEach items="${listOfProducts}" var = "product">
                    <tr>
                        <td>${product.pcode}</td>
                        <td>${product.pdescr}</td>
                        <td>${product.pprice}</td>
                        <td>      
                            <a href="${pageContext.request.contextPath}/product/update/${product.pcode}">Update</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/product/delete?id=${product.pcode}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
