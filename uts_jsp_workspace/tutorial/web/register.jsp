<%-- 
    Document   : register
    Created on : 12 May 2023, 2:45:15 pm
    Author     : jaehyeokseong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body onload="startTime()">
        <%
            String existErr = (String)session.getAttribute("existErr");
            String emailErr = (String)session.getAttribute("emailErr");
            String passErr = (String)session.getAttribute("passErr");
            String nameErr = (String)session.getAttribute("nameErr");
        %>
        <h1>Register Page <%=(existErr != null ? existErr : "")%></h1>
        <form action="RegisterServlet" method="post">
            <p>Full Name: </p><input type="text" placeholder="<%=(nameErr != null ? nameErr : "Enter name")%>" name="name">
            <p>Email: </p><input type="text" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" name="email">
            <p>Password: </p><input type="text" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" name="password">
            <p>Date of Birth</p><input type="date" placeholder="Enter dob" name="dob">
            <input type="submit" value="Sign Up">
        </form>
    </body>
</html>
