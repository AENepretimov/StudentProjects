package com.test.services;

import com.test.models.Student;
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

    public String createDB(){
        //....
        //...
        return defaultRepository.createDB();
    }

    public Integer addStudent(Student student){
        if (student != null){
            return studentRepository.addStudent(student);
        }else {
            return -1;
        }
    }

    public List<Student> getStudents(){
        //...
        //...
        return studentRepository.getStudents();
    }

    public Student getStudent(Integer id){
        if(id > 0 && id <= studentRepository.getStudents().size()) {
            return studentRepository.getStudent(id);
        }else{
            return null;
        }
    }


}
