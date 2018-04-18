$(document).ready(function() {
    //$('#ejemplo').DataTable();
     $('#ejemplo').DataTable( {
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    } );
} );

$(document).ready(function(){
  $(document).on('click','.delete', function(){
    var row = $(this);

    swal({
      title: "Seguro que quiere borrar este usuario?",
      text: "Recuerde que no podra recuperarlo!",
      type: "warning",
      showCancelButton: true,
      confirmButtonText: "Si, borrar!",
      cancelButtonClass: "btn-danger",
      cancelButtonText: "No, cancelar!",
      closeOnConfirm: false,
      closeOnCancel: false
    },
    function(isConfirm) {
      if (isConfirm) {
        row.parent().parent().remove();
        swal("Borrado!", "El usuario escogido se ha borrado correctamente.", 
        "success");
      } else {
        swal("Cancelado!", "El usuario escogido se salvado exitosamente :)", "error");
      }
    });
  });
$(document).on('click', '.save', function(){
  if(validarAsignaTrea()){
      var parent = $(this).parent().parent();
      var tdUsuario = parent.children("td:nth-child(1)");
      var tdContraseña = parent.children("td:nth-child(2)");
      var tdCorreo = parent.children("td:nth-child(3)");
      var tdCedula = parent.children("td:nth-child(4)");
      var tdFechanacimiento = parent.children("td:nth-child(5)");
      var tdButtons = parent.children("td:nth-child(6)");
      tdUsuario.html(tdUsuario.children("input[type=text]").val());
      tdContraseña.html(tdContraseña.children("input[type=text]").val());
      tdCorreo.html(tdCorreo.children("input[type=email]").val());
      tdCedula.html(tdCedula.children("input[type=text]").val());
      tdFechanacimiento.html(tdFechanacimiento.children("input[type=date]").val());
      tdButtons.html(
        "<button class=\"btn btn-xs btn-danger delete\"><span class=\"icon icon-remove-user\"></span></button>" + " " +
        "<button class=\"btn btn-xs btn-success edit\"><span class=\"icon icon-new-message\"></span></button>"+ " " 
        // "<button class=\"btn btn-xs btn-warning clone\"><i class=\"material-icons\">content_copy</i></button>" + " " +
        // "<button class=\"btn btn-xs btn-success add\"><i class=\"material-icons\">note_add</i></button>"
      );
    }
    });

  $(document).on('click', '.edit', function(){
      var par = $(this).parent().parent(); //trAKDAKLDJ
      var tdUsuario = par.children("td:nth-child(1)");
      var tdContraseña = par.children("td:nth-child(2)");
      var tdCorreo = par.children("td:nth-child(3)");
      var tdCedula = par.children("td:nth-child(4)");
      var tdFechanacimiento = par.children("td:nth-child(5)");
      var tdButtons = par.children("td:nth-child(6)");

      tdUsuario.html("<input type='text' id='txtUsuario' value='"+tdUsuario.html()+"'/>");
      tdContraseña.html("<input type='text' id='txtContraseña' value='"+tdContraseña.html()+"'/>");
      tdCorreo.html("<input type='email' id='txtCorreo' value='"+tdCorreo.html()+"'/>");
      tdCedula.html("<input type='text' id='txtCedula' minlength='8' maxlength='10'  value='"+tdCedula.html()+"'/>");
      tdFechanacimiento.html("<input type='date' id='txtFechanacimiento' value='"+tdFechanacimiento.html()+"'/>");
      tdButtons.html("<button class=\"btn btn-xs btn-success save\"><span class=\"icon icon-save\"></span></button></td>");
    })
  });
function validarAsignaTrea(){
  //with (document.frmAsignaTareas){
  if(document.getElementById('txtUsuario').value==''){
    swal('Por favor digite el nombre del usuario.');
    return false;
    }
    if(document.getElementById('txtContraseña').value==''){
    swal('Por favor digite la contraseña.');
    return false;
    }
    if(document.getElementById('txtCorreo').value==''){
      swal('Por favor digite el correo.');
      return false;
    }
    emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
    if (emailRegex.test(document.getElementById('txtCorreo').value)) {
      
    } else {
      
      swal('El correo digitado no tiene la estructura adecuada, por favor valide.');
      return false;
    }
    if(document.getElementById('txtCedula').value==''){
    swal('Por favor digite la cedula.');
    return false;
    }
  
    if(document.getElementById('txtFechanacimiento').value==''){
    swal('Por favor digite la fecha de nacimiento.');
    return false;
    }
    return true;
  //}
}