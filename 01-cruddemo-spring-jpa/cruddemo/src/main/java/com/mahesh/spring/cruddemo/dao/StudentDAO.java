package com.mahesh.spring.cruddemo.dao;

import com.mahesh.spring.cruddemo.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO {

    void save(Student student);
    Student findByID(int id);
}
