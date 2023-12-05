package com.mahesh.spring.cruddemo.dao;

import com.mahesh.spring.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;
    @Autowired
    public  StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findByID(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student",Student.class);


        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
        theQuery.setParameter("theData",lastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student student=entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
