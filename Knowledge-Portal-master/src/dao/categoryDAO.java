package com.nis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.nis.model.category;

public class categoryDAO {
static	String provider="jdbc:mysql://localhost:3306/KP";
static String uid="root";
static String pwd="";
public static boolean addNewRecord(category C)
{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="insert into category values('"+C.getCategoryid()+"','"+C.getCategoryname()+"','"+C.getCategorydescription()+"','"+C.getIcon()+"')";
boolean s=DBHelper.executeUpdate(query, cn);
return(s);
}catch(Exception e)
{System.out.println(e);
return(false);
}
}
public static ResultSet categoryDisplayall()
{
	try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="select * from category";
	ResultSet rs=DBHelper.executeQuery(query,cn);
	return(rs);
	}catch(Exception e)
	{
		System.out.println(e);
		return(null);
	}

}
public static category displayById(String cid){
	try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="select * from category where categoryId='"+cid+"'";
	ResultSet rs=DBHelper.executeQuery(query, cn);
	if(rs.next())
	{
		category C=new category();
		C.setCategoryid(rs.getString(1));
		C.setCategoryname(rs.getString(2));
		C.setCategorydescription(rs.getString(3));
		C.setIcon(rs.getString(4));
		return(C);
	}
	return(null);
	}catch(Exception e)
	{
		System.out.println(e);
		return(null);
	}
}
public static boolean deleteById(String cid)
{
	try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="delete from category where categoryid='"+cid+"'";
	boolean st=DBHelper.executeUpdate(query, cn);
	return(st);
}catch(Exception e)
{System.out.println(e);
return(false);
}
}
public static boolean editRecord(category C){
	try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="update category set categoryname='"+C.getCategoryname()+"',categorydescription='"+C.getCategorydescription()+"' where categoryid='"+C.getCategoryid()+"'";
System.out.println(query);
boolean st=DBHelper.executeUpdate(query,cn);
if(C.getIcon().length()>0)
{query="update category set icon='"+C.getIcon()+"' where categoryid='"+C.getCategoryid()+"'";
st=DBHelper.executeUpdate(query,cn);
}return(st);
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }
		
	}

	}
	

