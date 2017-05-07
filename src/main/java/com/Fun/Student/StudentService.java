package com.Fun.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fun.Teacher.Teacher;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> GetAllStudents() {
		List<Student> students=new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		return students;
	}

	public Student GetStudent(String mail) {
		return studentRepository.findOne(mail);
	}

	public void AddStudent(Student student) {
		studentRepository.save(student);
		
	}

	public void UpdateStudent(Student student, int id) {
		studentRepository.save(student);
		
	}

	public void DeleteStudent(String mail) {
		studentRepository.delete(mail);
		
	}
	
	
}
