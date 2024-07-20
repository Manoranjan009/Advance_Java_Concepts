package com.student.DAO;

import java.util.List;
import java.util.Map;

import com.student.model.Student;

public interface StudentDAO {
	int insertStudent(Student student);
	Student retriveStudentById(int id);
	List<Student> showAllStudents();
	Map<String, Integer> countMaleAndFemaleStudents();
	boolean deleteStudentById(int id);
	boolean deleteStudentbyNum(Long number);
	Map<String,Integer> displayCountByBranchName();
}
