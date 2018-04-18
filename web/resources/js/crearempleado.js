function validarCrear(){
  with (document.forma){
  if(document.getElementById('nombre').value==''){
    swal('Por favor digite el usuario.');
    return;
    }
    if(document.getElementById('fecha').value==''){
    swal('Por favor digite la fecha de nacimiento.');
    return;
    }
    if(document.getElementById('correo').value==''){
      swal('Por favor digite el correo del usuario');
      return;
    }
    emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
    if (emailRegex.test(document.getElementById('correo').value)) {
      
    } else {
      
      swal('El correo digitado no tiene la estructura adecuada, por favor valide.');
      return;
    }
    if(document.getElementById('cedula').value==''){
    swal('Por favor digite la cedula.');
    return;
    }
    swal({
          title: "Usuario creado correctamente",
          text: "Se ha enviado un correo con su usuario y contraseña",
          type: "success",
          showCancelButton: false,
          confirmButtonClass: "btn-success",
          confirmButtonText: "Ok",
          closeOnConfirm: false
        },
        function(){
         $('#forma').attr('action','crearempleado.html')
        submit();  
        });
    // submit();
  }
}