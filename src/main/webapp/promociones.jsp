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
          <div class="page-promociones">
              <div>

                Bienvenido Jose
            </div>
            <div>
              <div class="card">
                 <h1>Card #1</h1>
             </div>
             <div class="card">
                 <h1>Card #2</h1>
             </div>
            </div>
            <h1>promociones here ...</h1>
            <!-- -->
             <div class="container_promotion">
                    <div id="promotions">
                    </div>
                </div>
             <!-- -->
          </div>
          <jsp:include page="Menu/footer.jsp"></jsp:include>
    </body>
</html>
