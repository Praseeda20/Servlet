package com.cg.assgn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/servlet1")
public class AssgnServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssgnServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String user = request.getParameter("userName");
		String pass = request.getParameter("pass");
		
		if(user.equals("John")&& pass.equals("admin123")){
			HttpSession session = request.getSession();
			session.setAttribute("country", "India");
			RequestDispatcher rd = request.getRequestDispatcher("servlet2");
			rd.forward(request,  response);
		}
		else
		{
			out.print("Sorry UserName or password Error ! Enter Again !!");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request,  response);
		}
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
