$(function() {
	// Initialize form validation on the registration form.
	// It has the name attribute "registration"
	$("form[name='login']")
			.validate(
					{
						// Specify validation rules
						rules : {
							// The key name on the left side is the name
							// attribute
							// of an input field. Validation rules are defined
							// on the right side
							username : {
								required : true,
								minlength : 5
							},
							password : {
								required : true,
								minlength : 5
							}
						},
						// Specify validation error messages
						messages : {
							username : {
								required : "Vous devez tapez un nom utilisateur",
								minlength : "Un Username doit etre compris entre 5 et 30 caractéres"
							},
							password : {
								required : "Vous devez tapez une mot de passe ",
								minlength : "Une mot de passe doit etre compris entre 5 et 30 caractéres"
							}

						},
						// Make sure the form is submitted to the destination
						// defined
						// in the "action" attribute of the form when valid
						submitHandler : function(form) {
							form.submit();
						}
					});
});