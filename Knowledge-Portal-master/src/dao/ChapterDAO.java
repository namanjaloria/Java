package com.nis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.nis.model.Chapter;
import com.nis.model.category;


public class ChapterDAO {
	static	String provider="jdbc:mysql://localhost:3306/KP";
	static String uid="root";
	static String pwd="";
	public static boolean AddNewrecord(Chapter C)
	{try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="insert  into Chapter values('"+C.getCategoryID()+"','"+C.getChapterID()+"','"+C.getChaptername()+"','"+C.getDescription()+"')";
	boolean r=DBHelper.executeUpdate(query, cn);
	return(r);
	}catch(Exception e)
	{System.out.println(e);
	return(false);
	}

}
	public static ResultSet displayChapterByCategoryId(String cid)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="select * from Chapter where CategoryID='"+cid+"'";
			ResultSet rs=DBHelper.executeQuery(query, cn);
			return (rs);
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	public static ResultSet ChapterDisplayall()
	{
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from Chapter";
		ResultSet rs=DBHelper.executeQuery(query,cn);
		return(rs);
		}catch(Exception e)
		{
			System.out.println(e);
			return(null);
		}

	}
	public static boolean deleteById(String Chid)
	{
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="delete from Chapter where ChapterID='"+Chid+"'";
		System.out.println(query);
		boolean st=DBHelper.executeUpdate(query, cn);
		return(st);
	}catch(Exception e)
	{System.out.println(e);
	return(false);
	}
	}
	public static boolean editRecord(Chapter CH){
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="update Chapter set Chaptername='"+CH.getChaptername()+"',Description='"+CH.getDescription()+"' where ChapterID='"+CH.getChapterID()+"'";
	System.out.println(query);
	boolean st=DBHelper.executeUpdate(query,cn);
	
	return(st);
		}catch(Exception e){
			System.out.println(e);
			return false;
		 }
			
		}
	public static Chapter displayById(String Chid){
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from Chapter where ChapterID='"+Chid+"'";
		ResultSet rs=DBHelper.executeQuery(query, cn);
		if(rs.next())
		{
			Chapter CH=new Chapter();
			CH.setCategoryID(rs.getString(1));
			CH.setChapterID(rs.getString(2));
			CH.setChaptername(rs.getString(3));
			CH.setDescription(rs.getString(4));
			
			return(CH);
		}
		return(null);
		}catch(Exception e)
		{
			System.out.println(e);
			return(null);
		}
	}
	public static ResultSet displayChapterByCategoryName(String pat)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="select * from chapter where categoryid in (select categoryid from category where categoryname like '%"+pat+"%')";
		    System.out.println(query);
			ResultSet rs=DBHelper.executeQuery(query, cn);
			return (rs);
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
}
