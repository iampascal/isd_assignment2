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
import java.sql.SQLException;
import uts.isd.model.Payment;
import uts.isd.model.Student;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author pascal
 */
public class FindPayment extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String paymentId   = request.getParameter("paymentIdFilter");
        session.setAttribute("paymentId", paymentId);
        request.getRequestDispatcher("payment_find.jsp").include(request, response);
    }
}
