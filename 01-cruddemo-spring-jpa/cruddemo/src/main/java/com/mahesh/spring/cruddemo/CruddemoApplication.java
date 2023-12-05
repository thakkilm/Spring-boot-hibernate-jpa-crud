package com.mahesh.spring.cruddemo;

import com.mahesh.spring.cruddemo.dao.StudentDAO;
import com.mahesh.spring.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return  runner-> {
//			createStudent(studentDAO);
//		readStudent(studentDAO);
		findAllRecords(studentDAO);
		};
		}

	private void findAllRecords(StudentDAO studentDAO) {
		System.out.println("Displaying all the records: "+studentDAO.findAll());
	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent=new Student("Lavanya","Thakkilapati","thakkill@mail.gvsu.edu");
		studentDAO.save(tempStudent);
		System.out.println("ID: "+tempStudent.getId());
		Student myStudent=studentDAO.findByID(tempStudent.getId());
		System.out.println("Found record: "+myStudent);
	}


	private void createStudent(StudentDAO studentDAO) {

		Student tempStudent=new Student("Lokesh","Thakkilapati","thakkill@mail.gvsu.edu");
		studentDAO.save(tempStudent);
		System.out.println("ID: "+tempStudent.getId());
	}


}
