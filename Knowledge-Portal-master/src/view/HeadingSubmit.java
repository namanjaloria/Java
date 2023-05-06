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
 * Servlet implementation class HeadingSubmit
 */
@WebServlet("/HeadingSubmit")
public class HeadingSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeadingSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Heading H=new Heading();
		H.setHeadingid(request.getParameter("hid"));
		H.setChapterid(request.getParameter("chid")); 
		H.setHeadingname(request.getParameter("hnm"));
		H.setHeadingdescription(request.getParameter("hd"));
		boolean rs=HeadingDAO.addNewRecord(H);
		out.println("<html>");
		if(rs)
		{ out.println("<h4><font color=green>Heading Submitted...</font></h4>");
		}
		else
		{
			out.println("<h4><font color=red>Fail to Submit Heading.....</font></h4>");	
		}
	 	out.flush();

}
}

