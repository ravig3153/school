package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Emp;

/**
 * Servlet implementation class mobile
 */
@WebServlet("/content/mobile")
public class mobile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mobile() {
        super();
        // TODO Auto-generated constructor stub
        
    }
    String next="success.jsp";

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String email = request.getParameter("userEmail");
		String password = request.getParameter("password");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			
//			String q="SELECT * FROM login where (email, password) values(?,?)";
			String q="SELECT * FROM login where email=? and password=?";
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			ResultSet rs= pstmt.executeQuery();
			System.out.println("hghhh");
//			response.getWriter().write("completed");
			
			
			
			
			
			if(rs.next()){
				
			

				
				Emp emp = new Emp();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setMob(rs.getString("mob"));
				emp.setEmail(rs.getString("email"));
				emp.setGender(rs.getString("gender"));
				emp.setPassword(rs.getString("password"));
				emp.setEmpid(rs.getString("empid"));
				
//				request.setAttribute("data", emp);
				response.getWriter().print("done");
				
//			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
//			rd.forward(request, response);
				
				 HttpSession session = request.getSession();
				 session.setAttribute("data", emp);
				 next ="success.jsp";
				
			}
			else{
				
				response.getWriter().print("fail");
				next = "login.jsp";
//			RequestDispatcher rd=request.getRequestDispatcher("failure.jsp");
//				rd.forward(request, response);
			}
			System.out.println(rs);
				
			
		}
			catch (Exception e){
				e.printStackTrace();
				response.getWriter().write("error");
			}
		
		
	}

}
