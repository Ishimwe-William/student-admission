<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Academic Unit Form</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Academic Unit Form</h1>

<form action="academicUnit" method="post">
    <label for="code">Code:</label>
    <input type="text" name="code" id="code" required><br><br>

    <label for="name">Name:</label>
    <input type="text" name="name" id="name" required><br><br>

    <label for="unitType">Unit Type:</label>
    <select name="unitType" id="unitType">
        <option value="PROGRAMME">Programme</option>
        <option value="UNDERGRADUATE">Undergraduate</option>
        <option value="MASTERS">Masters</option>
        <!-- Add more options as needed -->
    </select><br><br>

    <input type="submit" value="Submit">
</form>
<jsp:include page="footer.html"></jsp:include>
</body>
</html>
