<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="static/css/signup.css">
  <title>AUCA Registration - SignUp</title>
</head>
<body>
<jsp:include page="header.html"/>
<hr/>
<h3>SignUp Form</h3>
<br/>

<form action="/signupServlet" method="post">
  Email: <input type="email" name="email" required/><br/><br/>
  Password: <input type="password" name="password" required/><br/><br/>
  <input type="submit" value="SignUp"/>
  <a href="login.jsp">Login instead</a>
</form>

<jsp:include page="footer.html"/>
</body>
</html>
