<%-- 
    Document   : main
    Created on : 17 May 2023, 2:34:48 pm
    Author     : jaehyeokseong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.Student"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
        <style>
    .button {
      background-color: #4CAF50;
      color: white;
      padding: 10px 20px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      text-decoration: none;
      display: inline-block;
    }

    .button:hover {
      background-color: #45a049;
    }
  </style>
    </head>
    <body onload="startTime(); resetSearch();">
        
        <%
            Student student = (Student)session.getAttribute("student");
        %>
        
        
        
       <h1>Payment Options</h1>
        <a href="payment_home.jsp?cardEmail='<%=student.getEmail()%>'&password='<%=student.getPassword()%>'" class="button">Pay Now</a>
        <a href="payment_update.jsp?cardEmail='<%=student.getEmail()%>'&password='<%=student.getPassword()%>'" class="button">Update Payment</a>
        <a href="payment_list.jsp?cardEmail='<%=student.getEmail()%>'&password='<%=student.getPassword()%>'" class="button">Payment List</a>

        
    </body>
</html>
