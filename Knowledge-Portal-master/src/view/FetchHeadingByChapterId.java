package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.nis.dao.DBHelper;
import com.nis.dao.HeadingDAO;

/**
 * Servlet implementation class FetchHeadingByChapterIdJSON
 */
@WebServlet("/FetchHeadingByChapterId")
public class FetchHeadingByChapterId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchHeadingByChapterId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try{
			String chid=request.getParameter("chid");
		 ResultSet rs=HeadingDAO.displayHeadingByChapterId(chid);
		 ArrayList<JSONObject>json=DBHelper.getFormattedResult(rs);
		   out.println(json);
		}catch(Exception e)
		{
		out.println(e);	
		}
		}
	}


