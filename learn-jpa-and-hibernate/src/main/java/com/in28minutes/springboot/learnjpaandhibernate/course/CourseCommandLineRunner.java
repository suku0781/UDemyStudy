package com.in28minutes.springboot.learnjpaandhibernate.course;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    @Autowired private CourseRepository repository;
    @Autowired private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS JPA!", "in28minutes"));
        repository.insert(new Course(2, "Learn Azure JPA!", "in28minutes"));
        repository.insert(new Course(3, "Learn DevOps JPA!", "in28minutes"));
        repository.deleteById(1);
        System.out.println(repository.selectById(2));
        System.out.println(repository.selectById(3));
    }
}
