/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;

import uts.isd.model.Student;
import uts.isd.model.Payment;
import uts.isd.model.PaymentList;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author jaehyeokseong
 */
public class DBManager {
    
    private Statement st;
    
    public DBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    public Student findStudent(String email, String password) throws SQLException {
        String fetch = "select * from ISDUSER.STUDENTS where EMAIL = '" + email + "' and PASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()) {
            String studentEmail = rs.getString(2);
            String studentPassword = rs.getString(3);
            if(studentEmail.equals(email) && studentPassword.equals(password)) {
                String studentName = rs.getString(1);
                String studentDOB = rs.getString(4);
                return new Student(studentName, studentEmail, studentPassword, studentDOB);
            }
        }
        
        // not found
        return null;
    }
    
    public void addStudent(String name, String email, String password, String dob) throws SQLException {
        st.executeUpdate("INSERT INTO ISDUSER.STUDENTS VALUES ('" + name + "', '" + email + "', '" + password + "', '" + dob + "')");
    }
    
    public void updateStudent(String name, String email, String password, String dob) throws SQLException {
        st.executeUpdate("UPDATE ISDUSER.STUDENTS SET NAME='" + name + "', PASSWORD='" + password + "', DOB='" + dob + "' WHERE EMAIL='" + email + "'");        
    }
    
    public void deleteStudent(String email) throws SQLException {
        st.executeUpdate("DELETE FROM ISDUSER.STUDENTS where EMAIL='" + email + "'");
    }
    
    public ArrayList<Student> fectStudents() throws SQLException {
        String fetch = "SELECT * FROM ISDUSER.STUDENTS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Student> students = new ArrayList<Student>();
        
        while(rs.next()) {
            String name = rs.getString(1);
            String email = rs.getString(2);
            String password = rs.getString(3);
            String dob = rs.getString(4);
            students.add(new Student(name, email, password, dob));
        }
        
        return students;
    }
    
    public boolean checkStudent(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM ISDUSER.STUDENTS WHERE EMAIL = '" + email + "' and PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()) {
            String studentEmail = rs.getString(2);
            String studentPassword = rs.getString(3);
            if(studentEmail.equals(email) && studentPassword.equals(password)) 
                return true;
        }
        
        return false;
    }
    
    
   
    
    public Payment findPayment(String userEmail) throws SQLException {
        String fetch = "select * from ISDUSER.PAYMENT where EMAIL = '" + userEmail + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()) {
            String cardEmail = rs.getString(5);
            if(cardEmail.equals(userEmail)) {
                String cardName = rs.getString(1);
                String cardNumber = rs.getString(2);
                String cardExpiry = rs.getString(3);
                String cardCvv = rs.getString(4);
                return new Payment(cardName, cardNumber , cardExpiry, cardCvv, cardEmail);
            }
        }
        
        // not found
        return null;
    }
    
    public void addPayment(String cardEmail, String cardName, String cardNumber, String cardExpiry, String cardCvv) throws SQLException {
        st.executeUpdate("INSERT INTO ISDUSER.PAYMENT VALUES ('" + cardName + "', '" + cardNumber + "', '" + cardExpiry + "', '" + cardCvv + "', '" + cardEmail + "')");
    }
    
    public void updatePayment(String cardName, String cardNumber, String cardExpiry, String cardCvv, String cardEmail) throws SQLException {
        st.executeUpdate("UPDATE ISDUSER.PAYMENT SET CARDNAME='" + cardName + "', CARDNUMBER='" + cardNumber + "', CARDEXPIRY='" + cardExpiry + "', CARDCVV='" + cardCvv + "' WHERE EMAIL = '" + cardEmail + "'");
    }
    public void deletePayment(String email) throws SQLException {
        st.executeUpdate("DELETE FROM ISDUSER.PAYMENT where EMAIL='" + email + "'");
    }
    
    public void createPayment(String paymentId, String orderId, String amount, String cardNumber, String cardEmail) throws SQLException {
        st.executeUpdate("INSERT INTO ISDUSER.PAYMENTLIST VALUES ('" + paymentId + "', '" + orderId + "', '" + amount + "', '" + cardNumber + "', '" + cardEmail + "',default)");
    }
    public String createPayId() {
        int randomNumber = (int)((Math.random() * 900000) + 100000);
        return Integer.toString(randomNumber);
    }
    
    public ArrayList<PaymentList> fectPayments() throws SQLException {
        String fetch = "SELECT * FROM ISDUSER.PAYMENTLIST";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<PaymentList> paymentList = new ArrayList<PaymentList>();
        
        while(rs.next()) {
            String paymentId = rs.getString(1);
            String orderId = rs.getString(2);
            String amount = rs.getString(3);
            String cardNumber = rs.getString(4);
            String cardEmail = rs.getString(5);
            String timestamp = rs.getString(6);
            paymentList.add(new PaymentList(paymentId, orderId, amount, cardNumber, cardEmail, timestamp));
        }
        
        return paymentList;
    }
    
    
    public ArrayList<PaymentList> findPaymentList(String paymentId) throws SQLException {
        String fetch = "select * from PAYMENTLIST where PAYMENTID = '" + paymentId + "'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<PaymentList> paymentList = new ArrayList<PaymentList>();
        
        while(rs.next()) {
            String paymentIds = rs.getString(1);
            if(paymentIds.equals(paymentId)) {
                String orderId = rs.getString(2);
                String amount = rs.getString(3);
                String cardNumber = rs.getString(4);
                String cardEmail = rs.getString(5);
                String timestamp = rs.getString(6);
                paymentList.add(new PaymentList(paymentIds, orderId , amount, cardNumber, cardEmail, timestamp));
            }
            return paymentList;
        }
        return null;
    }
}

    