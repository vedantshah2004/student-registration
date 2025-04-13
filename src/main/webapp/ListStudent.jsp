<%@page import="com.royal.bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List Page</title>
</head>
<body>
<% 
    ArrayList<StudentBean> list = (ArrayList<StudentBean>)request.getAttribute("list");
%>
<h3>Student List Page</h3>
<table border='1'>
    <tr>
        <td>Id</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Email</td>
        <td>Phone No</td>
        <td>Date of Birth</td>
        <td>Gender</td>
        <td>Address</td>
        <td>Course</td>
        <td>Batch Time</td>
        <td>Payment Mode</td>
        <td>Extracurricular Activities</td>
        <td>Actions</td>
    </tr>

<% 
    for (int i = 0; i < list.size(); i++) {
        StudentBean s = list.get(i);
%>    
   <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getFirstName() %></td>
        <td><%= s.getLastName() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getPhone() %></td>
        <td><%= s.getDob() %></td>
        <td><%= s.getGender() %></td>
        <td><%= s.getAddress() %></td>
        <td><%= s.getCourse() %></td>
        <td><%= s.getBatchTime() %></td>
        <td><%= s.getPaymentMode() %></td>

        <td>
            <% 
                StringBuilder extracurricular = new StringBuilder();
                if (s.isSports()) extracurricular.append("Sports ");
                if (s.isMusic()) extracurricular.append("Music ");
                if (s.isDebate()) extracurricular.append("Debate ");
                if (s.isVolunteering()) extracurricular.append("Volunteering");

                if (extracurricular.length() == 0) {
                    extracurricular.append("None");
                }
            %>
            <%= extracurricular.toString() %>
        </td>

        <td>
            <a href="EditStudentServlet?id=<%= s.getId() %>">EDIT</a> | <a href="DeleteStudentServlet?id=<%= s.getId() %>">DELETE</a>        
        </td>
    </tr>
<% 
    }
%>
</table>
</body>
</html>