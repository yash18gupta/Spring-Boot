package com.library.digital.Service;

import com.library.digital.Entities.Book;
import com.library.digital.Entities.Genre;
import com.library.digital.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    public BookRepository bookRepository;

    public List<Book> getAll(){
        return bookRepository.getAll();
    }

    public Optional<Book> getById(int id){
        return bookRepository.findById(id);
    }

    public List<Book> getAllAvailable(Genre genre, boolean available,String author){

        List<Book> filteredData = new ArrayList<>();
        if(genre!=null){
            filteredData = bookRepository.findAvailableByGenre(genre,available,author);
        }
        else{
            filteredData = bookRepository.findAvailable(available);
        }
        return filteredData;
    }

    public void create(Book a){
         bookRepository.save(a);
    }

    public void update(Book a){
        bookRepository.save(a);
    }
    public void delete(int id){
        bookRepository.deleteById(id);
    }
}
