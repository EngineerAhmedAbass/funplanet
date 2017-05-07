package com.Fun.Course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> GetCourse(String id) {
		List<Course> courses=new ArrayList<>();
		courseRepository.findByTeacherId(id)
		.forEach(courses::add);
		return courses;
	}

	public void AddCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepository.save(course);
	}

	public Course GetCourse(int id)
	{
		return courseRepository.findOne(id);
	}
	public List<Course> GetCourses() {
		List<Course> courses=new ArrayList<>();
		courseRepository.findAll()
		.forEach(courses::add);
		return courses;

	}
	
}
