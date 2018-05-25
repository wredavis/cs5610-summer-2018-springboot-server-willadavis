

function User(username, password, firstName, lastName, email, phone, role, dateOfBirth) {
	this.username = username;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phone = phone;
	this.role = role;
	this.dateOfBirth = dateOfBirth;
}

this.setUsername = setUsername;
this.getUsername = getUsername;

this.setPassword = setPassword;
this.getPassword = getPassword;

this.setFirstName = setFirstName;
this.getFirstName = getFirstName;

this.setLastName = setLastName;
this.getLastName = getLastName;

this.setEmail = setEmail;
this.getEmail = getEmail;

this.setPhone = setPhone;
this.getPhone = getPhone;

this.setRole = setRole;
this.getRole = getRole;

this.setDateOfBirth = setDateOfBirth;
this.getDateOfBirth = getDateOfBirth;


function setUsername(username) {
	this.username = username;
}
function getUsername() {
	return this.username;
}

function setPassword(password) {
	this.password = password;
}
function getPassword() {
	return this.password;
}

function setFirstName(firstName) {
	this.firstName = firstName;
}
function getFirstName() {
	return this.firstName;
}

function setLastName(lastName) {
	this.lastName = lastName;
}
function getLastName() {
	return this.lastName;
}

function setEmail(Email) {
	this.Email = Email;
}
function getEmail() {
	return this.Email;
}

function setRole(Role) {
	this.Role = Role;
}
function getRole() {
	return this.Role;
}

function setPhone(Phone) {
	this.Phone = Phone;
}
function getPhone() {
	return this.Phone;
}

function setDateOfBirth(DateOfBirth) {
	this.DateOfBirth = DateOfBirth;
}
function getDateOfBirth() {
	return this.DateOfBirth;
}

}