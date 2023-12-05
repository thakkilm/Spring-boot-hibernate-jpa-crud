package com.mahesh.spring.cruddemo.dao;

import com.mahesh.spring.cruddemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO {

    void save(Student student);
    Student findByID(int id);
    List<Student> findAll();
}
