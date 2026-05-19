package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.MarkDAO;

@WebServlet("/DeleteMarkServlet")

public class DeleteMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res)
            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(
                req.getParameter("id")
            );

            MarkDAO dao = new MarkDAO();

            int result = dao.deleteMark(id);

            if(result > 0) {
            	res.getWriter().println(
            		    "<html><head>"
            		    + "<link rel='stylesheet' href='css/style.css'>"
            		    + "</head><body>"
            		);

            		res.getWriter().println("<h2>Record Deleted Successfully</h2>");

            		res.getWriter().println(
            		    "<a href='index.jsp'>Back to Home</a><br><br>"
            		);

            		res.getWriter().println(
            		    "<a href='markdelete.jsp'>Delete More Records</a>"
            		);

            		res.getWriter().println("</body></html>");
            		res.getWriter().println(
            				
            				
                		    "<a href='index.jsp'>Back to Home</a><br><br>"
                		);

            }
            else {
                res.getWriter().println("Delete Failed");
            }

        } catch(Exception e) {

            res.getWriter().println(e);

        }
    }
}