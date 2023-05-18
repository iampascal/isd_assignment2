<%-- 
    Document   : edit
    Created on : 17 May 2023, 3:04:13 pm
    Author     : jaehyeokseong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.Student"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
    </head>
    <body onload="startTime()">
        <%
            Student student = (Student)session.getAttribute("student");
            String updated = (String)session.getAttribute("updated");
        %>
        <h1>Edit Page</h1>
        <a href="MainServlet?email='<%student.getEmail()%>'&password='<%=student.getPassword()%>'">Main</a>
        <a href="LogoutController">Logout</a>
        <h1>Edit Student Information: <%=updated != null ? updated : ""%></h1>
        <form action="UpdateServlet" method="post">
            <table>
                <td>Full Name:</td><td><input type="text" name="name" value="${student.name}"></td>
                <td>Email:</td><td><input type="text" name="email" value="${student.email}"></td>
                <td>Password:</td><td><input type="text" name="password" value="${student.password}"></td>
                <td>Date of Birth:</td><td><input type="text" name="dob" value="${student.dob}"></td>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
