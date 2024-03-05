package com.library.digital.Controller;

import com.library.digital.Entities.Student;
import com.library.digital.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    public StudentService studentService;

    @GetMapping("/getAll")
    public List<Student> getAll(){
        return studentService.getAll();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable int id){
        Optional<Student> a = studentService.getById(id);
        return new ResponseEntity(a.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Student a){
        studentService.create(a);
        return new ResponseEntity("Student Created", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Student a){
        studentService.update(a);
        return new ResponseEntity("Student Updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        studentService.delete(id);
        return new ResponseEntity("Student Deleted", HttpStatus.OK);
    }

}
