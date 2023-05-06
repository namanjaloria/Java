package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HeadingView
 */
@WebServlet("/HeadingView")
public class HeadingView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeadingView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession ses=request.getSession();
        try{
        String n="<h4><b><i>Admin Id:"+ses.getValue("SAID").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=red>"+ses.getValue("SANAME").toString()+"</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout>Logout</a></b></i></h4><hr color=green>";
        	
        	
        }
        catch(Exception e)
        {
        	response.sendRedirect("AdminLogin");
        }
		out.println("<html>");
		
		out.println("<script src='asset/js/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/js/Heading.js'></script>");
		
		out.println("<a href=HeadingDisplayall>List of headings</a><br>");
		out.print("<form action=HeadingSubmit >");
		out.println("<table>");
		out.println("<caption><h3><i>Heading Register</i></h3></caption>");
		out.println("<tr><td><b><i>Category Id:</b></i></td><td><select name=cid id=cid></select></td></tr>");

		out.println("<tr><td><b><i>Chapter ID:</b></i></td><td>");
		
 		out.println("<select name=chid id=chid>");
	 	out.println("<option>-Select-</option></select>");
	 
	out.println("</td></tr>");
		out.println("<tr><td><b><i>Heading Id:</i></b></td><td><input type=text name=hid size=30></td></tr>");
		out.println("<tr><td><b><i>Heading name:</i></b></td><td><input type=text name=hnm size=30></td></tr>");
		out.println("<tr><td><b><i>Heading description:</i></b></td><td><textarea name=hd rows=3 cols=30></textarea></td></tr>");
		out.println("<tr><td><input type=Submit></td><td><input type=reset></td></tr>");
		out.println("</table></form></html>");
		out.flush();
	}	
}
	


