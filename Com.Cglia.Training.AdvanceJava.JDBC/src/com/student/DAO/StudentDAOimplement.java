package com.student.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.student.model.Student;

public class StudentDAOimplement implements StudentDAO{
	@Override
	public int insertStudent(Student student) {
	    try {
	        Connection con = DBconnection.DBconn();
	        String query = "INSERT INTO student (id, name, age, gender, mobileNumber, email, branch) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement stm = con.prepareStatement(query);
	        stm.setInt(1, student.getId()); // Set the ID
	        stm.setString(2, student.getName());
	        stm.setInt(3, student.getAge());
	        stm.setString(4, student.getGender());
	        stm.setLong(5, student.getMobile_number());
	        stm.setString(6, student.getEmail());
	        stm.setString(7, student.getBranch());
	        return stm.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return -1; // Return -1 if insertion fails
	}



	@Override
	public Student retriveStudentById(int id) {
		Student std = null;
		try {
			   Connection con =  DBconnection.DBconn();
			   String query = "SELECT * FROM student WHERE id = ?";
	           PreparedStatement stm = con.prepareStatement(query);
	           stm.setInt(1, id);
	           ResultSet result = stm.executeQuery();
	           if (result.next()) {
	               std = new Student();
	               std.setName(result.getString("name"));
	               std.setId(result.getInt("id"));
	               std.setAge(result.getInt("age"));
	               std.setGender(result.getString("gender"));
	               std.setMobile_number(result.getLong("mobileNumber"));
	               std.setEmail(result.getString("email"));
	               std.setBranch(result.getString("branch"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return std;
	}

	
	@Override
	public List<Student> showAllStudents() {
		List<Student> allStd = new ArrayList<Student>();
		try {
			Connection con = DBconnection.DBconn();
		    String query = "SELECT * FROM student";
		    PreparedStatement stm = con.prepareStatement(query);
		    ResultSet result = stm.executeQuery();
		    while (result.next()) {
		        Student student = new Student();
		        student.setName(result.getString("name"));
		        student.setId(result.getInt("id"));
		        student.setAge(result.getInt("age"));
		        student.setGender(result.getString("gender"));
		        student.setMobile_number(result.getLong("mobileNumber"));
		        student.setEmail(result.getString("email"));
		        student.setBranch(result.getString("branch"));
		        allStd.add(student);
		       }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return allStd;
	}
	
	@Override
	public Map<String, Integer> countMaleAndFemaleStudents() {
		Map<String, Integer> gender = new HashMap<>();
		try {
			Connection con =DBconnection.DBconn();
			String query = "SELECT gender, COUNT(*) AS count FROM student GROUP BY gender";
		    PreparedStatement stm = con.prepareStatement(query);
		    ResultSet rs = stm.executeQuery();
		    while (rs.next()) {
		        String gen = rs.getString("gender");
		        int count = rs.getInt("count");
		        gender.put(gen, count);
		    }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return gender;
	}

	@Override
	public boolean deleteStudentById(int id) {
		try {
			Connection con = DBconnection.DBconn();
			String query = "DELETE FROM student WHERE id = ?";
			PreparedStatement stm = con.prepareStatement(query);
		    stm.setInt(1, id); 
		    return stm.executeUpdate() > 0; 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteStudentbyNum(Long number) {
	    try {
	    	Connection con = DBconnection.DBconn();
		    String query = "DELETE FROM student WHERE mobile_number = ?";
	        PreparedStatement stm = con.prepareStatement(query);
	        stm.setLong(1, number);
	        return stm.executeUpdate() > 0;
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	@Override
	public Map<String, Integer> displayCountByBranchName() {
		Map<String, Integer> count = new HashMap<>();
		try {
			Connection con = DBconnection.DBconn() ;
		    String query = "SELECT branch, COUNT(*) AS count FROM student GROUP BY branch";
		    PreparedStatement stm = con.prepareStatement(query);
		    ResultSet rs = stm.executeQuery();
		    while (rs.next()) {
		    	 String branch = rs.getString("branch");
			     int number = rs.getInt("count");
			     count.put(branch, number);
		    }
		       
		} 
		catch (Exception e) {
			 e.printStackTrace();
		}
		return count;
		
	}
}
