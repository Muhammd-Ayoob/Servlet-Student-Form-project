package com.dbconnection;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection getConnection()
    {
         Connection con=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_form", "root", "admin");
           //System.out.println("CONGRATULATIONS DATABAE Succefully Connected");
          
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
   return con;
    
    }
}
