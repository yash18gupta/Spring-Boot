package com.example.minorproject1.service;

import com.example.minorproject1.dto.CreateStudentRequest;
import com.example.minorproject1.dto.UpdateStudentResponse;
import com.example.minorproject1.model.SecuredUser;
import com.example.minorproject1.model.Student;
import com.example.minorproject1.repository.SecuredUserRepository;
import com.example.minorproject1.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    SecuredUserService securedUserService;

    @Value("${student.authorities}")
    String authorities;

    public Student create(CreateStudentRequest createStudentRequest) {
        Student student = createStudentRequest.to();

        SecuredUser securedUser = student.getSecuredUser();
        securedUser.setPassword(passwordEncoder.encode(securedUser.getPassword()));
        securedUser.setAuthorities(authorities);

        //created a user
        securedUser = securedUserService.save(securedUser);

        //create a student
        student.setSecuredUser(securedUser);

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
            securedUserService.deleteById(student.getSecuredUser().getId());
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
