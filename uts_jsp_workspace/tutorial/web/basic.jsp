<%-- 
    Document   : basic
    Created on : 18 May 2023, 2:34:48 pm
    Author     : Pascal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.Student"%>
<%@page import="uts.isd.model.Payment"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Page</title>
        
    </head>
    <body onload="startTime(); resetSearch();">
        
        <%
            Student student = (Student)session.getAttribute("student");
        %>
        
        <h1>Payment Page</h1>
        
        <p>HELLO</p>
      
        <jsp:include page="subjects.jsp" flush="true"/>
    </body>
</html>
