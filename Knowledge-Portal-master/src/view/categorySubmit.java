package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;

import org.softech.FileUpload;

import com.nis.dao.categoryDAO;
import com.nis.model.category;

/**
 * Servlet implementation class CategorySubmit
 */
@WebServlet("/categorySubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class categorySubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categorySubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		category C=new category();
		C.setCategoryid(request.getParameter("cid"));
		C.setCategoryname(request.getParameter("cna"));
		C.setCategorydescription(request.getParameter("cd"));
		//C.setIcon(request.getParameter("ci"));
		try{
			Part part=request.getPart("ci");
			String savepath="C:/Users/Public/workspace/KP/WebContent/Pic";
			FileUpload F=new FileUpload(part,savepath);
			C.setIcon(F.filename);
			
		}catch(Exception e)
		{System.out.print(e);}
		
		boolean st=categoryDAO.addNewRecord(C);
		out.println("<html>");
		if(st)
		{ out.println("<h4><font color=green>Category Submitted...<br><a href=categoryView>Click Here to Add More Category</a></font></h4>");
		}
		else
		{
			out.println("<h4><font color=red>Fail to Submit Category.....</font></h4>");	
		}
	 	out.flush();
		
	}

}
