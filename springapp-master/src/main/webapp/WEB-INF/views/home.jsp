<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Manager Home</title>
    </head>
    <body>
        <div align="center">
            <h1>Contact List</h1>
            <h3><a href="/newDBBook">New DBBook</a></h3>
            <table border="1">
                <th>No</th>
                <th>Name</th>
                <th>Auth</th>
                
                 
                <c:forEach var="dbbook" items="${listdbbook}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${dbbook.name}</td>
                    <td>${dbbook.auth}</td>
                    
                    <td>
                        <a href="/editDBBook?id=${dbbook.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/deleteContact?id=${dbbook.id}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>