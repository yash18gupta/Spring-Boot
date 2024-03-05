package org.geeksforgeeks.SpringBoot_JPA.controller;

import org.geeksforgeeks.SpringBoot_JPA.entity.Student;
import org.geeksforgeeks.SpringBoot_JPA.model.*;
import org.geeksforgeeks.SpringBoot_JPA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    public StudentService studentService;

    @RequestMapping("/test")
    public String test() {
        return "Test API Works";
    }

    @PostMapping("/create")
    public CreateStudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
        return studentService.createStudent(createStudentRequest);
    }

    @GetMapping("/get/{id}")
    public GetStudentResponse getById(@PathVariable int id) {
        return studentService.getById(id);
    }

    @GetMapping("/getName")
    public GetStudentResponse getStudentByName(@RequestParam String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @PutMapping("/update/{id}")
    public UpdateStudentResponse updateStudent(@PathVariable int id, @RequestBody UpdateStudentRequest updatedStudent) {
        return studentService.updateStudent(id,updatedStudent);
    }

    @DeleteMapping("/delete/{id}")
    public DeleteStudentResponse deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }

    @DeleteMapping("/deleteByName")
    public void deleteByName(@RequestParam String name){
        studentService.deleteByName(name);
    }
}
