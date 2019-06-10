package com.ibm.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fetch_login_details {
static	Connection con;
static String name;
	
   static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project_db?useUnicode=true&u"
					+ "seJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root","");
		}
		catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
		}
	    
	}
	
public static boolean validate_User(String un,String ps)
	{
		boolean flag=false;	
		try {

		String sql="select * from employee_login where Emp_id=? and Password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, un);
		pstmt.setString(2, ps);
		ResultSet rs=pstmt.executeQuery();
		
	if(rs.next())
	{
		flag=true;
		name=rs.getString(0);
	}
	

		}
	catch (SQLException e) {
		e.printStackTrace();
	}
		
		return flag;
	}

public static int create_User(String un,String id,String email,String contact, String pass) {
	int rs=0;
	try {
	String sql_employeeSignup="insert into employee_signup values(?,?,?,?,?)";
	PreparedStatement pstmt=con.prepareStatement(sql_employeeSignup);
	String sql_employeeLogin="insert into employee_login values(?,?)";
	PreparedStatement pst=con.prepareStatement(sql_employeeLogin);
	pstmt.setString(1, un);
	pstmt.setString(2, id);
	pstmt.setString(3, email);
	pstmt.setString(4, contact);
	pstmt.setString(5, pass);
	pst.setString(1, id);
	pst.setString(2, pass);
    rs=pstmt.executeUpdate();
    pst.executeUpdate();
	}
   catch (SQLException e) {
	e.printStackTrace();
   }
	if(rs>0)
	   return 1;
	else
       return 0;
	
}
public static String logged_user()
{
	return name;
}

}
