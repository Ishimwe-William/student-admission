<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Semester Information</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>Semester Information Form</h1>
<form action="/semesterServlet" method="post">
  <%
    String error = (String) request.getAttribute("error");
    if (error != null && !error.isEmpty()) {
  %>
  <p style="color: red; font-size: 14px; margin-top: 10px;text-align: center"><strong><%= error %></></p>
  <%
    }
  %>
  <label for="name">Name:</label>
  <input type="text" name="name" id="name" required><br><br>

  <label for="start">Start Date:</label>
  
  <input type="date" name="start" id="start" required>
  <label for="end">End Date:</label>
  <input type="date" name="end" id="end" required><br><br>

  <input type="submit" value="Submit"><br><br>
</form>
<jsp:include page="footer.html"/>
</body>
</html>
