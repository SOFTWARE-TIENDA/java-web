<%-- 
    Document   : navbar
    Created on : 25/09/2020, 07:38:19 PM
    Author     : josel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="resources/js/jquery-3.5.1.min.js"/>
        <script src="https://kit.fontawesome.com/649d61341c.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/649d61341c.js" crossorigin="anonymous"></script>
       <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>
           <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
        
          <link rel="stylesheet" href="resources/css/index.css"/>
          <link rel="stylesheet" href="resources/css/page2.css"/>
          <link rel="stylesheet" href="resources/css/page3.css"/>
    </head>
    <body>
         <a href="index.jsp">Home</a></br>
        <a href="promociones.jsp">Promociones</a>
          <a href="dashboard.jsp">Dashboar</a>
        <% 
         if(session.getAttribute("usuario") != null){
          %>
          <p><% out.println(session.getAttribute("usuario")); %></p>
            <a href="#" id="logout_user">Logout</a>
          <%
         }else{
            %>
            <a href="#" id="log_in">Log In</a>
            <p>User don't exists</p>
         <%   
        }
        %>
    </body>
</html>
