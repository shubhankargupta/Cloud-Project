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
    body { background-image:url(patient2.jpg);
           background-size:cover;}
    </style>
    </head>
    <body>
        <form action="Patient" method="GET">
    <center><h2>Enter the symptom below:</h2></center>
    <center><br><b>SYMPTOM:<input type="text" name="symptom"/>
    <center><h2>Enter your blood group to check the availability in the blood bank:</h2></center>
    <center><br><b>BLOOD GROUP:<input type="text" name="blood"/>    
        <center><br><input type="submit" value="Submit"/>    
            <center><br><b><a href="LoginJSP.jsp">Logout</a></b></center>
        
        </form>
    </body>  
      
</html>       
    

   

