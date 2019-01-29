package me.anichakra.poc.ruleservice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.ruleservice.entites.Student;
import me.anichakra.poc.ruleservice.service.StudentManagementService;
import me.anichakra.poc.ruleservice.vo.BookStuInfo;
import me.anichakra.poc.ruleservice.vo.GradeInfo;

@RestController
@RequestMapping(value="/api/students")
public class StudentController {

	@Autowired
	private StudentManagementService managementService;
	
	@PostMapping(value="/save")
	public Student saveStudentInfo(@RequestBody Student student)
	{
		return managementService.saveStudentInfo(student);
		
	}
	
	@GetMapping(value="/student/{rollNumber}")
	public Optional<Student> getStudentById(@PathVariable("rollNumber") Integer rollNumber)
	{
		return managementService.getStudentById(rollNumber);
		
	}
	
	@GetMapping(value="/student/allstudent")
	public Iterable<Student> getAllStudent()
	{
		return managementService.getAllStudent();
		
	}
	
	  @GetMapping(value="/student/rankerName/{rollNumber}") public String
	  getRankerStudent(@PathVariable("rollNumber") Integer rollNumber) throws IOException { return
	  managementService.getRankerStudent(rollNumber);
	  
	  }
	  
	  @GetMapping(value="/student/allGrade") public ArrayList<GradeInfo>
	  getGrade() throws IOException { return
	  managementService.getGrade();
	  
	  }
	  
	  @GetMapping(value="/student/booksuggetion") public ArrayList<BookStuInfo>
	  getBookSuggetion() throws IOException { return
	  managementService.getBookSuggetion();
	  
	  }
	  
	  @GetMapping(value="/student/sholarshipdetails/{stream}/{gdpa}") public String
	  getSholarshipDetails(@PathVariable("stream") String stream,@PathVariable("gdpa") Integer gdpa) throws IOException { return
	  managementService.getSholarshipDetails(stream,gdpa);
	  
	  }
	 
}
