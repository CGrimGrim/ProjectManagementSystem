<!DOCTYPE html>
<html>
    <head>
        <title>Log In</title>
<link rel="stylesheet" type = "text/css" href="projectManagement.css">
</head>
<body>
    <header>
        <h1>Project Management System</h1>
    </header>
<br>
<br>
    <form action="auth" method="post">
        Username:<br>
        <input type="text" name="username">
        <br>
        <br>
        Password:<br>
        <input type="password" name="password">
        <br>
        <br>
        <input type="submit" value="Submit">
    </form>
    <%
         if(request.getAttribute("authenticated") == null){
             
         }
         else{
             if(request.getAttribute("authenticated").equals(false)){
                 out.println("<p align=center>Username and/or Password is incorrect</p>");
             }
         }
    %>
</body>
</html>