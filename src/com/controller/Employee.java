package com.controller;

import java.io.IOException;
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

import com.model.Emp;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;
@WebServlet("/content/signup")

public class Employee extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String pageName = request.getParameter("pageName");
		
		if (pageName.equals("signup")) {
			String name = request.getParameter("name");
			System.out.println("FROM SIGNUP"+name);
			String empid = request.getParameter("empid");
			String email = request.getParameter("userEmail");
			String mob = request.getParameter("userMobile");
			String gender= request.getParameter("gender");
			String password= request.getParameter("password");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
				
				String q="insert into login (name, empid, email, mob, gender, password) values(?,?,?,?,?,?)";
				
				PreparedStatement pstmt=con.prepareStatement(q);
				pstmt.setString(1,name);
				pstmt.setString(2,empid);
				pstmt.setString(3, email);
				pstmt.setString(4, mob);
				pstmt.setString(5, gender);
				pstmt.setString(6, password);
				
				pstmt.executeUpdate();
				response.getWriter().write("done");
				
				
			}  catch (Exception e){
				e.printStackTrace();
				response.getWriter().write("error");
			}
		} else if (pageName.equals("login")) {
			String email = request.getParameter("userEmail");
			System.out.println("LOgin calling"+email);
			String password = request.getParameter("password");
			System.out.println(password);
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
				
//				String q="SELECT * FROM login where (email, password) values(?,?)";
				String q="SELECT * FROM login where email=? and password=?";
				PreparedStatement pstmt=con.prepareStatement(q);
				pstmt.setString(1,email);
				pstmt.setString(2,password);
				
				ResultSet rs= pstmt.executeQuery();
				response.getWriter().write("completed");
//				int id =rs.getInt("id");
//				String name =rs.getString("name");
				if(rs.next()){
					Emp emp = new Emp();
					emp.setId(rs.getInt("id"));
					emp.setName(rs.getString("name"));
					emp.setMob(rs.getString("mob"));
					emp.setEmail(rs.getString("email"));
					emp.setGender(rs.getString("gender"));
					emp.setPassword(rs.getString("password"));
					emp.setEmpid(rs.getString("empid"));
					
					request.setAttribute("data", emp);
					RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
					rd.forward(request, response);
				}
				else{
					RequestDispatcher rd=request.getRequestDispatcher("failure.jsp");
					rd.forward(request, response);
				}
				

					
				
				
				
				
				System.out.println(rs);
			} catch (Exception e){
				e.printStackTrace();
				response.getWriter().write("error");
			}
			
			
		}
		
		
		
		
	}
}
