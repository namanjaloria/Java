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
 * Servlet implementation class ChapterSubmit
 */
@WebServlet("/ChapterSubmit")
public class ChapterSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChapterSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Chapter C=new Chapter();
		C.setCategoryID(request.getParameter("Catid"));
		C.setChapterID(request.getParameter("Chid"));
		C.setChaptername(request.getParameter("chna")); 
		C.setDescription(request.getParameter("Chd"));
		boolean rs=ChapterDAO.AddNewrecord(C);
		out.println("<html>");
		if(rs)
		{ out.println("<h4><font color=green>Chapter Submitted...</font></h4>");
		}
		else
		{
			out.println("<h4><font color=red>Fail to Submit Chapter.....</font></h4>");	
		}
	 	out.flush();

}
}
