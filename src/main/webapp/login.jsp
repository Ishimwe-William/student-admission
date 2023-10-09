<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
 <link rel="stylesheet" href="static/css/login.css">
</head>
<body>
<header>
 <%@ include file="header.html" %>
</header>

<div class="container">
 <form action="/loginServlet" method="post" class="form-container">
  <%
   String error = (String) request.getAttribute("error");
   if (error != null && !error.isEmpty()) {
  %>
  <p class="error-message"><strong><%= error %></></p>
  <%
   }
  %>
  <fieldset>
   <legend style="text-align: center">Login Form</legend>
   <label for="email">Email:</label>
   <input type="email" id="email" name="email" required/><br/><br/>

   <label for="password">Password:</label>
   <input type="password" id="password" name="password" required/><br/><br/>

   <input type="submit" value="Login"/><br/><br/>
   <a href="signup.jsp" style="font-size: small">SignUp instead</a>
  </fieldset>
 </form>
</div>

<footer>
 <%@ include file="footer.html" %>
</footer>
</body>
</html>