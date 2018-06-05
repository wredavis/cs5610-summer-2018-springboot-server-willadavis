package com.example.myapp.repositories;
import org.springframework.data.repository.CrudRepository;
import com.example.myapp.model.Module;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ModuleRepository
  extends CrudRepository<Module, Integer>{
	
	
}
