package com.manageStudent;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.dbconnection.DbConnection;
import com.pojos.Student;

public class StudentDaoImpl implements StudentDao {
	
	Connection con=DbConnection.getConnection();
	public void addStudent(Student student)
	{
		

        try{
        String query="insert into student(name,rollno,email,contact,address) values(?,?,?,?,?)";
        
        PreparedStatement ps=con.prepareStatement(query);
        
        if(student.getName()!=null)
        ps.setString(1, student.getName() );
        
        if(student.getRollno()!=null)
        ps.setString(2, student.getRollno());
        
        
        if(student.getEmail()!=null)
        ps.setString(3, student.getEmail());
        
        if(student.getContact()!=null)
        ps.setString(4, student.getContact());
        
        if(student.getAddress()!=null)
        ps.setString(5, student.getAddress());
       
        ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }	
	}
	
	
	
	
	
	
	
	
	public List<Student> getStudents()
	{
		List<Student> list=new ArrayList<>();   
        try
        {
            String query="select *from student"; 
            
            PreparedStatement ps=con.prepareStatement(query);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
                Student student=new Student();
                
                student.setName(rs.getString("name"));
                
                student.setRollno(rs.getString("rollno"));
                
                student.setEmail(rs.getString("email"));
                
                student.setContact(rs.getString("contact"));
                
                student.setAddress(rs.getString("address"));
                
               list.add(student);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
return list;
	}
}
