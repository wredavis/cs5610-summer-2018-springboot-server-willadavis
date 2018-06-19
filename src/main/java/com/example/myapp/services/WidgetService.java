package com.example.myapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.model.Lesson;
import com.example.myapp.model.Widget;
import com.example.myapp.repositories.LessonRepository;
import com.example.myapp.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class WidgetService {
	
	@Autowired
	WidgetRepository widgetRepository;
	
	@Autowired
	LessonRepository lessonRepository;
	
	@PostMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/widget")
	public Widget createWidget(@PathVariable("lessonId") int lessonId,
			@RequestBody Widget newWidget) {
		
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		
		if(data.isPresent()) {
			Lesson lesson = data.get();
			newWidget.setLesson(lesson);
			return widgetRepository.save(newWidget);
		}
		return null;		
	}
	
	@GetMapping("/api/lesson/{lessonId}/widget")
	public List<Widget> findAllWidgetsForLesson(@PathVariable("lessonId") int lessonId) {
		Optional<Lesson> optionalLesson = lessonRepository.findById(lessonId);
		if(optionalLesson.isPresent()) {
			Lesson lesson = optionalLesson.get();
			return lesson.getWidgets();
		}
		return null;
	}
	
	@PostMapping("/api/widget/save")
	public void saveAllWidgets(@RequestBody List<Widget> widgets) {
		widgetRepository.deleteAll();
		
		for(Widget widget: widgets) {
			widgetRepository.save(widget);
		}
	}
	
	@GetMapping("/api/widget")
	public List<Widget> findAllWidgets() {
		return (List<Widget>) widgetRepository.findAll();
	}
	
	@GetMapping("/api/widget/{widgetId}")
	public Widget findWidgetById(@PathVariable("widgetId") int widgetId) {
		Optional<Widget> data = widgetRepository.findById(widgetId);
		if(data.isPresent()) {
			return data.get();
		}
		return null;
	}	
	
	@PutMapping("/api/widget/{widgetId}")
	public Widget updateWidget(@PathVariable("widgetId") int widgetId,@RequestBody Widget newWidget) {
		Optional<Widget> data= widgetRepository.findById(widgetId);
		if(data.isPresent()) {
			Widget widget = data.get();
			widget.setId(newWidget.getId());
			widget.setText(newWidget.getText());
			widget.setWidgetType(newWidget.getWidgetType());
			widget.setName(newWidget.getName());
			widget.setOrder(newWidget.getOrder());
			widget.setClassName(newWidget.getClassName());
			widget.setStyle(newWidget.getStyle());
			widget.setHeight(newWidget.getHeight());
			widget.setWidth(newWidget.getWidth());
			
			return widgetRepository.save(widget);
		}
		return null;
	}
	
	@DeleteMapping("/api/widget/{widgetId}")
	public void deleteWidget(@PathVariable("widgetId") int widgetId){
		widgetRepository.deleteById(widgetId);
	}
}