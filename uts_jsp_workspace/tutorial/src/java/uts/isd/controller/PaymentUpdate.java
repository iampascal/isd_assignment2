/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import uts.isd.model.*;
import uts.isd.model.dao.DBManager;
import java.sql.SQLException;

/**
 *
 * @author Pascal
 */
public class PaymentUpdate extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Student student  =  (Student) session.getAttribute("student");   
        
        String cardName = request.getParameter("cardName");
        String cardNumber = request.getParameter("cardNumber");
        String cardExpiry = request.getParameter("cardExpiry");
        String cardCvv = request.getParameter("cardCvv");
        String userEmail = student.getEmail();
        
        String amount = "100";
        String orderId = "1";
        
       
//        Payment payment = new Payment(cardName, cardNumber, cardExpiry, cardCvv, userEmail);
        Payment payment;
        DBManager manager = (DBManager)session.getAttribute("manager");
        
       
        
        
        try {
            payment = manager.findPayment(userEmail);
            if(payment != null) {
//                session.setAttribute("student", student);
                manager.updatePayment(cardName, cardNumber, cardExpiry, cardCvv, userEmail);
                request.getRequestDispatcher("main.jsp").include(request, response);
            } else {
                session.setAttribute("existErr", "User does not exist in the Database");
                request.getRequestDispatcher("payment_update.jsp").include(request, response);
            }
        } catch(SQLException ex) {
            System.out.println("payment_update.jsp SQLException");
        }        
        
        try {
            String paymentId = manager.createPayId();
            manager.createPayment(paymentId, orderId, amount, cardNumber, userEmail);
            request.getRequestDispatcher("main.jsp").include(request, response); 

            
        } catch(SQLException ex) {
            System.out.println("payment_update.jsp SQLException");

         
        }
        
        
    }
}

        
       
       