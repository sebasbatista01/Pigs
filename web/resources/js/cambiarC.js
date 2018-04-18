function EnviarUsuario(){
	with (document.formlogin){
		var vpassword = $('#password').val();
		var vpasswordNuevo = $('#contraN').val();
		var vpasswordConfirmar = $('#contraNR').val();

	// var url = $('../indexoficial.html').val();

	console.log(vpassword);
	if (vpassword=='' &&  vpasswordNuevo=='' &&  vpasswordConfirmar=='' ) {
		swal(
			'Oops...',
			'Por favor digite las contraseñas',
			'error'
			)
	}else{
		if (vpassword=='1234' && vpasswordNuevo==vpasswordConfirmar) {
			swal({
				title: "Contraseña ha sido cambiada correctamente",
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
		}else if(vpasswordNuevo!=vpasswordConfirmar) {
			swal(
				'Oops...',
				'Las nuevas contraseñas no coinciden.',
				'error'
				)
		}else if(vpassword!='1234') {
		swal(
			'Oops...',
			'La contraseña anterior no coincide.',
			'error'
			)
	}

}
}
}






