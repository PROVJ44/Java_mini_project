package com.dao;

import java.sql.*;
import java.util.*;

import com.model.StudentMark;

public class MarkDAO {

    Connection con;

    public MarkDAO() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/MarkDB",
            "root",
            "root"
        );
    }

    public int addMark(StudentMark s) throws Exception {

        PreparedStatement ps = con.prepareStatement(
            "insert into studentmarks values(?,?,?,?,?)"
        );

        ps.setInt(1, s.getStudentID());
        ps.setString(2, s.getStudentName());
        ps.setString(3, s.getSubject());
        ps.setInt(4, s.getMarks());
        ps.setDate(5, java.sql.Date.valueOf(s.getExamDate()));

        return ps.executeUpdate();
    }

    public int updateMark(StudentMark s) throws Exception {

        PreparedStatement ps = con.prepareStatement(
            "update studentmarks set StudentName=?, Subject=?, Marks=?, ExamDate=? where StudentID=?"
        );

        ps.setString(1, s.getStudentName());
        ps.setString(2, s.getSubject());
        ps.setInt(3, s.getMarks());
        ps.setDate(4, java.sql.Date.valueOf(s.getExamDate()));
        ps.setInt(5, s.getStudentID());

        return ps.executeUpdate();
    }

    public int deleteMark(int id) throws Exception {

        PreparedStatement ps = con.prepareStatement(
            "delete from studentmarks where StudentID=?"
        );

        ps.setInt(1, id);

        return ps.executeUpdate();
    }

    public List<StudentMark> getAllMarks() throws Exception {

        List<StudentMark> list = new ArrayList<>();

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(
            "select * from studentmarks"
        );

        while(rs.next()) {

            StudentMark s = new StudentMark();

            s.setStudentID(rs.getInt("StudentID"));
            s.setStudentName(rs.getString("StudentName"));
            s.setSubject(rs.getString("Subject"));
            s.setMarks(rs.getInt("Marks"));
            s.setExamDate(rs.getDate("ExamDate").toString());

            list.add(s);
        }

        return list;
    }

    public List<StudentMark> aboveMarks(int marks)
            throws Exception {

        List<StudentMark> list = new ArrayList<>();

        PreparedStatement ps = con.prepareStatement(
            "select * from studentmarks where Marks > ?"
        );

        ps.setInt(1, marks);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {

            StudentMark s = new StudentMark();

            s.setStudentID(rs.getInt("StudentID"));
            s.setStudentName(rs.getString("StudentName"));
            s.setSubject(rs.getString("Subject"));
            s.setMarks(rs.getInt("Marks"));
            s.setExamDate(rs.getDate("ExamDate").toString());

            list.add(s);
        }

        return list;
    }

    public List<StudentMark> subjectWise(String subject)
            throws Exception {

        List<StudentMark> list = new ArrayList<>();

        PreparedStatement ps = con.prepareStatement(
            "select * from studentmarks where Subject=?"
        );

        ps.setString(1, subject);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {

            StudentMark s = new StudentMark();

            s.setStudentID(rs.getInt("StudentID"));
            s.setStudentName(rs.getString("StudentName"));
            s.setSubject(rs.getString("Subject"));
            s.setMarks(rs.getInt("Marks"));
            s.setExamDate(rs.getDate("ExamDate").toString());

            list.add(s);
        }

        return list;
    }

    public List<StudentMark> topN(int n)
            throws Exception {

        List<StudentMark> list = new ArrayList<>();

        PreparedStatement ps = con.prepareStatement(
            "select * from studentmarks order by Marks desc limit ?"
        );

        ps.setInt(1, n);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {

            StudentMark s = new StudentMark();

            s.setStudentID(rs.getInt("StudentID"));
            s.setStudentName(rs.getString("StudentName"));
            s.setSubject(rs.getString("Subject"));
            s.setMarks(rs.getInt("Marks"));
            s.setExamDate(rs.getDate("ExamDate").toString());

            list.add(s);
        }

        return list;
    }
}