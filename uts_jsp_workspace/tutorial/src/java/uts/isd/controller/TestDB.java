/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import uts.isd.model.Student;
import uts.isd.model.dao.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author jaehyeokseong
 */
public class TestDB {
    
    private Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection connection;
    private DBManager db;
    
    public static void main(String[] args) {
        (new TestDB()).runQueries();
    }
    
    public TestDB() {
        try {
            connector = new DBConnector();
            connection = connector.openConnection();
            db = new DBManager(connection);
        } catch(ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private char readChoice() {
        System.out.println("CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }
    
    private void runQueries() {
        char c;
        
        while((c = readChoice()) != '*') {
            switch (c) {
                case 'C':
                    testAdd();
                    break;
                case 'R':
                    testRead();
                    break;
                case 'U':
                    testUpdate();
                    break;
                case 'D':
                    testDelete();
                    break;
                case 'S':
                    showAll();
                    break;
                default:
                    System.out.println("Unkown Command");
                    break;
            }
        }
        
        // close connection
        try {
            connector.closeConnection();
        } catch(SQLException ex) {
            System.out.println("session is not closed");
        }
    }
    
    private void testAdd() {
        System.out.println("Student name: ");
        String name = in.nextLine();
        
        System.out.println("Student email: ");
        String email = in.nextLine();
        
        System.out.println("Student password: ");
        String password = in.nextLine();
        
        System.out.println("Student date of birth: ");
        String dob = in.nextLine();
        
        try {
            db.addStudent(name, email, password, dob);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("student is added to the database");
    }
    
    private void testRead() {
        System.out.println("Student email: ");
        String email = in.nextLine();
        
        System.out.println("Student password: ");
        String password = in.nextLine();
        
        Student student = null;
        try {
            student = db.findStudent(email, password);
        } catch(SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(student != null) {
            System.out.println("Student " + student.getName() + " exist in the database.");
        } else {
            System.out.println("Student does not exist.");
        }
    }
    
    private void testUpdate() {
        System.out.println("Student email: ");
        String email = in.nextLine();
        
        System.out.println("Student password: ");
        String password = in.nextLine();
        
        try {
            if(db.checkStudent(email, password)) {
                
                System.out.println("[NEW] Student name: ");
                String name = in.nextLine();
                System.out.println("[NEW] Student dob: ");
                String dob = in.nextLine();
                db.updateStudent(name, email, password, dob);
            } else {
                System.out.println("Student does not exist.");
            }
        } catch(SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testDelete() {
        System.out.println("Student email: ");
        String email = in.nextLine();
        
        try {
            db.deleteStudent(email);
        } catch(SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showAll() {
        ArrayList<Student> students = new ArrayList<Student>();
        
        try {
            students = db.fectStudents();
        } catch(SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Student student : students) {
            System.out.println("================================");
            System.out.println("name: " + student.getName());
            System.out.println("email: " + student.getEmail());
            System.out.println("password: " + student.getPassword());
            System.out.println("dob: " + student.getDOB());
        }
        if(!students.isEmpty()) 
            System.out.println("================================");
    }
}
