package com.studentservice.service;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import com.student.model.Student;


	public class StudentService {
	    private List<Student> studentList;

	    public StudentService() {
	        studentList = new ArrayList<>();
	    }

	    public int createStudent(Student student) {
	        studentList.add(student);
	        return student.getId();
	    }

	    public Student findStudentById(Integer id) {
	        for (Student student : studentList) {
	            if (student.getId().equals(id)) {
	                return student;
	            }
	        }
	        return null;
	    }

	    public List<Student> showAllStudents() {
	        return studentList;
	    }

	    public Map<String, Integer> countMaleAndFemaleStudents() {
	        Map<String, Integer> countMap = new HashMap<>();
	        int maleCount = 0;
	        int femaleCount = 0;
	        for (Student student : studentList) {
	            if (student.getGender().equalsIgnoreCase("M")) {
	                maleCount++;
	            } else if (student.getGender().equalsIgnoreCase("F")) {
	                femaleCount++;
	            }
	        }
	        countMap.put("Male", maleCount);
	        countMap.put("Female", femaleCount);
	        return countMap;
	    }

	    public boolean deleteStudentById(Integer id) {
	        Iterator<Student> iterator = studentList.iterator();
	        while (iterator.hasNext()) {
	            Student student = iterator.next();
	            if (student.getId().equals(id)) {
	                iterator.remove();
	                return true;
	            }
	        }
	        return false;
	    }

	    public Map<String, Integer> displayCountByBranchName() {
	        Map<String, Integer> branchCountMap = new HashMap<>();
	        for (Student student : studentList) {
	            String branch = student.getBranch();
	            branchCountMap.put(branch, branchCountMap.getOrDefault(branch, 0) + 1);
	        }
	        return branchCountMap;
	    }
	}

