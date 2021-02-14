package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manageStudent.StudentDao;
import com.manageStudent.StudentDaoImpl;
import com.pojos.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StudentServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		
		pw.write("<h1>Student form</h1>");
		
		pw.write("<form method='post'>");
		
		pw.write("Name <input type='text'  name='name'/>");
		
		pw.write("<br>");
		pw.write("<br>");
		
		pw.write("Roll no <input type='text'  name='rollno'/>");
		
		pw.write("<br>");
		pw.write("<br>");
		
		pw.write("Email <input type='text'  name='email'/>");
		
		pw.write("<br>");
		pw.write("<br>");
		
		
		pw.write("Contact <input type='text'  name='contact'/>");
		
		
		
		pw.write("<br>");
		pw.write("<br>");
		
		pw.write("Address <input type='text'  name='address'/>");
		
		pw.write("<br>");
		pw.write("<br>");
		
		
		pw.write("<input type='submit'  value='save'/>");
		
		pw.write("</form>");
		
		Student student=new Student();
		
		String name=request.getParameter("name");
		student.setName(name);
		
		String rollno=request.getParameter("rollno");
		student.setRollno(rollno);
		
		String email=request.getParameter("email");
		student.setEmail(email);
		
		String contact=request.getParameter("contact");
		student.setContact(contact);
		
		String address=request.getParameter("address");
		student.setAddress(address);
		
		StudentDao studentdao=new StudentDaoImpl();
		
		studentdao.addStudent(student);
		
		
		
		List<Student> list=studentdao.getStudents();
		
		
		
		pw.write("<table border='2px'>");
		
		pw.write("<th>Name</th>");
		
		pw.write("<th>Roll no</th>");
		
		pw.write("<th>Email</th>");
		
		pw.write("<th>Contact</th>");
		
		pw.write("<th>Address</th>");
		
		for(Student studentlist:list)
		{
		pw.write("<tr>");
		
		pw.write("<td>"+studentlist.getName()+"</td>");
		
		pw.write("<td>"+studentlist.getRollno()+"</td>");
		
		pw.write("<td>"+studentlist.getEmail()+"</td>");
		
		pw.write("<td>"+studentlist.getContact()+"</td>");
		
		pw.write("<td>"+studentlist.getAddress()+"</td>");
		
		pw.write("</tr>");
		}
		pw.write("</table>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
