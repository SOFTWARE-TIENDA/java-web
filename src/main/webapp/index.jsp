<%-- 
    Document   : index
    Created on : 25/09/2020, 10:25:20 PM
    Author     : josel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <jsp:include page="Menu/navbar.jsp"></jsp:include>
            <div class="container">
                 <!-- card about-->
                <div class="text-title">
                <span class="chip-text">Que Somos</span>
                  <div class="chip-line">
                  <hr class="line"> 
                    <i class="fas fa-circle" id="circle-chip"></i>
                </div>
              </div>
                
             <div class="card-about">
            <img class="image-about" src="resources/images/imageninicial.jpeg"/>
            <p class="text-about">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem I
          psum has been the industry's standard
           dummy text 
          ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book</p>
              </div>
                <!-- card information-->
                <div class="text-title">
                <span class="chip-text">Información</span>
                  <div class="chip-line">
                  <hr class="line"> 
                    <i class="fas fa-circle" id="circle-chip"></i>
                </div>
              </div>
                 <div class="container-information">
        <div class="oval">
          <h1>Mision</h1> 
     <div class="letra2"> Brindar a los clientes productos de alta calidad que se ajuste a cada uno de ellos.</div>
        </div>
                       <br/>
      <div class="oval2">
        <h1>Vision</h1>
       <div class="letra2">Ser reconocidos como el líder en ventas, también ser la primera 
           alternativa para los clientes y llegar a cada parte del Perú. </div>
       </div>
    </div>  
                <br/>
                <!-- card ubicacio-->
         <div class="text-title">
                <span class="chip-text">Ubicación</span>
                  <div class="chip-line">
                  <hr class="line"> 
                    <i class="fas fa-circle" id="circle-chip"></i>
                </div>
              </div>
        
         <div class="ubicacion-box">
        <iframe 
          class="ubicacion"
          src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3940.1888422583547!2d-77.81217908565895!3d-9.046532295811316!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x91a953be90cf6b81%3A0xd9a6c713f84d3dcf!2sSanta%20Cruz%20316%2C%20Caraz%2002167!5e0!3m2!1ses!2spe!4v1602717978284!5m2!1ses!2spe"  
          height="600" frameborder="205" style="border:0;" allowfullscreen="" 
                aria-hidden="false" tabindex="0">
        </iframe>
          </div>
            </div>

          <jsp:include page="Menu/footer.jsp"></jsp:include>
    </body>
</html>
