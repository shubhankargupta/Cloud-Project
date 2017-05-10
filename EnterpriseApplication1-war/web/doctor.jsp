<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<META HTTP-EQUIV="refresh" CONTENT="<%= session.getMaxInactiveInterval()%>; URL=LoginJSP.jsp" />

<html>
    <head>

    <style>
    .img-container {
height: 900px;
position: relative;
background-color: #000000;
}
.img-container img {
height: 100%;
width: 100%;
opacity: 0.5;
}
.submit{
  z-index: 100;
position: absolute;
color: white;
left: 150px;
top: 200px;
}
    </style>

      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      
      
        <%String doctor = request.getSession(false).getAttribute("Doctor").toString();%>

    </head>
    <body>
          <nav class="navbar navbar-default navbar-fixed-top">
          <div class="container">
              <div class="navbar-header"> <a class="navbar-brand mon" href="#home">Medicare</a> </div>
              <ul class="nav navbar-nav navbar-right hidden-xs hidden-sm">
                  <li><a href="About.html">About</a>
                  </li>
                  <li><a href="LoginJSP.jsp">Sign Out</a>                  
              </ul>
          </div>
      </nav>
        
        
        

        <div class="img-container"><img class="doctor_image" src="doctor.jpeg"/>
          <form action="Doctor" method="POST" class = "submit">
              <center>             <h2>      <%=doctor%></h2></center>
      <center><h2>Enter the symptom below:</h2></center>
      <center><br><b>SYMPTOM: <input type="text" name="symptom" style="color:black;"/>
      <center><h2>Enter the possible disease below:</h2></center>
      <center><br><b>DISEASE:<input type="text" name="disease" style="color:black;"/></b></center>
      <center><h2>Enter the possible cure below:</h2></center>
      <center><br><b>CURE:<input type="text" name="cure" style="color:black;"/></b></center>
          <center><br><input type="submit" value="ADD TO THE DATABASE" style="color:black; padding:10px;background-color:#00BCD4;"/>
              <center><br><b><a href="LoginJSP.jsp">Logout</a></b></center>

          </form>
        </div>
    </body> 

</html>