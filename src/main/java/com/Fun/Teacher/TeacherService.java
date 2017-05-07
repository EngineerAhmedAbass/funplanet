package com.Fun.Teacher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	public List<Teacher> GetAllTeachers() {
		List<Teacher> teachers=new ArrayList<>();
		teacherRepository.findAll().forEach(teachers::add);
		return teachers;
	}

	public Teacher GetTeacher(String email) {
		return teacherRepository.findOne(email);
	}

	public void AddTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
		
	}

	public void UpdateTeacher(Teacher teacher, int id) {
		teacherRepository.save(teacher);
		
	}

	public void DeleteTeacher(String mail) {
		teacherRepository.delete(mail);
		
	}
	
	
}
