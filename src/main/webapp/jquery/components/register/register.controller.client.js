(function () {
	var $usernameFld, $passwordFld, $verifyPasswordFld;
	var $registerBtn, $loginBtn;
	var userService = new UserServiceClient();

	$(main);

	function main() {
		$usernameFld = $('#usernameFld');
		$passwordFld = $('#passwordFld');
		$verifyPasswordFld = $('#verifyPasswordFld');

		$registerBtn = $('#registerBtn');
		$registerBtn
		.click(register);

		$loginBtn = $('#loginBtn');
		$loginBtn
		.click(goToLogin);
	}

	function register() {
		$usernameFld = $("#usernameFld");
		$passwordFld = $("#passwordFld");

		$registerBtn = $("#registerBtn")
		.click(register);

		var user = {
				username: $usernameFld.val(),
				password: $passwordFld.val()
		};
		userService
		.register(user)
		.then(success);
	}
	
    function goToLogin() {
        var url = "../login/login.template.client.html";
        window.location.href = url;
    }

	function success(response) {
		if (response == null) {
			alert('Errors exist.')
		} else {
			alert('Success')
		}
	})
