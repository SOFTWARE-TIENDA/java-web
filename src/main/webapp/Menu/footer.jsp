<%-- 
    Document   : footer
    Created on : 25/09/2020, 10:31:30 PM
    Author     : josel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
         <jsp:include page="login.jsp"></jsp:include>
      <footer>
            <p class="text-footer-tittle">Informacion</p>
      <div class="main-content">
        <!-- left box -->
        <div class="left box">
          <div class="content">
            <div class="phone">
  <icon><i class="fas fa-phone"></i></icon>
     <span class="text"> 987-548-495</span>
              </div>
            <div class="email">
           <icon1> <i class="fas fa-envelope"></i></icon1>
              <span class="text">correo@hotmail.com</span>
          </div>
            </div>
          </div>
        <!-- close left-->
        <!-- right box -->
        <div class="right box">
          <div class="content">
            <div class="phone2">
<icon2><i class="fas fa-phone"></i></icon2>     
<span class="text">987-548-495</span>
            </div>
            <div class="email2">
          <icon3> <i class="fas fa-envelope"></i></icon3>
<span class="text">correo@hotmail.com</span> 
            </div>
          </div>
        </div>
        <!-- close right -->
      </div>
      </footer>
    </body>
    <script src="resources/js/index.js"></script>
</html>
