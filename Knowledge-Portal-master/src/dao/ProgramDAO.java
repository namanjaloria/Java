package com.nis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.nis.model.Program;
import com.nis.model.category;

public class ProgramDAO {
	static	String provider="jdbc:mysql://localhost:3306/KP";
	static String uid="root";
	static String pwd="";
	public static boolean addNewRecord(Program P)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="insert into program values('"+P.getHeadingid()+"','"+P.getProgramid()+"','"+P.getProgramdescription()+"','"+P.getProgram()+"','"+P.getProgramoutput()+"','"+P.getDownload()+"')";
	System.out.print(query);
		boolean s=DBHelper.executeUpdate(query, cn);
	return(s);
	}catch(Exception e)
	{System.out.println(e);
	return(false);
	}
	}
	public static ResultSet ProgramDisplayall()
	{
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from program";
		ResultSet rs=DBHelper.executeQuery(query,cn);
		return(rs);
		}catch(Exception e)
		{
			System.out.println(e);
			return(null);
		}

	}
	public static Program displayByProgramId(String pid){
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from Program where Programid='"+pid+"'";
		ResultSet rs=DBHelper.executeQuery(query, cn);
		if(rs.next())
		{
			Program P=new Program();
			P.setHeadingid(rs.getString(1));
			P.setProgramid(rs.getString(2));
			P.setProgramdescription(rs.getString(3));
			P.setProgram(rs.getString(4));
			P.setProgramoutput(rs.getString(5));
			P.setDownload(rs.getString(6));
			return(P);
		}
		return(null);
		}catch(Exception e)
		{
			System.out.println(e);
			return(null);
		}
	}
	public static ResultSet displayProgramByHeading(String hid)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="select * from program where headingid='"+hid+"'";
			ResultSet rs=DBHelper.executeQuery(query, cn);
			return (rs);
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	public static boolean deleteById(String pid)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="delete from program where programid='"+pid+"'";
			boolean st=DBHelper.executeUpdate(query, cn);
			return (st);
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
	public static boolean editRecord(Program P)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="update program set description='"+P.getProgramdescription()+"' where programid='"+P.getProgramid()+"'";
			boolean st=DBHelper.executeUpdate(query, cn);
			if(P.getProgram().length()>0)
			{
				query="update program set program='"+P.getProgram()+"' where programid='"+P.getProgramid()+"'";
				st=DBHelper.executeUpdate(query, cn);
			}
			if(P.getProgramoutput().length()>0)
			{
				query="update program set programoutput='"+P.getProgramoutput()+"' where programid='"+P.getProgramid()+"'";
				st=DBHelper.executeUpdate(query, cn);
			}
			if(P.getDownload().length()>0)
			{
				query="update program set download='"+P.getDownload()+"' where programid='"+P.getProgramid()+"'";
				st=DBHelper.executeUpdate(query, cn);
			}
			return (st);
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

}
