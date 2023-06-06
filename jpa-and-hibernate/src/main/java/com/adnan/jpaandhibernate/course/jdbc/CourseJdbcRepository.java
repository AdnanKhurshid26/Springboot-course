package com.adnan.jpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.adnan.jpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static String INSERT_QUERY =  """
                                            INSERT INTO COURSE
                                            (id,name,author)
                                            VALUES(?,?,?)
                                            """;
    private static String SELECT_QUERY =  """
                                            SELECT * FROM COURSE
                                            WHERE id = ?
                                            """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    }

    public Course findById(Long id) {
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
                                            
            
}
