package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cook
 */
@WebServlet("/Cook")
public class Cook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=res.getWriter();
		   Cookie c[]=req.getCookies();
		   if(c==null || c.length==0)
		   { out.println("This Page Open By User First Time");
		    Cookie cc=new Cookie("PrevLogin",new Date().toString());
		    cc.setMaxAge(10000000);
		    res.addCookie(cc);
		        }
		   else if(c.length==1)
		   {out.println("This Page Open By User Second  Time");
		    Cookie ccc=new Cookie("secondLogin",new Date().toString());
		    out.println("This Page Open by User Dated:"+ccc.getValue());
			ccc.setValue(new Date().toString());
			ccc.setMaxAge(10000000);
			res.addCookie(ccc);
		   }
		   
		        else
		      {
				  Cookie cc=null;
				  for(int i=0;i<c.length;i++)
		      {if(c[i].getName().equals("PrevLogin"))
		        {cc=c[i];
		          break;
					}
				   }

			out.println("This Page Open by User jjjjjjjj Dated:"+cc.getValue());
			cc.setValue(new Date().toString());
			cc.setMaxAge(10000000);
			res.addCookie(cc);

				  }
	}
}


	


