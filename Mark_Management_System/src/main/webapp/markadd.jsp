<html>
<head>
<link rel="stylesheet" href="css/style.css">
<title>Add Marks</title>
</head>

<body>

<h2>Add Student Marks</h2>

<form action="AddMarkServlet" method="post">

<input type="number" name="id" placeholder="Student ID" required><br><br>

<input type="text" name="name" placeholder="Student Name" required><br><br>

<input type="text" name="subject" placeholder="Subject" required><br><br>

<input type="number" name="marks" placeholder="Marks" required><br><br>

<input type="date" name="date" required><br><br>

<input type="submit" value="Add Marks">

<br>

<a href="index.jsp">Back to Home</a>

</form>

</body>
</html>