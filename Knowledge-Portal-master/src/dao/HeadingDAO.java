package com.nis.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.nis.model.Chapter;
import com.nis.model.Heading;
import com.nis.model.category;

public class HeadingDAO {
static	String provider="jdbc:mysql://localhost:3306/KP";
static String uid="root";
static String pwd="";
public static boolean addNewRecord(Heading H)
{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="insert into heading values('"+H.getChapterid()+"','"+H.getHeadingid()+"','"+H.getHeadingname()+"','"+H.getHeadingdescription()+"')";
boolean s=DBHelper.executeUpdate(query, cn);
return(s);
}catch(Exception e)
{System.out.println(e);
return(false);
}
}
public static ResultSet displayAll()
{
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from heading";
		ResultSet rs=DBHelper.executeQuery(query, cn);
		return (rs);
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	}
}
public static ResultSet displayHeadingByChapterId(String chid)
{
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from heading where Chapterid='"+chid+"'";
		ResultSet rs=DBHelper.executeQuery(query, cn);
		return (rs);
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	}
}
public static Heading displayById(String hid){
	try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="select * from Heading where headingid='"+hid+"'";
	ResultSet rs=DBHelper.executeQuery(query, cn);
	if(rs.next())
	{
		Heading H=new Heading();
		H.setChapterid(rs.getString(1));
		H.setHeadingid(rs.getString(2));
		H.setHeadingname(rs.getString(3));
	    H.setHeadingdescription(rs.getString(4));
		
		return(H);
	}
	return(null);
	}catch(Exception e)
	{
		System.out.println(e);
		return(null);
	}
}
public static boolean deleteById(String hid)
{
	try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="delete from heading where headingid='"+hid+"'";
	boolean st=DBHelper.executeUpdate(query, cn);
	return(st);
}catch(Exception e)
{System.out.println(e);
return(false);
}
}
public static boolean editRecord(Heading H){
	try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="update heading set headingname='"+H.getHeadingname()+"',headingdescription='"+H.getHeadingdescription()+"' where headingid='"+H.getHeadingid()+"'";
	
System.out.println(query);
boolean st=DBHelper.executeUpdate(query,cn);

return(st);
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }
		
	}

}
