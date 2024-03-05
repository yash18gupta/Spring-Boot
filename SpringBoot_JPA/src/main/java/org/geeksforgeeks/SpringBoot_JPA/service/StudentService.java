package org.geeksforgeeks.SpringBoot_JPA.service;

import org.geeksforgeeks.SpringBoot_JPA.entity.Student;
import org.geeksforgeeks.SpringBoot_JPA.model.*;
import org.geeksforgeeks.SpringBoot_JPA.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    public StudentRepo studentRepo;

    public CreateStudentResponse createStudent(CreateStudentRequest createStudentRequest){

        Student s = new Student();
        s.setId(createStudentRequest.getId());
        s.setName(createStudentRequest.getName());
        s.setRollNum(createStudentRequest.getRollNum());
        s.setEmail(createStudentRequest.getUsername()+"@"+createStudentRequest.getDomain());

        Student student = studentRepo.save(s);

        CreateStudentResponse response = new CreateStudentResponse(student.getId(),student.getName(),student.getEmail(),student.getRollNum(),200,"Student saved successfully!");
        return response;
    }

    public GetStudentResponse getById(int id){
        Student student = studentRepo.getById(id);

        GetStudentResponse response = new GetStudentResponse(student.getId(), student.getName(),student.getEmail(),student.getRollNum(),200,"Student fetched success");

        return response;

    }
    public GetStudentResponse getStudentByName(String name){
        Student student = studentRepo.findByName(name);

        GetStudentResponse response = new GetStudentResponse(student.getId(), student.getName(),student.getEmail(),student.getRollNum(),200,"Student fetched by name");
        return response;
    }

    public List<Student> getAll(){
        return studentRepo.getAll();
    }

    public UpdateStudentResponse updateStudent(int id, UpdateStudentRequest updatedStudent) {
        Student s = studentRepo.getById(id);
        s.setName(updatedStudent.getName());
        s.setEmail(updatedStudent.getUsername()+"@"+updatedStudent.getDomain());
        s.setRollNum(updatedStudent.getRollNum());

        Student student = studentRepo.save(s);

        UpdateStudentResponse response = new UpdateStudentResponse(student.getId(),student.getName(),student.getEmail(),student.getRollNum(),200,"Update successful");
        return response;
    }

    public DeleteStudentResponse deleteStudent(@PathVariable int id){
        Student s = studentRepo.getById(id);
        studentRepo.deleteById(id);

        DeleteStudentResponse response = new DeleteStudentResponse(s.getId(),s.getName(),s.getEmail(),s.getRollNum(),200,"Deleted record success");
        return response;
    }

    public void deleteByName(String name){

        Student s = studentRepo.findByName(name);
        if(s!=null){
            studentRepo.delete(s);
        }
    }
}
