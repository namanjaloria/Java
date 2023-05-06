package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.nis.dao.categoryDAO;
import com.nis.model.category;

/**
 * Servlet implementation class categoryEditDelete
 */
@WebServlet("/categoryEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class categoryEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public categoryEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		//Navigation bar
        HttpSession ses=request.getSession();
        try{
        String n="<h4><b><i>Admin Id:"+ses.getValue("SAID").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=red>"+ses.getValue("SANAME").toString()+"</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout>Logout</a></b></i></h4><hr color=green>";
        out.println(n);		
        	
        }
        catch(Exception e)
        {
        	response.sendRedirect("AdminLogin");
        }
		String btn=request.getParameter("btn");
		if(btn.equalsIgnoreCase("Delete"))
		{String cid=request.getParameter("cid");
	boolean st=categoryDAO.deleteById(cid);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			category C=new category();
			C.setCategoryid(request.getParameter("cid"));
			C.setCategoryname(request.getParameter("cna"));
			C.setCategorydescription(request.getParameter("cd"));
			C.setIcon(""); 
			if(request.getPart("ci").getSize()>0)
			{
			try{
				Part part=request.getPart("ci");
				String savepath="C:/Users/Public/workspace/KP/WebContent/Pic";
				FileUpload F=new FileUpload(part,savepath);
				C.setIcon(F.filename);
			}catch(Exception e){
				System.out.println(e);
			}
		   	
			}
			categoryDAO.editRecord(C);
			
		}
		response.sendRedirect("categoryDisplayall");
		}
	

}
