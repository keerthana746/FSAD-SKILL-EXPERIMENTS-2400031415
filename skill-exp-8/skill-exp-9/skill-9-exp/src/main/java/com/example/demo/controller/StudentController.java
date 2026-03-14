package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.exception.InvalidInputException;

@RestController
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable String id) {

		int studentId;

		try {
			studentId = Integer.parseInt(id);
		} 
		catch (NumberFormatException e) {
			throw new InvalidInputException("Student ID must be a number");
		}

		if (studentId != 1) {
			throw new StudentNotFoundException("Student with ID " + studentId + " not found");
		}

		return new Student(1, "john", "Computer Science");
	}
}