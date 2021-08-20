package com.Project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class InsertingDataByBatchFile {

	public static void main(String[] args) {
		Connection cn=null;
		PreparedStatement pst=null;
		Scanner t=new Scanner(System.in);
          try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=abcd&useSSL=true");
			String qu="insert into tables.employee values(?,?,?)";
			pst=cn.prepareStatement(qu);
			int r=0;
			do {
				System.out.println("Enter id,name and Salary");
				pst.setInt(1,t.nextInt());
				pst.setString(2, t.next());
				pst.setDouble(3, t.nextDouble());
				
				pst.addBatch();
				System.out.println("Data inserted");
				System.out.println("Enter 1 to repeat inserting");
				r=t.nextInt();
			}while(r==1);
			System.out.println(Arrays.toString(pst.executeBatch()));
			System.out.println("Check data base");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
	}

}
