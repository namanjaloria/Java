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

import com.nis.dao.ChapterDAO;
import com.nis.dao.categoryDAO;

/**
 * Servlet implementation class ChapterDisplayall
 */
@WebServlet("/ChapterDisplayall")
public class ChapterDisplayall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChapterDisplayall() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ResultSet rs=ChapterDAO.ChapterDisplayall();
		out.print("<html>");
		//Navigation bar
        HttpSession ses=request.getSession();
        try{
        String n="<h4><b><i>Admin Id:"+ses.getValue("SAID").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=red>"+ses.getValue("SANAME").toString()+"</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout>Logout</a></b></i></h4><hr color=green>";
        	
        	
        }
        catch(Exception e)
        {
        	response.sendRedirect("AdminLogin");
        }
		try{ 
			if(rs.next())
			{
			out.println("<center><table border=1 width=100%>");
			out.println("<caption ><h3>List of Chapters</caption></h3>");
			out.println("<tr><th>Category ID:</th><th>Chapter ID:</th><th>Chapter Name</th><th>Description</th>");
			do
			{
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td><a href=ChapterViewById?Chid="+rs.getString(2)+">Edit/Delete</a></td></tr>");
				
			}while(rs.next());
			out.println("</table></center>");
			}
			else{out.println("<h3><font color=red>record no found</font></h3>");
		}
		out.print("</html>");
	}catch(Exception e)
	{System.out.println(e);
	}
	}
	
}
