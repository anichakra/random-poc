package me.anichakra.poc.ruleservice;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.anichakra.poc.ruleservice.entites.Student;
import me.anichakra.poc.ruleservice.service.StudentManagementService;

@SpringBootApplication
public class StudentmanagementApplication implements CommandLineRunner{

	@Autowired
	StudentManagementService studentManagementService;
	
	@Autowired
	private DataSource dataSource;
	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Student student=new Student();
		student.setStudentName("arup");
		student.setAddress("420 ABR");
		student.setClassSpec("M.TECH");
		student.setFabSub("Spring Boot");
		student.setScore(75);
		student.setGdpa(8);
		studentManagementService.saveStudentInfo(student);
		Student student1=new Student();
		student1.setStudentName("swarup");
		student1.setAddress("420 ABR");
		student1.setClassSpec("B.TECH");
		student1.setFabSub("Automata");
		student1.setScore(99);
		student1.setGdpa(10);
		studentManagementService.saveStudentInfo(student1);
		System.out.println("dataSource"+dataSource);
	}

}

