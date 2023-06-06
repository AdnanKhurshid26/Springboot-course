package com.adnan.jpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adnan.jpaandhibernate.course.Course;

@Component
public class CourseJdbcCLR implements CommandLineRunner {


    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1L,"Adnan","Spring Boot"));
        repository.insert(new Course(2L,"Adnan","MongoDB"));
        repository.insert(new Course(3L,"Adnan","Design Patterns"));

        System.out.println(repository.findById(1L));
    }
    
}
