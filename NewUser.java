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
 * Servlet implementation class NewUser
 */
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name2 = request.getParameter("name2");
		String ID2 = request.getParameter("ID2");
		//From the parameter from the request, give me a parameter whose name is name2
		out.print("<h1>Welcome Great Employee!</h1>");
		out.print("<br>");
		out.print("<form action= 'NewUser' method = 'post'>");
		out.print("<input type=\"hidden\" name=\"name2\" value ="+name2+"/>");
		out.print("<input type=\"hidden\" name=\"ID2\" value ="+ID2+"/>");
		out.print("<h2> Submit your ticket </h2>");
		out.print("<br>");
		out.print("<label for=\"food2\">Food:</label>");
		out.print("<input type=\"text\" name=\"food2\"/>");
		out.print("<br>");
		out.print("<label for=\"price2\">Price:</label>");
		out.print("<input type=\"text\" name=\"price2\"/>");
		out.print("<br>");
		out.print("<label for=\"description2\">Description:</label>");
		out.print("<input type=\"text\" name=\"description2\"/>");
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
		String ID2 = request.getParameter("ID2");
		String name2 = request.getParameter("name2");
		String food2 = request.getParameter("food2");
		String price2 = request.getParameter("price2");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		try {
				 connection = ConnectionUtils.getInstance().getConnection();
				 out.print("<h2>Ticket Submitted</h2>");
				 PreparedStatement insertData;
				 insertData = connection.prepareStatement("insert into expenseticket2 (ID, name1, food, price) values(?,?,?,?)");
				 insertData.setString(1, ID2);
				 insertData.setString(2, name2);
				 insertData.setString(3, food2);
				 insertData.setString(4, price2);
				 insertData.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}

}
