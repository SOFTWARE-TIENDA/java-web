/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$( document ).ready(function() {
    //initialize modals
     const path = window.location.pathname.split("/")[2];
    showProductos();
     showData();
     showPromociones();
     let id;
     
    
      // MODALS ! ..
        //MODAL LOGIN
      $('#log_in').click(function(event){
          event.preventDefault();
          $('#modal').show();
      });
      $('#item-menu').click(function(event){
    event.preventDefault();
    $('.menu').toggle();
  })
      //show modal promotions
       $('#datatable').on('click','.btn_promocion',function(e){
         e.preventDefault();
             id = $(this).attr("id");
            $('#modal_promotions').show();
            $('.btn-change').text("Cambiar Producto");
            
       });
       //  close modal
         $('#icon_close').on('click',function(e){
             $('#modal').hide();
         });
         $('#close_modal').click(function(e){
             $('#modal_promotions').hide();
         })
           
     // fin modals
     //login user method post ---
     $('#changeOferta').click(function(){
           $('#modal_promotions').show();
           $('.btn-change').text("Cambiar Descuento");
     })
     
     // --- 
      $('#login').submit(function(e){
         e.preventDefault();
          const param={
            email :$('#email').val(),
            password : $('#password').val()
          };
          if(param.email == "" || param.password == ""){
              return errorMessage("complet campos obligatorios");
          }
            $.ajax({
            data: param,
            type: "POST",
            url: "UserController"
        }).done(function(data){ //status => 200
                  window.location.href="dashboard.jsp";
        }).fail(function(data){ // status => 400
             errorMessage(data.responseText);
        });
      });
      // logout user --
       $('#logout_user').click(function(e){
         e.preventDefault();
         $.get('UserController',function(){
               window.location.href="index.jsp";
         });
      });
      function errorMessage(response){
         $('#text_error').text(response);
     }
      
         $('.container_promotion_dashboard').on('click','.btn-change',function(e){
        let param;
        const promociones=[]
          const idpromocion = e.target.id
          const descuento = prompt('Ingrese la oferta del producto');
            if(e.target.textContent === "Cambiar Producto"){
                       param={
                     descuento : descuento,
                     codigoproducto: id,
                     id:idpromocion,
                     action:"changeproducto"
                };
             }else{
                param={
                    id:idpromocion,
                    descuento:descuento,
                    action:"changedescuento"
                };
            }
                $.ajax({
                  data: param,
                  type: "POST",
                  url: "ProductoController"
              }).done(function(data){ //status => 200
                           window.location.href="dashboard.jsp";          
              //$('.container_promotion_dashboard').load(' .container_promotion_dashboard')
              });
            
        });
        
      // PAGE PROMOTIONS AND DASHBOARD
      //show catalogo de productos promociones
      function showPromociones(){
         if(path === "promociones.jsp" || "dashboard.jsp"){
               $.ajax({
            data: {action:"listarpromocion"},
            type: "GET",
            url: "ProductoController"
            }).done(function(data){ //status => 200
                showData(data);
                promociones=data;
                showPromocionesDashboard(data);
            })
         }
    }
      
      //PAGE PROMOCIONES cards promociones
       //show data 
     function showData(data){
        $.each(data,function(key,value){
            $('.container_promotion').append(`
             <div class="card">
         <div class="producto">
           <div align="center" class="circle">
           <p class="costo_anterior">s/${value.precioventa}0</p>
           <div >Oferta</div>
           <div class="costo_real">s/${value.descuento}</div></div>
         </div>
        <div class="imagen">
         <img src="${value.imageUrl}" id="imagen_promocion"> 
         </div>
        </div> 
        `);
        });
      }
      //PAGE DASHBOARD
      // show query data count,max,min
      function showQuerys(){
           $.ajax({
                data:{action:"listarconsultas"},
                type:"GET",
                url:"ProductoController"
            }).done(function(data){
                $('#total_producto').text(data.totalproducto);
                $('#menor_cantidad').text(data.NombreMinimo);
                 $('#mayor_cantidad').text(data.NombreMayor);
            });
      }
       // QUERY 
      function showProductos(){
               if(path==="dashboard.jsp"){
                 $.ajax({
                data:{action:"listarproductos"},
                type:"GET",
                url:"ProductoController"
            }).done(function(data){
                showTableData(data);
                showQuerys();
            });
         }
      }
       
      //show promociones dashboard
      function showPromocionesDashboard(data){
           $.each(data,function(key,value){
            $('.container_promotion_dashboard').append(`
             <div class="card-dashboard-promotion">
               <p class="number_text">${key+1}</p>
           <button type="button" class="btn-change"s id="${key+1}">Cambiar Producto</button>  
          <img
           src="${value.imageUrl}" width="150" height="150"
                />
          <p style="font-size:20px;">Precio : $./ ${value.precioventa}0</p>
          <span style="font-size:19px;">Oferta :  $./${value.descuento}.0</span>
          <p style="font-size:15px;">Fecha Apertura : <span>${value.fecha}</span></p>
          </div>
        `)
        })
      }
        
     
      //  DATA TABLES
        function showTableData(data){
         $.each(data,function(key,value){
                    $('#data_table').append(`<tr>
                     <td>${key+1}</td>
                      <td>${value.nombre}</td>
                         <td>${value.precioventa}</td>
                         <td>${value.cantidad}</td>
                <td><img src="${value.imageUrl}" src="${value.imagenid}" width="100" height="100"</td>
              <td><button  class="btn_promocion" id="${value.codigo}"><i class="fas fa-tag"></i>Promocionar</button></td>
                    </tr>
                    `);
                });
                    
        $("#datatable").DataTable({
                  "lengthMenu": [ 5, 10, 15, 25, 100 ],
        });   
     }
    

    
      
});
