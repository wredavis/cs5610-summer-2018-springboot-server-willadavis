(function() {
	$(init);

	var $staticEmail;
	var $firstNameFld;
	var $lastNameFld;
	var $updateBtn;
	var $emailFld;
	var $roleFld;
	var $phoneFld;
	var $dateOfBirthFld;
	
	var userService = new UserServiceClient();

	function init() {
		$staticEmail = $("#staticEmail");
		$firstNameFld = $("#firstName");
		$lastNameFld = $("#lastName");
		$phoneFld = $("#phone");
		$emailFld = $("#email")
		$roleFld = #("#role");
		
		$updateBtn = $("#updateBtn")
		.click(updateUser);		
		findUserById(162);

        $logoutBtn = $('#logoutBtn')
        .click(logout);
        
	}
	
	function updateUser() {
		var user = {
				firstName: $firstName.val(),
				lastName: $lastName.val()
				phone: $phone.val();
				email: $email.val();
				role: $role.val();
				
						
		};
		
		userService
			.updateProfile(162, user)
			.then(success);
	}
	
	function success(response) {
		if(response === null) {
			alert('unable to update')
		}
		else {
		alert('success');
		}
	}
	
	function findUserById(userId) {
		userService
		.findUserById(userId)
		.then(renderUser);
	}
	
	function renderUser(user) {
		console.log(user);
		$staticEmail.val(user.email);
		$firstNameFld.val(user.firstName);
		$lastNameFld.val(user.lastName);
		$roleFld.val(user.role);
		$phoneFld.val(user.phone);
		$dateOfBirthFld.val(user.dateOfBirth);
	}

	function logout() {
		userService
		.logout();
		
		var url = "../login/login.template.client.html";
	}

}
)

