package com.Project1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ByUsingCallableStatementInsertingQuery {

	public static void main(String[] args) {
		Scanner t=new Scanner(System.in);
		 Connection cn=null;
		    CallableStatement cst=null;
		    
	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=abcd&useSSL=true");
			cst=cn.prepareCall("call jspiders.inserting(?,?,?,?,?)");
			System.out.println("enter name,id,marks,mob and address");
			cst.setString(1, t.nextLine());
			cst.setInt(2, t.nextInt());
			cst.setDouble(3, t.nextDouble());
			cst.setLong(4, t.nextLong());
			cst.setString(5, t.next());
			cst.executeUpdate();
			System.out.println("data in serted");
			
		} catch (ClassNotFoundException | SQLException e) {
				
			e.printStackTrace();
		}

				
	}

}
