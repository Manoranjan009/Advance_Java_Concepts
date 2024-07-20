package com.student.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.student.model.Student;
import com.studentservice.service.StudentService;


public class StudentView {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add student");
            System.out.println("2. Display all students");
            System.out.println("3. Display student by id");
            System.out.println("4. Display number of male and female students");
            System.out.println("5. Remove student");
            System.out.println("6. Display number of students by branch wise");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter Student name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter id: ");
                    Integer id = sc.nextInt();

                    System.out.print("Age: ");
                    Integer age = sc.nextInt();

                    System.out.print("Gender (M/F): ");
                    String gender = sc.next();

                    System.out.print("Mobile Number: ");
                    Long mobileNumber = sc.nextLong();

                    System.out.print("Email: ");
                    String email = sc.next();

                    System.out.print("Branch: ");
                    String branch = sc.next();

                    // Create a new student object
                    Student student = new Student(name, id, age, gender, mobileNumber, email, branch);

                    // Add the student to the list
                    studentService.createStudent(student);

                    System.out.println("Student data added successfully!");
                    break;

                case 2:
                    List<Student> allStudents = studentService.showAllStudents();
                    if (allStudents.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("All students:");
                        for (Student s : allStudents) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter student id: ");
                    Integer studentId = sc.nextInt();
                    Student studentById = studentService.findStudentById(studentId);
                    if (studentById != null) {
                        System.out.println(studentById);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    Map<String, Integer> genderCountMap = studentService.countMaleAndFemaleStudents();
                    System.out.println("Male students: " + genderCountMap.getOrDefault("Male", 0));
                    System.out.println("Female students: " + genderCountMap.getOrDefault("Female", 0));
                    break;

                case 5:
                    System.out.print("Enter student ID to remove: ");
                    Integer studentIdToRemove = sc.nextInt();
                    boolean isRemoved = studentService.deleteStudentById(studentIdToRemove);
                    if (isRemoved) {
                        System.out.println("Student removed successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 6:
                    Map<String, Integer> branchCountMap = studentService.displayCountByBranchName();
                    for (Map.Entry<String, Integer> entry : branchCountMap.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;

                case 7:
                    System.out.println("Exiting the application.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
     }
}
