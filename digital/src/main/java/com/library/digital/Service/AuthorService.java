package com.library.digital.Service;

import com.library.digital.Entities.Author;
import com.library.digital.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    public AuthorRepository authorRepository;

    public List<Author> getAll(){
        return authorRepository.getAll();
    }

    public Optional<Author> getById(int id){
        return authorRepository.findById(id);
    }

    public void create(Author a){
         authorRepository.save(a);
    }

    public void update(Author a){
        authorRepository.save(a);
    }
    public void delete(int id){
        authorRepository.deleteById(id);
    }
}
