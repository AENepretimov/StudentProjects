package com.test.services;

import com.test.model.Student;
import com.test.repositories.DefaultRepository;
import com.test.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultService {

    @Autowired
    DefaultRepository defaultRepository;
    @Autowired
    StudentRepository studentRepository;

    public Integer addStudent(Student student){
        return studentRepository.addStudent(student);
    }

    public List<Student> getStudents(){
        return studentRepository.getStugents();
    }

    public String createDB(){
        //....
        return  defaultRepository.createDB();
    }

}
