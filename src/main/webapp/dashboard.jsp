<%-- 
    Document   : dashboard
    Created on : 03/10/2020, 12:37:02 AM
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
             <% 
                if(session.getAttribute("usuario") == null){
                    response.sendRedirect("index.jsp");
                }
            %>
          <jsp:include page="Menu/navbar.jsp"></jsp:include>
          <h1 style="text-align: center;">Bievenido <% out.println(session.getAttribute("usuario")); %> </h1>
          <!--tarea de cards ... -->
                <div class="container-query">
                  <div class="card-query">
                  <i class="fas fa-list" id='icon_list'></i>
                   <div class="text-card">
                     <p class="text-card-dashboard-tittle">Total de producto:</p>
                   <span class="text-quer-dashboard" id="total_producto"></span>
                  </div>
                </div>
                <!-- -->
                  <div class="card-query">
                  <i class="fas fa-exclamation-triangle" id='icon_list'></i>

                   <div class="text-card">
                     <p class="text-card-dashboard-tittle">Producto que tiene menor cantidad:</p>
                   <span class="text-quer-dashboard" id="menor_cantidad"></span>
                  </div>
                </div>
                <!-- -->
                  <div class="card-query">
                  <i class="fas fa-exclamation-triangle" id='icon_list'></i>
                   <div class="text-card">
                     <p class="text-card-dashboard-tittle">Producto que tiene mayor cantidad:</p>
                   <span class="text-quer-dashboard" id="mayor_cantidad"></span>
                  </div>
                </div>
                <!-- -->
                </div>
           <table id="datatable" class="display nowrap cell-border" cellspacing="0">
                <thead>
                    <tr>
                       <th style="width:10px;">N</th>
                       <th>Nombre</th>
                       <th style="width:10px;">Precio Venta</th>
                       <th style="width:10px;">Cantidad</th>
                       <th>Image</th>
                       <th></th>
                   </tr>
               </thead>
               <tbody id="data_table" style="text-align:center;"></tbody>
           </table>
          
          
      <div id="modal_promotions">
      <!-- -->
       <div class="body-modal-promotions">
            <div class="container_promotion">
                <i class="fas fa-times" id="icon_close"></i>
                    <div id="promotions">
                    </div>
                </div>
         <!-- -->
      </div>
      <!-- -->
    </div>
          
          <jsp:include page="Menu/footer.jsp"></jsp:include>
    </body>
</html>
