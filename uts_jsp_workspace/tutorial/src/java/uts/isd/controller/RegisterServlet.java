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
import uts.isd.model.dao.DBManager;
import java.sql.SQLException;
import uts.isd.model.Student;

/**
 *
 * @author jaehyeokseong
 */
public class RegisterServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        
        String email = "NOT WORKING";
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        DBManager manager = (DBManager)session.getAttribute("manager");
        validator.clear(session);
        
        if(!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if(!validator.validateName(name)) {
            session.setAttribute("nameErr", "Error: Name format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if(!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else {
            try {
                Student exist = manager.findStudent(email, password);
                if(exist != null) {
                    session.setAttribute("existErr", "Student already exists in the Database!");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                } else {
                    manager.addStudent(name, email, password, dob);
                    Student student = new Student(name, email, password, dob);
                    session.setAttribute("student", student);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
            } catch(SQLException ex) {
                System.out.println("RegisterServlet.java 에서 SQLException 발생함");
            }
        }
    }
}
