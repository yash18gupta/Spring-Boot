package com.library.digital.Repository;

import com.library.digital.Entities.Author;
import com.library.digital.Entities.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Transactional
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "select s from Student s")
    public List<Student> getAll();
}
