package com.calc.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ResultShowing
 */
@WebServlet("/calc")
public class ResultShowing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultShowing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		System.out.println("response.setContentType(\"text/html\");ontrol came back");

		try(PrintWriter pw=response.getWriter()){
			Calculation c2=(Calculation) request.getAttribute("res");
			if (c2 == null) {
			    pw.print("<h2>Error: No calculation result found.</h2>");
			    pw.print("<h2><a href='calc.html'>Go Back</a></h2>");
			    return;
			}
 			pw.print("<h1> "+c2.getNum1()+"--"+c2.getNum2()+"="+c2.getResult()+"</h1>");
 			pw.print("<h2><a href='calc.html'>REDIRECT</a></h2>");
			System.out.println("[][]");

		}
	}

}
