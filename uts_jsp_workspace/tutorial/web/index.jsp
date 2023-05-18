<%-- 
    Document   : index
    Created on : 12 May 2023, 2:35:45 pm
    Author     : jaehyeokseong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>ISD Workshop Demo</h1>
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
        <jsp:include page="/ConnServlet" flush="true"/>
    </body>
</html>
