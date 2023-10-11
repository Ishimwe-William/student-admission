<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
 <link rel="stylesheet" href="static/css/login.css">
 <title>AUCA Registration - Login</title>
</head>
<body>
<header>
 <%@ include file="header.jsp" %>
</header>
<div class="container">
 <fieldset>
  <legend style="text-align: center">Login Form</legend>
  <form action="/loginServlet" method="post" class="form-container">
  <%
   String error = (String) request.getAttribute("error");
   if (error != null && !error.isEmpty()) {
  %>
  <p class="error-message"><strong><%= error %></></p>
  <%
   }
  %>
   Email: <input type="email" id="email" name="email" required/><br/><br/>

   Password: <input type="password" id="password" name="password" required/><br/><br/>

   <input type="submit" value="Login"/><br/><br/>
   <a href="signup.jsp" style="font-size: small">SignUp instead</a>
  </fieldset>
 </form>
</div>
 <%@ include file="footer.html" %>
</body>
</html>