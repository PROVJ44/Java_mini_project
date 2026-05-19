package com.model;

public class StudentMark {

    private int studentID;
    private String studentName;
    private String subject;
    private int marks;
    private String examDate;

    public StudentMark() {}

    public StudentMark(int studentID, String studentName,
                       String subject, int marks, String examDate) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.subject = subject;
        this.marks = marks;
        this.examDate = examDate;
    }

    public int getStudentID() { return studentID; }
    public void setStudentID(int studentID) { this.studentID = studentID; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }

    public String getExamDate() { return examDate; }
    public void setExamDate(String examDate) { this.examDate = examDate; }
}