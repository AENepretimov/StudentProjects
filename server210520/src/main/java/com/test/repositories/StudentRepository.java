package com.test.repositories;

import com.test.mapper.StudentMapper;
import com.test.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer addStudent(Student student){
        jdbcTemplate.execute("USE test1");
        return jdbcTemplate.update("INSERT INTO student (name, gr)" +
                " VALUES (?, ?)",
                student.getName(),
                student.getGr());
    }

    public List<Student> getStudents(){
        jdbcTemplate.execute("USE test1");
        return jdbcTemplate.query("SELECT * FROM student", new StudentMapper());
    }

    public Student getStudent(Integer id){
        jdbcTemplate.execute("USE test1");

        Object[] listId = {id};

        return jdbcTemplate.queryForObject("SELECT * FROM student WHERE id = ?",
                listId,
                new StudentMapper());
    }


}
