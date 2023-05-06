package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class categoryView
 */
@WebServlet("/categoryView")
public class categoryView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categoryView() {
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
	
        out.println("<html>");
	       HttpSession ses=request.getSession();
	       try{
	       String n="<h4><b><i>Admin Id:"+ses.getValue("SAID").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=red>"+ses.getValue("SANAME").toString()+"</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout>Logout</a></b></i></h4><hr color=green>";
	       out.println(n);	
	       	
	       }
	       catch(Exception e)
	       {
	       	response.sendRedirect("AdminLogin");
	       }
	   
		
		out.println("<a href=categoryDisplayall>List of categories</a><br>");
		out.print("<form action=categorySubmit method=post enctype='multipart/form-data'>");
		out.println("<table>");
		out.println("<caption><h3><i>category Register</i></h3></caption>");
		out.println("<tr><td><b><i>category Id:</i></b></td><td><input type=text name=cid size=30></td></tr>");
		out.println("<tr><td><b><i>category name:</i></b></td><td><input type=text name=cna size=30></td></tr>");
		out.println("<tr><td><b><i>category description:</i></b></td><td><textarea name=cd rows=3 cols=30></textarea></td></tr>");
		out.println("<tr><td><b><i>Icon</i></b></td><td><input type=file name=ci size=30></td></tr>");
		out.println("<tr><td><input type=Submit></td><td><input type=reset></td></tr>");
		out.println("</table></form></html>");
		Cookie c[]=request.getCookies();
		   if(c==null || c.length==0)
		   { out.println("This Page Open By User First Time");
		    Cookie cc=new Cookie("PrevLogin",new Date().toString());
		    cc.setMaxAge(10000000);
		    response.addCookie(cc);
		        }
		   else
		      {
				  Cookie cc=null;
				  for(int i=0;i<c.length;i++)
		      {if(c[i].getName().equals("PrevLogin"))
		        {cc=c[i];
		          break;
					}
				   }

			out.println("This Page Open by admin Dated:"+cc.getValue());
			cc.setValue(new Date().toString());
			cc.setMaxAge(10000000);
			response.addCookie(cc);

				  }
		out.flush();
	}	
}

