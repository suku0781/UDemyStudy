package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
    @PersistenceContext private EntityManager entityManager; // @Autowire대신 더 구체적인 @PersistenceContext 사용

    // insert
    public void insert(Course course) {
        entityManager.merge(course);

    }

    // select
    public Course selectById(long id) {
        return entityManager.find(Course.class, id);

    }


    // delete
    public void deleteById(long id) {
        entityManager.remove(entityManager.find(Course.class, id));
    }

}
