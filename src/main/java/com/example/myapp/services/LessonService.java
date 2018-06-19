package com.example.myapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.model.Lesson;
import com.example.myapp.model.Module;
import com.example.myapp.model.Course;


import com.example.myapp.repositories.CourseRepository;
import com.example.myapp.repositories.LessonRepository;
import com.example.myapp.repositories.ModuleRepository;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

public class LessonService {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	ModuleRepository moduleRepository;

	@Autowired
	LessonRepository lessonRepository;

	@GetMapping("/api/course/{cid}/module/{mid}/lesson")
	public Iterable<Lesson> findAllLessonsForModule(@PathVariable("cid") int courseId,
			@PathVariable("mid") int moduleId) {
		Optional<Module> data = moduleRepository.findById(moduleId);
		if (data.isPresent()) {
			Module module = data.get();
			return module.getLessons();
		}
		return null;
	}

	@PostMapping("/api/course/{cid}/module/{mid}/lesson")
	public Lesson createLesson(@PathVariable("cid") int courseId, @PathVariable("mid") int moduleId,
			@RequestBody Lesson lesson) {
		Optional<Module> data = moduleRepository.findById(moduleId);
		if (data.isPresent()) {
			Module module = data.get();
			lesson.setModule(module);
			return lessonRepository.save(lesson);
		}
		return null;
	}

	@DeleteMapping("/api/lesson/{id}")
	public void deleteLesson(@PathVariable("id") int id) {
		lessonRepository.deleteById(id);
	}

}