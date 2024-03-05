package com.example.minorproject1.service;

import com.example.minorproject1.dto.CreateStudentRequest;
import com.example.minorproject1.dto.UpdateStudentResponse;
import com.example.minorproject1.model.Book;
import com.example.minorproject1.model.Student;
import com.example.minorproject1.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student create(CreateStudentRequest createStudentRequest) {
        Student student = createStudentRequest.to();
        return studentRepository.save(student);
    }

    public Student getStudent(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Transactional
    public Student deleteStudentById(int id) throws Exception {
        Student student = this.studentRepository.findById(id).orElse(null);

        if(student!=null && student.getBookList().size()==0){
            studentRepository.deleteById(id);
            return student;
        }
        else{
            throw new Exception("Student can't be deleted - Books are alloted to student");
        }
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student updateStudent(int id, UpdateStudentResponse updateStudentResponse) throws Exception {

        Student studentFromDb = studentRepository.findById(id).orElse(null);

        if(studentFromDb==null){
            throw new Exception("Student not found!");
        }

        studentFromDb.setName(updateStudentResponse.getName());
        studentFromDb.setContact(updateStudentResponse.getContact());
        return studentRepository.save(studentFromDb);
    }
}
