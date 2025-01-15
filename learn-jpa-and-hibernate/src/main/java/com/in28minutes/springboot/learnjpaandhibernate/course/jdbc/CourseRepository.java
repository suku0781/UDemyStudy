package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {
    @Autowired private JdbcTemplate jdbcTemplate;
    private static String INSERT_QUERY = """        
        insert into course(id, name, author) 
        values(?, ?, ?);
    """;

    private static String DETETE_QUERY = """        
        delete from course where id = ?;
    """;

    private static String SELECT_QUERY = """        
        select * from course where id = ?
    """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        jdbcTemplate.update(DETETE_QUERY, id);
    }

    public Course selectById(long id) {
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);


    }

}
