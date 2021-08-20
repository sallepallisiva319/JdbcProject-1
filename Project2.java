package com.Project1;

import java.sql.*;
import java.util.Scanner;

public class Project2 {
      public static void main(String[]args) {
    	  Project2 p=new Project2();
    	  p.insertingData();
    	  p.DeletingData();
    	 
    	  //p.UpdateData();
    	  //p.Fetching();
      }
      public void insertingData() {
    	 Connection cn=null;
    	 PreparedStatement pst=null;
    	Scanner t=new Scanner(System.in);
    	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=abcd&useSSL=true");
			pst=cn.prepareStatement("insert into hospital.student values(?,?,?)");
			int r=0;
			do {
				System.out.println("enter id,name and marks");
				pst.setInt(1,t.nextInt());
				pst.setString(2,t.next());
				pst.setDouble(3, t.nextDouble());
				pst.addBatch();
				System.out.println("Data inserted");
				System.out.println("enter 1 to repeat inserting");
				r=t.nextInt();
			}while(r==1);
			pst.executeBatch();
			System.out.println("Check Database");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   
      }
      public void Fetching() {
    	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=abcd&useSSL=true");
			PreparedStatement pst=cn.prepareStatement("select * from hospital.student");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String na=rs.getString(2);
				double ma=rs.getDouble(3);
				System.out.println(id+"  "+na+"  "+ma);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      public void DeletingData() {
    	  Scanner t=new Scanner(System.in);
    	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=abcd&useSSL=true");
			PreparedStatement pst=cn.prepareStatement("delete from hospital.student where id=?");
			System.out.println("Enter id");
			pst.setInt(1,t.nextInt());
			pst.executeUpdate();
			System.out.println("data deleted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      public void UpdateData() {
    	  Scanner t=new Scanner(System.in);
    	  
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=abcd&useSSL=true");
				PreparedStatement pst=cn.prepareStatement("update hospital.student set name=? where id=?");
				System.out.println("set a name");
			    pst.setString(1, t.next());
			    System.out.println("Enter id");
			    pst.setInt(2, t.nextInt());
			    pst.executeUpdate();
			    System.out.println("data updated");
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      }
}
