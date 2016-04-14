package com.temp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	private static final String URL="jdbc:mysql://localhost:3306/db";
	private static final String USER="root";
	private static final String PASSWORD="";
	private static Connection connection=null;
	
	public static Connection Getconnection() {
		try {
			
			//1、加载驱动程序 
			Class.forName("com.mysql.jdbc.Driver");
			//2、获得数据库的连接
			connection=DriverManager.getConnection(URL,USER,PASSWORD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
			
	}
	
	public static void main(String[] args) {
		try {
			//1、加载驱动程序 
			Class.forName("com.mysql.jdbc.Driver");
			//2、获得数据库的连接
			Connection connection=DriverManager.getConnection(URL,USER,PASSWORD);
			Statement statement=connection.createStatement();
			ResultSet rSet=statement.executeQuery("select id,name from mysql");
			
			while(rSet.next()){
				System.out.println("美女"+rSet.getString("id")+","+rSet.getString("name"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
