package com.assignment.pages;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.assignment.dao.ProductDao;
import com.assignment.dao.ProductDaoImpl;
import com.assignment.entity.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(value="/search" ,loadOnStartup = 1)
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       ProductDao prodao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			prodao= new ProductDaoImpl();
			System.out.println("Init ok");
		}catch(Exception e) {
			throw new ServletException("err in init of - " + getClass(), e);
		}
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String catname=request.getParameter("category");
		try(PrintWriter pw=response.getWriter()) {
			List<Product> list=prodao.getProducts(catname);
			 for(int i=0;i<list.size();i++) {
				 pw.print("<h3>"+ list.get(i) + "</h3>");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
