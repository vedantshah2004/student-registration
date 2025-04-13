
package com.royal.controller;
import java.io.IOException;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDaoPrep;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	  String firstName = request.getParameter("firstname");
          String lastName = request.getParameter("lastname");
          String email = request.getParameter("email");
          String phno = request.getParameter("phno");
          String date = request.getParameter("date");
          String gender = request.getParameter("gender");
          String address = request.getParameter("address");
          String course = request.getParameter("course");
          String batchTime = request.getParameter("batchtime");
          String paymentMode = request.getParameter("paymentmode");
          
          boolean sports = Boolean.parseBoolean(request.getParameter("sports"));
          boolean music = Boolean.parseBoolean(request.getParameter("music"));
          boolean debate = Boolean.parseBoolean(request.getParameter("debate"));
          boolean volunteering = Boolean.parseBoolean(request.getParameter("volunteering"));
        
          
          StudentBean studentBean = new StudentBean(0, firstName, lastName, email, phno, date, gender, address, course, batchTime, paymentMode, sports, music, debate, volunteering);

        StudentDaoPrep dao = new StudentDaoPrep();

        int rowAffected = dao.insertStudent(studentBean);
        System.out.println("rowAffected: " + rowAffected);
        RequestDispatcher rd = null;

        if (rowAffected > 0) {
        	System.out.println("Going into ListStudentServlet");
            rd = request.getRequestDispatcher("ListStudentServlet");
        	System.out.println("Going out ListStudentServlet");

        } else {
        	System.out.println("Going into registration");
            rd = request.getRequestDispatcher("registration.jsp");
           
            System.out.println("Going out registration");
        	
        }
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}



