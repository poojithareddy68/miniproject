package com.infor.controller;


	import java.sql.Connection;
	import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

	public class insertBook {
	   public static void main(String args[]) throws SQLException {
	      Connection c = null;
	      Statement stmt = null;
	     
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/book", "postgres", "Apps4321");
	         
	         /*dataSource.setUrl("jdbc:postgresql://localhost:5432/book");
			dataSource.setUsername("postgres");
			dataSource.setPassword("Apps4321");*/
	         
	         
	         
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         
	        
        

	         stmt.close();
	         c.commit();
	         c.close();
	      } catch (Exception e) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      
	      System.out.println("Records created successfully");
	   }
	}


