package com.nis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.nis.model.Admin;

public class AdminDAO {
	static	String provider="jdbc:mysql://localhost:3306/KP";
	static String uid="root";
	static String Pwd="";
	public static Admin checkPassword(String aid,String pwd)
	{try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,Pwd);
		  String query="select * from admin where adminid='"+aid+"' and password='"+pwd+"'";
		  System.out.println(query);
		  ResultSet rs=DBHelper.executeQuery(query, cn);
		  if(rs.next())
		  {Admin A=new Admin();
		   A.setAdminid(rs.getString(1));
		   A.setAdminname(rs.getString(2));
		   A.setPassword(rs.getString(3));
		   return(A);
		     
		  }
		  else{
		  return(null);}
		  
		}catch(Exception e){
			System.out.println(e);
			return null;
		 }
		}
}
