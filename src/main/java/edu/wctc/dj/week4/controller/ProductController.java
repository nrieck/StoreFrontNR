
package edu.wctc.dj.week4.controller;

import edu.wctc.dj.week4.model.Product;
import edu.wctc.dj.week4.model.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        ProductService productService = new ProductService();
		RequestDispatcher dispatcher = null;

		String id = request.getParameter("id");
		String search = request.getParameter("search");
		if (id != null) {
			Product productName = productService.getProductName(id);
			request.setAttribute("productName", productName);
			dispatcher =
				request.getRequestDispatcher("/ProductDetail.jsp");
		} else if (search != null) {
			List<Product> productList = productService.findProductNames(search);
			request.setAttribute("productList", productList);
			dispatcher =
				request.getRequestDispatcher("/ProductList.jsp");
		} else {
			List<Product> productList = productService.findProductNames(id);
			request.setAttribute("productList", productList);
			dispatcher =
				request.getRequestDispatcher("/ProductList.jsp");
		}

		dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
