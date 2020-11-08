<%-- 
    Document   : login
    Created on : 03/10/2020, 04:17:58 PM
    Author     : josel
--%>
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
                    class="form-control" required/>
             </div>
             <div class="form-group">
               <input type="password"
                      id="password"
                      placeholder="Ingrese password"
                      class="form-control" required/>
           </div>
               <div id="error_message"><p id="text_error"></p></div>
             <button type="submit" class="btn-login">Log In</button>
           </form>
         </div>
         <!-- -->
      </div>
      <!-- -->
    </div>
