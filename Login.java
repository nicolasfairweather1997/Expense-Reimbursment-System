package com.revature.project__1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name1 = request.getParameter("name1");
		String ID = request.getParameter("ID");
		//From the parameter from the request, give me a parameter whose name is username
		out.print("<h1>Welcome Great Employee!</h1>");
		out.print("<br>");
		out.print("<form action='Login' method = 'post'>");
		out.print("<input type=\"hidden\" name=\"name1\" value ="+name1+"/>");
		out.print("<input type=\"hidden\" name=\"ID\" value ="+ID+"/>");
		out.print("<h2> Submit your ticket </h2>");
		out.print("<br>");
		out.print("<label for=\"food\">Food:</label>");
		out.print("<input type=\"text\" name=\"food\"/>");
		out.print("<br>");
		out.print("<label for=\"price\">Price:</label>");
		out.print("<input type=\"text\" name=\"price\"/>");
		out.print("<br>");
		out.print("<label for=\"description\">Description:</label>");
		out.print("<input type=\"text\" name=\"description\"/>");
		out.print("<br>");
		out.print("<input type=\"submit\" value=\"Submit\">");
		out.print("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection connection;
		String ID = request.getParameter("ID");
		String name1 = request.getParameter("name1");
		String food = request.getParameter("food");
		String price = request.getParameter("price");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		try {
				 connection = ConnectionUtils.getInstance().getConnection();
				 out.print("<h2>Ticket Submitted</h2>");
				 PreparedStatement insertData;
				 insertData = connection.prepareStatement("insert into expenseticket2 (ID,name1, food, price) values(?,?,?,?)");
				 insertData.setString(1, ID);
				 insertData.setString(2, name1);
				 insertData.setString(3, food);
				 insertData.setString(4, price);
				 insertData.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
	}}

