package com.calc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CalcServelet
 */
@WebServlet("/calculate")
public class CalcServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try(PrintWriter pw=response.getWriter()){
			int num1= Integer.parseInt(request.getParameter("num1"));
			int num2= Integer.parseInt(request.getParameter("num2"));
			
			String ch=request.getParameter("action");
			int res=0;
			switch (ch) {
			case "+":
				res=num1+num2;
				break;
			case "-":
				res=num1-num2;
				break;
			case "*":
				res=num1*num2;
				break;
			case "/":
				res=num1/num2;
				break;

			default:
				break;
			}
			pw.print("<h1>RESULT IS ..."+res+ "</h1>");
			
			pw.print("<a href=\"index.html\">RECALCULATE</a>");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
