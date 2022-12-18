package com.app.servletdemo;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class TestParamServlet
 */
@WebServlet("/TestParamServlet")
public class TestParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//step 1: set content type
		response.setContentType("text.html");
		
	//step 2:get printwriter
		PrintWriter out = response.getWriter();
	
	//step 3: read configuration params
		ServletContext context =getServletContext();  //inherit from HttpServlet
		
		String maxCart = context.getInitParameter("max-shopping-cart-size");
		
		String teamName = context.getInitParameter("project-team-name");
	//step 4:generate HTML content
		out.println("<html><body>");
		out.println("Max cart:" + maxCart);
		out.println("<br><br>");
		out.println("Team name:" + teamName);
	 	out.println("</body></html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
