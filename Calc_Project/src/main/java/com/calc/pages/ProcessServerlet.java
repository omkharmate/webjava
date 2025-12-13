package com.calc.pages;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ProcessServerlet
 */
@WebServlet("/calculate")
public class ProcessServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessServerlet() {
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num1=Integer.parseInt(request.getParameter("num1"));
		int num2=Integer.parseInt(request.getParameter("num2"));
		String sign=request.getParameter("action");
		int res=0;
		switch (sign) {
		case "add":
			res=num1+num2;
			break;
		case "subtract":
			res=num1-num2;
			break;
		case "multiply":
			res=num1*num2;
			break;
		case "divide":
			res=num1/num2;
			break;
		default:
			break;
		}
		Calculation c1=new Calculation(num1,num2,res);
		request.setAttribute("res", c1);
		RequestDispatcher rd=request.getRequestDispatcher("calc");
		rd.forward(request, response);
		System.out.println("control came back");
	}

}
