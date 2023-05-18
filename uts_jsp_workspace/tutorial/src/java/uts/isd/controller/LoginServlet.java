 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.isd.model.dao.DBManager;
import uts.isd.model.*;

/**
 *
 * @author jaehyeokseong
 */
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBManager manager = (DBManager)session.getAttribute("manager");
        Student student = null;
        validator.clear(session);
        
       
//        if(!validator.validateEmail(email)) {
//            session.setAttribute("emailErr", "Error: Email fromat incorrect");
//            request.getRequestDispatcher("login.jsp").include(request, response);
//        } else if(!validator.validatePassword(password)) {
//            session.setAttribute("passErr", "Error: password format incorrect");
//            request.getRequestDispatcher("login.jsp").include(request, response);
//        } else {
//            try {
//                student = manager.findStudent(email, password);
//                if(student != null) {
//                    session.setAttribute("student", student);
//                    request.getRequestDispatcher("main.jsp").include(request, response);
//                } else {
//                    session.setAttribute("existErr", "Student does not exist in the Database!");
//                    request.getRequestDispatcher("login.jsp").include(request, response);
//                }
//            } catch(SQLException | NullPointerException ex) {
//                
//            }
//        }

            try {
                student = manager.findStudent(email, password);
                if(student != null) {
                    session.setAttribute("student", student);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                } else {
                    session.setAttribute("existErr", "Student does not exist in the Database!");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }
            } catch(SQLException | NullPointerException ex) {
                
            }


    }
}
