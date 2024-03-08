package com.example.minorproject1.controller;

import com.example.minorproject1.dto.BookFrontend;
import com.example.minorproject1.dto.CreateBookRequest;
import com.example.minorproject1.model.Book;
import com.example.minorproject1.model.enums.Genre;
import com.example.minorproject1.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('admin')")
    public Book createBook(@RequestBody @Valid CreateBookRequest createBookResponse){
        return bookService.createBook(createBookResponse);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyAuthority('student','admin')")
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('student', 'admin')")
    public Book getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public Book deleteBookById(@PathVariable int id) throws Exception {
        return bookService.deleteBookById(id);
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyAuthority('student','admin')")
    public List<Book> getAllAvailable(@RequestParam(value = "name" ,required = false) String name,
                                      @RequestParam(value= "author" ,required = false) String author,
                                      @RequestParam(value = "genre" ,required = false) Genre genre,
                                      @RequestParam(value = "minPages" ,required = false) Integer minPages,
                                      @RequestParam(value = "maxPages" ,required = false) Integer maxPages
                                      ){
        return bookService.getAllAvailable(Optional.ofNullable(name), Optional.ofNullable(author), Optional.ofNullable(genre), Optional.ofNullable(minPages), Optional.ofNullable(maxPages));
    }


    @GetMapping("/frontend")
    @PreAuthorize("hasAuthority('student')")
    public List<BookFrontend> showBooks(){
        return bookService.showBooks();
    }

}
