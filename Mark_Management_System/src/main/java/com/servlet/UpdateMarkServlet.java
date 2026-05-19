package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.MarkDAO;
import com.model.StudentMark;

@WebServlet("/UpdateMarkServlet")

public class UpdateMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res)
            throws ServletException, IOException {

        try {

            StudentMark s = new StudentMark();

            s.setStudentID(
                Integer.parseInt(req.getParameter("id"))
            );

            s.setStudentName(
                req.getParameter("name")
            );

            s.setSubject(
                req.getParameter("subject")
            );

            s.setMarks(
                Integer.parseInt(req.getParameter("marks"))
            );

            s.setExamDate(
                req.getParameter("date")
            );

            MarkDAO dao = new MarkDAO();

            int result = dao.updateMark(s);

            if(result > 0) {
            	res.getWriter().println(
            		    "<html><head>"
            		    + "<link rel='stylesheet' href='css/style.css'>"
            		    + "</head><body>"
            		);

            		res.getWriter().println("<h2>Record Updated Successfully</h2>");

            		res.getWriter().println(
            		    "<a href='index.jsp'>Back to Home</a><br><br>"
            		);

            		res.getWriter().println(
            		    "<a href='markupdate.jsp'>Update More Records</a>"
            		);

            		res.getWriter().println("</body></html>");
            		res.getWriter().println(
            				
            				
                		    "<a href='index.jsp'>Back to Home</a><br><br>"
            				);
            }
            else {
                res.getWriter().println("Update Failed");
            }

        } catch(Exception e) {

            res.getWriter().println(e);

        }
    }
}