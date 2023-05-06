package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.dao.ChapterDAO;
import com.nis.dao.HeadingDAO;
import com.nis.model.Chapter;
import com.nis.model.Heading;

/**
 * Servlet implementation class HeadingViewById
 */
@WebServlet("/HeadingViewById")
public class HeadingViewById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeadingViewById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String hid=request.getParameter("hid");
		Heading H=HeadingDAO.displayById(hid);
		if(H!=null)
		{
			out.println("<html>");
			out.println("<form action=HeadingEditDelete method=post >");
			out.println("<center><table>");
			out.println("<caption><h3>Heading Details</h3></caption>");
			out.println("<tr><td><b><i>Heading ID:</i></b></td><td><input type=text name=hid size=30 value='"+H.getHeadingid()+"' readonly=true></td></tr>");
		       out.println("<tr><td><b><i>heading Name:</i></b></td><td><input type=text name=hnm size=30 value='"+H.getHeadingname()+"'></td></tr>");
		       out.println("<tr><td><b><i>Heading Description:</i></b></td><td><textarea name=hd rows=3 cols=40>"+H.getHeadingdescription()+"</textarea></td></tr>");
		       
		       out.println("<tr><td><input name=btn type=submit value=Edit></td><td><input name=btn type=submit value=Delete></td></tr>");
		       out.println("</table></center></form></html>");		
					 
		}
	}

	}


