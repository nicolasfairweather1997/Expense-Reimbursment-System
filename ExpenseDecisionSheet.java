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
 * Servlet implementation class ExpenseDecisionSheet
 */
public class ExpenseDecisionSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpenseDecisionSheet() {
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
		Connection connection = null;
        try {
        	connection = ConnectionUtils.getInstance().getConnection();
			out.print("<h2>Ticket Status Updated</h2>");
        	String Id = request.getParameter("ID#");
        	String decision = request.getParameter("decision");
            PreparedStatement updateData=connection.prepareStatement("update expenseticket2 set acceptance=? where id=?");
            updateData.setString(1, decision);
            updateData.setString(2, Id);
            updateData.executeUpdate();
            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
            }
            
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
