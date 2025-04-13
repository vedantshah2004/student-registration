package com.royal.controller;

import java.io.IOException;
import com.royal.bean.StudentBean;
import com.royal.dao.StudentDaoPrep;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateStudentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 System.out.println("request.getParameter(\"id\") : " + request.getParameter("id"));
	        System.out.println("request.getParameter(\"firstname\") : " + request.getParameter("firstname"));
	        System.out.println("request.getParameter(\"lastname\") : " + request.getParameter("lastname"));
	        System.out.println("request.getParameter(\"email\") : " + request.getParameter("email"));
	        System.out.println("request.getParameter(\"phno\") : " + request.getParameter("phno"));
	        System.out.println("request.getParameter(\"dob\") : " + request.getParameter("dob"));
	        System.out.println("request.getParameter(\"gender\") : " + request.getParameter("gender"));
	        System.out.println("request.getParameter(\"address\") : " + request.getParameter("address"));
	        System.out.println("request.getParameter(\"course\") : " + request.getParameter("course"));
	        System.out.println("request.getParameter(\"batchtime\") : " + request.getParameter("batchtime"));
	        System.out.println("request.getParameter(\"paymentmode\") : " + request.getParameter("paymentmode"));
	        System.out.println("request.getParameter(\"sports\") : " + request.getParameter("sports"));
	        System.out.println("request.getParameter(\"music\") : " + request.getParameter("music"));
	        System.out.println("request.getParameter(\"debate\") : " + request.getParameter("debate"));
	        System.out.println("request.getParameter(\"volunteering\") : " + request.getParameter("volunteering"));
	        
	        int id = Integer.parseInt(request.getParameter("id"));
	        String firstname = request.getParameter("firstname");
	        String lastname = request.getParameter("lastname");
	        String email = request.getParameter("email");
	        String phno = request.getParameter("phno");
	        String dob = request.getParameter("dob");
	        String gender = request.getParameter("gender");
	        String address = request.getParameter("address");
	        String course = request.getParameter("course");
	        String batchTime = request.getParameter("batchtime");
	        String paymentMode = request.getParameter("paymentmode");
	        boolean sports = request.getParameter("sports") != null;
	        boolean music = request.getParameter("music") != null;
	        boolean debate = request.getParameter("debate") != null;
	        boolean volunteering = request.getParameter("volunteering") != null;
	       
	        
	        StudentBean sbean = new StudentBean(id, firstname, lastname, email, phno, dob, gender, address, course, batchTime, paymentMode, sports, music, debate, volunteering);
	        
		System.out.println("sbean : " + sbean);
		
		StudentDaoPrep dao = new StudentDaoPrep();
		
		int rowsAffected = dao.updateStudent(sbean, id);
		
		RequestDispatcher rd = null;
		System.out.println("Update befor if :" +rowsAffected);
		if (rowsAffected > 0 ) 
		{
			System.out.println("Update inside if :" +rowsAffected);

			rd = request.getRequestDispatcher("ListStudentServlet");
			System.out.println("Update outside if :" +rowsAffected);

		} else 
		{
			System.out.println("Update inside else :" +rowsAffected);

			rd = request.getRequestDispatcher("registration.jsp");
			System.out.println("Update outside else :" +rowsAffected);

		}		
		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
