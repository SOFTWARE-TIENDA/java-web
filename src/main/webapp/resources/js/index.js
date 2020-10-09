/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$( document ).ready(function() {
     const path = window.location.pathname.split("/")[2];
    showProductos();
     showData();
     showPromociones();
     
    console.log("here ...");
         // show modal login 
      $('#log_in').click(function(event){
          event.preventDefault();
          console.log("boom");
          $('#modal').show();
      });
      //show modal promotions
       $('#datatable').on('click','.btn_promocion',function(e){
         e.preventDefault();
             console.log("button");
            $('#modal_promotions').show();
       });
       //  close modal
         $('#icon_close').on('click',function(e){
             $('#modal_promotions').hide();
             $('#modal').hide();
         });
           
     //login user method post ---
      $('#login').submit(function(e){
         e.preventDefault();
         console.log("button");
          const param={
            email :$('#email').val(),
            password : $('#password').val()
          };
            $.ajax({
            data: param,
            type: "POST",
            url: "UserController"
        }).done(function(data){ //status => 200
                  window.location.href="dashboard.jsp";
        }).fail(function(data){ // status => 400
             console.log(data.responseText);
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
      //-- verify path
      function showProductos(){
               if(path==="dashboard.jsp"){
                 $.ajax({
                data:{action:"listarproductos"},
                type:"GET",
                url:"ProductoController"
            }).done(function(data){
                showTableData(data);
                showQuerys();
            }).fail(function(data){
                console.log(data);
                console.log("fail");
            });
         }
      }
      function showQuerys(){
           $.ajax({
                data:{action:"listarconsultas"},
                type:"GET",
                url:"ProductoController"
            }).done(function(data){
                console.log(data);
                console.log(data.NombreMinimo);
                $('#total_producto').text(data.totalproducto);
                $('#menor_cantidad').text(data.NombreMinimo);
                 $('#mayor_cantidad').text(data.NombreMayor);
            }).fail(function(data){
                console.log(data);
                console.log("fail");
            });
      }
      
      function showPromociones(){
          console.log("here promotions");
         if(path === "promociones.jsp" || "dashboard.jsp"){
               $.ajax({
            data: {action:"listarpromocion"},
            type: "GET",
            url: "ProductoController"
            }).done(function(data){ //status => 200
                showData(data);
            }).fail(function(data){ // status => 400
                 console.log(data);
         });
         }
    }
    
     function errorMessage(response){
         $('#error_message').append(`<p style="color:red;">${response}</p>`)
     }
     
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
                    
         $("#datatable").DataTable();
     }

    //show data 
     function showData(data){
        $.each(data,function(key,value){
            $('.container_promotion').append(`
             <div id="card_promotion">
              <img src="${value.imageUrl}" width="150" height="150"/>
            </div>
        `);
        });
      }
    
    
      
});
