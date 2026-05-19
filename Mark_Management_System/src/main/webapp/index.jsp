<html>
<head>
<link rel="stylesheet" href="css/style.css">
<title>Student Marks Management System</title>

<style>
body {
    font-family: Arial;
    background: linear-gradient(to right, #1e3c72, #2a5298);
    color: white;
    text-align: center;
}

.container {
    margin-top: 80px;
}

h1 {
    font-size: 40px;
    margin-bottom: 40px;
}

a {
    display: inline-block;
    padding: 12px 25px;
    margin: 10px;
    background: white;
    color: #2a5298;
    text-decoration: none;
    border-radius: 10px;
    font-weight: bold;
    transition: 0.3s;
}

a:hover {
    background: #ffcc00;
    color: black;
    transform: scale(1.1);
}
</style>

</head>

<body>

<div class="container">

<h1> Student Marks System</h1>

<a href="markadd.jsp"> Add Marks</a>
<a href="markupdate.jsp"> Update Marks</a>
<a href="markdelete.jsp"> Delete Marks</a>
<a href="DisplayMarkServlet"> View Marks</a>
<a href="reports.jsp"> Reports</a>

</div>

</body>
</html>