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
 * @author jaehyeokseong
 */
public class EditServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        Student student = null;
        
        try {
            student = manager.findStudent(email, password);
            if(student != null) {
                session.setAttribute("student", student);
                request.getRequestDispatcher("edit.jsp").include(request, response);
            } else {
                session.setAttribute("existErr", "Student does not exist in the Database");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }
        } catch(SQLException ex) {
            System.out.println("EditServlet.java에서 SQLException 발생함");
        }
        
        request.getRequestDispatcher("edit.jsp").include(request, response);
    }
}
