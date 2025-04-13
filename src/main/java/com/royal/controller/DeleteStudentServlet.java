package com.royal.controller;
import com.royal.dao.StudentDaoPrep;
import com.royal.util.DBConnection;
import com.royal.bean.StudentBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteStudentServlet extends  HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("id"));
		
		StudentDaoPrep dao =new StudentDaoPrep();
		int rowAffected=dao.deleteStudent(id);
		
		RequestDispatcher rd=null;
		System.out.println(rowAffected+" in delete student");
		if(rowAffected>0)
		{
			System.out.println(rowAffected+" in delete student if..........");

			rd=request.getRequestDispatcher("ListStudentServlet");
		}
		else
		{
			System.out.println(rowAffected+" in delete student else");
			rd=request.getRequestDispatcher("registration.jsp");

		}
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
