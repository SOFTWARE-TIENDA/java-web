<%-- 
    Document   : login
    Created on : 03/10/2020, 04:17:58 PM
    Author     : josel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
    <div id="modal">
      <!-- -->
       <div class="body-modal-login">
         <div class="body-modal-header-login">
             <i class="fas fa-times" id="icon_close"></i>
           <img src="resources/images/logo.JPG"/>
           <h3>Inicio de Session</h3>
         </div>
         <!--initialzie form -->
         <div class="body-modal-form-login">
           <form id="login" method="POST">
              <div class="form-group">
             <input type="email"
                    id="email"
                    placeholder="Ingrese correo"
                    class="form-control"/>
             </div>
             <div class="form-group">
               <input type="password"
                      id="password"
                      placeholder="Ingrese password"
                      class="form-control"/>
           </div>
               <div id="error_message"></div>
             <button type="submit" class="btn-login">Log In</button>
           </form>
         </div>
         <!-- -->
      </div>
      <!-- -->
    </div>
    
  </body>
</html>
