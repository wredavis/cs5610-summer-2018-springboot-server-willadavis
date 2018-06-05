(function () {
    var $usernameFld, $passwordFld;
    var $loginBtn;
    
    var userService = new UserServiceClient();
    
    $(main);

    function main() {
    	$usernameFld = $('#usernameFld');
    	$passwordFld = $('#passwordFld');

    	$loginBtn = $('#loginBtn')
    	.click(login);
    }
    
    function login() {

    	var user = {
    			username: $usernameFld.val(),
    			password: $passwordFld.val()
    	};

    	userService
    	.login(user)
    	.then(success)
    }
    
    function success(response) {
        if (response === null) {
            alert('Try again.');
        } else {
            alert('success');
            goToProfile();
        }
    }
    
    function goToProfile() {
    	var url = "../profile/profile.template.client.html";
        window.location.href = url;
    }
})
