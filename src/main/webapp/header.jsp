<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/css/header.css">
</head>
<body>
<header>
    <div id="logo">
        <img src="static/img/AUCA-logo-wide-webblue-2.png" alt="AUCA Logo">
    </div>
    <nav>
        <ul>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="index.jsp">Registration</a></li>
            <%
                if (session != null && session.getAttribute("user") != null) {
            %>
            <li><a href="logout">Logout</a></li>
            <%
            } else {
            %>
            <li><a href="login.jsp">Login</a></li>
            <%
                }
            %>
            <li><a href="#">More</a></li>
            <li><a href="#">Search</a></li>
        </ul>
    </nav>
</header>
</body>
</html>
