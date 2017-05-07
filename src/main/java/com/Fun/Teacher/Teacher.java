package com.Fun.Teacher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {
	
	@Id
	private String Email;
	private String Pass;
	private String Name;
	private int Age;
	private String Phone;

	public Teacher() {
		super();
	}
	public Teacher(String email, String pass, String name, int age, String phone) {
		super();
		Email = email;
		Pass = pass;
		Name = name;
		Age = age;
		Phone = phone;
	}


	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}
	
	
}
