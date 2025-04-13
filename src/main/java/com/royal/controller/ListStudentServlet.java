package com.royal.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.royal.dao.StudentDaoPrep;
import com.royal.bean.StudentBean;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;;

public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html ");

		StudentDaoPrep dao=new StudentDaoPrep();
		ArrayList<StudentBean> list = dao.getAllStudentRecords();
		
		request.setAttribute("list", list);
		System.out.println("In listjsp");
		request.getRequestDispatcher("ListStudent.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
