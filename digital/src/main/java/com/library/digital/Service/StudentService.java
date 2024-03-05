package com.library.digital.Service;

import com.library.digital.Entities.Student;
import com.library.digital.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    public List<Student> getAll(){
        return studentRepository.getAll();
    }

    public Optional<Student> getById(int id){
        return studentRepository.findById(id);
    }

    public void create(Student a){
         studentRepository.save(a);
    }

    public void update(Student a){
        studentRepository.save(a);
    }
    public void delete(int id){
        studentRepository.deleteById(id);
    }
}
