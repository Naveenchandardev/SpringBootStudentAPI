package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import jakarta.persistence.Id;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/getAll")
	public List<Student> getAll(){
		return studentRepository.findAll();
	}
	
	@PostMapping("/saveStudent")
	public String saveAll(@RequestBody Student student){
		studentRepository.save(student);
		return "Student successFully Created";
	}
	
	@PostMapping("/updateStudent/{Id}")
	public String updateStudent(@PathVariable int Id , @RequestBody Student student){
		Student existingStudent = studentRepository.findById(Id).get();
		student.setName(student.getName());
		student.setBranch(student.getBranch());
		student.setPercentage(student.getPercentage());
		studentRepository.save(student);
		return "Student successFully updated";
	}
	@DeleteMapping("/{Id}")
	public String deleteStudent(@PathVariable int Id){
		studentRepository.deleteById(Id);
		return "Student successFully Deleted";
	}

}
