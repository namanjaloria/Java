package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProgramView
 */
@WebServlet("/ProgramView")
public class ProgramView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<script src='asset/js/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/js/Program.js'></script>");
		
		
		out.println("<a href=ProgramDisplayAll>List Of Programs</a><br>");
		out.println("<form action=ProgramSubmit method=post enctype='multipart/form-data'>");
		out.println("<table>");
		out.println("<caption><h3><i>Program Register</i></h3></caption>");
		out.println("<tr><td><b><i> Category :</b></i></td><td><select name=cid id=cid></select></td></tr>");
		out.println("<tr><td><b><i>Chapter :</b></i></td><td><select name=chid id=chid></select></td></tr>");
        out.println("<tr><td><b><i>Heading ID:</b></i></td></tr>");
 		out.println("<select name=hid id=hid></select>");
	 	out.println("<option>-Select-</option></select>");
	 
		out.println("<tr><td><b><i>Program ID:</b></i></td><td><input type='text' name=pid size=30></td></tr>");
		out.println("<tr><td><b><i>Program Description:</b></i></td><td><textarea name=pd rows=3 cols=40></textarea></td></tr>");
		out.println("<tr><td><b><i>Program:</b></i></td><td><input type='file' name=p size=30></td></tr>");
		out.println("<tr><td><b><i>Program Output:</b></i></td><td><input type='file' name=po size=30></td></tr>");
		out.println("<tr><td><b><i>Download:</b></i></td><td><input type='file' name=d size=30></td></tr>");
		out.println("<tr><td><input type='submit'></td><td><input type=reset></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</html>");
	}


	}


