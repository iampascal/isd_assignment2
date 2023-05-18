<%-- 
    Document   : payment_list
    Created on : 18 May 2023, 9:39:45 pm
    Author     : pascal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.dao.DBManager"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
  <title>Payment List</title>
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

    .payment-container table {
      width: 100%;
      border-collapse: collapse;
    }

    .payment-container table th, .payment-container table td {
      padding: 8px;
      border: 1px solid #ccc;
    }

    .payment-container table th {
      background-color: #f2f2f2;
      text-align: left;
    }

    .payment-container table tr:hover {
      background-color: #f5f5f5;
    }
  </style>
</head>
<body>
  <div class="payment-container">
      
      
      
    <%
        String paymentId = (String)session.getAttribute("paymentId");
        ArrayList<PaymentList> paymentLists = new ArrayList<PaymentList>();
        if(paymentId != null) {
            DBManager manager = (DBManager)session.getAttribute("manager");
            paymentLists = manager.findPaymentList(paymentId);
        }
    %>
    <h1>Payment List</h1>
    <input type="text" id="paymentIdFilter" placeholder="Search by Payment ID">
    
    <table>
        <th>Payment ID</th>
        <th>Order ID</th>
        <th>Amount</th>
        <th>Credit Card</th>
        <th>Card Email</th>
        <th>Card Number</th>
      
      <!-- Add more payment rows here -->
      <%for(PaymentList p : paymentLists) { %>
        <tr>
            <td><%=p.getPaymentId()%></td>
            <td><%=p.getOrderId()%></td>
            <td><%=p.getAmount()%></td>
            <td><%=p.getCardNumber()%></td>
            <td><%=p.getCardEmail()%></td>
            <td><%=p.getCardNumber()%></td>
        </tr>
      <%} %>
    </table>
  </div>
</body>
</html>