<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<title>Reports</title>
</head>

<body>

<div class="container">

<h2>📊 Reports Section</h2>

<form action="ReportServlet" method="get">

<select name="type">
    <option value="above">Students Above Marks</option>
    <option value="subject">Subject Wise</option>
    <option value="top">Top N Students</option>
</select>

<br><br>

<input type="text" name="value" placeholder="Enter value (marks / subject / N)" required>

<br><br>

<input type="submit" value="Generate Report">

<br>

<a href="index.jsp">Back to Home</a>

</form>

</div>

</body>
</html>