package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    @Autowired private CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1, "Learn AWS Now!", "in28minutes"));
        courseJdbcRepository.insert(new Course(2, "Learn Azure Now!", "in28minutes"));
        courseJdbcRepository.insert(new Course(3, "Learn DevOps Now!", "in28minutes"));
        courseJdbcRepository.delete(new Course(1));
    }
}
