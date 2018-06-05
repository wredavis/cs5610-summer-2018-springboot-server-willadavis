function UserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.register = register;
    this.updateUser = updateUser;
    this.login = login;
    
    this.loginUrl = 'http://localhost:8080/api/login';
    this.url = 'http://localhost:8080/api/user';
    var self = this;

    function createUser(user) {
        console.log(user);

        return fetch(self.url, {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        });
    }
    
    function findAllUsers(callback) {
    	   return $.ajax({
    	       url: self.url,
    	       success: callback
    	   })
    	}
    
    function findUserById(userId) {
    	   return fetch(
    	      self.url + '/' + userId);
    	}

    function updateUser(userId, user) {
    	   return fetch(self.url + '/' + userId, {
    	       method: 'PUT',
    	       body: JSON.stringify(user)
    	   });
    	}

    function deleteUser(userId, callback) {
    	   return fetch(
    	       self.url + '/' + userId,
    	       { method: 'DELETE' }
    	   );
    	}

//    function login(user) {
//        return fetch('http://localhost:8080/api/login', {
//            method: 'post',
//            body: JSON.stringify(user),
//            headers: {
//                'content-type': 'application/json'
//            }
//        });
//    }
    
    function login(user) {
    	return fetch(self.loginUrl, {
    		method: 'post',
    		body: JSON.stringify({username:username, password:password}),
    		headers: {
    			'content-type': 'application/json'
    		}
    	})
    }

    function register(user) {
    	return fetch('http://localhost:8080/api/register', {
    		method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
		});
	}
}