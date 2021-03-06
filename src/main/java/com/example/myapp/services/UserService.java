package com.example.myapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;

import com.example.myapp.model.User;
import com.example.myapp.repositories.UserRepository;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserService {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/api/user")	
	public Iterable<User> findAllUsers() {
		return userRepository.findAll();
	}

	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		System.out.println(user.getFirstName());
		return userRepository.save(user);
	}

	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable("userId") int id) {
		return userRepository.findById(id).get();
	}

	@GetMapping("/api/users/{username}")
	public User findUserByUsername(@RequestBody String username) {
		return userRepository.findUserByUsername(username);
	}

//	@PutMapping("/api/user/{userId}")
//	public User updateUser(@PathVariable("userId") int id, @RequestBody User newUser) {
//
//		User user = userRepository.findById(id).get();
//		user.set(newUser);
//
//		return userRepository.save(user);
//	}
	
	@PutMapping("/api/user{userId}")
	public User updateUser(@PathVariable("userId") int userId, @RequestBody User newUser) {
		Optional<User> data = userRepository.findById(userId);
		if (data.isPresent()) {
			User user = data.get();
			user.setFirstName(newUser.getFirstName());
			user.setLastName(newUser.getLastName());
			user.setEmail(newUser.getEmail());
			user.setRole(newUser.getRole());
			user.setPhone(newUser.getPhone());
			userRepository.save(user);
			return user;
		}
		else return null;
	}

	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		userRepository.deleteById(id);
	}

	@PostMapping("/api/register")
	public User register(@RequestBody User user, HttpSession session) {
		return createUser(user);
	}

//	@PostMapping("/api/login")
//	public User login(@RequestBody User user, HttpSession session) {
//		User loginUser = userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
//		if (loginUser == null) {
//			return null;
//		}
//		else session.setAttribute("Current User", loginUser);
//
//		return user;
//	}

	@PostMapping("/api/login")
	public User login(@RequestBody User user) {
		return userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
	
	@PutMapping("/api/profile")
	public User updateProfile(@RequestBody User user, HttpSession session) {
		User currentUser = (User) session.getAttribute("Current User");

		if (currentUser == null) {
			return null;
		}
		else {
			currentUser.setPassword(user.getPassword());
			currentUser.setDateOfBirth(user.getDateOfBirth());
			currentUser.setEmail(user.getEmail());
			currentUser.setFirstName(user.getFirstName());
			currentUser.setLastName(user.getLastName());
			currentUser.setPhone(user.getPhone());
			currentUser.setRole(user.getRole());
			userRepository.save(currentUser);

			return currentUser;
		}
	}

	@PostMapping("/api/logout")
	public void logout(HttpSession session) {
	session.removeAttribute("Current User");
	}
}

