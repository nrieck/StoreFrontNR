
package edu.wctc.nr.week3.controller;

import edu.wctc.nr.week3.model.Name;
import edu.wctc.nr.week3.model.NameService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author L117student
 */
public class NameController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NameController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NameController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NameService nameService = new NameService();
        RequestDispatcher dispatcher = null;
        
        String id = request.getParameter("id");
        String search = request.getParameter("search");
        if (id != null) {
            Name name = nameService.getName(id);
        } else if (search != null) {
            List<Name> nameList = nameService.findNames(search);
            request.setAttribute("nameList", nameList);
                    dispatcher = request.getRequestDispatcher("/nameDetail.jsp");
            // go to nameList.jsp
        } else {
            List<Name> nameList = nameService.getAllNames();
            request.setAttribute("nameList", nameList);
            dispatcher = request.getRequestDispatcher("/nameList.jsp");
            // go to nameList.jsp
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
    }// </editor-fold>

}
