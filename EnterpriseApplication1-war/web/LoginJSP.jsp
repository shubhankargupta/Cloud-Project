<%-- 
    Document   : LoginJSP
    Created on : 12 Apr, 2017, 11:57:10 PM
    Author     : Gupta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
.card {
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    transition: 0.3s;
    width: 40%;
    padding : 20px;
}

.card:hover {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

.container {
    padding: 2px 16px;
}

div {
    background-color: #FFFFFF;
}
</style>
    </head>
    <body bgcolor="#26A69A">
        <h2 align="center">LOGIN PAGE</h2>

<div class="card" bgcolor = "#FFFFFF" align = "center" style="margin:0 auto;">

<form action="LoginServlet" method="GET">
            Name :   <input type="text" name="user"><br><br>
    Password : <input type="password" name="password"><br><br>
            Option:<select name="prof">
                <option value="Patient">Patient</option>
                <option value="Doctor">Doctor</option>
            </select>
            <br><br>
            <input type="submit" value="Sign IN" padding = 12px>

        </form>
    
    <form action="profession.html">
        <br>
           <input type="submit" value="Sign UP"/>
    </form>
  
</div>
    </body>
    
</html>

