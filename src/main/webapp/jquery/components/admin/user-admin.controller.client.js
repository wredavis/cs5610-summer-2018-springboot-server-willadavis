(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld;
    var $userRowTemplate, $tbody;
    var userService = new UserServiceClient();

    $(main);
    
    function main() {
        $usernameFld = $('#usernameFld');
        $passwordFld = $('#passwordFld');
        $firstNameFld = $('#firstNameFld');
        $lastNameFld = $('#lastNameFld');

        $tbody = $('.wbdv-tbody');
        $userRowTemplate = $('.wbdv-template');

        $createBtn = $('#createUser');
        $createBtn.click(createUser);

        $editBtn = $('#updateUser')
        $editBtn.click(updateUser);

        $removeBtn = $('#deleteUser');
        $removeBtn.click(deleteUser);

        $('#searchUser').click();

        findAllUsers();
    }

    function findAllUsers() {
        userService
            .findAllUsers()
            .then(renderUsers);
    }

    function renderUsers(users) {
        $tbody.empty();
        for (var u in users) {
            var user = users[u];
            var $row = $userRowTemplate.clone();
            $row.attr('id', user.id);
            $row.find('.wbdv-username').html(user.username);
            $row.find('.wbdv-password').html(user.password);
            $row.find('.wbdv-first-name').html(user.firstName);
            $row.find('.wbdv-last-name').html(user.lastName);
            $row.find('.wbdv-role').html(user.role);
            $row.find('.wbdv-remove').click(deleteUser);
            $row.find('.wbdv-edit').click(editUser);

            $tbody.append($row);
        }

    }
    
    function createUser() {
        var username = $('#usernameFld').val();
        var password = $('#passwordFld').val();
        var firstName = $('#firstNameFld').val();
        var lastName = $('#lastNameFld').val();
        var role = $('#roleFld').val();

        var user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
        };

        userService.createUser(user).then(findAllUsers);
    }

    function editUser(event) {
    	$editBtn = $(event.currentTarget);
    	var userId = $editBtn
    		.parent()
    		.parent()
    		.parent()
    		.attr('id');
    	userService
    		.findUserById(userId)
    		.then(renderUser);
    }

    function deleteUser(event) {
        $removeBtn = $(event.currentTarget);
        var userId = $removeBtn
            .parent()
            .parent()
            .parent()
            .attr('id');
        userService
            .deleteUser(userId)
            .then(findAllUsers);
    }

    function renderUser(user) {
        document.getElementById("usernameFld").value = user.username;
        document.getElementById("passwordFld").value = user.password;
        document.getElementById("firstNameFld").value = user.firstName;
        document.getElementById("lastNameFld").value = user.lastName;
        document.getElementById("roleFld").value = user.role;
        
        console.log(user);

        $updateBtn = $('#update');
        $updateBtn.click(function() {
            $usernameFld = $('#usernameFld').val();
            $passwordFld = $('#passwordFld').val();
            $firstNameFld = $('#firstNameFld').val();
            $lastNameFld = $('#lastNameFld').val();
            $roleFld = $('#roleFld').val();

            var new_user = {
                username: $usernameFld,
                password: $passwordFld,
                firstName: $firstNameFld,
                lastName: $lastNameFld,
                role: $roleFld
            };

            userService
                .updateUser(user.id, new_user)
                .then(findAllUsers);

            $('#usernameFld').val("");
            $('#passwordFld').val("");
            $('#firstNameFld').val("");
            $('#lastNameFld').val("");
            $('#roleFld').val("");
        });
    }


    function updateUser(event) {
    	
    }

    function findUserById() {
    	return userService.findUserById(userId);
    }

}());