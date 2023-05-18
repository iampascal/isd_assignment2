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
public class PaymentServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
            Student student  =  (Student) session.getAttribute("student");
            String cardEmail = student.getEmail();
            String cardName   = request.getParameter("cardName");
            String cardNumber = request.getParameter("cardNumber");
            String cardExpiry = request.getParameter("cardExpiry");
            String cardCvv    = request.getParameter("cardCvv");
            
        DBManager manager = (DBManager) session.getAttribute("manager");
        
       try {
           
            
             manager.addPayment(cardEmail, cardName, cardNumber, cardExpiry, cardCvv);
             
             request.getRequestDispatcher("main.jsp").include(request, response);       
             
             
             
              } catch(SQLException ex) {
                  
                System.out.println("payment_home.java SQLException");   

              }
    }
}

