package com.student.model;

public class Student {

	private String name;
	private Integer id;
	private Integer age;
	private String gender;
	private Long mobile_number;
	private String email;
	private String branch;

	public Student(String name, Integer id, Integer age, String gender, Long mobile_number, String email,
			String branch) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.mobile_number = mobile_number;
		this.email = email;
		this.branch = branch;
	}

	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Student_Pojo_Object [name=" + name + ", id=" + id + ", age=" + age + ", gender=" + gender + ", mobile_number="
				+ mobile_number + ", email=" + email + ", branch=" + branch + "]";
	}

}


	


