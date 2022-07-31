package com.revature.project__1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagerLogin
 */
public class ManagerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h2> Welcome </h2>");
		Connection connection = null;
        //Statement statement=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet;
        try {
        connection = ConnectionUtils.getInstance().getConnection();
		preparedStatement=connection.prepareStatement("select * from expenseticket2");
        // Step 4: Execute the Query and get the result of Query in ResultSet
            
            //resultSet=statement.executeQuery("select * from employee where id="+id);
            resultSet=preparedStatement.executeQuery();
        // Step 5: Iterate over ResultSet and display columns values using getXXX()
        while(resultSet.next()) {
            //System.out.println(resultSet.getInt("id") +"   "+resultSet.getString("first_name")+"   "+resultSet.getString("last_name"));
        	out.print("<table>"); 
            out.print("<tr>");
            out.print("<th>ID#</th>");
            out.print("<th>Name</th>");
            out.print("<th>Food</th>");
            out.print("<th>Price</th>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>"+resultSet.getString(1)+"</td>");
            out.print("<td>"+resultSet.getString(2)+"</td>");
            out.print("<td>"+resultSet.getString(3)+"</td>");
            out.print("<td>"+resultSet.getString(4)+"</td>");
            out.print("</tr>");
            out.print("</table>");
            out.print("<form action = 'ExpenseDecisionSheet' method = 'get'>");
            //out.print("<label for=\"ID#\">Select ID#:</label>");
            out.print("<input type=\"hidden\" name=\"ID#\" value =\""+resultSet.getString(1)+"\"/>");
            out.print("<label for=\"decision\">Approve or Deny:</label>");
            out.print("<input type=\"text\" name=\"decision\"/>");
            out.print("<input type=\"submit\" value=\"Submit\">");

            out.print("</form>");
        }}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}}
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 String username2= request.getParameter("username2");
         String password2= request.getParameter("password2");
		if (username2 == "admin" && password2 == "revature") {
		Connection connection = null;
        //Statement statement=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet;
        try {
        	connection = ConnectionUtils.getInstance().getConnection();
        	out.print("<h2> Welcome </h2>");
    // Step 3 : Create the Statement Object
            //    statement=connection.createStatement();
            preparedStatement=connection.prepareStatement("select * from expenseticket2");
            // Step 4: Execute the Query and get the result of Query in ResultSet
                resultSet=preparedStatement.executeQuery();
            // Step 5: Iterate over ResultSet and display columns values using getXXX()
            out.println(resultSet);
            }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
	}*/


