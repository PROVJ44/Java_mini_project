package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.MarkDAO;
import com.model.StudentMark;

@WebServlet("/ReportServlet")

public class ReportServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");

        try {

            String type = req.getParameter("type");
            String value = req.getParameter("value");

            MarkDAO dao = new MarkDAO();

            List<StudentMark> list = null;

            if(type.equals("above")) {

                int marks = Integer.parseInt(value);

                list = dao.aboveMarks(marks);
            }

            else if(type.equals("subject")) {

                list = dao.subjectWise(value);
            }

            else if(type.equals("top")) {

                int n = Integer.parseInt(value);

                list = dao.topN(n);
            }

            res.getWriter().println(
                "<html><head>"
                + "<link rel='stylesheet' href='css/style.css'>"
                + "</head><body>"
            );

            res.getWriter().println(
                "<h2>Report Results</h2>"
            );

            res.getWriter().println(
                "<table border='1' width='80%'>"
            );

            res.getWriter().println(
                "<tr>"
                + "<th>ID</th>"
                + "<th>Name</th>"
                + "<th>Subject</th>"
                + "<th>Marks</th>"
                + "<th>Date</th>"
                + "</tr>"
            );

            for(StudentMark s : list) {

                res.getWriter().println(

                    "<tr>"

                    + "<td>" + s.getStudentID() + "</td>"

                    + "<td>" + s.getStudentName() + "</td>"

                    + "<td>" + s.getSubject() + "</td>"

                    + "<td>" + s.getMarks() + "</td>"

                    + "<td>" + s.getExamDate() + "</td>"

                    + "</tr>"
                );
            }

            res.getWriter().println(
                "</table></body></html>"
            );

        }

        catch(Exception e) {

            res.getWriter().println(e);

        }
    }
}