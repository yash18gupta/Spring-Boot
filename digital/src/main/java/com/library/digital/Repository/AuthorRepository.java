package com.library.digital.Repository;

import com.library.digital.Entities.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Transactional
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    @Query(value = "select a from Author a")
    public List<Author> getAll();
}
