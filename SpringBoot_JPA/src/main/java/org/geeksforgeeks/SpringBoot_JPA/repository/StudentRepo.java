package org.geeksforgeeks.SpringBoot_JPA.repository;

import jakarta.transaction.Transactional;
import org.geeksforgeeks.SpringBoot_JPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    @Query(value= "select s from Student s where s.name=?1")
    public Student findByName(String name);


    @Query(value= "select s from Student s where s.name=?1 and s.id=?2")
    public List<Student> findByName(String name, int id);

    @Query(value = "select s from Student s")
    public List<Student> getAll();

}
