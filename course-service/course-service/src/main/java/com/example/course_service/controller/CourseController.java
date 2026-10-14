package com.example.course_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course_service.entity.Course;
import com.example.course_service.repository.CourseRepository;
import java.util.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
	private final CourseRepository repository;
	
	public CourseController(CourseRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	public Course createCourse(@RequestBody Course course) {
		return repository.save(course);
	}
	
	@GetMapping
	public List<Course> getAllCourse() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Course getCourse(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() ->
				new RuntimeException("Course Not Found"));
	}
	
}