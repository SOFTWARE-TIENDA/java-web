<%-- 
    Document   : promociones
    Created on : 25/09/2020, 10:29:18 PM
    Author     : josel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promociones Page</title>
    </head>
    <body>
          <jsp:include page="Menu/navbar.jsp"></jsp:include>
            <img src="resources/images/imagen_background.png" class="imagen_background_initial" alt=""/>
            <!-- -->
            <div class="text-title">
                <span class="chip-text">Promociones</span>
                  <div class="chip-line">
                  <hr class="line"> 
                    <i class="fas fa-circle" id="circle-chip"></i>
                </div>
              </div>
             <div class="container_promotion">
                    <div id="promotions">
                    </div>
                </div>
             <!-- -->
          <jsp:include page="Menu/footer.jsp"></jsp:include>
    </body>
</html>
