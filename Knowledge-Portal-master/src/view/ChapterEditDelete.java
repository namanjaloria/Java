package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.nis.dao.ChapterDAO;
import com.nis.dao.HeadingDAO;

import com.nis.model.Chapter;


/**
 * Servlet implementation class ChapterEditDelete
 */
@WebServlet("/ChapterEditDelete")
public class ChapterEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChapterEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String btn=request.getParameter("btn");
		if(btn.equalsIgnoreCase("Delete"))
		{String Chid=request.getParameter("Chid");
		boolean st=ChapterDAO.deleteById(Chid);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			Chapter CH=new Chapter();
			CH.setCategoryID(request.getParameter("Catid"));
			CH.setChapterID(request.getParameter("Chid"));
			CH.setChaptername(request.getParameter("chna"));
			CH.setDescription(request.getParameter("Chd"));
	
		   	
			
		ChapterDAO.editRecord(CH);
		}
		response.sendRedirect("ChapterDisplayall");
		}
}
	

	

