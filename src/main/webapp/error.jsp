<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error</title>
</head>
<body>
<h1>Error</h1>
<%
    String error = (String) request.getAttribute("error");
if (error != null && !error.isEmpty()) {
%>
<p><%= error %></p>
<% } else { %>
<p>An unspecified error occurred.</p>
<% } %>
</body>
</html>

