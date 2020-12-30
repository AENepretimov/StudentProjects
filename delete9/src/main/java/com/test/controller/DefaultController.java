package com.test.controller;

import com.test.model.Student;
import com.test.services.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DefaultController {

    @Autowired
    DefaultService defaultService;

    @RequestMapping("/getStudents")
    @ResponseBody
    public List<Student> getStudents(){
        return defaultService.getStudents();
    }

    @RequestMapping("/addStudent")
    @ResponseBody
    public Integer addStudent(@RequestParam(value = "name") String name,
                              @RequestParam(value = "gr") Integer gr){
        Student student = new Student();
        student.setName(name);
        student.setGr(gr);
        return defaultService.addStudent(student);
    }

    @RequestMapping("/createDB")
    @ResponseBody
    public String createDB(){
        return defaultService.createDB();
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

}
