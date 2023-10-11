<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/css/login.css">
    <script src="static/js/signup.js"></script>
    <title>AUCA Registration - SignUp</title>
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<div class="container">
    <fieldset>
        <legend style="text-align: center">SignUp Form</legend>
        <form action="/signupServlet" method="post" class="form-container">
            Email: <input type="email" name="email" required/><br/><br/>
            Password: <input type="password" name="password" required/><br/><br/>
            <input type="submit" value="SignUp"/><br/><br/>
            <a href="login.jsp" style="font-size: small">Login instead</a>
        </form>
    </fieldset>
</div>
<jsp:include page="footer.html"/>
</body>
</html>
