package com.test.mapper;

import com.test.models.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();

        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setGr(resultSet.getInt("gr"));

        return student;
    }
}
