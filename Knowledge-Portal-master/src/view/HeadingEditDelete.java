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

import com.nis.dao.HeadingDAO;
import com.nis.dao.categoryDAO;
import com.nis.model.Heading;
import com.nis.model.category;

/**
 * Servlet implementation class HeadingEditDelete
 */
@WebServlet("/HeadingEditDelete")
public class HeadingEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeadingEditDelete() {
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
		{String hid=request.getParameter("hid");
		boolean st=HeadingDAO.deleteById(hid);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			Heading H=new Heading();
			H.setChapterid(request.getParameter("chid"));
			H.setHeadingid(request.getParameter("hid"));
			H.setHeadingname(request.getParameter("hnm"));
		H.setHeadingdescription(request.getParameter("hd")); 
		HeadingDAO.editRecord(H);
			}
		   	
			
			
		
		response.sendRedirect("HeadingDisplayall");
}
	}
	

	


