package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logout
 */
@WebServlet("/content/logout")
public class logout extends HttpServlet {
	
    
    public logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession();
		 
		 if(session.getAttribute("data") != null){
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

	            session.removeAttribute("data");
	            response.sendRedirect("../index.jsp");
	        }
	}

	

}
