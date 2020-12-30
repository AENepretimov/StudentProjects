package com.test.repositories;

import com.test.mapper.StudentMapper;
import com.test.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer addStudent(Student student){
        jdbcTemplate.execute("USE test3");
        return jdbcTemplate.update("INSERT INTO students (name, gr) " +
                "VALUES (? , ?) ",
                student.getName(),
                student.getGr());
    }

    public List<Student> getStugents(){
        jdbcTemplate.execute("USE test3");
        return jdbcTemplate.query("SELECT * FROM students", new StudentMapper());
    }

}
