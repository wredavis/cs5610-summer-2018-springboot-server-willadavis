package com.example.myapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.myapp.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
//	@Query("SELECT * FROM user WHERE username=:username")
//	User findUserByUsername(@Param("username") String username);
//	
//	@Query("SELECT * FROM user WHERE username=:username AND password=:password")
//	User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
