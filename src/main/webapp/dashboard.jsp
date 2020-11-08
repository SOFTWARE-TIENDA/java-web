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
          <h1 class="title-user">Bievenido <% out.println(session.getAttribute("usuario")); %> </h1>
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
          <div class="offert_button">
              <h3>Cambiar Ofertas</h3>
              <button id="changeOferta" class="buttom_oferta">Cambiar Ofertas</button>
          </div>
          <div style="overflow-x:auto;">
           <table id="datatable" class="display responsive nowrap" cellspacing="0">
                <thead>
                    <tr>
                       <th style="width:10px;">N</th>
                       <th>Nombre</th>
                       <th style="width:10px;">Precio Venta</th>
                       <th style="width:10px;">Cantidad</th>
                       <th>Imagen</th>
                       <th></th>
                   </tr>
               </thead>
           <tbody id="data_table" style="text-align:center;"></tbody> 
           </table>
          </div>
      <div id="modal_promotions">
         
          <!-- -->
       <div class="body-modal-promotions">
            <div class="head_promotions">
                <button id="close_modal">Cerrar   <i class="fas fa-times"></i> </button>
               <p class="catalogo_promotion">Catalogo de Promociones</p>
          </div>
               <div class="container_promotion_dashboard"></div> 
         <!-- -->
      </div>
      <!-- -->
    </div>
          
          <jsp:include page="Menu/footer.jsp"></jsp:include>
    </body>
</html>
