<%@ page import="java.util.*,com.dao.MarkDAO,com.model.StudentMark" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Delete Records</title>

<link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="container">

<h2>Delete Student Records</h2>

<table border="1" width="80%">

<tr>
<th>ID</th>
<th>Name</th>
<th>Subject</th>
<th>Marks</th>
<th>Date</th>
<th>Action</th>
</tr>

<%

try {

    MarkDAO dao = new MarkDAO();

    List<StudentMark> list = dao.getAllMarks();

    for(StudentMark s : list) {

%>

<tr>

<td><%= s.getStudentID() %></td>

<td><%= s.getStudentName() %></td>

<td><%= s.getSubject() %></td>

<td><%= s.getMarks() %></td>

<td><%= s.getExamDate() %></td>

<td>

<form action="DeleteMarkServlet" method="post">

<input type="hidden"
name="id"
value="<%= s.getStudentID() %>">

<input type="submit" value="Delete">


</form>

</td>

</tr>

<%
    }

} catch(Exception e) {

    out.println(e);

}

%>

</table>

</div>
<br>

<a href="index.jsp">Back to Home</a>


</body>
</html>