package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired private JdbcTemplate jdbcTemplate;
    private static String INSERT_QUERY = """        
        insert into course(id, name, author) 
        values(?, ?, ?);
    """;
    private static String DETETE_QUERY = """        
        delete from course where id = ?;
    """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(Course course) {
        jdbcTemplate.update(DETETE_QUERY, course.getId());
    }
}
