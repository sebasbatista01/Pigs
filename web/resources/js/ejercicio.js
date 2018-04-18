function EnviarUsuario(){
	with (document.formlogin){
	var vusuario = $('#usuario').val();
	var vpassword = $('#password').val();

	// var url = $('../indexoficial.html').val();

	console.log(vusuario);
	console.log(vpassword);

	if (vusuario=='diego@gmail.com' && vpassword=='1234') {
			swal({
				  title: "Bienvenido administrador Diego",
				  text: "",
				  type: "success",
				  showCancelButton: false,
				  confirmButtonClass: "btn-success",
				  confirmButtonText: "Ok",
				  closeOnConfirm: false
				},
				function(){
				 $('#formlogin').attr('action','indexoficiales.html');
				 submit();
				});
	} else if (vusuario=='tania@gmail.com' && vpassword=='5678') {
			swal({
				  title: "Bienvenida empleada Tania",
				  text: "",
				  type: "success",
				  showCancelButton: false,
				  confirmButtonClass: "btn-success",
				  confirmButtonText: "Ok",
				  closeOnConfirm: false
				},
				function(){
				 $('#formlogin').attr('action','indexempleado.html');
				 submit();
				});


	}else if (vusuario=='jenny@gmail.com' && vpassword=='4321') {
				swal({
				  title:"Bienvenida cliente jenny",
				  text: "",
				  type: "success",
				  showCancelButton: false,
				  confirmButtonClass: "btn-success",
				  confirmButtonText: "Ok",
				  closeOnConfirm: false
				},
				function(){
				 $('#formlogin').attr('action','indexCliente.html');
				 submit();
				});

	}else{
	if (document.getElementById('password').value=='' &&  document.getElementById('usuario').value=='') {
		swal('Por favor digite correo y contraseña');
    	return;
	}else{
		if(document.getElementById('usuario').value=='diego@gmail.com' ||document.getElementById('usuario').value=='jenny@gmail.com' || document.getElementById('usuario').value=='tania@gmail.com'){
    
    }else{
    	swal('Su correo es incorrecto');
    	return;
    }
    if(document.getElementById('password').value=='1234' || document.getElementById('password').value=='5678' || document.getElementById('password').value=='4321'){
    
    }else{
    	swal('Su contraseña es incorrecta');
    	return;
    }
	}	
	
}
}
}
