package com.example.minorproject1.controller;

import com.example.minorproject1.dto.CreateStudentRequest;
import com.example.minorproject1.dto.UpdateStudentResponse;
import com.example.minorproject1.model.Book;
import com.example.minorproject1.model.Student;
import com.example.minorproject1.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody CreateStudentRequest createStudentRequest){
        return studentService.create(createStudentRequest);
    }

    @GetMapping("/get/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @DeleteMapping("/delete/{id}")
    public Student deleteStudentById(@PathVariable int id) throws Exception {
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/getAll")
    public List<Student> getAllBooks(){
        return studentService.getAll();
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody @Valid UpdateStudentResponse updateStudentResponse) throws Exception {
        return studentService.updateStudent(id,updateStudentResponse);
    }

}
