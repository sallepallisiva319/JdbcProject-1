package com.Project1;

import java.sql.*;
import java.util.Scanner;

public class DMLOperations {
         Connection cn=null;
         PreparedStatement pst=null;
         ResultSet rs=null;
         Scanner t=new Scanner(System.in);
         DMLOperations(){
        	 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=abcd&useSSL=true");
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
         public void insertingData() {
        	 String qu="insert into jspiders1.doctors values(?,?,?)";
        	 try {
        		 
				pst=cn.prepareStatement(qu);
				int r=0;
				do {
				System.out.println("Enter id,name and salary ");
				int id=t.nextInt();
				String na=t.next();
				double sal=t.nextDouble();
			    pst.setInt(1, id);
			    pst.setString(2, na);
			    pst.setDouble(3, sal);
			     
			 pst.executeUpdate();
				System.out.println("data inserted");
				System.out.println("enter 1 to repeat inserting");
				r=t.nextInt();
				}while(r==1);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 
         }
         public void delete() {
        	 String qu="delete from jspiders.student where id=?";
        	 System.out.println("enter a row number");
        	 int id=t.nextInt();
        	 try {
				pst=cn.prepareStatement(qu);
				pst.setInt(1, id);
				pst.executeUpdate();
				System.out.println("data deleted");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
         }
         public void FetchingDb() {
        	 String qu="select * from jspiders1.doctors";
        	 
        	 try {
        		 pst=cn.prepareStatement(qu);
        		rs= pst.executeQuery();
				while(rs.next()) {
					 int id=rs.getInt(1);
					 String na=rs.getString(2);
					 double sal=rs.getDouble(3);
					 System.out.println(id+" "+na+" "+sal);
				 }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
         
}
