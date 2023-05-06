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
 * Servlet implementation class categoryDisplayall
 */
@WebServlet("/categoryDisplayall")
public class categoryDisplayall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categoryDisplayall() {
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
		 
		ResultSet rs=categoryDAO.categoryDisplayall();
		
		try{
		
			if(rs.next())
			{
			out.println("<center><table border=1 width=100%>");
			out.println("<caption ><h3>List of Subject Category</caption></h3>");
			out.println("<tr><th>Category ID:</th><th>Category name:</th><th>Category<br>Description</th><th>category Icon</th>");
			do
			{
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td><img src=Pic/"+rs.getString(4)+" width=30 height=30></td><td><a href=categoryViewById?cid="+rs.getString(1)+">Edit/Delete</a></td></tr>");
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
