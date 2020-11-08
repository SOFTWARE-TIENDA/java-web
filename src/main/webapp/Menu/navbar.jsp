<%-- 
    Document   : navbar
    Created on : 25/09/2020, 07:38:19 PM
    Author     : josel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="resources/js/jquery-3.5.1.min.js"></script>
        <script src="https://kit.fontawesome.com/649d61341c.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no">

       <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>
           <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
        
          <link rel="stylesheet" href="resources/css/index.css"/>
            <link rel="stylesheet" href="resources/css/page1.css"/>
          <link rel="stylesheet" href="resources/css/page2.css"/>
          <link rel="stylesheet" href="resources/css/page3.css"/>
    </head>
    <body>
         
        <!-- bruno component -->

<nav class="nav">
        <label class="logo"><img src="https://i.postimg.cc/RFpCqFzJ/Whats-App-Image-2020-10-06-at-9-29-49-AM.jpg">
        </label>
       <i class="fas fa-bars" id="item-menu"></i>
      <ul class="menu">
        <!--quitar el color -->
        <li class="menu_link"><a  class="nav-item" href="index.jsp">Inicio</a></li>
        <li class="menu_link"><a class="nav-item" href="promociones.jsp">Promociones</a></li>
        
          <% 
         if(session.getAttribute("usuario") != null){
          %>
         <li class="menu_link"><a class="nav-item"  href="dashboard.jsp">Dashboard</a></li>
         <li class="menu_link" id="logout_user"><a style="color:red" class="nav-item" href="#">Logout</a></li>
          <%
         }else{
            %>
          <li class="menu_link"><a id="log_in" class="nav-item" href="#">Iniciar Sesion</a></li>
         <%   
        }
        %>
        
        </ul>
      </nav>
        
    </body>
</html>
