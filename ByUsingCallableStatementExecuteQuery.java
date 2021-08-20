package com.Project1;

import java.sql.*;

public class ByUsingCallableStatementExecuteQuery {

	public static void main(String[] args) {
	    Connection cn=null;
	    CallableStatement cst=null;
	    ResultSet rs=null;
	    
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=abcd&useSSL=true");
			cst=cn.prepareCall("call jspiders.ExecuteQuery()");
			rs=cst.executeQuery();
			while(rs.next()) {
				
				System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getDouble("marks"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    

	}

}
