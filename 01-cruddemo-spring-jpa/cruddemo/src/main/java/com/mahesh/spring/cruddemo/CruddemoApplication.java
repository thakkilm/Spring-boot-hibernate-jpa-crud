package com.mahesh.spring.cruddemo;

import com.mahesh.spring.cruddemo.dao.StudentDAO;
import com.mahesh.spring.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
//		findAllRecords(studentDAO);
//		findByLastName(studentDAO);
//		updateByFirstName(studentDAO);
//		deleteByID(studentDAO);
		deletAll(studentDAO);
		};
		}

	private void deletAll(StudentDAO studentDAO) {
		List<Student> stl=studentDAO.findAll();
		System.out.println("Before: "+stl);
		System.out.println(studentDAO.deleteAll());
		stl=studentDAO.findAll();
		System.out.println("After: "+stl);
	}

	private void deleteByID(StudentDAO studentDAO) {
//		Student st1=studentDAO.findByID(1);
		List<Student> stl=studentDAO.findAll();
		System.out.println("Before: "+stl);
		studentDAO.delete(1);
		stl=studentDAO.findAll();
		System.out.println("After: "+stl);

	}

	private void updateByFirstName(StudentDAO studentDAO) {
		Student st1=studentDAO.findByID(1);
		System.out.println("Before Updating First Name: "+st1);
		st1.setFirstName("Mahesh Naidu");
		studentDAO.update(st1);
		System.out.println("After Updating First Name: "+studentDAO.findByID(1));
	}

	private void findByLastName(StudentDAO studentDAO) {
		System.out.println("Displaying all the records with matching lastName: "+studentDAO.findByLastName("korapati"));
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

		Student tempStudent=new Student("Lavanya","Korapati","korapal@mail.gvsu.edu");
		studentDAO.save(tempStudent);
		System.out.println("ID: "+tempStudent.getId());
	}


}
