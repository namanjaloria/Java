package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.dao.categoryDAO;

/**
 * Servlet implementation class ChapterView
 */
@WebServlet("/ChapterView")
public class ChapterView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChapterView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		//Navigation bar
	       HttpSession ses=request.getSession();
	       try{
	       String n="<h4><b><i>Admin Id:"+ses.getValue("SAID").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=red>"+ses.getValue("SANAME").toString()+"</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout>Logout</a></b></i></h4><hr color=green>";
	       out.print(n);	
	       	
	       }
	       catch(Exception e)
	       {
	       	response.sendRedirect("AdminLogin");
	       }
		out.println("<html>");
		out.println("<a href=ChapterDisplayall>List Of Chapters</a><br>");
		out.println("<form action=ChapterSubmit>");
		out.println("<table>");
		out.println("<caption><h3><i>Chapter Register</i></h3></caption>");
		out.println("<tr><td><b><i>Category ID:</b></i></td><td>");
		try{
	          ResultSet rs=categoryDAO.categoryDisplayall();
	          out.println("<select name=Catid>");
	          out.println("<option>Category</option>");
	          while(rs.next())
	          {
	        	  out.print("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>");	
	          }
	        	 
	          out.println("</select>"); 	 
	         }catch(Exception e){}

			
			out.println("</td></tr>");
		out.println("<tr><td><b><i>Chapter Id:</i></b></td><td><input type=text name=Chid size=30></td></tr>");
		out.println("<tr><td><b><i>Chapter name:</i></b></td><td><input type=text name=chna size=30></td></tr>");
		out.println("<tr><td><b><i>description:</i></b></td><td><textarea name=Chd rows=3 cols=30></textarea></td></tr>");
		out.println("<tr><td><input type=submit></td><td><input type=reset></td></tr>");
		out.println("</table></form></html>");
		out.flush();
		
		
	}

}
