package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.bean.StudentBean;

import com.royal.dao.StudentDaoPrep;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditStudentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		
		StudentDaoPrep dao = new StudentDaoPrep();
		
		Object object =	dao.getStudentById(id);
		System.out.println("Object received: " + object);
		System.out.println("Going in edit if");
		if (object instanceof StudentBean ) 
		{
			System.out.println("inside edit if");

			StudentBean sbean = (StudentBean)object;
			
			out.print("<h3>Edit Student Registration Page</h3>");
            out.print("<form action='UpdateStudentServlet' method='post'>");
            out.print("<table>");

            out.print("<input type='hidden' name='id' value='" + sbean.getId() + "'>");
            out.print("<tr><td>First Name</td><td><input type='text' name='firstname' value='" + sbean.getFirstName() + "' required></td></tr>");
            out.print("<tr><td>Last Name</td><td><input type='text' name='lastname' value='" + sbean.getLastName() + "' required></td></tr>");
            out.print("<tr><td>Email</td><td><input type='email' name='email' value='" + sbean.getEmail() + "' required></td></tr>");
            out.print("<tr><td>Phone Number</td><td><input type='text' name='phno' value='" + sbean.getPhone() + "' required></td></tr>");
            out.print("<tr><td>Date of Birth</td><td><input type='date' name='dob' value='" + sbean.getDob() + "' required></td></tr>");
            
            out.print("<tr><td>Gender</td><td>");
            out.print("<input type='radio' name='gender' value='Male'" + ("Male".equals(sbean.getGender()) ? " checked" : "") + ">Male");
            out.print("<input type='radio' name='gender' value='Female'" + ("Female".equals(sbean.getGender()) ? " checked" : "") + ">Female");
            out.print("<input type='radio' name='gender' value='Other'" + ("Other".equals(sbean.getGender()) ? " checked" : "") + ">Other");
            out.print("</td></tr>");

            out.print("<tr><td>Address</td><td><textarea name='address' rows='3' cols='30' required>" + sbean.getAddress() + "</textarea></td></tr>");

            out.print("<tr><td>Course</td><td>");
            out.print("<select name='course' required>");
            out.print("<option value='BCA'" + ("BCA".equals(sbean.getCourse()) ? " selected" : "") + ">BCA</option>");
            out.print("<option value='msc_it'" + ("msc_it".equals(sbean.getCourse()) ? " selected" : "") + ">M.Sc IT</option>");
            out.print("<option value='BTech'" + ("BTech".equals(sbean.getCourse()) ? " selected" : "") + ">BTech</option>");
            out.print("<option value='MTech'" + ("MTech".equals(sbean.getCourse()) ? " selected" : "") + ">MTech</option>");
            out.print("<option value='MCA'" + ("MCA".equals(sbean.getCourse()) ? " selected" : "") + ">MCA</option>");
            out.print("</select>");
            out.print("</td></tr>");

            out.print("<tr><td>Batch Time</td><td>");
            out.print("<select name='batchtime' required>");
            out.print("<option value='Morning'" + ("Morning".equals(sbean.getBatchTime()) ? " selected" : "") + ">Morning</option>");
            out.print("<option value='Afternoon'" + ("Afternoon".equals(sbean.getBatchTime()) ? " selected" : "") + ">Afternoon</option>");
            out.print("<option value='Evening'" + ("Evening".equals(sbean.getBatchTime()) ? " selected" : "") + ">Evening</option>");
            out.print("</select>");
            out.print("</td></tr>");

            out.print("<tr><td>Payment Mode</td><td>");
            out.print("<input type='radio' name='paymentmode' value='credit_card'" + ("credit_card".equals(sbean.getPaymentMode()) ? " checked" : "") + ">Credit Card");
            out.print("<input type='radio' name='paymentmode' value='debit_card'" + ("debit_card".equals(sbean.getPaymentMode()) ? " checked" : "") + ">Debit Card");
            out.print("<input type='radio' name='paymentmode' value='net_banking'" + ("net_banking".equals(sbean.getPaymentMode()) ? " checked" : "") + ">Net Banking");
            out.print("</td></tr>");

            out.print("<tr><td>Sports</td><td><input type='checkbox' name='sports'" + (sbean.isSports() ? " checked" : "") + "></td></tr>");
            out.print("<tr><td>Music</td><td><input type='checkbox' name='music'" + (sbean.isMusic() ? " checked" : "") + "></td></tr>");
            out.print("<tr><td>Debate</td><td><input type='checkbox' name='debate'" + (sbean.isDebate() ? " checked" : "") + "></td></tr>");
            out.print("<tr><td>Volunteering</td><td><input type='checkbox' name='volunteering'" + (sbean.isVolunteering() ? " checked" : "") + "></td></tr>");

            out.print("<tr><td></td><td><input type='submit' value='Update'></td></tr>");
            out.print("</table>");
            out.print("</form>");
    		System.out.println("Going outof  edit if");

		} else 
		{
			System.out.println(" inside edit else");

			RequestDispatcher rd = request.getRequestDispatcher("ListStudentServlet");
			rd.forward(request, response);
			System.out.println(" inside edit out");

		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}