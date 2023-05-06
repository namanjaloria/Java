package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.dao.ChapterDAO;

import com.nis.model.Chapter;


/**
 * Servlet implementation class ChapterViewById
 */
@WebServlet("/ChapterViewById")
public class ChapterViewById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChapterViewById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String Chid=request.getParameter("Chid");
		Chapter Ch=ChapterDAO.displayById(Chid);
		if(Ch!=null)
		{
			out.println("<html>");
			out.println("<form action=ChapterEditDelete method=post >");
			out.println("<center><table>");
			out.println("<caption><h3>Chapter Details</h3></caption>");
			out.println("<tr><td><b><i>Chapter ID:</i></b></td><td><input type=text name=Chid size=30 value='"+Ch.getChapterID()+"' readonly=true></td></tr>");
		       out.println("<tr><td><b><i>Chapter Name:</i></b></td><td><input type=text name=chna size=30 value='"+Ch.getChaptername()+"'></td></tr>");
		       out.println("<tr><td><b><i>Description:</i></b></td><td><textarea name=Chd rows=3 cols=40>"+Ch.getDescription()+"</textarea></td></tr>");
		       
		       out.println("<tr><td><input name=btn type=submit value=Edit></td><td><input name=btn type=submit value=Delete></td></tr>");
		       out.println("</table></center></form></html>");		
					 
		}
	}

}
