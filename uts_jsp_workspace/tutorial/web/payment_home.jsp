<%-- 
    Document   : payment_home
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
        
  <style>
    .payment-container {
      max-width: 400px;
      margin: 0 auto;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    .payment-container input[type="text"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      box-sizing: border-box;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    .payment-container input[type="submit"] {
      background-color: #4CAF50;
      color: white;
      padding: 10px 20px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    .payment-container input[type="submit"]:hover {
      background-color: #45a049;
    }
  </style>
</head>    

    <body onload="startTime(); resetSearch();">
        
        <%
            Student student = (Student)session.getAttribute("student");
        %>
        
 <body>
  <div class="payment-container">
    <h1>Payment Page</h1>
    
    <form action="PaymentServlet?cardEmail='<%=student.getEmail()%>'&password='<%=student.getPassword()%>'"" method="post">
            
        
    
    <input type="submit" value="Use Existing Payment Information">
    
    
    
    <form action="PaymentServlet?cardEmail='<%=student.getEmail()%>'&password='<%=student.getPassword()%>'"" method="post">
      
      
     
          
          
     
      <div id="paymentFields">
        <p>Card Name</p>
        <input type="text" name="cardName">
        <p>Card Number</p>
        <input type="text" name="cardNumber">
        <p>Card Expiry (MM/YY)</p>
        <input type="text" name="cardExpiry" placeholder="e.g., 05/23">
        <p>Card CVV</p>
        <input type="text" name="cardCvv">
      </div>
      <h3>Total Amount: $50</h3>
      <input type="submit" value="Add New Payment Information">
    </form>
    </div>
    </body>    
    </body>
</html>


