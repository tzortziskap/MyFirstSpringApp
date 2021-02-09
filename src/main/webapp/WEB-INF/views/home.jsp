<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${myMessage}</h1>
        <a href="${pageContext.request.contextPath}/customer">Customers</a>
        <a href="${pageContext.request.contextPath}/product">Products</a>
        <a href="${pageContext.request.contextPath}/salesman">Salesmen</a>
    </body>
</html>
